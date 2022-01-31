package com.tencent.mobileqq.emoticonview;

import ajvp;
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
import anxd;
import anxf;
import anyb;
import anze;
import anzi;
import aoag;
import aoah;
import aoak;
import aoam;
import aoan;
import aoap;
import aobg;
import aobk;
import aocn;
import aocp;
import askd;
import bbkx;
import bfob;
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
  public anyb a;
  public aoak a;
  public BaseChatPie a;
  public QQAppInterface a;
  public HashSet<String> a;
  public List<aoak> a;
  public Map<Integer, anxd> a;
  public boolean a;
  public int b;
  public Map<String, anxd> b;
  public boolean b;
  
  public EmotionPanelViewPagerAdapter(QQAppInterface paramQQAppInterface, Context paramContext, anyb paramanyb, BaseChatPie paramBaseChatPie, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Anyb = paramanyb;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
  }
  
  private void a(int paramInt, aoak paramaoak, anxd paramanxd, ListView paramListView)
  {
    ThreadManager.post(new EmotionPanelViewPagerAdapter.1(this, paramInt, paramanxd, paramaoak, paramListView), 5, null, true);
  }
  
  private void a(EmoticonPackage paramEmoticonPackage, anxd paramanxd, List<aoah> paramList)
  {
    Object localObject;
    if (paramEmoticonPackage != null)
    {
      localObject = anzi.a(paramEmoticonPackage.epId, false);
      if ((localObject == null) || (System.currentTimeMillis() - ((anzi)localObject).b > anzi.a)) {
        ((ajvp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).b(Integer.parseInt(paramEmoticonPackage.epId));
      }
      if (!(paramanxd instanceof anxf)) {
        break label86;
      }
      a((askd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14), Collections.singleton(paramEmoticonPackage), false);
    }
    label86:
    while ((!(paramanxd instanceof aobg)) || (paramList == null)) {
      return;
    }
    paramEmoticonPackage = (askd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
    paramanxd = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (aoah)paramList.next();
      if ((localObject instanceof aobk))
      {
        localObject = (aobk)localObject;
        if (((aobk)localObject).a != null)
        {
          localObject = paramEmoticonPackage.a(((aobk)localObject).a.epId);
          if (localObject != null) {
            paramanxd.add(localObject);
          }
        }
      }
    }
    a(paramEmoticonPackage, paramanxd, true);
  }
  
  private void a(List<aoah> paramList, ListView paramListView)
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
        paramListView = (aoah)paramList.get(i);
        if ((paramListView instanceof aocp))
        {
          paramListView = (aocp)paramListView;
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
        paramListView = (aoah)paramList.get(i);
        if ((paramListView instanceof aocp))
        {
          paramListView = (aocp)paramListView;
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
  
  anxd a(aoak paramaoak)
  {
    if (paramaoak == null) {}
    do
    {
      do
      {
        return null;
        if (QLog.isColorLevel()) {
          QLog.d("EmotionPanelViewPagerAdapter", 2, "getAdapterFromCache type = " + paramaoak.jdField_a_of_type_Int);
        }
        if ((paramaoak.jdField_a_of_type_Int != 6) && (paramaoak.jdField_a_of_type_Int != 10)) {
          break;
        }
        paramaoak = paramaoak.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
      } while ((paramaoak == null) || (TextUtils.isEmpty(paramaoak.epId)) || (!this.jdField_b_of_type_JavaUtilMap.containsKey(paramaoak.epId)));
      return (anxd)this.jdField_b_of_type_JavaUtilMap.get(paramaoak.epId);
    } while (!this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramaoak.jdField_a_of_type_Int)));
    return (anxd)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramaoak.jdField_a_of_type_Int));
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelViewPagerAdapter", 2, "onDestroy");
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    if (this.jdField_a_of_type_Anyb != null) {
      this.jdField_a_of_type_Anyb = null;
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
    aoan.a().a();
    aoap.a().a();
  }
  
  public void a(aoak paramaoak)
  {
    if (paramaoak == null) {}
    do
    {
      return;
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        QLog.e("EmotionPanelViewPagerAdapter", 1, "refreshListViewAdapter error not in main thread");
        return;
      }
      int i = aoag.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaoak);
      if (QLog.isColorLevel()) {
        QLog.d("EmotionPanelViewPagerAdapter", 2, "refreshListViewAdapter panelType = " + i);
      }
      paramaoak = a(paramaoak);
    } while (paramaoak == null);
    paramaoak.b();
    notifyDataSetChanged();
  }
  
  public void a(askd paramaskd, Collection<EmoticonPackage> paramCollection, boolean paramBoolean)
  {
    long l2 = System.currentTimeMillis();
    ajvp localajvp = (ajvp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12);
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
          localajvp.a(localEmoticonPackage.epId, paramBoolean);
          paramaskd.a(localEmoticonPackage);
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
  
  public void a(List<aoak> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelViewPagerAdapter", 2, "setData justDownload:" + this.jdField_a_of_type_JavaUtilHashSet.toString());
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
    this.jdField_a_of_type_JavaUtilHashSet.clear();
  }
  
  public void b(aoak paramaoak)
  {
    this.jdField_a_of_type_Aoak = paramaoak;
    if (paramaoak == null) {}
    do
    {
      return;
      int i = aoag.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaoak);
      if (QLog.isColorLevel()) {
        QLog.d("EmotionPanelViewPagerAdapter", 2, "onPageSelected panelType = " + i);
      }
      paramaoak = a(paramaoak);
    } while (paramaoak == null);
    paramaoak.jdField_a_of_type_Aoak = this.jdField_a_of_type_Aoak;
    paramaoak.c();
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
      paramObject = (anxd)paramView.getAdapter();
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
      aoan.a().a(paramView);
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
      aoak localaoak = (aoak)localView.getTag();
      if (localaoak != null)
      {
        if ((localaoak.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null) && (this.jdField_a_of_type_JavaUtilHashSet.contains(localaoak.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmotionPanelViewPagerAdapter", 2, "getItemPosition destroy " + localView.getTag());
          }
          return -2;
        }
        int j = this.jdField_a_of_type_JavaUtilList.indexOf(localaoak);
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
    EmotionPanelListView localEmotionPanelListView = aoan.a().a(this.jdField_a_of_type_AndroidContentContext);
    if (localEmotionPanelListView == null)
    {
      QLog.e("EmotionPanelViewPagerAdapter", 1, "instantiateItem listView is null");
      paramView = null;
      return paramView;
    }
    localEmotionPanelListView.setDivider(null);
    localEmotionPanelListView.setEdgeEffectEnabled(false);
    localEmotionPanelListView.setSelector(2130849552);
    aoak localaoak = (aoak)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    int k = aoag.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaoak);
    int j = localaoak.jdField_b_of_type_Int;
    int i = j;
    if (this.jdField_a_of_type_Boolean)
    {
      j = Math.max(1, j * 4 / 7);
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("EmotionPanelViewPagerAdapter", 2, "multiWindowMode: " + localaoak.jdField_b_of_type_Int + "->" + j);
        i = j;
      }
    }
    anxd localanxd = aoam.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, i, k, localaoak.jdField_a_of_type_Int, localaoak.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, this.jdField_a_of_type_Anyb, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_b_of_type_Int, this.jdField_b_of_type_Boolean);
    if (localanxd == null)
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
            if (!(localObject1 instanceof anze)) {
              localEmotionPanelListView.setOnScrollListener(new anze(localEmotionPanelListView, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), (bfob)localObject1));
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
              ((RelativeLayout.LayoutParams)localObject2).rightMargin = bbkx.a(5.0F);
              ((RelativeLayout.LayoutParams)localObject2).bottomMargin = bbkx.a(7.0F);
              ((RelativeLayout.LayoutParams)localObject2).addRule(11);
              ((RelativeLayout.LayoutParams)localObject2).addRule(12);
              ((RelativeLayout)localObject1).addView(localImageButton, (ViewGroup.LayoutParams)localObject2);
              this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localImageButton);
              localImageButton.measure(0, 0);
              if ((localanxd instanceof aocn)) {
                ((aocn)localanxd).a(localImageButton.getMeasuredHeight());
              }
            }
          }
        }
      }
    }
    localanxd.d = this.jdField_a_of_type_Int;
    localanxd.jdField_a_of_type_Aoak = this.jdField_a_of_type_Aoak;
    localanxd.a(localEmotionPanelListView);
    localEmotionPanelListView.setAdapter(localanxd);
    QLog.d("EmotionPanelViewPagerAdapter", 1, "instantiateItem start get data, panelType = " + k + ", position = " + paramInt + ", panelInfo = " + localaoak);
    if ((localaoak.jdField_a_of_type_Int == 6) || (localaoak.jdField_a_of_type_Int == 10))
    {
      localObject2 = localaoak.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
      if ((localObject2 != null) && (!TextUtils.isEmpty(((EmoticonPackage)localObject2).epId)))
      {
        this.jdField_b_of_type_JavaUtilMap.put(((EmoticonPackage)localObject2).epId, localanxd);
        label748:
        if ((localObject1 == null) || (((RelativeLayout)localObject1).getParent() == paramView) || (paramInt >= getCount())) {
          break label850;
        }
        ((ViewGroup)paramView).addView((View)localObject1);
      }
    }
    for (;;)
    {
      localEmotionPanelListView.setTag(localaoak);
      a(k, localaoak, localanxd, localEmotionPanelListView);
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
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(localaoak.jdField_a_of_type_Int), localanxd);
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