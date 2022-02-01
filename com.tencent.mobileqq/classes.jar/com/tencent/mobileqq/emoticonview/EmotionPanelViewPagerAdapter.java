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
import anlb;
import arwf;
import arwh;
import arxd;
import aryi;
import aryt;
import arza;
import asab;
import asac;
import asaf;
import asah;
import asai;
import asak;
import asbm;
import asbq;
import asct;
import ascv;
import awmr;
import bgtn;
import bkhe;
import bkky;
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
  public arxd a;
  public asaf a;
  public BaseChatPie a;
  public QQAppInterface a;
  public HashSet<String> a;
  public List<asaf> a;
  public Map<Integer, arwf> a;
  public boolean a;
  int[] a;
  public int b;
  public Map<String, arwf> b;
  public boolean b;
  boolean c = false;
  boolean d = false;
  
  public EmotionPanelViewPagerAdapter(QQAppInterface paramQQAppInterface, Context paramContext, arxd paramarxd, BaseChatPie paramBaseChatPie, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ArrayOfInt = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Arxd = paramarxd;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
  }
  
  @NotNull
  private RelativeLayout a(int paramInt, EmotionPanelListView paramEmotionPanelListView, arwf paramarwf)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
    localRelativeLayout.addView(paramEmotionPanelListView, new RelativeLayout.LayoutParams(-1, -1));
    paramEmotionPanelListView = new RelativeLayout.LayoutParams(-2, -2);
    ImageButton localImageButton = new ImageButton(this.jdField_a_of_type_AndroidContentContext);
    localImageButton.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131689851));
    localImageButton.setBackgroundResource(2130837988);
    localImageButton.setOnClickListener(this);
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getText())) {}
    for (int i = 8;; i = 0)
    {
      localImageButton.setVisibility(i);
      paramEmotionPanelListView.rightMargin = bgtn.a(5.0F);
      paramEmotionPanelListView.bottomMargin = bgtn.a(7.0F);
      paramEmotionPanelListView.addRule(11);
      paramEmotionPanelListView.addRule(12);
      localRelativeLayout.addView(localImageButton, paramEmotionPanelListView);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localImageButton);
      localImageButton.measure(0, 0);
      if ((paramarwf instanceof asct)) {
        ((asct)paramarwf).b(localImageButton.getMeasuredHeight());
      }
      return localRelativeLayout;
    }
  }
  
  private void a(int paramInt, asaf paramasaf, arwf paramarwf, ListView paramListView)
  {
    if (paramInt == 14)
    {
      a();
      return;
    }
    ThreadManager.post(new EmotionPanelViewPagerAdapter.1(this, paramInt, paramarwf, paramasaf, paramListView), 5, null, true);
  }
  
  private void a(arwf paramarwf)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() != null) && ((paramarwf instanceof asct)))
    {
      ((asct)paramarwf).h = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().jdField_a_of_type_Int;
      ((asct)paramarwf).i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().jdField_b_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().jdField_b_of_type_Int = -1;
    }
  }
  
  private void a(EmoticonPackage paramEmoticonPackage, arwf paramarwf, List<asac> paramList)
  {
    Object localObject;
    if (paramEmoticonPackage != null)
    {
      localObject = arza.a(paramEmoticonPackage.epId, false);
      if ((localObject == null) || (System.currentTimeMillis() - ((arza)localObject).b > arza.a)) {
        ((anlb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).b(Integer.parseInt(paramEmoticonPackage.epId));
      }
      if (!(paramarwf instanceof arwh)) {
        break label86;
      }
      a((awmr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14), Collections.singleton(paramEmoticonPackage), false);
    }
    label86:
    while ((!(paramarwf instanceof asbm)) || (paramList == null)) {
      return;
    }
    paramEmoticonPackage = (awmr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
    paramarwf = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (asac)paramList.next();
      if ((localObject instanceof asbq))
      {
        localObject = (asbq)localObject;
        if (((asbq)localObject).a != null)
        {
          localObject = paramEmoticonPackage.a(((asbq)localObject).a.epId);
          if (localObject != null) {
            paramarwf.add(localObject);
          }
        }
      }
    }
    a(paramEmoticonPackage, paramarwf, true);
  }
  
  private void a(List<asac> paramList, ListView paramListView)
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
        paramListView = (asac)paramList.get(i);
        if ((paramListView instanceof ascv))
        {
          paramListView = (ascv)paramListView;
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
        paramListView = (asac)paramList.get(i);
        if ((paramListView instanceof ascv))
        {
          paramListView = (ascv)paramListView;
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
  
  protected RelativeLayout a(EmotionPanelListView paramEmotionPanelListView, int paramInt, arwf paramarwf)
  {
    if (paramInt == 14)
    {
      RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      localRelativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      localRelativeLayout.addView(paramEmotionPanelListView, new RelativeLayout.LayoutParams(-1, -1));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.topMargin = bgtn.a(60.0F);
      localLayoutParams.addRule(12);
      View localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558595, null);
      localRelativeLayout.addView(localView, localLayoutParams);
      a(paramEmotionPanelListView, paramarwf, localView, paramInt);
      paramEmotionPanelListView.setVerticalScrollBarEnabled(false);
      return localRelativeLayout;
    }
    a(paramEmotionPanelListView);
    return null;
  }
  
  public arwf a(asaf paramasaf)
  {
    if (paramasaf == null) {}
    do
    {
      do
      {
        return null;
        if (QLog.isColorLevel()) {
          QLog.d("EmotionPanelViewPagerAdapter", 2, "getAdapterFromCache type = " + paramasaf.jdField_a_of_type_Int);
        }
        if ((paramasaf.jdField_a_of_type_Int != 6) && (paramasaf.jdField_a_of_type_Int != 10)) {
          break;
        }
        paramasaf = paramasaf.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
      } while ((paramasaf == null) || (TextUtils.isEmpty(paramasaf.epId)) || (!this.jdField_b_of_type_JavaUtilMap.containsKey(paramasaf.epId)));
      return (arwf)this.jdField_b_of_type_JavaUtilMap.get(paramasaf.epId);
    } while (!this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramasaf.jdField_a_of_type_Int)));
    return (arwf)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramasaf.jdField_a_of_type_Int));
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() == null)) {
      return;
    }
    ((aryi)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a().a(7)).r();
  }
  
  protected void a(int paramInt, asaf paramasaf, arwf paramarwf, ListView paramListView, List<asac> paramList)
  {
    ThreadManager.getUIHandler().post(new EmotionPanelViewPagerAdapter.2(this, paramInt, paramasaf, paramListView, paramList, paramarwf));
  }
  
  public void a(asaf paramasaf)
  {
    if (paramasaf == null) {}
    do
    {
      return;
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        QLog.e("EmotionPanelViewPagerAdapter", 1, "refreshListViewAdapter error not in main thread");
        return;
      }
      int i = asab.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramasaf);
      if (QLog.isColorLevel()) {
        QLog.d("EmotionPanelViewPagerAdapter", 2, "refreshListViewAdapter panelType = " + i);
      }
      paramasaf = a(paramasaf);
    } while (paramasaf == null);
    paramasaf.b();
    notifyDataSetChanged();
  }
  
  public void a(awmr paramawmr, Collection<EmoticonPackage> paramCollection, boolean paramBoolean)
  {
    long l2 = System.currentTimeMillis();
    anlb localanlb = (anlb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12);
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
          localanlb.a(localEmoticonPackage.epId, paramBoolean);
          paramawmr.a(localEmoticonPackage);
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
    aryi localaryi = (aryi)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a().a(7);
    localaryi.a(paramEmotionPanelListView);
    paramEmotionPanelListView.removeOnScrollListener(localaryi);
  }
  
  protected void a(EmotionPanelListView paramEmotionPanelListView, arwf paramarwf, View paramView, int paramInt)
  {
    if ((paramEmotionPanelListView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() == null)) {
      return;
    }
    aryi localaryi = (aryi)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a().a(7);
    localaryi.a(paramEmotionPanelListView, paramarwf, paramInt);
    localaryi.b(paramView);
    paramEmotionPanelListView.addOnScrollListener(localaryi);
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_JavaUtilHashSet.add(paramString);
    }
  }
  
  public void a(List<asaf> paramList)
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
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    if (this.jdField_a_of_type_Arxd != null) {
      this.jdField_a_of_type_Arxd = null;
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
    asai.a().a();
    asak.a().a();
  }
  
  public void b(asaf paramasaf)
  {
    this.jdField_a_of_type_Asaf = paramasaf;
    if (paramasaf == null) {}
    do
    {
      return;
      int i = asab.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramasaf);
      if (QLog.isColorLevel()) {
        QLog.d("EmotionPanelViewPagerAdapter", 2, "onPageSelected panelType = " + i);
      }
      paramasaf = a(paramasaf);
    } while (paramasaf == null);
    paramasaf.jdField_a_of_type_Asaf = this.jdField_a_of_type_Asaf;
    paramasaf.c();
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
      if (!(paramObject instanceof bkky)) {
        break label251;
      }
      paramObject = (arwf)((bkky)paramObject).getWrappedAdapter();
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
      asai.a().a(paramView);
      return;
      paramView = (EmotionPanelListView)paramObject;
      break;
      label251:
      paramObject = (arwf)paramObject;
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
      asaf localasaf = (asaf)localView.getTag();
      if (localasaf != null)
      {
        if ((localasaf.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null) && (this.jdField_a_of_type_JavaUtilHashSet.contains(localasaf.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmotionPanelViewPagerAdapter", 2, "getItemPosition destroy " + localView.getTag());
          }
          return -2;
        }
        int j = this.jdField_a_of_type_JavaUtilList.indexOf(localasaf);
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
    EmotionPanelListView localEmotionPanelListView = asai.a().a(this.jdField_a_of_type_AndroidContentContext);
    if (localEmotionPanelListView == null)
    {
      QLog.e("EmotionPanelViewPagerAdapter", 1, "instantiateItem listView is null");
      paramView = null;
      return paramView;
    }
    localEmotionPanelListView.setDivider(null);
    localEmotionPanelListView.setVerticalScrollBarEnabled(true);
    localEmotionPanelListView.setEdgeEffectEnabled(false);
    localEmotionPanelListView.setSelector(2130850667);
    asaf localasaf = (asaf)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    int k = asab.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localasaf);
    int j = localasaf.jdField_b_of_type_Int;
    int i = j;
    if (this.jdField_a_of_type_Boolean)
    {
      j = Math.max(1, j * 4 / 7);
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("EmotionPanelViewPagerAdapter", 2, "multiWindowMode: " + localasaf.jdField_b_of_type_Int + "->" + j);
        i = j;
      }
    }
    arwf localarwf = asah.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, i, k, localasaf.jdField_a_of_type_Int, localasaf.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, this.jdField_a_of_type_Arxd, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_b_of_type_Int, this.jdField_b_of_type_Boolean);
    if (localarwf == null)
    {
      QLog.e("EmotionPanelViewPagerAdapter", 1, "instantiateItem adapter is null, panelType = " + k);
      return null;
    }
    a(localarwf);
    if ((localarwf instanceof asct)) {
      ((asct)localarwf).jdField_a_of_type_Boolean = this.c;
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
            if (!(localObject instanceof aryt)) {
              localEmotionPanelListView.setOnScrollListener(new aryt(localEmotionPanelListView, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), (bkhe)localObject));
            }
            if ((k != 1) && (k != 2)) {
              break label646;
            }
            localObject = a(paramInt, localEmotionPanelListView, localarwf);
          }
        }
      }
    }
    label444:
    localarwf.d = this.jdField_a_of_type_Int;
    localarwf.jdField_a_of_type_Asaf = this.jdField_a_of_type_Asaf;
    localarwf.a(localEmotionPanelListView);
    localEmotionPanelListView.setAdapter(localarwf);
    QLog.d("EmotionPanelViewPagerAdapter", 1, "instantiateItem start get data, panelType = " + k + ", position = " + paramInt + ", panelInfo = " + localasaf);
    if ((localasaf.jdField_a_of_type_Int == 6) || (localasaf.jdField_a_of_type_Int == 10))
    {
      localEmoticonPackage = localasaf.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
      if ((localEmoticonPackage != null) && (!TextUtils.isEmpty(localEmoticonPackage.epId)))
      {
        this.jdField_b_of_type_JavaUtilMap.put(localEmoticonPackage.epId, localarwf);
        label585:
        if ((localObject == null) || (((RelativeLayout)localObject).getParent() == paramView) || (paramInt >= getCount())) {
          break label697;
        }
        ((ViewGroup)paramView).addView((View)localObject);
      }
    }
    for (;;)
    {
      localEmotionPanelListView.setTag(localasaf);
      a(k, localasaf, localarwf, localEmotionPanelListView);
      paramView = (View)localObject;
      if (localObject != null) {
        break;
      }
      return localEmotionPanelListView;
      label646:
      localObject = a(localEmotionPanelListView, k, localarwf);
      break label444;
      QLog.e("EmotionPanelViewPagerAdapter", 1, "instantiateItem put adapter to map error");
      break label585;
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(localasaf.jdField_a_of_type_Int), localarwf);
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