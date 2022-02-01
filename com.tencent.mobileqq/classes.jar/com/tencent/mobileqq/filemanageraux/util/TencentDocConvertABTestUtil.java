package com.tencent.mobileqq.filemanageraux.util;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.tendoc.TencentDocEditConvertConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem;
import com.tencent.mobileqq.config.business.tendoc.TencentDocEditConvertConfigProcessor;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TencentDocConvertABTestUtil
{
  public static int a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return 106;
    }
    return ViewUtils.a(53.0F);
  }
  
  private static int a(String paramString)
  {
    return Integer.decode(paramString).intValue() | 0xFF000000;
  }
  
  public static List<TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem> a()
  {
    return (List)TencentDocEditConvertConfigProcessor.a().a().get("wording");
  }
  
  private static List<TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = FileUtil.a(paramString).toLowerCase().replace(".", "");
    return (List)TencentDocEditConvertConfigProcessor.a().a().get(paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, View paramView, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, TencentDocConvertABTestUtil.DocClickTypeRunnable paramDocClickTypeRunnable)
  {
    if ((paramTeamWorkFileImportInfo == null) || (paramActivity == null)) {}
    do
    {
      return;
      paramActivity = paramActivity.getResources();
    } while (paramActivity == null);
    Object localObject = a(paramTeamWorkFileImportInfo.b);
    ArrayList localArrayList = new ArrayList();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      if (paramTeamWorkFileImportInfo.a != 1)
      {
        paramTeamWorkFileImportInfo = ((List)localObject).iterator();
        while (paramTeamWorkFileImportInfo.hasNext())
        {
          localObject = (TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem)paramTeamWorkFileImportInfo.next();
          if (((TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem)localObject).b() != 2) {
            localArrayList.add(localObject);
          }
        }
      }
      localArrayList.addAll((Collection)localObject);
    }
    a(paramQQAppInterface, paramActivity, paramView, localArrayList, paramDocClickTypeRunnable);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Resources paramResources, View paramView, List<TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem> paramList, TencentDocConvertABTestUtil.DocClickTypeRunnable paramDocClickTypeRunnable)
  {
    if ((paramView == null) || (paramDocClickTypeRunnable == null) || (paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      paramResources = (ViewGroup)paramView.findViewById(2131367140);
      ViewGroup localViewGroup = (ViewGroup)paramView.findViewById(2131363797);
      if ((paramResources != null) && (localViewGroup != null))
      {
        paramView.setVisibility(8);
        paramResources.setVisibility(8);
        localViewGroup.setVisibility(8);
        LayoutInflater localLayoutInflater = (LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater");
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem localTencentDocEditConvertConfigItem = (TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem)paramList.next();
          switch (localTencentDocEditConvertConfigItem.a())
          {
          default: 
            QLog.w("TencentDocConvertABTestUtil", 2, "can not show edit entrance");
            break;
          case 1: 
            a(paramQQAppInterface, paramView, paramDocClickTypeRunnable, paramResources, localLayoutInflater, localTencentDocEditConvertConfigItem);
            break;
          case 2: 
            a(paramQQAppInterface, paramView, paramDocClickTypeRunnable, paramResources, localViewGroup, localLayoutInflater, localTencentDocEditConvertConfigItem);
          }
        }
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, View paramView, TencentDocConvertABTestUtil.DocClickTypeRunnable paramDocClickTypeRunnable, ViewGroup paramViewGroup, LayoutInflater paramLayoutInflater, TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem paramTencentDocEditConvertConfigItem)
  {
    paramView.setVisibility(0);
    paramViewGroup.setVisibility(0);
    paramView = paramLayoutInflater.inflate(2131560952, paramViewGroup, false);
    paramLayoutInflater = (GradientDrawable)paramViewGroup.getBackground();
    if (paramLayoutInflater != null)
    {
      paramLayoutInflater.setAlpha(Math.round(paramTencentDocEditConvertConfigItem.a() * 255.0F));
      if (TextUtils.isEmpty(paramTencentDocEditConvertConfigItem.a())) {}
    }
    try
    {
      paramLayoutInflater.setColor(a(paramTencentDocEditConvertConfigItem.a()));
      if (TextUtils.isEmpty(paramTencentDocEditConvertConfigItem.c())) {}
    }
    catch (NumberFormatException paramLayoutInflater)
    {
      try
      {
        ((TextView)paramView.findViewById(2131380228)).setTextColor(a(paramTencentDocEditConvertConfigItem.c()));
        if (!TextUtils.isEmpty(paramTencentDocEditConvertConfigItem.b())) {
          ((TextView)paramView.findViewById(2131380228)).setText(paramTencentDocEditConvertConfigItem.b());
        }
        if (!TextUtils.isEmpty(paramTencentDocEditConvertConfigItem.d()))
        {
          paramLayoutInflater = (URLImageView)paramView.findViewById(2131369586);
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          paramLayoutInflater.setImageDrawable(URLDrawable.getDrawable(paramTencentDocEditConvertConfigItem.d(), localURLDrawableOptions));
        }
        paramView.setOnClickListener(new TencentDocConvertABTestUtil.2(paramQQAppInterface, paramTencentDocEditConvertConfigItem.e(), paramDocClickTypeRunnable, paramTencentDocEditConvertConfigItem));
        if (paramTencentDocEditConvertConfigItem.b() == 2) {
          paramDocClickTypeRunnable.a((ImageView)paramView.findViewById(2131380895));
        }
        ReportController.b(paramQQAppInterface, "dc00898", "", "", paramTencentDocEditConvertConfigItem.f(), paramTencentDocEditConvertConfigItem.f(), 0, 0, "", "", "", "");
        paramViewGroup.addView(paramView);
        return;
        paramLayoutInflater = paramLayoutInflater;
        QLog.e("TencentDocConvertABTestUtil", 1, "parse bg color fail", paramLayoutInflater);
      }
      catch (NumberFormatException paramLayoutInflater)
      {
        for (;;)
        {
          QLog.e("TencentDocConvertABTestUtil", 1, "parse text color fail", paramLayoutInflater);
        }
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, View paramView, TencentDocConvertABTestUtil.DocClickTypeRunnable paramDocClickTypeRunnable, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, LayoutInflater paramLayoutInflater, TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem paramTencentDocEditConvertConfigItem)
  {
    paramView.setVisibility(0);
    paramViewGroup2.setVisibility(0);
    paramView = paramLayoutInflater.inflate(2131560952, paramViewGroup1, false);
    paramViewGroup1 = (LayerDrawable)paramViewGroup2.getBackground();
    if (paramViewGroup1 != null)
    {
      paramViewGroup1 = (GradientDrawable)paramViewGroup1.findDrawableByLayerId(2131363419);
      paramViewGroup1.setAlpha(Math.round(paramTencentDocEditConvertConfigItem.a() * 255.0F));
      if (TextUtils.isEmpty(paramTencentDocEditConvertConfigItem.a())) {}
    }
    try
    {
      paramViewGroup1.setColor(a(paramTencentDocEditConvertConfigItem.a()));
      if (TextUtils.isEmpty(paramTencentDocEditConvertConfigItem.c())) {}
    }
    catch (NumberFormatException paramViewGroup1)
    {
      try
      {
        ((TextView)paramView.findViewById(2131380228)).setTextColor(a(paramTencentDocEditConvertConfigItem.c()));
        if (!TextUtils.isEmpty(paramTencentDocEditConvertConfigItem.b())) {
          ((TextView)paramView.findViewById(2131380228)).setText(paramTencentDocEditConvertConfigItem.b());
        }
        if (!TextUtils.isEmpty(paramTencentDocEditConvertConfigItem.d()))
        {
          paramViewGroup1 = (URLImageView)paramView.findViewById(2131369586);
          paramLayoutInflater = URLDrawable.URLDrawableOptions.obtain();
          paramViewGroup1.setImageDrawable(URLDrawable.getDrawable(paramTencentDocEditConvertConfigItem.d(), paramLayoutInflater));
        }
        paramView.setOnClickListener(new TencentDocConvertABTestUtil.1(paramQQAppInterface, paramTencentDocEditConvertConfigItem.e(), paramDocClickTypeRunnable, paramTencentDocEditConvertConfigItem));
        if (paramTencentDocEditConvertConfigItem.b() == 2) {
          paramDocClickTypeRunnable.a((ImageView)paramView.findViewById(2131380895));
        }
        ReportController.b(paramQQAppInterface, "dc00898", "", "", paramTencentDocEditConvertConfigItem.f(), paramTencentDocEditConvertConfigItem.f(), 0, 0, "", "", "", "");
        paramViewGroup2.addView(paramView);
        return;
        paramViewGroup1 = paramViewGroup1;
        QLog.e("TencentDocConvertABTestUtil", 1, "parse bg color fail", paramViewGroup1);
      }
      catch (NumberFormatException paramViewGroup1)
      {
        for (;;)
        {
          QLog.e("TencentDocConvertABTestUtil", 1, "parse text color fail", paramViewGroup1);
        }
      }
    }
  }
  
  public static boolean a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    return (paramTeamWorkFileImportInfo != null) && (a(paramTeamWorkFileImportInfo.b));
  }
  
  public static boolean a(String paramString)
  {
    paramString = a(paramString);
    return (paramString != null) && (paramString.size() > 0) && (((TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem)paramString.get(0)).a() != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.util.TencentDocConvertABTestUtil
 * JD-Core Version:    0.7.0.1
 */