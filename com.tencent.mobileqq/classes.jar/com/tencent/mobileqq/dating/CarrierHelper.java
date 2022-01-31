package com.tencent.mobileqq.dating;

import ajyc;
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
import axqw;
import aywk;
import bbdj;
import bbds;
import bbej;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.struct.AdData;
import com.tencent.mobileqq.widget.CarrierADView;
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
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { ajyc.a(2131701447), ajyc.a(2131701450), ajyc.a(2131701453), ajyc.a(2131701451), ajyc.a(2131701448), ajyc.a(2131701447), ajyc.a(2131701452) };
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
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator;
      CarrierHelper.EntranceConfig localEntranceConfig;
      if (this.b == 2)
      {
        localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localEntranceConfig = (CarrierHelper.EntranceConfig)localIterator.next();
        } while (localEntranceConfig.type != 2);
        return localEntranceConfig;
      }
      if (this.b == 1)
      {
        localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          localEntranceConfig = (CarrierHelper.EntranceConfig)localIterator.next();
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
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView.getVisibility() != 0)) {}
    while (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      AdData localAdData = (AdData)localIterator.next();
      if ((localAdData != null) && (!localLinkedList.contains(Integer.valueOf(localAdData.ad_source)))) {
        localLinkedList.add(Integer.valueOf(localAdData.ad_source));
      }
    }
    ThreadManager.getSubThreadHandler().post(new CarrierHelper.1(this, localLinkedList));
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView == null) || (!(paramObject instanceof Boolean)));
        if (((Boolean)paramObject).booleanValue())
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView.setVisibility(0);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView.setVisibility(8);
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView == null) || (!(paramObject instanceof Boolean)));
      if (((Boolean)paramObject).booleanValue())
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView.i();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView.j();
      return;
    } while ((this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView == null) || (this.jdField_a_of_type_JavaUtilList == null) || (this.c == -1));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView.setCarrierData(this.jdField_a_of_type_JavaUtilList, this.c, this);
  }
  
  public void a(View paramView, AdData paramAdData)
  {
    Object localObject = (ImageView)paramView.findViewById(2131362013);
    BorderTextView localBorderTextView = (BorderTextView)paramView.findViewById(2131362030);
    SingleLineTextView localSingleLineTextView1 = (SingleLineTextView)paramView.findViewById(2131362048);
    SingleLineTextView localSingleLineTextView2 = (SingleLineTextView)paramView.findViewById(2131362029);
    TextView localTextView1 = (TextView)paramView.findViewById(2131361972);
    TextView localTextView2 = (TextView)paramView.findViewById(2131361974);
    View localView = paramView.findViewById(2131363959);
    localBorderTextView.setTextSize(1, 11.0F);
    localBorderTextView.setBorderWidth(Math.round(localBorderTextView.getResources().getDisplayMetrics().density * 1.0F));
    ((ImageView)localObject).setImageDrawable(aywk.a(paramAdData.img_url));
    int i;
    if ((paramAdData.wording != null) && (paramAdData.wording.length() > 0))
    {
      localBorderTextView.setText(paramAdData.wording);
      localBorderTextView.setTextColor(paramAdData.bgColor);
      localBorderTextView.setBorderColor(paramAdData.bgColor);
      localBorderTextView.setVisibility(0);
      if (TextUtils.isEmpty(paramAdData.distance)) {
        break label341;
      }
      localSingleLineTextView2.setText(paramAdData.distance);
      localSingleLineTextView2.setVisibility(0);
      i = Math.round(localBorderTextView.a().measureText(paramAdData.distance)) + 5 + 89;
      label211:
      localSingleLineTextView1.setMaxWidth((int)(this.jdField_a_of_type_Int - i * this.jdField_a_of_type_Float));
      localSingleLineTextView1.setText(paramAdData.title);
      localTextView1.setText(paramAdData.content);
      localTextView2.setText(paramAdData.content2);
      if ((paramAdData.ad_source < 0) || (paramAdData.ad_source >= jdField_a_of_type_ArrayOfJavaLangString.length)) {
        break label354;
      }
    }
    label341:
    label354:
    for (localObject = jdField_a_of_type_ArrayOfJavaLangString[paramAdData.ad_source];; localObject = jdField_a_of_type_ArrayOfJavaLangString[0])
    {
      paramView.setContentDescription((CharSequence)localObject);
      localView.setContentDescription((CharSequence)localObject);
      localView.setTag(paramAdData.jump_url);
      localView.setTag(2131373009, Integer.valueOf(paramAdData.ad_source));
      localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
      localBorderTextView.setVisibility(4);
      break;
      localSingleLineTextView2.setVisibility(8);
      i = 89;
      break label211;
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilList.size() == 0) || (this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView.a();
    bbdj.a(paramString, new Object[] { this.jdField_a_of_type_JavaUtilList, Integer.valueOf(i), this.jdField_a_of_type_JavaUtilArrayList });
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
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView.getVisibility() != 0) {
      return false;
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = (Integer)paramView.getTag(2131373009);
    String str = (String)paramView.getTag();
    if ((localObject == null) || (str == null)) {
      return;
    }
    if ((this.b == 2) || (this.b == 1)) {
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80050D1", "0X80050D1", this.b, 0, String.valueOf(localObject), "", "", "");
    }
    if (((Integer)localObject).intValue() == 5) {
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80052A3", "0X80052A3", this.b, 0, "", "", "", "");
    }
    if (this.jdField_a_of_type_AndroidAppActivity == null) {}
    for (paramView = BaseApplicationImpl.getContext();; paramView = this.jdField_a_of_type_AndroidAppActivity)
    {
      localObject = bbej.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, str);
      if (localObject == null) {
        break;
      }
      ((bbds)localObject).c();
      return;
    }
    localObject = new Intent(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", URLUtil.guessUrl(str));
    paramView.startActivity((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dating.CarrierHelper
 * JD-Core Version:    0.7.0.1
 */