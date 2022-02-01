package com.tencent.mobileqq.profilecard.bussiness.stickynote;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.tencent.ditto.utils.ClassLoadUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import com.tencent.widget.XSimpleListAdapter;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import mqq.os.MqqHandler;

public class QzoneStickyNoteManager
  implements AbsListView.OnScrollListener
{
  private static final String ADAPTER_CLASS = "com.qzone.homepage.ui.activity.FriendProfileCardAdapter";
  private static final String ADAPTER_CONVERTER = "com.qzone.homepage.ui.activity.FriendProfileCardAdapterConverter";
  private static final int STATE_LOADING_DOING = 2;
  private static final int STATE_LOADING_NOT_START = 0;
  private static final int STATE_LOADING_WAITING = 1;
  private static final String TAG = "QzoneStickyNoteManager";
  private Activity mActivity;
  private Class<?> mAdapterClass;
  private boolean mAdapterLoaded;
  private QQAppInterface mApp;
  private boolean mCanLoadMore = true;
  private Object mConverter;
  private Class mConverterClass;
  private boolean mIsAttach;
  private ListView mListView;
  private Object mLoadCallback;
  private int mLoadingState = 0;
  private BaseAdapter mQzoneAdapter;
  private ClassLoader mQzoneClassLoader = null;
  private int mScrollState = 0;
  private boolean mShouldNotifyDataChanged = false;
  private ProfileStickyNoteComponent mStickyNoteComponent;
  private View mTitleView;
  private int mTotalItemCount;
  private Handler mUiHandler = new Handler(Looper.getMainLooper());
  private long mUin;
  
  private Class<?> getAdapterClass()
  {
    try
    {
      if (this.mAdapterClass == null) {
        this.mAdapterClass = ClassLoadUtils.load(this.mQzoneClassLoader, "com.qzone.homepage.ui.activity.FriendProfileCardAdapter");
      }
    }
    catch (Exception localException)
    {
      QLog.w("QzoneStickyNoteManager", 4, "getAdapterClass failed!", localException);
    }
    return this.mAdapterClass;
  }
  
  private Class getConverterClass()
  {
    Class localClass = this.mConverterClass;
    if (localClass != null) {
      return localClass;
    }
    try
    {
      this.mConverterClass = ClassLoadUtils.load(this.mQzoneClassLoader, "com.qzone.homepage.ui.activity.FriendProfileCardAdapterConverter");
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getConverterClass failed: ");
      localStringBuilder.append(localException.getMessage());
      QLog.w("QzoneStickyNoteManager", 4, localStringBuilder.toString());
    }
    return this.mConverterClass;
  }
  
  private Object getLoadCallback()
  {
    Object localObject1 = this.mLoadCallback;
    if (localObject1 != null) {
      return localObject1;
    }
    try
    {
      localObject1 = ClassLoadUtils.load(this.mQzoneClassLoader, "com.qzone.homepage.ui.activity.FriendProfileCardAdapterConverter$LoadCallback");
      localObject2 = this.mQzoneClassLoader;
      QzoneStickyNoteManager.3 local3 = new QzoneStickyNoteManager.3(this);
      this.mLoadCallback = Proxy.newProxyInstance((ClassLoader)localObject2, new Class[] { localObject1 }, local3);
    }
    catch (Throwable localThrowable)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getLocalCallback failed: ");
      ((StringBuilder)localObject2).append(localThrowable.getMessage());
      QLog.w("QzoneStickyNoteManager", 1, ((StringBuilder)localObject2).toString());
    }
    return this.mLoadCallback;
  }
  
  private int getStartLoadPos()
  {
    return this.mTotalItemCount - 2;
  }
  
  private void loadMore()
  {
    QLog.i("QzoneStickyNoteManager", 1, "loadMore");
    Object localObject = getLoadCallback();
    if (localObject == null)
    {
      QLog.e("QzoneStickyNoteManager", 1, "loadMore exit due to null callback");
      return;
    }
    try
    {
      getConverterClass().getDeclaredMethod("loadMore", new Class[] { Object.class }).invoke(this.mConverter, new Object[] { localObject });
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadMore failed: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("QzoneStickyNoteManager", 1, localStringBuilder.toString());
    }
  }
  
  private Object newConverter(ListView paramListView)
  {
    if (this.mQzoneClassLoader == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        localObject = getConverterClass().getConstructor(new Class[] { Activity.class, ListView.class, Long.TYPE, Boolean.TYPE });
        if ((this.mApp != null) && (this.mUin == this.mApp.getLongAccountUin()))
        {
          bool = true;
          paramListView = ((Constructor)localObject).newInstance(new Object[] { this.mActivity, paramListView, Long.valueOf(this.mUin), Boolean.valueOf(bool) });
          return paramListView;
        }
      }
      catch (Exception paramListView)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("newConverter failed: ");
        ((StringBuilder)localObject).append(paramListView.getMessage());
        QLog.w("QzoneStickyNoteManager", 4, ((StringBuilder)localObject).toString());
        return null;
      }
      boolean bool = false;
    }
  }
  
  private void onLifecycle(String paramString)
  {
    try
    {
      getConverterClass().getDeclaredMethod("onLifecycle", new Class[] { String.class }).invoke(this.mConverter, new Object[] { paramString });
      return;
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLifecycle failed: ");
      localStringBuilder.append(paramString.getMessage());
      QLog.w("QzoneStickyNoteManager", 4, localStringBuilder.toString());
    }
  }
  
  private void onLoad(int paramInt, boolean paramBoolean)
  {
    QZLog.d("QzoneStickyNoteManager", 4, String.format("onLoad pos=%s hasMore=%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) }));
    if (this.mLoadingState == 2) {
      this.mLoadingState = 0;
    }
    this.mShouldNotifyDataChanged = true;
    this.mCanLoadMore = paramBoolean;
  }
  
  private void onLoadFinish(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLoadFinish ");
    localStringBuilder.append(paramBoolean);
    QZLog.d("QzoneStickyNoteManager", 4, localStringBuilder.toString());
    this.mLoadingState = 1;
  }
  
  private void onScrollProxy(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.mIsAttach) {
      return;
    }
    try
    {
      getConverterClass().getDeclaredMethod("onScroll", new Class[] { AbsListView.class, Integer.TYPE, Integer.TYPE, Integer.TYPE }).invoke(this.mConverter, new Object[] { paramAbsListView, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      return;
    }
    catch (Exception paramAbsListView)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onScrollProxy failed: ");
      localStringBuilder.append(paramAbsListView.getMessage());
      QLog.w("QzoneStickyNoteManager", 4, localStringBuilder.toString());
    }
  }
  
  private void onScrollStateChangedProxy(AbsListView paramAbsListView, int paramInt)
  {
    if (!this.mIsAttach) {
      return;
    }
    try
    {
      getConverterClass().getDeclaredMethod("onScrollStateChanged", new Class[] { AbsListView.class, Integer.TYPE }).invoke(this.mConverter, new Object[] { paramAbsListView, Integer.valueOf(paramInt) });
      return;
    }
    catch (Exception paramAbsListView)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onScrollStateChangedProxy failed: ");
      localStringBuilder.append(paramAbsListView.getMessage());
      QLog.w("QzoneStickyNoteManager", 4, localStringBuilder.toString());
    }
  }
  
  private void scrollToStickNoteTop()
  {
    int i = this.mListView.getFirstVisiblePosition();
    QZLog.d("QzoneStickyNoteManager", 4, String.format("scrollToStickNoteTop firstVisiblePos=%s", new Object[] { Integer.valueOf(i) }));
    if (i > 1)
    {
      Activity localActivity = this.mActivity;
      if ((localActivity instanceof QBaseActivity))
      {
        i = ((QBaseActivity)localActivity).getTitleBarHeight();
        int j = this.mTitleView.getHeight();
        this.mListView.setSelectionFromTop(1, i + j);
      }
    }
  }
  
  private void setAdapterIfNeed(ListAdapter paramListAdapter)
  {
    if (!this.mAdapterLoaded)
    {
      ListView localListView = this.mListView;
      if ((localListView != null) && (paramListAdapter != null))
      {
        localListView.setAdapter(paramListAdapter);
        paramListAdapter = this.mTitleView;
        if (paramListAdapter != null) {
          paramListAdapter.setVisibility(0);
        }
        this.mAdapterLoaded = true;
      }
    }
  }
  
  private void setStickyNoteComponentToAdapter()
  {
    if (this.mQzoneAdapter != null)
    {
      Class localClass = getAdapterClass();
      if (localClass != null) {
        try
        {
          localClass.getDeclaredMethod("setStickyNoteComponent", new Class[] { ProfileStickyNoteComponent.class }).invoke(this.mQzoneAdapter, new Object[] { this.mStickyNoteComponent });
          return;
        }
        catch (Exception localException)
        {
          QLog.e("QzoneStickyNoteManager", 1, "setStickyNoteComponentToAdapter failed!", localException);
        }
      }
    }
  }
  
  private void tryLoadMore()
  {
    QLog.i("QzoneStickyNoteManager", 1, "tryLoadMore");
    if ((this.mCanLoadMore) && (this.mLoadingState != 2) && (this.mScrollState == 0))
    {
      this.mLoadingState = 2;
      loadMore();
    }
  }
  
  public void attach(QQAppInterface paramQQAppInterface, Activity paramActivity, ListView paramListView, Card paramCard)
  {
    if ((paramQQAppInterface != null) && (paramActivity != null) && (paramListView != null))
    {
      if (paramCard == null) {
        return;
      }
      long l;
      try
      {
        l = Long.parseLong(paramCard.uin);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        l = 0L;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("attach: ");
      localStringBuilder.append(this.mIsAttach);
      localStringBuilder.append(", ");
      localStringBuilder.append(l);
      QZLog.i("QzoneStickyNoteManager", localStringBuilder.toString());
      if (l <= 0L) {
        return;
      }
      if (this.mIsAttach) {
        return;
      }
      if (this.mQzoneClassLoader == null) {
        this.mQzoneClassLoader = QzonePluginProxyActivity.getQZonePluginClassLoaderInUI();
      }
      if (paramQQAppInterface != QZoneApiProxy.getLastRuntime()) {
        QZoneApiProxy.onAccountChange(paramActivity, paramQQAppInterface);
      }
      this.mActivity = paramActivity;
      this.mApp = paramQQAppInterface;
      this.mUin = l;
      this.mUiHandler.post(new QzoneStickyNoteManager.2(this, paramListView, paramCard));
    }
  }
  
  public void destroy()
  {
    if (this.mAdapterLoaded)
    {
      ListView localListView = this.mListView;
      if (localListView != null) {
        localListView.setAdapter(new XSimpleListAdapter(null));
      }
    }
  }
  
  public BaseAdapter getAdapter()
  {
    BaseAdapter localBaseAdapter = this.mQzoneAdapter;
    if (localBaseAdapter != null) {
      return localBaseAdapter;
    }
    if (this.mConverter == null) {
      return null;
    }
    if (this.mQzoneClassLoader != null)
    {
      try
      {
        this.mQzoneAdapter = ((BaseAdapter)getConverterClass().getDeclaredMethod("getAdapter", new Class[0]).invoke(this.mConverter, new Object[0]));
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getAdapter failed: ");
        localStringBuilder.append(localException.getMessage());
        QLog.w("QzoneStickyNoteManager", 4, localStringBuilder.toString());
      }
      setStickyNoteComponentToAdapter();
    }
    return this.mQzoneAdapter;
  }
  
  public void init(Activity paramActivity, QQAppInterface paramQQAppInterface, Card paramCard, ListView paramListView, View paramView, ProfileStickyNoteComponent paramProfileStickyNoteComponent)
  {
    if ((paramActivity != null) && (paramQQAppInterface != null))
    {
      this.mListView = paramListView;
      this.mTitleView = paramView;
      this.mStickyNoteComponent = paramProfileStickyNoteComponent;
      paramActivity = new WeakReference(paramActivity);
      paramListView = new WeakReference(paramListView);
      ThreadManager.getSubThreadHandler().post(new QzoneStickyNoteManager.1(this, paramQQAppInterface, paramActivity, paramListView, paramCard));
      return;
    }
    QLog.w("QzoneStickyNoteManager", 1, "init failed due to null parameter");
  }
  
  public boolean isQzoneLoaded()
  {
    return this.mQzoneClassLoader != null;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QZLog.d("QzoneStickyNoteManager", 4, String.format("onActivityResult requestCode=%s resultCode=%s mCanLoadMore=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.mCanLoadMore) }));
    try
    {
      getConverterClass().getDeclaredMethod("onActivityResult", new Class[] { Integer.TYPE, Integer.TYPE, Intent.class }).invoke(this.mConverter, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
    }
    catch (Exception paramIntent)
    {
      QZLog.e("QzoneStickyNoteManager", 4, new Object[] { "onActivityResult failed!", paramIntent });
    }
    if ((paramInt1 == 1209) && (paramInt2 == -1) && (!this.mCanLoadMore)) {
      scrollToStickNoteTop();
    }
  }
  
  public void onDestroy()
  {
    onLifecycle("onDestroy");
    this.mConverter = null;
    this.mIsAttach = false;
    this.mLoadCallback = null;
  }
  
  public void onPause()
  {
    onLifecycle("onPause");
  }
  
  public void onResume()
  {
    onLifecycle("onResume");
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mTotalItemCount = paramInt3;
    onScrollProxy(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.mScrollState = paramInt;
    if (paramInt == 0)
    {
      if (this.mShouldNotifyDataChanged)
      {
        this.mQzoneAdapter.notifyDataSetChanged();
        this.mShouldNotifyDataChanged = false;
      }
      if (paramAbsListView.getLastVisiblePosition() >= getStartLoadPos()) {
        tryLoadMore();
      }
    }
    onScrollStateChangedProxy(paramAbsListView, paramInt);
  }
  
  public void updateFriendProfileCard(Card paramCard)
  {
    if (this.mConverter == null) {
      return;
    }
    if (this.mQzoneClassLoader != null) {
      try
      {
        getConverterClass().getDeclaredMethod("updateFriendProfileCard", new Class[] { Card.class }).invoke(this.mConverter, new Object[] { paramCard });
        return;
      }
      catch (Exception paramCard)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateFriendProfileCard failed: ");
        localStringBuilder.append(paramCard.getMessage());
        QLog.w("QzoneStickyNoteManager", 4, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.stickynote.QzoneStickyNoteManager
 * JD-Core Version:    0.7.0.1
 */