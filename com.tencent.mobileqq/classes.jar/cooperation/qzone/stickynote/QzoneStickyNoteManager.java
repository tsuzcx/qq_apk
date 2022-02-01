package cooperation.qzone.stickynote;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import bace;
import blha;
import com.tencent.ditto.utils.ClassLoadUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
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
  private ClassLoader mQzoneClassLoader;
  private int mScrollState = 0;
  private boolean mShouldNotifyDataChanged;
  private bace mStickyNoteComponent;
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
      return this.mAdapterClass;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w("QzoneStickyNoteManager", 4, "getAdapterClass failed!", localException);
      }
    }
  }
  
  private Class getConverterClass()
  {
    if (this.mConverterClass != null) {
      return this.mConverterClass;
    }
    try
    {
      this.mConverterClass = ClassLoadUtils.load(this.mQzoneClassLoader, "com.qzone.homepage.ui.activity.FriendProfileCardAdapterConverter");
      return this.mConverterClass;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w("QzoneStickyNoteManager", 4, "getConverterClass failed: " + localException.getMessage());
      }
    }
  }
  
  private Object getLoadCallback()
  {
    if (this.mLoadCallback != null) {
      return this.mLoadCallback;
    }
    try
    {
      Class localClass = ClassLoadUtils.load(this.mQzoneClassLoader, "com.qzone.homepage.ui.activity.FriendProfileCardAdapterConverter$LoadCallback");
      ClassLoader localClassLoader = this.mQzoneClassLoader;
      QzoneStickyNoteManager.3 local3 = new QzoneStickyNoteManager.3(this);
      this.mLoadCallback = Proxy.newProxyInstance(localClassLoader, new Class[] { localClass }, local3);
      return this.mLoadCallback;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.w("QzoneStickyNoteManager", 1, "getLocalCallback failed: " + localThrowable.getMessage());
      }
    }
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
      QLog.e("QzoneStickyNoteManager", 1, "loadMore failed: " + localException.getMessage());
    }
  }
  
  private Object newConverter(ListView paramListView)
  {
    boolean bool = true;
    if (this.mQzoneClassLoader == null) {
      return null;
    }
    try
    {
      Constructor localConstructor = getConverterClass().getConstructor(new Class[] { Activity.class, ListView.class, Long.TYPE, Boolean.TYPE });
      if ((this.mApp != null) && (this.mUin == this.mApp.getLongAccountUin())) {}
      for (;;)
      {
        paramListView = localConstructor.newInstance(new Object[] { this.mActivity, paramListView, Long.valueOf(this.mUin), Boolean.valueOf(bool) });
        return paramListView;
        bool = false;
      }
      return null;
    }
    catch (Exception paramListView)
    {
      QLog.w("QzoneStickyNoteManager", 4, "newConverter failed: " + paramListView.getMessage());
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
      QLog.w("QzoneStickyNoteManager", 4, "onLifecycle failed: " + paramString.getMessage());
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
    QZLog.d("QzoneStickyNoteManager", 4, "onLoadFinish " + paramBoolean);
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
      QLog.w("QzoneStickyNoteManager", 4, "onScrollProxy failed: " + paramAbsListView.getMessage());
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
      QLog.w("QzoneStickyNoteManager", 4, "onScrollStateChangedProxy failed: " + paramAbsListView.getMessage());
    }
  }
  
  private void scrollToStickNoteTop()
  {
    int i = this.mListView.getFirstVisiblePosition();
    QZLog.d("QzoneStickyNoteManager", 4, String.format("scrollToStickNoteTop firstVisiblePos=%s", new Object[] { Integer.valueOf(i) }));
    if ((i > 1) && ((this.mActivity instanceof FriendProfileCardActivity)))
    {
      i = ((FriendProfileCardActivity)this.mActivity).getTitleBarHeight();
      int j = this.mTitleView.getHeight();
      this.mListView.setSelectionFromTop(1, i + j);
    }
  }
  
  private void setAdapterIfNeed(ListAdapter paramListAdapter)
  {
    if ((!this.mAdapterLoaded) && (this.mListView != null) && (paramListAdapter != null))
    {
      this.mListView.setAdapter(paramListAdapter);
      if (this.mTitleView != null) {
        this.mTitleView.setVisibility(0);
      }
      this.mAdapterLoaded = true;
    }
  }
  
  private void setStickyNoteComponentToAdapter()
  {
    Class localClass;
    if (this.mQzoneAdapter != null)
    {
      localClass = getAdapterClass();
      if (localClass == null) {}
    }
    try
    {
      localClass.getDeclaredMethod("setStickyNoteComponent", new Class[] { bace.class }).invoke(this.mQzoneAdapter, new Object[] { this.mStickyNoteComponent });
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QzoneStickyNoteManager", 1, "setStickyNoteComponentToAdapter failed!", localException);
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
    if ((paramQQAppInterface == null) || (paramActivity == null) || (paramListView == null) || (paramCard == null)) {}
    for (;;)
    {
      return;
      try
      {
        l = Long.parseLong(paramCard.uin);
        QZLog.i("QzoneStickyNoteManager", "attach: " + this.mIsAttach + ", " + l);
        if ((l <= 0L) || (this.mIsAttach)) {
          continue;
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
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          long l = 0L;
        }
      }
    }
  }
  
  public void destroy()
  {
    if ((this.mAdapterLoaded) && (this.mListView != null)) {
      this.mListView.setAdapter(new blha(null));
    }
  }
  
  public BaseAdapter getAdapter()
  {
    if (this.mQzoneAdapter != null) {
      return this.mQzoneAdapter;
    }
    if (this.mConverter == null) {
      return null;
    }
    if (this.mQzoneClassLoader != null) {}
    try
    {
      this.mQzoneAdapter = ((BaseAdapter)getConverterClass().getDeclaredMethod("getAdapter", new Class[0]).invoke(this.mConverter, new Object[0]));
      setStickyNoteComponentToAdapter();
      return this.mQzoneAdapter;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w("QzoneStickyNoteManager", 4, "getAdapter failed: " + localException.getMessage());
      }
    }
  }
  
  public void init(Activity paramActivity, QQAppInterface paramQQAppInterface, Card paramCard, ListView paramListView, View paramView, bace parambace)
  {
    if ((paramActivity == null) || (paramQQAppInterface == null))
    {
      QLog.w("QzoneStickyNoteManager", 1, "init failed due to null parameter");
      return;
    }
    this.mListView = paramListView;
    this.mTitleView = paramView;
    this.mStickyNoteComponent = parambace;
    paramActivity = new WeakReference(paramActivity);
    paramListView = new WeakReference(paramListView);
    ThreadManager.getSubThreadHandler().post(new QzoneStickyNoteManager.1(this, paramQQAppInterface, paramActivity, paramListView, paramCard));
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
      if ((paramInt1 == 201209) && (paramInt2 == -1) && (!this.mCanLoadMore)) {
        scrollToStickNoteTop();
      }
      return;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        QZLog.e("QzoneStickyNoteManager", 4, new Object[] { "onActivityResult failed!", paramIntent });
      }
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
    if (this.mConverter == null) {}
    while (this.mQzoneClassLoader == null) {
      return;
    }
    try
    {
      getConverterClass().getDeclaredMethod("updateFriendProfileCard", new Class[] { Card.class }).invoke(this.mConverter, new Object[] { paramCard });
      return;
    }
    catch (Exception paramCard)
    {
      QLog.w("QzoneStickyNoteManager", 4, "updateFriendProfileCard failed: " + paramCard.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.stickynote.QzoneStickyNoteManager
 * JD-Core Version:    0.7.0.1
 */