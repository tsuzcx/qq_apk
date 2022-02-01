package com.tencent.mobileqq.search;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.mobileqq.search.model.BusinessSearchEntryDataModel;
import com.tencent.mobileqq.search.model.BusinessSearchEntryDataModel.SearchEntry;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BusinessSearchEntryModel
  extends BaseSearchEntryModel<View>
{
  private Context d;
  private View e;
  private LinearLayout f;
  private QQAppInterface g;
  private boolean h = false;
  private HashMap<String, Integer> i;
  
  public BusinessSearchEntryModel(int paramInt, boolean paramBoolean)
  {
    super(paramInt);
    this.h = paramBoolean;
  }
  
  public View a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.d = paramContext;
    this.g = paramQQAppInterface;
    paramBundle = paramQQAppInterface;
    if (paramQQAppInterface == null)
    {
      if ((paramContext instanceof BaseActivity)) {
        paramViewGroup = ((BaseActivity)paramContext).getAppRuntime();
      } else {
        paramViewGroup = null;
      }
      paramBundle = paramQQAppInterface;
      if ((paramViewGroup instanceof QQAppInterface)) {
        paramBundle = (QQAppInterface)paramViewGroup;
      }
    }
    if (paramBundle == null) {
      return new View(paramContext);
    }
    this.e = LayoutInflater.from(paramContext).inflate(2131629615, null);
    this.f = ((LinearLayout)this.e.findViewById(2131437486));
    return this.e;
  }
  
  public void a()
  {
    ThreadManager.post(new BusinessSearchEntryModel.2(this, new BusinessSearchEntryDataModel(this.g, 3, this.a, this.h)), 5, null, true);
  }
  
  public void a(SearchEntryDataModel paramSearchEntryDataModel)
  {
    b(paramSearchEntryDataModel);
  }
  
  public void b(SearchEntryDataModel paramSearchEntryDataModel)
  {
    Object localObject2 = this.g.getCurrentUin();
    paramSearchEntryDataModel = (BusinessSearchEntryDataModel)paramSearchEntryDataModel;
    if (paramSearchEntryDataModel == null) {
      return;
    }
    Object localObject1 = paramSearchEntryDataModel.a;
    if (localObject1 != null)
    {
      if (((List)localObject1).size() == 0) {
        return;
      }
      if (((List)localObject1).size() <= 6) {
        this.f.setVisibility(8);
      } else {
        this.f.setVisibility(0);
      }
      if (((List)localObject1).size() == 10) {
        paramSearchEntryDataModel = e();
      } else {
        paramSearchEntryDataModel = d();
      }
      int j = 0;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      while (j < ((List)localObject1).size())
      {
        localObject3 = (BusinessSearchEntryDataModel.SearchEntry)((List)localObject1).get(j);
        localObject4 = this.e.findViewById(((Integer)paramSearchEntryDataModel.get(j)).intValue());
        localObject5 = ((View)localObject4).findViewById(2131444531);
        TextView localTextView = (TextView)((View)localObject4).findViewById(2131431938);
        URLImageView localURLImageView = (URLImageView)((View)localObject4).findViewById(2131431937);
        ((View)localObject4).setVisibility(0);
        Object localObject6 = new ColorDrawable();
        if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
          ((ColorDrawable)localObject6).setColor(this.d.getResources().getColor(2131168420));
        } else {
          ((ColorDrawable)localObject6).setColor(this.d.getResources().getColor(2131168419));
        }
        if (!TextUtils.isEmpty(((BusinessSearchEntryDataModel.SearchEntry)localObject3).b))
        {
          Object localObject7 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject7).mRequestHeight = AIOUtils.b(28.0F, this.d.getResources());
          ((URLDrawable.URLDrawableOptions)localObject7).mRequestWidth = AIOUtils.b(28.0F, this.d.getResources());
          ((URLDrawable.URLDrawableOptions)localObject7).mFailedDrawable = ((Drawable)localObject6);
          ((URLDrawable.URLDrawableOptions)localObject7).mLoadingDrawable = ((Drawable)localObject6);
          localObject6 = URLDrawable.getDrawable(((BusinessSearchEntryDataModel.SearchEntry)localObject3).b, (URLDrawable.URLDrawableOptions)localObject7);
          if (localURLImageView != null) {
            if (QQTheme.isNowSimpleUI())
            {
              if (this.i == null)
              {
                this.i = new HashMap();
                this.i.put("https://qzonestyle.gtimg.cn/aoi/sola/20190816141611_NQ31kYWAQJ.png", Integer.valueOf(2130851710));
                this.i.put("https://pub.idqqimg.com/pc/misc/files/20190522/88ab43d24bc14de9a48d3ee11471b7ea.png", Integer.valueOf(2130851712));
                this.i.put("https://pub.idqqimg.com/pc/misc/files/20190522/299abcb70f194aeab89292db649698f5.png", Integer.valueOf(2130851711));
                this.i.put("https://qzonestyle.gtimg.cn/aoi/sola/20190529143225_pb7ADOBDqd.png", Integer.valueOf(2130851714));
                this.i.put("https://sola.gtimg.cn/aoi/sola/20200805150154_yGkHAchZSR.png", Integer.valueOf(2130851713));
                this.i.put("https://pub.idqqimg.com/pc/misc/files/20190522/7b5f61f779db42e38d8d8b6757a72e1b.png", Integer.valueOf(2130851715));
              }
              localObject7 = (Integer)this.i.get(((BusinessSearchEntryDataModel.SearchEntry)localObject3).b);
              if (localObject7 == null)
              {
                localURLImageView.setImageDrawable((Drawable)localObject6);
              }
              else
              {
                localObject7 = this.d.getDrawable(((Integer)localObject7).intValue());
                if (localObject7 != null) {
                  localURLImageView.setImageDrawable((Drawable)localObject7);
                } else {
                  localURLImageView.setImageDrawable((Drawable)localObject6);
                }
              }
            }
            else
            {
              localURLImageView.setImageDrawable((Drawable)localObject6);
            }
          }
        }
        localTextView.setText(((BusinessSearchEntryDataModel.SearchEntry)localObject3).a);
        if (QQTheme.isNowSimpleUI())
        {
          if (!QQTheme.isNowThemeSimpleNight()) {
            localTextView.setTextColor(-16777216);
          }
          localTextView.setTextSize(1, 12.0F);
        }
        int k = SharedPreUtils.a(((BusinessSearchEntryDataModel.SearchEntry)localObject3).g, (String)localObject2);
        boolean bool = SharedPreUtils.b(((BusinessSearchEntryDataModel.SearchEntry)localObject3).g, (String)localObject2);
        if ((((BusinessSearchEntryDataModel.SearchEntry)localObject3).e == 1) && ((((BusinessSearchEntryDataModel.SearchEntry)localObject3).f > k) || ((((BusinessSearchEntryDataModel.SearchEntry)localObject3).f == k) && (!bool)))) {
          ((View)localObject5).setVisibility(0);
        } else {
          ((View)localObject5).setVisibility(8);
        }
        SharedPreUtils.a(((BusinessSearchEntryDataModel.SearchEntry)localObject3).g, ((BusinessSearchEntryDataModel.SearchEntry)localObject3).f, (String)localObject2);
        ((View)localObject4).setOnClickListener(new BusinessSearchEntryModel.1(this, (View)localObject4, (BusinessSearchEntryDataModel.SearchEntry)localObject3, (View)localObject5, (String)localObject2, (List)localObject1));
        j += 1;
      }
      if (((List)localObject1).size() < 6)
      {
        j = ((List)localObject1).size();
        while (j < 6)
        {
          this.e.findViewById(((Integer)paramSearchEntryDataModel.get(j)).intValue()).setVisibility(8);
          j += 1;
        }
      }
      if (((List)localObject1).size() == 6)
      {
        this.e.findViewById(2131431948).setVisibility(8);
        this.e.findViewById(2131431949).setVisibility(8);
        this.e.findViewById(2131431950).setVisibility(8);
        this.e.findViewById(2131431940).setVisibility(8);
        this.e.findViewById(2131431941).setVisibility(8);
        this.e.findViewById(2131431942).setVisibility(8);
      }
      else if (((List)localObject1).size() == 10)
      {
        this.e.findViewById(2131431947).setVisibility(8);
        this.e.findViewById(2131431942).setVisibility(8);
      }
      paramSearchEntryDataModel = new StringBuilder("");
      j = 0;
      while (j < ((List)localObject1).size())
      {
        if (j == ((List)localObject1).size() - 1)
        {
          paramSearchEntryDataModel.append(((BusinessSearchEntryDataModel.SearchEntry)((List)localObject1).get(j)).a);
        }
        else
        {
          paramSearchEntryDataModel.append(((BusinessSearchEntryDataModel.SearchEntry)((List)localObject1).get(j)).a);
          paramSearchEntryDataModel.append("::");
        }
        j += 1;
      }
      localObject2 = (Boolean)SearchEntryFragment.mIsModelsReported.get(Integer.valueOf(3));
      if ((localObject2 == null) || (!((Boolean)localObject2).booleanValue()))
      {
        SearchUtils.a("home_page", "exp_entry", new String[] { paramSearchEntryDataModel.toString(), "", String.valueOf(this.a) });
        localObject2 = new ReportModelDC02528().module("all_result").action("exp_entry").ver2(UniteSearchReportController.a(this.a)).ver4(paramSearchEntryDataModel.toString());
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("{experiment_id:");
        ((StringBuilder)localObject3).append(UniteSearchReportController.b);
        ((StringBuilder)localObject3).append("}");
        UniteSearchReportController.a(null, ((ReportModelDC02528)localObject2).ver7(((StringBuilder)localObject3).toString()));
        localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        localObject3 = new UniteSearchHandler((QQAppInterface)localObject2);
        localObject4 = UniteSearchReportController.a(this.a);
        paramSearchEntryDataModel = paramSearchEntryDataModel.toString();
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("{experiment_id:");
        ((StringBuilder)localObject5).append(UniteSearchReportController.b);
        ((StringBuilder)localObject5).append("}");
        ((UniteSearchHandler)localObject3).b((QQAppInterface)localObject2, "exp_entry", "all_result", (String)localObject4, "", paramSearchEntryDataModel, ((StringBuilder)localObject5).toString());
        SearchEntryFragment.mIsModelsReported.put(Integer.valueOf(3), Boolean.valueOf(true));
        j = SearchEntryFragment.b(this.a);
        paramSearchEntryDataModel = ((List)localObject1).iterator();
        while (paramSearchEntryDataModel.hasNext())
        {
          localObject1 = (BusinessSearchEntryDataModel.SearchEntry)paramSearchEntryDataModel.next();
          if (localObject1 != null) {
            UniteSearchReportController.a(this.g, 0, j, "0X8009D1B", 0, 0, ((BusinessSearchEntryDataModel.SearchEntry)localObject1).a, null);
          }
        }
      }
    }
  }
  
  public List<Integer> d()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2131431939));
    localArrayList.add(Integer.valueOf(2131431943));
    localArrayList.add(Integer.valueOf(2131431944));
    localArrayList.add(Integer.valueOf(2131431945));
    localArrayList.add(Integer.valueOf(2131431946));
    localArrayList.add(Integer.valueOf(2131431947));
    localArrayList.add(Integer.valueOf(2131431948));
    localArrayList.add(Integer.valueOf(2131431949));
    localArrayList.add(Integer.valueOf(2131431950));
    localArrayList.add(Integer.valueOf(2131431940));
    localArrayList.add(Integer.valueOf(2131431941));
    localArrayList.add(Integer.valueOf(2131431942));
    return localArrayList;
  }
  
  public List<Integer> e()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2131431939));
    localArrayList.add(Integer.valueOf(2131431943));
    localArrayList.add(Integer.valueOf(2131431944));
    localArrayList.add(Integer.valueOf(2131431945));
    localArrayList.add(Integer.valueOf(2131431946));
    localArrayList.add(Integer.valueOf(2131431948));
    localArrayList.add(Integer.valueOf(2131431949));
    localArrayList.add(Integer.valueOf(2131431950));
    localArrayList.add(Integer.valueOf(2131431940));
    localArrayList.add(Integer.valueOf(2131431941));
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.BusinessSearchEntryModel
 * JD-Core Version:    0.7.0.1
 */