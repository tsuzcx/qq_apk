package com.tencent.mobileqq.emoticonview;

import acnw;
import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EmotionPanelViewPagerAdapter
  extends PagerAdapter
{
  public float a;
  public int a;
  public Context a;
  public BaseChatPie a;
  public QQAppInterface a;
  public EmoticonCallback a;
  public EmotionPanelInfo a;
  public HashSet a;
  public List a;
  public Map a;
  public boolean a;
  public Map b;
  
  public EmotionPanelViewPagerAdapter(QQAppInterface paramQQAppInterface, Context paramContext, EmoticonCallback paramEmoticonCallback, BaseChatPie paramBaseChatPie, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = paramEmoticonCallback;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.b = new HashMap();
  }
  
  private void a(int paramInt, EmotionPanelInfo paramEmotionPanelInfo, BaseEmotionAdapter paramBaseEmotionAdapter, ListView paramListView)
  {
    ThreadManager.post(new acnw(this, paramInt, paramEmotionPanelInfo, paramBaseEmotionAdapter, paramListView), 5, null, true);
  }
  
  private void a(EmoticonPackage paramEmoticonPackage, BaseEmotionAdapter paramBaseEmotionAdapter, List paramList)
  {
    Object localObject;
    if (paramEmoticonPackage != null)
    {
      localObject = EmoticonRecDressup.a(paramEmoticonPackage.epId, false);
      if ((localObject == null) || (System.currentTimeMillis() - ((EmoticonRecDressup)localObject).b > EmoticonRecDressup.a)) {
        ((EmoticonHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).b(Integer.parseInt(paramEmoticonPackage.epId));
      }
      if (!(paramBaseEmotionAdapter instanceof BigEmotionDownloadedAdapter)) {
        break label86;
      }
      a((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13), Collections.singleton(paramEmoticonPackage), false);
    }
    label86:
    while ((!(paramBaseEmotionAdapter instanceof MagicFaceAdapter)) || (paramList == null)) {
      return;
    }
    paramEmoticonPackage = (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
    paramBaseEmotionAdapter = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (EmotionPanelData)paramList.next();
      if ((localObject instanceof PicEmoticonInfo))
      {
        localObject = (PicEmoticonInfo)localObject;
        if (((PicEmoticonInfo)localObject).a != null)
        {
          localObject = paramEmoticonPackage.a(((PicEmoticonInfo)localObject).a.epId);
          if (localObject != null) {
            paramBaseEmotionAdapter.add(localObject);
          }
        }
      }
    }
    a(paramEmoticonPackage, paramBaseEmotionAdapter, true);
  }
  
  private void a(List paramList, ListView paramListView)
  {
    if ((paramListView != null) && (paramList != null) && (paramList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionPanelViewPagerAdapter", 2, "onScrollStateChanged preload systemEmotion");
      }
      int k = paramListView.getFirstVisiblePosition();
      int j = (paramListView.getLastVisiblePosition() + 1) * 7;
      int i = j;
      while ((i < j + 35) && (i < paramList.size()))
      {
        paramListView = (EmotionPanelData)paramList.get(i);
        if ((paramListView instanceof SystemAndEmojiEmoticonInfo))
        {
          paramListView = (SystemAndEmojiEmoticonInfo)paramListView;
          if ((paramListView.c != 3) && (paramListView.b != -1))
          {
            paramListView = (URLDrawable)paramListView.a(false);
            if ((paramListView != null) && (paramListView.getStatus() != 1)) {
              paramListView.startDownload();
            }
          }
        }
        i += 1;
      }
      j = k * 7 - 1;
      i = j;
      while ((i >= 0) && (i > j - 35))
      {
        paramListView = (EmotionPanelData)paramList.get(i);
        if ((paramListView instanceof SystemAndEmojiEmoticonInfo))
        {
          paramListView = (SystemAndEmojiEmoticonInfo)paramListView;
          if ((paramListView.c != 3) && (paramListView.b != -1))
          {
            paramListView = (URLDrawable)paramListView.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Float);
            if ((paramListView != null) && (paramListView.getStatus() != 1)) {
              paramListView.startDownload();
            }
          }
        }
        i -= 1;
      }
    }
  }
  
  public BaseEmotionAdapter a(EmotionPanelInfo paramEmotionPanelInfo)
  {
    if (paramEmotionPanelInfo == null) {}
    do
    {
      do
      {
        return null;
        if (QLog.isColorLevel()) {
          QLog.d("EmotionPanelViewPagerAdapter", 2, "getAdapterFromCache type = " + paramEmotionPanelInfo.jdField_a_of_type_Int);
        }
        if ((paramEmotionPanelInfo.jdField_a_of_type_Int != 6) && (paramEmotionPanelInfo.jdField_a_of_type_Int != 10)) {
          break;
        }
        paramEmotionPanelInfo = paramEmotionPanelInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
      } while ((paramEmotionPanelInfo == null) || (TextUtils.isEmpty(paramEmotionPanelInfo.epId)) || (!this.b.containsKey(paramEmotionPanelInfo.epId)));
      return (BaseEmotionAdapter)this.b.get(paramEmotionPanelInfo.epId);
    } while (!this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramEmotionPanelInfo.jdField_a_of_type_Int)));
    return (BaseEmotionAdapter)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramEmotionPanelInfo.jdField_a_of_type_Int));
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelViewPagerAdapter", 2, "onDestroy");
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = null;
    }
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    if (this.b != null) {
      this.b.clear();
    }
    EmotionPanelListViewPool.a().a();
    EmotionPanelViewPool.a().a();
  }
  
  public void a(EmotionPanelInfo paramEmotionPanelInfo)
  {
    if (paramEmotionPanelInfo == null) {}
    do
    {
      return;
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        QLog.e("EmotionPanelViewPagerAdapter", 1, "refreshListViewAdapter error not in main thread");
        return;
      }
      int i = EmotionPanelConstans.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmotionPanelInfo);
      if (QLog.isColorLevel()) {
        QLog.d("EmotionPanelViewPagerAdapter", 2, "refreshListViewAdapter panelType = " + i);
      }
      paramEmotionPanelInfo = a(paramEmotionPanelInfo);
    } while (paramEmotionPanelInfo == null);
    paramEmotionPanelInfo.b();
    notifyDataSetChanged();
  }
  
  public void a(EmoticonManager paramEmoticonManager, Collection paramCollection, boolean paramBoolean)
  {
    long l2 = System.currentTimeMillis();
    EmoticonHandler localEmoticonHandler = (EmoticonHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)paramCollection.next();
      if (localEmoticonPackage.status == 2)
      {
        if (localEmoticonPackage.richIPReqTime == 0L) {}
        for (long l1 = 86400L;; l1 = localEmoticonPackage.richIPReqTime)
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmotionPanelViewPagerAdapter", 2, "rich ip emoticon, richReqTime = " + l1 + " epId = " + localEmoticonPackage.epId);
          }
          if (l2 - localEmoticonPackage.richIPLastReqTime <= l1 * 1000L) {
            break;
          }
          localEmoticonPackage.richIPLastReqTime = l2;
          localEmoticonHandler.a(localEmoticonPackage.epId, paramBoolean);
          paramEmoticonManager.a(localEmoticonPackage);
          break;
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_JavaUtilHashSet.add(paramString);
    }
  }
  
  public void a(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelViewPagerAdapter", 2, "setData justDownload:" + this.jdField_a_of_type_JavaUtilHashSet.toString());
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
    this.jdField_a_of_type_JavaUtilHashSet.clear();
  }
  
  public void b(EmotionPanelInfo paramEmotionPanelInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelInfo = paramEmotionPanelInfo;
    if (paramEmotionPanelInfo == null) {}
    do
    {
      return;
      int i = EmotionPanelConstans.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmotionPanelInfo);
      if (QLog.isColorLevel()) {
        QLog.d("EmotionPanelViewPagerAdapter", 2, "onPageSelected panelType = " + i);
      }
      paramEmotionPanelInfo = a(paramEmotionPanelInfo);
    } while (paramEmotionPanelInfo == null);
    paramEmotionPanelInfo.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelInfo = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelInfo;
    paramEmotionPanelInfo.c();
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelViewPagerAdapter", 2, "destroyItem position = " + paramInt);
    }
    if ((paramView == null) || (paramObject == null))
    {
      QLog.e("EmotionPanelViewPagerAdapter", 1, "container or object = null");
      return;
    }
    ((ViewGroup)paramView).removeView((View)paramObject);
    paramView = (EmotionPanelListView)paramObject;
    paramObject = (BaseEmotionAdapter)paramView.getAdapter();
    paramView.setAdapter(null);
    paramView.setOnScrollListener(null);
    if (paramObject != null)
    {
      paramInt = paramObject.b;
      if ((paramInt != 6) && (paramInt != 10)) {
        break label171;
      }
      EmoticonPackage localEmoticonPackage = paramObject.a();
      if ((localEmoticonPackage != null) && (!TextUtils.isEmpty(localEmoticonPackage.epId)) && (this.b.containsKey(localEmoticonPackage.epId))) {
        this.b.remove(localEmoticonPackage.epId);
      }
    }
    for (;;)
    {
      paramObject.a();
      EmotionPanelListViewPool.a().a(paramView);
      return;
      label171:
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt))) {
        this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(paramInt));
      }
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    QLog.e("EmotionPanelViewPagerAdapter", 1, "getCount count = 0");
    return 0;
  }
  
  public int getItemPosition(Object paramObject)
  {
    if ((paramObject instanceof View))
    {
      View localView = (View)paramObject;
      EmotionPanelInfo localEmotionPanelInfo = (EmotionPanelInfo)localView.getTag();
      if (localEmotionPanelInfo != null)
      {
        if ((localEmotionPanelInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null) && (this.jdField_a_of_type_JavaUtilHashSet.contains(localEmotionPanelInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmotionPanelViewPagerAdapter", 2, "getItemPosition destroy " + localView.getTag());
          }
          return -2;
        }
        int j = this.jdField_a_of_type_JavaUtilList.indexOf(localEmotionPanelInfo);
        int i = j;
        if (j < 0) {
          i = -2;
        }
        return i;
      }
    }
    return super.getItemPosition(paramObject);
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelViewPagerAdapter", 2, "instantiateItem position = " + paramInt);
    }
    EmotionPanelListView localEmotionPanelListView = EmotionPanelListViewPool.a().a(this.jdField_a_of_type_AndroidContentContext);
    if (localEmotionPanelListView == null)
    {
      QLog.e("EmotionPanelViewPagerAdapter", 1, "instantiateItem listView is null");
      return null;
    }
    localEmotionPanelListView.setDivider(null);
    localEmotionPanelListView.setEdgeEffectEnabled(false);
    localEmotionPanelListView.setSelector(2130846525);
    EmotionPanelInfo localEmotionPanelInfo = (EmotionPanelInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    int i = EmotionPanelConstans.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localEmotionPanelInfo);
    BaseEmotionAdapter localBaseEmotionAdapter = EmotionPanelListViewAdapterBuilder.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localEmotionPanelInfo.b, i, localEmotionPanelInfo.jdField_a_of_type_Int, localEmotionPanelInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);
    if (localBaseEmotionAdapter == null)
    {
      QLog.e("EmotionPanelViewPagerAdapter", 1, "instantiateItem adapter is null, panelType = " + i);
      return null;
    }
    localBaseEmotionAdapter.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelInfo = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelInfo;
    localBaseEmotionAdapter.a(localEmotionPanelListView);
    localEmotionPanelListView.setAdapter(localBaseEmotionAdapter);
    QLog.d("EmotionPanelViewPagerAdapter", 1, "instantiateItem start get data, panelType = " + i + ", position = " + paramInt + ", panelInfo = " + localEmotionPanelInfo);
    if ((localEmotionPanelInfo.jdField_a_of_type_Int == 6) || (localEmotionPanelInfo.jdField_a_of_type_Int == 10))
    {
      EmoticonPackage localEmoticonPackage = localEmotionPanelInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
      if ((localEmoticonPackage != null) && (!TextUtils.isEmpty(localEmoticonPackage.epId))) {
        this.b.put(localEmoticonPackage.epId, localBaseEmotionAdapter);
      }
    }
    for (;;)
    {
      if ((localEmotionPanelListView.getParent() != paramView) && (paramInt < getCount())) {
        ((ViewGroup)paramView).addView(localEmotionPanelListView);
      }
      localEmotionPanelListView.setTag(localEmotionPanelInfo);
      a(i, localEmotionPanelInfo, localBaseEmotionAdapter, localEmotionPanelListView);
      return localEmotionPanelListView;
      QLog.e("EmotionPanelViewPagerAdapter", 1, "instantiateItem put adapter to map error");
      continue;
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(localEmotionPanelInfo.jdField_a_of_type_Int), localBaseEmotionAdapter);
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */