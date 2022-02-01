package com.tencent.mobileqq.dating;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.struct.AdData;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.widget.CarrierADView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BorderTextView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class CarrierHelper
  implements View.OnClickListener
{
  private static final String[] c = { HardCodeUtil.a(2131899693), HardCodeUtil.a(2131899696), HardCodeUtil.a(2131899699), HardCodeUtil.a(2131899697), HardCodeUtil.a(2131899694), HardCodeUtil.a(2131899693), HardCodeUtil.a(2131899698) };
  int a;
  float b;
  private int d;
  private QQAppInterface e;
  private View.OnClickListener f;
  private CarrierADView g;
  private int h;
  private List<AdData> i;
  private ArrayList<CarrierHelper.EntranceConfig> j;
  private Activity k;
  private boolean l;
  
  public void a(int paramInt, Object paramObject)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        paramObject = this.g;
        if (paramObject != null)
        {
          List localList = this.i;
          if (localList != null)
          {
            paramInt = this.h;
            if (paramInt != -1) {
              paramObject.setCarrierData(localList, paramInt, this);
            }
          }
        }
      }
      else if ((this.g != null) && ((paramObject instanceof Boolean)))
      {
        if (((Boolean)paramObject).booleanValue())
        {
          this.g.j();
          return;
        }
        this.g.k();
      }
    }
    else if ((this.g != null) && ((paramObject instanceof Boolean)))
    {
      if (((Boolean)paramObject).booleanValue())
      {
        this.g.setVisibility(0);
        return;
      }
      this.g.setVisibility(8);
    }
  }
  
  public void a(View paramView, AdData paramAdData)
  {
    Object localObject = (ImageView)paramView.findViewById(2131427708);
    BorderTextView localBorderTextView = (BorderTextView)paramView.findViewById(2131427729);
    SingleLineTextView localSingleLineTextView1 = (SingleLineTextView)paramView.findViewById(2131427750);
    SingleLineTextView localSingleLineTextView2 = (SingleLineTextView)paramView.findViewById(2131427728);
    TextView localTextView1 = (TextView)paramView.findViewById(2131427666);
    TextView localTextView2 = (TextView)paramView.findViewById(2131427667);
    View localView = paramView.findViewById(2131430386);
    localBorderTextView.setTextSize(1, 11.0F);
    localBorderTextView.setBorderWidth(Math.round(localBorderTextView.getResources().getDisplayMetrics().density * 1.0F));
    ((ImageView)localObject).setImageDrawable(URLDrawableHelper.getDrawable(paramAdData.img_url));
    if ((paramAdData.wording != null) && (paramAdData.wording.length() > 0))
    {
      localBorderTextView.setText(paramAdData.wording);
      localBorderTextView.setTextColor(paramAdData.bgColor);
      localBorderTextView.setBorderColor(paramAdData.bgColor);
      localBorderTextView.setVisibility(0);
    }
    else
    {
      localBorderTextView.setVisibility(4);
    }
    boolean bool = TextUtils.isEmpty(paramAdData.distance);
    int m = 89;
    if (!bool)
    {
      localSingleLineTextView2.setText(paramAdData.distance);
      localSingleLineTextView2.setVisibility(0);
      m = 89 + (Math.round(localBorderTextView.getPaint().measureText(paramAdData.distance)) + 5);
    }
    else
    {
      localSingleLineTextView2.setVisibility(8);
    }
    localSingleLineTextView1.setMaxWidth((int)(this.a - m * this.b));
    localSingleLineTextView1.setText(paramAdData.title);
    localTextView1.setText(paramAdData.content);
    localTextView2.setText(paramAdData.content2);
    if (paramAdData.ad_source >= 0)
    {
      m = paramAdData.ad_source;
      localObject = c;
      if (m < localObject.length)
      {
        localObject = localObject[paramAdData.ad_source];
        break label326;
      }
    }
    localObject = c[0];
    label326:
    paramView.setContentDescription((CharSequence)localObject);
    localView.setContentDescription((CharSequence)localObject);
    localView.setTag(paramAdData.jump_url);
    localView.setTag(2131442300, Integer.valueOf(paramAdData.ad_source));
    localView.setOnClickListener(this.f);
  }
  
  public void a(String paramString)
  {
    if ((this.i.size() != 0) && (this.g != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      int m = this.g.getCurrentScreen();
      FileUtils.writeObjectList(paramString, new Object[] { this.i, Integer.valueOf(m), this.j });
    }
  }
  
  public void a(List<AdData> paramList, int paramInt, ArrayList<CarrierHelper.EntranceConfig> paramArrayList)
  {
    this.i.clear();
    if ((paramList != null) && (paramList.size() > 0)) {
      this.i.addAll(paramList);
    }
    this.h = paramInt;
    this.j = paramArrayList;
  }
  
  public boolean a()
  {
    CarrierADView localCarrierADView = this.g;
    boolean bool = false;
    if (localCarrierADView == null) {
      return false;
    }
    if (localCarrierADView.getVisibility() == 0) {
      bool = true;
    }
    return bool;
  }
  
  public CarrierHelper.EntranceConfig b()
  {
    Object localObject = this.j;
    if (localObject != null)
    {
      int m = this.d;
      CarrierHelper.EntranceConfig localEntranceConfig;
      if (m == 2)
      {
        localObject = ((ArrayList)localObject).iterator();
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localEntranceConfig = (CarrierHelper.EntranceConfig)((Iterator)localObject).next();
        } while (localEntranceConfig.type != 2);
        return localEntranceConfig;
      }
      if (m == 1)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localEntranceConfig = (CarrierHelper.EntranceConfig)((Iterator)localObject).next();
          if (localEntranceConfig.type == 1) {
            return localEntranceConfig;
          }
        }
      }
    }
    return null;
  }
  
  public void c()
  {
    if (!this.l)
    {
      Object localObject = this.g;
      if (localObject != null)
      {
        if (((CarrierADView)localObject).getVisibility() != 0) {
          return;
        }
        if (this.i.size() == 0) {
          return;
        }
        localObject = new LinkedList();
        Iterator localIterator = this.i.iterator();
        while (localIterator.hasNext())
        {
          AdData localAdData = (AdData)localIterator.next();
          if ((localAdData != null) && (!((LinkedList)localObject).contains(Integer.valueOf(localAdData.ad_source)))) {
            ((LinkedList)localObject).add(Integer.valueOf(localAdData.ad_source));
          }
        }
        ThreadManager.getSubThreadHandler().post(new CarrierHelper.1(this, (LinkedList)localObject));
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = (Integer)paramView.getTag(2131442300);
    String str = (String)paramView.getTag();
    if ((localObject1 != null) && (str != null))
    {
      int m = this.d;
      if ((m == 2) || (m == 1)) {
        ReportController.b(this.e, "CliOper", "", "", "0X80050D1", "0X80050D1", this.d, 0, String.valueOf(localObject1), "", "", "");
      }
      if (((Integer)localObject1).intValue() == 5) {
        ReportController.b(this.e, "CliOper", "", "", "0X80052A3", "0X80052A3", this.d, 0, "", "", "", "");
      }
      Object localObject2 = this.k;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = BaseApplicationImpl.getContext();
      }
      localObject2 = JumpParser.a(this.e, (Context)localObject1, str);
      if (localObject2 != null)
      {
        ((JumpAction)localObject2).a();
      }
      else
      {
        localObject2 = new Intent(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", URLUtil.guessUrl(str));
        ((Context)localObject1).startActivity((Intent)localObject2);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.CarrierHelper
 * JD-Core Version:    0.7.0.1
 */