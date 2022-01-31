package com.tencent.mobileqq.emoticonview;

import ajvn;
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
import anxi;
import anxk;
import anyg;
import anzj;
import anzn;
import aoal;
import aoam;
import aoap;
import aoar;
import aoas;
import aoau;
import aobl;
import aobp;
import aocs;
import aocu;
import askf;
import bbll;
import bfos;
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
  public anyg a;
  public aoap a;
  public BaseChatPie a;
  public QQAppInterface a;
  public HashSet<String> a;
  public List<aoap> a;
  public Map<Integer, anxi> a;
  public boolean a;
  public int b;
  public Map<String, anxi> b;
  public boolean b;
  
  public EmotionPanelViewPagerAdapter(QQAppInterface paramQQAppInterface, Context paramContext, anyg paramanyg, BaseChatPie paramBaseChatPie, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Anyg = paramanyg;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
  }
  
  private void a(int paramInt, aoap paramaoap, anxi paramanxi, ListView paramListView)
  {
    ThreadManager.post(new EmotionPanelViewPagerAdapter.1(this, paramInt, paramanxi, paramaoap, paramListView), 5, null, true);
  }
  
  private void a(EmoticonPackage paramEmoticonPackage, anxi paramanxi, List<aoam> paramList)
  {
    Object localObject;
    if (paramEmoticonPackage != null)
    {
      localObject = anzn.a(paramEmoticonPackage.epId, false);
      if ((localObject == null) || (System.currentTimeMillis() - ((anzn)localObject).b > anzn.a)) {
        ((ajvn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).b(Integer.parseInt(paramEmoticonPackage.epId));
      }
      if (!(paramanxi instanceof anxk)) {
        break label86;
      }
      a((askf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14), Collections.singleton(paramEmoticonPackage), false);
    }
    label86:
    while ((!(paramanxi instanceof aobl)) || (paramList == null)) {
      return;
    }
    paramEmoticonPackage = (askf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
    paramanxi = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (aoam)paramList.next();
      if ((localObject instanceof aobp))
      {
        localObject = (aobp)localObject;
        if (((aobp)localObject).a != null)
        {
          localObject = paramEmoticonPackage.a(((aobp)localObject).a.epId);
          if (localObject != null) {
            paramanxi.add(localObject);
          }
        }
      }
    }
    a(paramEmoticonPackage, paramanxi, true);
  }
  
  private void a(List<aoam> paramList, ListView paramListView)
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
        paramListView = (aoam)paramList.get(i);
        if ((paramListView instanceof aocu))
        {
          paramListView = (aocu)paramListView;
          if ((paramListView.c != 3) && (paramListView.jdField_b_of_type_Int != -1))
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
      while ((i >= 0) && (i > j - 35) && (i < paramList.size()))
      {
        paramListView = (aoam)paramList.get(i);
        if ((paramListView instanceof aocu))
        {
          paramListView = (aocu)paramListView;
          if ((paramListView.c != 3) && (paramListView.jdField_b_of_type_Int != -1))
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
  
  anxi a(aoap paramaoap)
  {
    if (paramaoap == null) {}
    do
    {
      do
      {
        return null;
        if (QLog.isColorLevel()) {
          QLog.d("EmotionPanelViewPagerAdapter", 2, "getAdapterFromCache type = " + paramaoap.jdField_a_of_type_Int);
        }
        if ((paramaoap.jdField_a_of_type_Int != 6) && (paramaoap.jdField_a_of_type_Int != 10)) {
          break;
        }
        paramaoap = paramaoap.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
      } while ((paramaoap == null) || (TextUtils.isEmpty(paramaoap.epId)) || (!this.jdField_b_of_type_JavaUtilMap.containsKey(paramaoap.epId)));
      return (anxi)this.jdField_b_of_type_JavaUtilMap.get(paramaoap.epId);
    } while (!this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramaoap.jdField_a_of_type_Int)));
    return (anxi)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramaoap.jdField_a_of_type_Int));
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelViewPagerAdapter", 2, "onDestroy");
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    if (this.jdField_a_of_type_Anyg != null) {
      this.jdField_a_of_type_Anyg = null;
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
    aoas.a().a();
    aoau.a().a();
  }
  
  public void a(aoap paramaoap)
  {
    if (paramaoap == null) {}
    do
    {
      return;
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        QLog.e("EmotionPanelViewPagerAdapter", 1, "refreshListViewAdapter error not in main thread");
        return;
      }
      int i = aoal.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaoap);
      if (QLog.isColorLevel()) {
        QLog.d("EmotionPanelViewPagerAdapter", 2, "refreshListViewAdapter panelType = " + i);
      }
      paramaoap = a(paramaoap);
    } while (paramaoap == null);
    paramaoap.b();
    notifyDataSetChanged();
  }
  
  public void a(askf paramaskf, Collection<EmoticonPackage> paramCollection, boolean paramBoolean)
  {
    long l2 = System.currentTimeMillis();
    ajvn localajvn = (ajvn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12);
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
          localajvn.a(localEmoticonPackage.epId, paramBoolean);
          paramaskf.a(localEmoticonPackage);
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
  
  public void a(List<aoap> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelViewPagerAdapter", 2, "setData justDownload:" + this.jdField_a_of_type_JavaUtilHashSet.toString());
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
    this.jdField_a_of_type_JavaUtilHashSet.clear();
  }
  
  public void b(aoap paramaoap)
  {
    this.jdField_a_of_type_Aoap = paramaoap;
    if (paramaoap == null) {}
    do
    {
      return;
      int i = aoal.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaoap);
      if (QLog.isColorLevel()) {
        QLog.d("EmotionPanelViewPagerAdapter", 2, "onPageSelected panelType = " + i);
      }
      paramaoap = a(paramaoap);
    } while (paramaoap == null);
    paramaoap.jdField_a_of_type_Aoap = this.jdField_a_of_type_Aoap;
    paramaoap.c();
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
      paramObject = (anxi)paramView.getAdapter();
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
      aoas.a().a(paramView);
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
      aoap localaoap = (aoap)localView.getTag();
      if (localaoap != null)
      {
        if ((localaoap.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null) && (this.jdField_a_of_type_JavaUtilHashSet.contains(localaoap.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmotionPanelViewPagerAdapter", 2, "getItemPosition destroy " + localView.getTag());
          }
          return -2;
        }
        int j = this.jdField_a_of_type_JavaUtilList.indexOf(localaoap);
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
    EmotionPanelListView localEmotionPanelListView = aoas.a().a(this.jdField_a_of_type_AndroidContentContext);
    if (localEmotionPanelListView == null)
    {
      QLog.e("EmotionPanelViewPagerAdapter", 1, "instantiateItem listView is null");
      paramView = null;
      return paramView;
    }
    localEmotionPanelListView.setDivider(null);
    localEmotionPanelListView.setEdgeEffectEnabled(false);
    localEmotionPanelListView.setSelector(2130849561);
    aoap localaoap = (aoap)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    int k = aoal.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaoap);
    int j = localaoap.jdField_b_of_type_Int;
    int i = j;
    if (this.jdField_a_of_type_Boolean)
    {
      j = Math.max(1, j * 4 / 7);
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("EmotionPanelViewPagerAdapter", 2, "multiWindowMode: " + localaoap.jdField_b_of_type_Int + "->" + j);
        i = j;
      }
    }
    anxi localanxi = aoar.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, i, k, localaoap.jdField_a_of_type_Int, localaoap.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, this.jdField_a_of_type_Anyg, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_b_of_type_Int, this.jdField_b_of_type_Boolean);
    if (localanxi == null)
    {
      QLog.e("EmotionPanelViewPagerAdapter", 1, "instantiateItem adapter is null, panelType = " + k);
      return null;
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
            if (!(localObject1 instanceof anzj)) {
              localEmotionPanelListView.setOnScrollListener(new anzj(localEmotionPanelListView, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), (bfos)localObject1));
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
              localImageButton.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131689909));
              localImageButton.setBackgroundResource(2130837701);
              localImageButton.setOnClickListener(this);
              if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getText())) {
                break label809;
              }
              bool = true;
              label518:
              localImageButton.setEnabled(bool);
              ((RelativeLayout.LayoutParams)localObject2).rightMargin = bbll.a(5.0F);
              ((RelativeLayout.LayoutParams)localObject2).bottomMargin = bbll.a(7.0F);
              ((RelativeLayout.LayoutParams)localObject2).addRule(11);
              ((RelativeLayout.LayoutParams)localObject2).addRule(12);
              ((RelativeLayout)localObject1).addView(localImageButton, (ViewGroup.LayoutParams)localObject2);
              this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localImageButton);
              localImageButton.measure(0, 0);
              if ((localanxi instanceof aocs)) {
                ((aocs)localanxi).a(localImageButton.getMeasuredHeight());
              }
            }
          }
        }
      }
    }
    localanxi.d = this.jdField_a_of_type_Int;
    localanxi.jdField_a_of_type_Aoap = this.jdField_a_of_type_Aoap;
    localanxi.a(localEmotionPanelListView);
    localEmotionPanelListView.setAdapter(localanxi);
    QLog.d("EmotionPanelViewPagerAdapter", 1, "instantiateItem start get data, panelType = " + k + ", position = " + paramInt + ", panelInfo = " + localaoap);
    if ((localaoap.jdField_a_of_type_Int == 6) || (localaoap.jdField_a_of_type_Int == 10))
    {
      localObject2 = localaoap.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
      if ((localObject2 != null) && (!TextUtils.isEmpty(((EmoticonPackage)localObject2).epId)))
      {
        this.jdField_b_of_type_JavaUtilMap.put(((EmoticonPackage)localObject2).epId, localanxi);
        label748:
        if ((localObject1 == null) || (((RelativeLayout)localObject1).getParent() == paramView) || (paramInt >= getCount())) {
          break label850;
        }
        ((ViewGroup)paramView).addView((View)localObject1);
      }
    }
    for (;;)
    {
      localEmotionPanelListView.setTag(localaoap);
      a(k, localaoap, localanxi, localEmotionPanelListView);
      paramView = (View)localObject1;
      if (localObject1 != null) {
        break;
      }
      return localEmotionPanelListView;
      label809:
      bool = false;
      break label518;
      QLog.e("EmotionPanelViewPagerAdapter", 1, "instantiateItem put adapter to map error");
      break label748;
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(localaoap.jdField_a_of_type_Int), localanxi);
      break label748;
      label850:
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
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */