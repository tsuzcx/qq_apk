package com.tencent.mobileqq.dating;

import abpo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.struct.AdData;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
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
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "特别推荐", "约会的推荐", "附近的群的推荐", "活动的推荐", "热聊的推荐", "特别推荐", "排行榜的推荐" };
  float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private CarrierADView jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private List jdField_a_of_type_JavaUtilList = new LinkedList();
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c = -1;
  
  public CarrierHelper(QQAppInterface paramQQAppInterface, View.OnClickListener paramOnClickListener, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.b = paramInt;
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener == null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener = this;
    }
  }
  
  public View a(IFlingSwitch paramIFlingSwitch)
  {
    View localView = LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2130970380, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView = ((CarrierADView)localView.findViewById(2131365666));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView.setContentDescription(",");
    this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView.setFlingSwitch(paramIFlingSwitch);
    return localView;
  }
  
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
    ThreadManager.getSubThreadHandler().post(new abpo(this, localLinkedList));
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
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Int = paramActivity.getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Float = paramActivity.getResources().getDisplayMetrics().density;
  }
  
  public void a(View paramView, AdData paramAdData)
  {
    Object localObject = (ImageView)paramView.findViewById(2131368223);
    BorderTextView localBorderTextView = (BorderTextView)paramView.findViewById(2131370329);
    SingleLineTextView localSingleLineTextView1 = (SingleLineTextView)paramView.findViewById(2131370327);
    SingleLineTextView localSingleLineTextView2 = (SingleLineTextView)paramView.findViewById(2131370328);
    TextView localTextView1 = (TextView)paramView.findViewById(2131370330);
    TextView localTextView2 = (TextView)paramView.findViewById(2131370331);
    View localView = paramView.findViewById(2131370332);
    localBorderTextView.setTextSize(1, 11.0F);
    localBorderTextView.setBorderWidth(Math.round(localBorderTextView.getResources().getDisplayMetrics().density * 1.0F));
    ((ImageView)localObject).setImageDrawable(URLDrawableHelper.a(paramAdData.img_url));
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
      localView.setTag(2131362041, Integer.valueOf(paramAdData.ad_source));
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
    Class[] arrayOfClass = new Class[3];
    arrayOfClass[0] = Object.class;
    arrayOfClass[1] = Integer.class;
    arrayOfClass[2] = Object.class;
    paramString = FileUtils.a(paramString, arrayOfClass);
    if ((paramString != null) && (paramString.length == arrayOfClass.length))
    {
      this.jdField_a_of_type_JavaUtilList = ((List)paramString[0]);
      this.c = ((Integer)paramString[1]).intValue();
      this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)paramString[2]);
    }
  }
  
  public void a(List paramList, int paramInt, ArrayList paramArrayList)
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
  
  public void b(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilList.size() == 0) || (this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqWidgetCarrierADView.a();
    FileUtils.a(paramString, new Object[] { this.jdField_a_of_type_JavaUtilList, Integer.valueOf(i), this.jdField_a_of_type_JavaUtilArrayList });
  }
  
  public void onClick(View paramView)
  {
    Object localObject = (Integer)paramView.getTag(2131362041);
    String str = (String)paramView.getTag();
    if ((localObject == null) || (str == null)) {
      return;
    }
    if ((this.b == 2) || (this.b == 1)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80050D1", "0X80050D1", this.b, 0, String.valueOf(localObject), "", "", "");
    }
    if (((Integer)localObject).intValue() == 5) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80052A3", "0X80052A3", this.b, 0, "", "", "", "");
    }
    if (this.jdField_a_of_type_AndroidAppActivity == null) {}
    for (paramView = BaseApplicationImpl.getContext();; paramView = this.jdField_a_of_type_AndroidAppActivity)
    {
      localObject = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, str);
      if (localObject == null) {
        break;
      }
      ((JumpAction)localObject).b();
      return;
    }
    localObject = new Intent(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", URLUtil.guessUrl(str));
    paramView.startActivity((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.dating.CarrierHelper
 * JD-Core Version:    0.7.0.1
 */