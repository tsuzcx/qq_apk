package com.tencent.mobileqq.search.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.presenter.RichSearchResultPresenter.OnActionListener;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class RichTemplateOneSearchResultView$RichTemplateSearchResultHelper
  implements View.OnClickListener
{
  protected RichSearchResultPresenter.OnActionListener a;
  private Context b;
  private ImageView c;
  private ImageView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private final TextView[] h = new TextView[3];
  private final View[] i = new View[3];
  private View j;
  private View k;
  private int l = 0;
  private int m;
  private String n;
  private String o;
  private String p;
  private String q;
  private String r;
  private String s;
  private final String[] t = new String[3];
  private final String[] u = new String[3];
  private int v;
  private int w;
  private String x;
  
  public RichTemplateOneSearchResultView$RichTemplateSearchResultHelper(Context paramContext)
  {
    this.b = paramContext;
  }
  
  private void a(String paramString, ImageView paramImageView)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setImageUrl ");
        localStringBuilder.append(paramString);
        QLog.e("RichTemplateOneSearchResultView", 2, localStringBuilder.toString());
      }
      paramImageView.setImageDrawable(URLDrawable.getDrawable(new URL(paramString), 0, 0, new ColorDrawable(-1315339), new ColorDrawable(-1315339), true));
      return;
    }
    catch (MalformedURLException paramString)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setImageUrl error ");
        localStringBuilder.append(paramString.toString());
        QLog.e("RichTemplateOneSearchResultView", 2, localStringBuilder.toString());
      }
      paramImageView.setImageDrawable(new ColorDrawable(-1315339));
    }
  }
  
  private void b(String paramString)
  {
    Intent localIntent = new Intent(this.b, QQBrowserDelegationActivity.class);
    localIntent.putExtra("param_force_internal_browser", true);
    localIntent.putExtra("url", paramString);
    WebAccelerator.a(this.b, localIntent, paramString);
  }
  
  void a()
  {
    int i1 = 0;
    this.m = 0;
    this.n = null;
    this.o = null;
    this.p = null;
    this.q = null;
    this.r = null;
    this.s = null;
    this.l = 0;
    this.v = 0;
    this.w = 0;
    this.x = null;
    while (i1 < 3)
    {
      this.t[i1] = null;
      this.u[i1] = null;
      i1 += 1;
    }
  }
  
  void a(View paramView)
  {
    if (paramView != null)
    {
      this.c = ((ImageView)paramView.findViewById(2131435223));
      this.d = ((ImageView)paramView.findViewById(2131429399));
      this.e = ((TextView)paramView.findViewById(2131439126));
      this.f = ((TextView)paramView.findViewById(2131431771));
      this.g = ((TextView)paramView.findViewById(2131437899));
      this.h[0] = ((TextView)paramView.findViewById(2131430117));
      this.h[1] = ((TextView)paramView.findViewById(2131430118));
      this.h[2] = ((TextView)paramView.findViewById(2131430119));
      this.j = paramView.findViewById(2131429400);
      this.i[0] = paramView.findViewById(2131429609);
      this.i[1] = paramView.findViewById(2131429611);
      this.i[2] = paramView.findViewById(2131429610);
      this.k = paramView.findViewById(2131430124);
      ImageView localImageView = this.c;
      if ((localImageView instanceof ThemeImageView)) {
        ((ThemeImageView)localImageView).setMaskShape(ThemeImageWrapper.MODE_OTHER);
      }
      localImageView = this.d;
      if ((localImageView instanceof ThemeImageView)) {
        ((ThemeImageView)localImageView).setMaskShape(ThemeImageWrapper.MODE_OTHER);
      }
      this.d.getViewTreeObserver().addOnGlobalLayoutListener(new RichTemplateOneSearchResultView.RichTemplateSearchResultHelper.1(this));
      paramView.setOnClickListener(new RichTemplateOneSearchResultView.RichTemplateSearchResultHelper.2(this));
    }
  }
  
  protected void a(RichSearchResultPresenter.OnActionListener paramOnActionListener)
  {
    this.a = paramOnActionListener;
  }
  
  void a(String paramString)
  {
    for (;;)
    {
      int i1;
      try
      {
        localObject = new JSONObject(paramString).optJSONObject("data");
        if (localObject != null)
        {
          paramString = ((JSONObject)localObject).get("serverdata");
          if (paramString != null)
          {
            if ((paramString instanceof String)) {
              paramString = new JSONObject((String)paramString);
            } else if ((paramString instanceof JSONObject)) {
              paramString = (JSONObject)paramString;
            } else {
              paramString = new JSONObject();
            }
            this.m = paramString.optInt("appid");
            this.n = paramString.optString("thumbnail");
            this.o = paramString.optString("title");
            this.p = paramString.optString("sub_title");
            this.q = paramString.optString("bg_pic_url");
            this.r = paramString.optString("bg_main_btn_text");
            this.s = paramString.optString("bg_main_btn_url");
            paramString = paramString.optJSONArray("bottom_btn_list");
            if (paramString != null)
            {
              int i2 = paramString.length();
              i1 = 0;
              if (i1 < i2)
              {
                JSONObject localJSONObject = paramString.optJSONObject(i1);
                if ((localJSONObject == null) || (i1 >= 3)) {
                  break label330;
                }
                this.t[i1] = localJSONObject.optString("bottom_btn_text");
                this.u[i1] = localJSONObject.optString("bottom_btn_url");
                break label330;
              }
            }
          }
          paramString = ((JSONObject)localObject).getJSONObject("extradata");
          if (paramString != null)
          {
            this.v = paramString.getInt("entry");
            this.w = paramString.getInt("match");
            this.x = paramString.getString("keyword");
            this.l = paramString.optInt("nightmode", 0);
            return;
          }
        }
      }
      catch (JSONException paramString)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("initData error ");
          ((StringBuilder)localObject).append(paramString.toString());
          QLog.e("RichTemplateOneSearchResultView", 2, ((StringBuilder)localObject).toString());
        }
      }
      return;
      label330:
      i1 += 1;
    }
  }
  
  void b()
  {
    String str2 = this.o;
    String str1 = "";
    if (str2 != null) {
      this.e.setText(str2);
    } else {
      this.e.setText("");
    }
    str2 = this.p;
    if (str2 != null) {
      this.f.setText(str2);
    } else {
      this.f.setText("");
    }
    if (!TextUtils.isEmpty(this.n)) {
      a(this.n, this.c);
    } else {
      this.c.setImageDrawable(null);
    }
    if (!TextUtils.isEmpty(this.q))
    {
      this.j.setOnClickListener(this);
      View localView = this.j;
      str2 = this.r;
      if (str2 != null) {
        str1 = str2;
      }
      localView.setContentDescription(str1);
      this.j.setVisibility(0);
      a(this.q, this.d);
    }
    else
    {
      this.j.setVisibility(8);
      this.d.setImageDrawable(null);
    }
    if (!TextUtils.isEmpty(this.r))
    {
      this.g.setVisibility(0);
      this.g.setText(this.r);
    }
    else
    {
      this.g.setVisibility(8);
    }
    int i1 = 0;
    while (i1 < 3)
    {
      if (!TextUtils.isEmpty(this.t[i1]))
      {
        this.h[i1].setVisibility(0);
        this.h[i1].setText(this.t[i1]);
        this.h[i1].setOnClickListener(this);
        this.i[i1].setVisibility(0);
      }
      else
      {
        this.h[i1].setVisibility(8);
        this.i[i1].setVisibility(8);
      }
      if (this.l == 1) {
        this.i[i1].setBackgroundColor(this.b.getResources().getColor(2131167919));
      } else {
        this.i[i1].setBackgroundColor(-1315339);
      }
      i1 += 1;
    }
    this.k.setOnClickListener(new RichTemplateOneSearchResultView.RichTemplateSearchResultHelper.3(this));
  }
  
  public String c()
  {
    return this.o;
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131429400)
    {
      switch (i1)
      {
      default: 
        localObject1 = null;
        i1 = 0;
        break;
      case 2131430119: 
        localObject1 = this.u[2];
        i1 = 3;
        break;
      case 2131430118: 
        localObject1 = this.u[1];
        i1 = 2;
        break;
      case 2131430117: 
        localObject1 = this.u[0];
        i1 = 1;
        break;
      }
    }
    else
    {
      localObject1 = this.s;
      i1 = 4;
    }
    if (this.w == 1) {
      UniteSearchReportController.a(null, this.v, 0, "0X8009D2D", this.m, i1, this.x);
    } else {
      UniteSearchReportController.a(null, this.v, 0, "0X8009D41", this.m, i1, this.x);
    }
    if (localObject1 != null)
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onClick ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.e("RichTemplateOneSearchResultView", 2, ((StringBuilder)localObject2).toString());
      }
      if (((String)localObject1).startsWith("http"))
      {
        b((String)localObject1);
      }
      else
      {
        localObject2 = JumpParser.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.b, (String)localObject1);
        if (localObject2 != null)
        {
          ((JumpAction)localObject2).a();
        }
        else
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("wrong url ");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.e("RichTemplateOneSearchResultView", 2, ((StringBuilder)localObject2).toString());
          }
          b((String)localObject1);
        }
      }
    }
    Object localObject1 = this.a;
    if (localObject1 != null) {
      ((RichSearchResultPresenter.OnActionListener)localObject1).a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.RichTemplateOneSearchResultView.RichTemplateSearchResultHelper
 * JD-Core Version:    0.7.0.1
 */