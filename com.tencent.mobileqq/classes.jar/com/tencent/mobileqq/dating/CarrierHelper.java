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
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { HardCodeUtil.a(2131701671), HardCodeUtil.a(2131701674), HardCodeUtil.a(2131701677), HardCodeUtil.a(2131701675), HardCodeUtil.a(2131701672), HardCodeUtil.a(2131701671), HardCodeUtil.a(2131701676) };
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private CarrierADView jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView;
  private ArrayList<CarrierHelper.EntranceConfig> jdField_a_of_type_JavaUtilArrayList;
  private List<AdData> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  
  public CarrierHelper.EntranceConfig a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      int i = this.b;
      CarrierHelper.EntranceConfig localEntranceConfig;
      if (i == 2)
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
      if (i == 1)
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
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView;
      if (localObject != null)
      {
        if (((CarrierADView)localObject).getVisibility() != 0) {
          return;
        }
        if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
          return;
        }
        localObject = new LinkedList();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
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
  
  public void a(int paramInt, Object paramObject)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        paramObject = this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView;
        if (paramObject != null)
        {
          List localList = this.jdField_a_of_type_JavaUtilList;
          if (localList != null)
          {
            paramInt = this.c;
            if (paramInt != -1) {
              paramObject.setCarrierData(localList, paramInt, this);
            }
          }
        }
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView != null) && ((paramObject instanceof Boolean)))
      {
        if (((Boolean)paramObject).booleanValue())
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView.i();
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView.j();
      }
    }
    else if ((this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView != null) && ((paramObject instanceof Boolean)))
    {
      if (((Boolean)paramObject).booleanValue())
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView.setVisibility(8);
    }
  }
  
  public void a(View paramView, AdData paramAdData)
  {
    Object localObject = (ImageView)paramView.findViewById(2131362129);
    BorderTextView localBorderTextView = (BorderTextView)paramView.findViewById(2131362150);
    SingleLineTextView localSingleLineTextView1 = (SingleLineTextView)paramView.findViewById(2131362169);
    SingleLineTextView localSingleLineTextView2 = (SingleLineTextView)paramView.findViewById(2131362149);
    TextView localTextView1 = (TextView)paramView.findViewById(2131362088);
    TextView localTextView2 = (TextView)paramView.findViewById(2131362089);
    View localView = paramView.findViewById(2131364358);
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
    int i = 89;
    if (!bool)
    {
      localSingleLineTextView2.setText(paramAdData.distance);
      localSingleLineTextView2.setVisibility(0);
      i = 89 + (Math.round(localBorderTextView.getPaint().measureText(paramAdData.distance)) + 5);
    }
    else
    {
      localSingleLineTextView2.setVisibility(8);
    }
    localSingleLineTextView1.setMaxWidth((int)(this.jdField_a_of_type_Int - i * this.jdField_a_of_type_Float));
    localSingleLineTextView1.setText(paramAdData.title);
    localTextView1.setText(paramAdData.content);
    localTextView2.setText(paramAdData.content2);
    if (paramAdData.ad_source >= 0)
    {
      i = paramAdData.ad_source;
      localObject = jdField_a_of_type_ArrayOfJavaLangString;
      if (i < localObject.length)
      {
        localObject = localObject[paramAdData.ad_source];
        break label326;
      }
    }
    localObject = jdField_a_of_type_ArrayOfJavaLangString[0];
    label326:
    paramView.setContentDescription((CharSequence)localObject);
    localView.setContentDescription((CharSequence)localObject);
    localView.setTag(paramAdData.jump_url);
    localView.setTag(2131374205, Integer.valueOf(paramAdData.ad_source));
    localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilList.size() != 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      int i = this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView.a();
      FileUtils.writeObjectList(paramString, new Object[] { this.jdField_a_of_type_JavaUtilList, Integer.valueOf(i), this.jdField_a_of_type_JavaUtilArrayList });
    }
  }
  
  public void a(List<AdData> paramList, int paramInt, ArrayList<CarrierHelper.EntranceConfig> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList != null) && (paramList.size() > 0)) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    this.c = paramInt;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public boolean a()
  {
    CarrierADView localCarrierADView = this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView;
    boolean bool = false;
    if (localCarrierADView == null) {
      return false;
    }
    if (localCarrierADView.getVisibility() == 0) {
      bool = true;
    }
    return bool;
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = (Integer)paramView.getTag(2131374205);
    String str = (String)paramView.getTag();
    if ((localObject1 != null) && (str != null))
    {
      int i = this.b;
      if ((i == 2) || (i == 1)) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80050D1", "0X80050D1", this.b, 0, String.valueOf(localObject1), "", "", "");
      }
      if (((Integer)localObject1).intValue() == 5) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80052A3", "0X80052A3", this.b, 0, "", "", "", "");
      }
      Object localObject2 = this.jdField_a_of_type_AndroidAppActivity;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = BaseApplicationImpl.getContext();
      }
      localObject2 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Context)localObject1, str);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dating.CarrierHelper
 * JD-Core Version:    0.7.0.1
 */