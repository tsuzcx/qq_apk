package com.tencent.mobileqq.emoticonview;

import alna;
import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import apov;
import apox;
import appt;
import apre;
import aprk;
import apsi;
import apsj;
import apsm;
import apso;
import apsp;
import apsr;
import apti;
import aptm;
import apup;
import apur;
import aube;
import bdkf;
import bhpo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import com.tencent.widget.XEditTextEx;
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
  implements View.OnClickListener
{
  public float a;
  public int a;
  public Context a;
  public SparseArray<ImageButton> a;
  public appt a;
  public apsm a;
  public BaseChatPie a;
  public QQAppInterface a;
  public HashSet<String> a;
  public List<apsm> a;
  public Map<Integer, apov> a;
  public boolean a;
  int[] a;
  public int b;
  public Map<String, apov> b;
  public boolean b;
  boolean c = false;
  boolean d = false;
  
  public EmotionPanelViewPagerAdapter(QQAppInterface paramQQAppInterface, Context paramContext, appt paramappt, BaseChatPie paramBaseChatPie, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ArrayOfInt = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Appt = paramappt;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
  }
  
  private void a(int paramInt, apsm paramapsm, apov paramapov, ListView paramListView)
  {
    ThreadManager.post(new EmotionPanelViewPagerAdapter.1(this, paramInt, paramapov, paramapsm, paramListView), 5, null, true);
  }
  
  private void a(apov paramapov)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() != null) && ((paramapov instanceof apup)))
    {
      ((apup)paramapov).h = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().jdField_a_of_type_Int;
      ((apup)paramapov).i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().jdField_b_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().jdField_b_of_type_Int = -1;
    }
  }
  
  private void a(EmoticonPackage paramEmoticonPackage, apov paramapov, List<apsj> paramList)
  {
    Object localObject;
    if (paramEmoticonPackage != null)
    {
      localObject = aprk.a(paramEmoticonPackage.epId, false);
      if ((localObject == null) || (System.currentTimeMillis() - ((aprk)localObject).b > aprk.a)) {
        ((alna)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).b(Integer.parseInt(paramEmoticonPackage.epId));
      }
      if (!(paramapov instanceof apox)) {
        break label86;
      }
      a((aube)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14), Collections.singleton(paramEmoticonPackage), false);
    }
    label86:
    while ((!(paramapov instanceof apti)) || (paramList == null)) {
      return;
    }
    paramEmoticonPackage = (aube)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
    paramapov = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (apsj)paramList.next();
      if ((localObject instanceof aptm))
      {
        localObject = (aptm)localObject;
        if (((aptm)localObject).a != null)
        {
          localObject = paramEmoticonPackage.a(((aptm)localObject).a.epId);
          if (localObject != null) {
            paramapov.add(localObject);
          }
        }
      }
    }
    a(paramEmoticonPackage, paramapov, true);
  }
  
  private void a(List<apsj> paramList, ListView paramListView)
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
        paramListView = (apsj)paramList.get(i);
        if ((paramListView instanceof apur))
        {
          paramListView = (apur)paramListView;
          if ((paramListView.c != 3) && (paramListView.jdField_b_of_type_Int != -1))
          {
            paramListView = paramListView.a(false);
            if ((paramListView instanceof URLDrawable))
            {
              paramListView = (URLDrawable)paramListView;
              if ((paramListView != null) && (paramListView.getStatus() != 1)) {
                paramListView.startDownload();
              }
            }
          }
        }
        i += 1;
      }
      j = k * 7 - 1;
      i = j;
      while ((i >= 0) && (i > j - 35) && (i < paramList.size()))
      {
        paramListView = (apsj)paramList.get(i);
        if ((paramListView instanceof apur))
        {
          paramListView = (apur)paramListView;
          if ((paramListView.c != 3) && (paramListView.jdField_b_of_type_Int != -1))
          {
            paramListView = paramListView.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Float);
            if ((paramListView instanceof URLDrawable))
            {
              paramListView = (URLDrawable)paramListView;
              if ((paramListView != null) && (paramListView.getStatus() != 1)) {
                paramListView.startDownload();
              }
            }
          }
        }
        i -= 1;
      }
    }
  }
  
  public ImageButton a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelViewPagerAdapter", 2, "getDeleteButtonFromCache position = " + paramInt);
    }
    return (ImageButton)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public apov a(apsm paramapsm)
  {
    if (paramapsm == null) {}
    do
    {
      do
      {
        return null;
        if (QLog.isColorLevel()) {
          QLog.d("EmotionPanelViewPagerAdapter", 2, "getAdapterFromCache type = " + paramapsm.jdField_a_of_type_Int);
        }
        if ((paramapsm.jdField_a_of_type_Int != 6) && (paramapsm.jdField_a_of_type_Int != 10)) {
          break;
        }
        paramapsm = paramapsm.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
      } while ((paramapsm == null) || (TextUtils.isEmpty(paramapsm.epId)) || (!this.jdField_b_of_type_JavaUtilMap.containsKey(paramapsm.epId)));
      return (apov)this.jdField_b_of_type_JavaUtilMap.get(paramapsm.epId);
    } while (!this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramapsm.jdField_a_of_type_Int)));
    return (apov)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramapsm.jdField_a_of_type_Int));
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelViewPagerAdapter", 2, "onDestroy");
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    if (this.jdField_a_of_type_Appt != null) {
      this.jdField_a_of_type_Appt = null;
    }
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
      this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    }
    if (this.jdField_b_of_type_JavaUtilMap != null) {
      this.jdField_b_of_type_JavaUtilMap.clear();
    }
    apsp.a().a();
    apsr.a().a();
  }
  
  public void a(apsm paramapsm)
  {
    if (paramapsm == null) {}
    do
    {
      return;
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        QLog.e("EmotionPanelViewPagerAdapter", 1, "refreshListViewAdapter error not in main thread");
        return;
      }
      int i = apsi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramapsm);
      if (QLog.isColorLevel()) {
        QLog.d("EmotionPanelViewPagerAdapter", 2, "refreshListViewAdapter panelType = " + i);
      }
      paramapsm = a(paramapsm);
    } while (paramapsm == null);
    paramapsm.b();
    notifyDataSetChanged();
  }
  
  public void a(aube paramaube, Collection<EmoticonPackage> paramCollection, boolean paramBoolean)
  {
    long l2 = System.currentTimeMillis();
    alna localalna = (alna)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12);
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
          localalna.a(localEmoticonPackage.epId, paramBoolean);
          paramaube.a(localEmoticonPackage);
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
  
  public void a(List<apsm> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelViewPagerAdapter", 2, "setData justDownload:" + this.jdField_a_of_type_JavaUtilHashSet.toString());
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
    this.jdField_a_of_type_JavaUtilHashSet.clear();
  }
  
  public void b(apsm paramapsm)
  {
    this.jdField_a_of_type_Apsm = paramapsm;
    if (paramapsm == null) {}
    do
    {
      return;
      int i = apsi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramapsm);
      if (QLog.isColorLevel()) {
        QLog.d("EmotionPanelViewPagerAdapter", 2, "onPageSelected panelType = " + i);
      }
      paramapsm = a(paramapsm);
    } while (paramapsm == null);
    paramapsm.jdField_a_of_type_Apsm = this.jdField_a_of_type_Apsm;
    paramapsm.c();
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
    int i;
    if ((paramObject instanceof RelativeLayout))
    {
      paramView = (EmotionPanelListView)((RelativeLayout)paramObject).getChildAt(0);
      ((RelativeLayout)paramObject).removeViewAt(0);
      paramObject = (apov)paramView.getAdapter();
      paramView.setAdapter(null);
      paramView.setOnScrollListener(null);
      paramView.setEnableExtendPanle(false);
      paramView.setPullAndFastScrollListener(null);
      if (paramObject != null)
      {
        i = paramObject.jdField_b_of_type_Int;
        if ((i != 6) && (i != 10)) {
          break label229;
        }
        EmoticonPackage localEmoticonPackage = paramObject.a();
        if ((localEmoticonPackage != null) && (!TextUtils.isEmpty(localEmoticonPackage.epId)) && (this.jdField_b_of_type_JavaUtilMap.containsKey(localEmoticonPackage.epId))) {
          this.jdField_b_of_type_JavaUtilMap.remove(localEmoticonPackage.epId);
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
        this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
      }
      paramObject.a();
      apsp.a().a(paramView);
      return;
      paramView = (EmotionPanelListView)paramObject;
      break;
      label229:
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(i))) {
        this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
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
      apsm localapsm = (apsm)localView.getTag();
      if (localapsm != null)
      {
        if ((localapsm.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null) && (this.jdField_a_of_type_JavaUtilHashSet.contains(localapsm.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmotionPanelViewPagerAdapter", 2, "getItemPosition destroy " + localView.getTag());
          }
          return -2;
        }
        int j = this.jdField_a_of_type_JavaUtilList.indexOf(localapsm);
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
    EmotionPanelListView localEmotionPanelListView = apsp.a().a(this.jdField_a_of_type_AndroidContentContext);
    if (localEmotionPanelListView == null)
    {
      QLog.e("EmotionPanelViewPagerAdapter", 1, "instantiateItem listView is null");
      paramView = null;
      return paramView;
    }
    localEmotionPanelListView.setDivider(null);
    localEmotionPanelListView.setEdgeEffectEnabled(false);
    localEmotionPanelListView.setSelector(2130850002);
    apsm localapsm = (apsm)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    int k = apsi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localapsm);
    int j = localapsm.jdField_b_of_type_Int;
    int i = j;
    if (this.jdField_a_of_type_Boolean)
    {
      j = Math.max(1, j * 4 / 7);
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("EmotionPanelViewPagerAdapter", 2, "multiWindowMode: " + localapsm.jdField_b_of_type_Int + "->" + j);
        i = j;
      }
    }
    apov localapov = apso.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, i, k, localapsm.jdField_a_of_type_Int, localapsm.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, this.jdField_a_of_type_Appt, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_b_of_type_Int, this.jdField_b_of_type_Boolean);
    if (localapov == null)
    {
      QLog.e("EmotionPanelViewPagerAdapter", 1, "instantiateItem adapter is null, panelType = " + k);
      return null;
    }
    a(localapov);
    if ((localapov instanceof apup)) {
      ((apup)localapov).jdField_a_of_type_Boolean = this.c;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a != null)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().b())
          {
            localEmotionPanelListView.setEnableExtendPanle(true);
            localEmotionPanelListView.setPullAndFastScrollListener(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
            localObject1 = localEmotionPanelListView.getOnScrollListener();
            if (!(localObject1 instanceof apre)) {
              localEmotionPanelListView.setOnScrollListener(new apre(localEmotionPanelListView, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), (bhpo)localObject1));
            }
            if (k != 1)
            {
              localObject1 = localObject2;
              if (k != 2) {}
            }
            else
            {
              localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
              ((RelativeLayout)localObject1).setLayoutParams(new AbsListView.LayoutParams(-1, -1));
              ((RelativeLayout)localObject1).addView(localEmotionPanelListView, new RelativeLayout.LayoutParams(-1, -1));
              localObject2 = new RelativeLayout.LayoutParams(-2, -2);
              ImageButton localImageButton = new ImageButton(this.jdField_a_of_type_AndroidContentContext);
              localImageButton.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131689956));
              localImageButton.setBackgroundResource(2130837756);
              localImageButton.setOnClickListener(this);
              if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getText())) {
                break label835;
              }
              bool = true;
              label544:
              localImageButton.setEnabled(bool);
              ((RelativeLayout.LayoutParams)localObject2).rightMargin = bdkf.a(5.0F);
              ((RelativeLayout.LayoutParams)localObject2).bottomMargin = bdkf.a(7.0F);
              ((RelativeLayout.LayoutParams)localObject2).addRule(11);
              ((RelativeLayout.LayoutParams)localObject2).addRule(12);
              ((RelativeLayout)localObject1).addView(localImageButton, (ViewGroup.LayoutParams)localObject2);
              this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localImageButton);
              localImageButton.measure(0, 0);
              if ((localapov instanceof apup)) {
                ((apup)localapov).b(localImageButton.getMeasuredHeight());
              }
            }
          }
        }
      }
    }
    localapov.d = this.jdField_a_of_type_Int;
    localapov.jdField_a_of_type_Apsm = this.jdField_a_of_type_Apsm;
    localapov.a(localEmotionPanelListView);
    localEmotionPanelListView.setAdapter(localapov);
    QLog.d("EmotionPanelViewPagerAdapter", 1, "instantiateItem start get data, panelType = " + k + ", position = " + paramInt + ", panelInfo = " + localapsm);
    if ((localapsm.jdField_a_of_type_Int == 6) || (localapsm.jdField_a_of_type_Int == 10))
    {
      localObject2 = localapsm.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
      if ((localObject2 != null) && (!TextUtils.isEmpty(((EmoticonPackage)localObject2).epId)))
      {
        this.jdField_b_of_type_JavaUtilMap.put(((EmoticonPackage)localObject2).epId, localapov);
        label774:
        if ((localObject1 == null) || (((RelativeLayout)localObject1).getParent() == paramView) || (paramInt >= getCount())) {
          break label876;
        }
        ((ViewGroup)paramView).addView((View)localObject1);
      }
    }
    for (;;)
    {
      localEmotionPanelListView.setTag(localapsm);
      a(k, localapsm, localapov, localEmotionPanelListView);
      paramView = (View)localObject1;
      if (localObject1 != null) {
        break;
      }
      return localEmotionPanelListView;
      label835:
      bool = false;
      break label544;
      QLog.e("EmotionPanelViewPagerAdapter", 1, "instantiateItem put adapter to map error");
      break label774;
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(localapsm.jdField_a_of_type_Int), localapov);
      break label774;
      label876:
      if ((localEmotionPanelListView.getParent() != paramView) && (paramInt < getCount())) {
        ((ViewGroup)paramView).addView(localEmotionPanelListView);
      }
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */