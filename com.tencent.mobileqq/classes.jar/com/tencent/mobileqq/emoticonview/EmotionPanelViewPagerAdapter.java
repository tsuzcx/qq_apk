package com.tencent.mobileqq.emoticonview;

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
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import anwx;
import aslt;
import aslv;
import asmr;
import asnw;
import asoh;
import asoo;
import aspp;
import aspq;
import aspt;
import aspv;
import aspw;
import aspy;
import asra;
import asre;
import assh;
import assj;
import axfj;
import bhtq;
import blih;
import blmb;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class EmotionPanelViewPagerAdapter
  extends PagerAdapter
  implements View.OnClickListener
{
  public float a;
  public int a;
  public Context a;
  public SparseArray<ImageButton> a;
  public asmr a;
  public aspt a;
  public BaseChatPie a;
  public QQAppInterface a;
  public HashSet<String> a;
  public List<aspt> a;
  public Map<Integer, aslt> a;
  public boolean a;
  int[] a;
  public int b;
  public Map<String, aslt> b;
  public boolean b;
  boolean c = false;
  boolean d = false;
  
  public EmotionPanelViewPagerAdapter(QQAppInterface paramQQAppInterface, Context paramContext, asmr paramasmr, BaseChatPie paramBaseChatPie, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ArrayOfInt = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Asmr = paramasmr;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
  }
  
  @NotNull
  private RelativeLayout a(int paramInt, EmotionPanelListView paramEmotionPanelListView, aslt paramaslt)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
    localRelativeLayout.addView(paramEmotionPanelListView, new RelativeLayout.LayoutParams(-1, -1));
    paramEmotionPanelListView = new RelativeLayout.LayoutParams(-2, -2);
    ImageButton localImageButton = new ImageButton(this.jdField_a_of_type_AndroidContentContext);
    localImageButton.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131689856));
    localImageButton.setBackgroundResource(2130837995);
    localImageButton.setOnClickListener(this);
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getText())) {}
    for (int i = 8;; i = 0)
    {
      localImageButton.setVisibility(i);
      paramEmotionPanelListView.rightMargin = bhtq.a(5.0F);
      paramEmotionPanelListView.bottomMargin = bhtq.a(7.0F);
      paramEmotionPanelListView.addRule(11);
      paramEmotionPanelListView.addRule(12);
      localRelativeLayout.addView(localImageButton, paramEmotionPanelListView);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localImageButton);
      localImageButton.measure(0, 0);
      if ((paramaslt instanceof assh)) {
        ((assh)paramaslt).b(localImageButton.getMeasuredHeight());
      }
      return localRelativeLayout;
    }
  }
  
  private void a(int paramInt, aspt paramaspt, aslt paramaslt, ListView paramListView)
  {
    if (paramInt == 14)
    {
      a();
      return;
    }
    ThreadManager.post(new EmotionPanelViewPagerAdapter.1(this, paramInt, paramaslt, paramaspt, paramListView), 5, null, true);
  }
  
  private void a(aslt paramaslt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() != null) && ((paramaslt instanceof assh)))
    {
      ((assh)paramaslt).h = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().jdField_a_of_type_Int;
      ((assh)paramaslt).i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().jdField_b_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().jdField_b_of_type_Int = -1;
    }
  }
  
  private void a(EmoticonPackage paramEmoticonPackage, aslt paramaslt, List<aspq> paramList)
  {
    Object localObject;
    if (paramEmoticonPackage != null)
    {
      localObject = asoo.a(paramEmoticonPackage.epId, false);
      if ((localObject == null) || (System.currentTimeMillis() - ((asoo)localObject).b > asoo.a)) {
        ((anwx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).b(Integer.parseInt(paramEmoticonPackage.epId));
      }
      if (!(paramaslt instanceof aslv)) {
        break label86;
      }
      a((axfj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14), Collections.singleton(paramEmoticonPackage), false);
    }
    label86:
    while ((!(paramaslt instanceof asra)) || (paramList == null)) {
      return;
    }
    paramEmoticonPackage = (axfj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
    paramaslt = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (aspq)paramList.next();
      if ((localObject instanceof asre))
      {
        localObject = (asre)localObject;
        if (((asre)localObject).a != null)
        {
          localObject = paramEmoticonPackage.a(((asre)localObject).a.epId);
          if (localObject != null) {
            paramaslt.add(localObject);
          }
        }
      }
    }
    a(paramEmoticonPackage, paramaslt, true);
  }
  
  private void a(List<aspq> paramList, ListView paramListView)
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
        paramListView = (aspq)paramList.get(i);
        if ((paramListView instanceof assj))
        {
          paramListView = (assj)paramListView;
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
        paramListView = (aspq)paramList.get(i);
        if ((paramListView instanceof assj))
        {
          paramListView = (assj)paramListView;
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
  
  protected RelativeLayout a(EmotionPanelListView paramEmotionPanelListView, int paramInt, aslt paramaslt)
  {
    if (paramInt == 14)
    {
      RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      localRelativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      localRelativeLayout.addView(paramEmotionPanelListView, new RelativeLayout.LayoutParams(-1, -1));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.topMargin = bhtq.a(60.0F);
      localLayoutParams.addRule(12);
      View localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558597, null);
      localRelativeLayout.addView(localView, localLayoutParams);
      a(paramEmotionPanelListView, paramaslt, localView, paramInt);
      paramEmotionPanelListView.setVerticalScrollBarEnabled(false);
      return localRelativeLayout;
    }
    a(paramEmotionPanelListView);
    return null;
  }
  
  public aslt a(aspt paramaspt)
  {
    if (paramaspt == null) {}
    do
    {
      do
      {
        return null;
        if (QLog.isColorLevel()) {
          QLog.d("EmotionPanelViewPagerAdapter", 2, "getAdapterFromCache type = " + paramaspt.jdField_a_of_type_Int);
        }
        if ((paramaspt.jdField_a_of_type_Int != 6) && (paramaspt.jdField_a_of_type_Int != 10)) {
          break;
        }
        paramaspt = paramaspt.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
      } while ((paramaspt == null) || (TextUtils.isEmpty(paramaspt.epId)) || (!this.jdField_b_of_type_JavaUtilMap.containsKey(paramaspt.epId)));
      return (aslt)this.jdField_b_of_type_JavaUtilMap.get(paramaspt.epId);
    } while (!this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramaspt.jdField_a_of_type_Int)));
    return (aslt)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramaspt.jdField_a_of_type_Int));
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() == null)) {
      return;
    }
    ((asnw)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a().a(7)).r();
  }
  
  protected void a(int paramInt, aspt paramaspt, aslt paramaslt, ListView paramListView, List<aspq> paramList)
  {
    ThreadManager.getUIHandler().post(new EmotionPanelViewPagerAdapter.2(this, paramInt, paramaspt, paramListView, paramList, paramaslt));
  }
  
  public void a(aspt paramaspt)
  {
    if (paramaspt == null) {}
    do
    {
      return;
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        QLog.e("EmotionPanelViewPagerAdapter", 1, "refreshListViewAdapter error not in main thread");
        return;
      }
      int i = aspp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaspt);
      if (QLog.isColorLevel()) {
        QLog.d("EmotionPanelViewPagerAdapter", 2, "refreshListViewAdapter panelType = " + i);
      }
      paramaspt = a(paramaspt);
    } while (paramaspt == null);
    paramaspt.b();
    notifyDataSetChanged();
  }
  
  public void a(axfj paramaxfj, Collection<EmoticonPackage> paramCollection, boolean paramBoolean)
  {
    long l2 = System.currentTimeMillis();
    anwx localanwx = (anwx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12);
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
          localanwx.a(localEmoticonPackage.epId, paramBoolean);
          paramaxfj.a(localEmoticonPackage);
          break;
        }
      }
    }
  }
  
  protected void a(EmotionPanelListView paramEmotionPanelListView)
  {
    if ((paramEmotionPanelListView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() == null)) {
      return;
    }
    asnw localasnw = (asnw)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a().a(7);
    localasnw.a(paramEmotionPanelListView);
    paramEmotionPanelListView.removeOnScrollListener(localasnw);
  }
  
  protected void a(EmotionPanelListView paramEmotionPanelListView, aslt paramaslt, View paramView, int paramInt)
  {
    if ((paramEmotionPanelListView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() == null)) {
      return;
    }
    asnw localasnw = (asnw)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a().a(7);
    localasnw.a(paramEmotionPanelListView, paramaslt, paramInt);
    localasnw.b(paramView);
    paramEmotionPanelListView.addOnScrollListener(localasnw);
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_JavaUtilHashSet.add(paramString);
    }
  }
  
  public void a(List<aspt> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelViewPagerAdapter", 2, "setData justDownload:" + this.jdField_a_of_type_JavaUtilHashSet.toString());
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
    this.jdField_a_of_type_JavaUtilHashSet.clear();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelViewPagerAdapter", 2, "onDestroy");
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      notifyDataSetChanged();
    }
    if (this.jdField_a_of_type_Asmr != null) {
      this.jdField_a_of_type_Asmr = null;
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
    aspw.a().a();
    aspy.a().a();
  }
  
  public void b(aspt paramaspt)
  {
    this.jdField_a_of_type_Aspt = paramaspt;
    if (paramaspt == null) {}
    do
    {
      return;
      int i = aspp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaspt);
      if (QLog.isColorLevel()) {
        QLog.d("EmotionPanelViewPagerAdapter", 2, "onPageSelected panelType = " + i);
      }
      paramaspt = a(paramaspt);
    } while (paramaspt == null);
    paramaspt.jdField_a_of_type_Aspt = this.jdField_a_of_type_Aspt;
    paramaspt.c();
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
    label113:
    int i;
    if ((paramObject instanceof RelativeLayout))
    {
      paramView = (EmotionPanelListView)((RelativeLayout)paramObject).getChildAt(0);
      ((RelativeLayout)paramObject).removeViewAt(0);
      paramObject = paramView.getAdapter();
      if (!(paramObject instanceof blmb)) {
        break label251;
      }
      paramObject = (aslt)((blmb)paramObject).getWrappedAdapter();
      paramView.setAdapter(null);
      paramView.setOnScrollListener(null);
      paramView.setEnableExtendPanle(false);
      paramView.setPullAndFastScrollListener(null);
      a(paramView);
      if (paramObject != null)
      {
        i = paramObject.jdField_b_of_type_Int;
        if ((i != 6) && (i != 10)) {
          break label259;
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
      aspw.a().a(paramView);
      return;
      paramView = (EmotionPanelListView)paramObject;
      break;
      label251:
      paramObject = (aslt)paramObject;
      break label113;
      label259:
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
      aspt localaspt = (aspt)localView.getTag();
      if (localaspt != null)
      {
        if ((localaspt.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null) && (this.jdField_a_of_type_JavaUtilHashSet.contains(localaspt.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmotionPanelViewPagerAdapter", 2, "getItemPosition destroy " + localView.getTag());
          }
          return -2;
        }
        int j = this.jdField_a_of_type_JavaUtilList.indexOf(localaspt);
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
    EmotionPanelListView localEmotionPanelListView = aspw.a().a(this.jdField_a_of_type_AndroidContentContext);
    if (localEmotionPanelListView == null)
    {
      QLog.e("EmotionPanelViewPagerAdapter", 1, "instantiateItem listView is null");
      paramView = null;
      return paramView;
    }
    localEmotionPanelListView.setDivider(null);
    localEmotionPanelListView.setVerticalScrollBarEnabled(true);
    localEmotionPanelListView.setEdgeEffectEnabled(false);
    localEmotionPanelListView.setSelector(2130850683);
    aspt localaspt = (aspt)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    int k = aspp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaspt);
    int j = localaspt.jdField_b_of_type_Int;
    int i = j;
    if (this.jdField_a_of_type_Boolean)
    {
      j = Math.max(1, j * 4 / 7);
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("EmotionPanelViewPagerAdapter", 2, "multiWindowMode: " + localaspt.jdField_b_of_type_Int + "->" + j);
        i = j;
      }
    }
    aslt localaslt = aspv.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, i, k, localaspt.jdField_a_of_type_Int, localaspt.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, this.jdField_a_of_type_Asmr, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_b_of_type_Int, this.jdField_b_of_type_Boolean);
    if (localaslt == null)
    {
      QLog.e("EmotionPanelViewPagerAdapter", 1, "instantiateItem adapter is null, panelType = " + k);
      return null;
    }
    a(localaslt);
    if ((localaslt instanceof assh)) {
      ((assh)localaslt).jdField_a_of_type_Boolean = this.c;
    }
    EmoticonPackage localEmoticonPackage = null;
    Object localObject = localEmoticonPackage;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      localObject = localEmoticonPackage;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() != null)
      {
        localObject = localEmoticonPackage;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a != null)
        {
          localObject = localEmoticonPackage;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().b())
          {
            localEmotionPanelListView.setEnableExtendPanle(true);
            localEmotionPanelListView.setPullAndFastScrollListener(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
            localObject = localEmotionPanelListView.getOnScrollListener();
            if (!(localObject instanceof asoh)) {
              localEmotionPanelListView.setOnScrollListener(new asoh(localEmotionPanelListView, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), (blih)localObject));
            }
            if ((k != 1) && (k != 2)) {
              break label646;
            }
            localObject = a(paramInt, localEmotionPanelListView, localaslt);
          }
        }
      }
    }
    label444:
    localaslt.d = this.jdField_a_of_type_Int;
    localaslt.jdField_a_of_type_Aspt = this.jdField_a_of_type_Aspt;
    localaslt.a(localEmotionPanelListView);
    localEmotionPanelListView.setAdapter(localaslt);
    QLog.d("EmotionPanelViewPagerAdapter", 1, "instantiateItem start get data, panelType = " + k + ", position = " + paramInt + ", panelInfo = " + localaspt);
    if ((localaspt.jdField_a_of_type_Int == 6) || (localaspt.jdField_a_of_type_Int == 10))
    {
      localEmoticonPackage = localaspt.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
      if ((localEmoticonPackage != null) && (!TextUtils.isEmpty(localEmoticonPackage.epId)))
      {
        this.jdField_b_of_type_JavaUtilMap.put(localEmoticonPackage.epId, localaslt);
        label585:
        if ((localObject == null) || (((RelativeLayout)localObject).getParent() == paramView) || (paramInt >= getCount())) {
          break label697;
        }
        ((ViewGroup)paramView).addView((View)localObject);
      }
    }
    for (;;)
    {
      localEmotionPanelListView.setTag(localaspt);
      a(k, localaspt, localaslt, localEmotionPanelListView);
      paramView = (View)localObject;
      if (localObject != null) {
        break;
      }
      return localEmotionPanelListView;
      label646:
      localObject = a(localEmotionPanelListView, k, localaslt);
      break label444;
      QLog.e("EmotionPanelViewPagerAdapter", 1, "instantiateItem put adapter to map error");
      break label585;
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(localaspt.jdField_a_of_type_Int), localaslt);
      break label585;
      label697:
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
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */