package com.tencent.mobileqq.businessCard.activity;

import abnp;
import abnq;
import abnr;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.BusinessCardObserver;
import com.tencent.mobileqq.businessCard.BusinessCardServlet;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardGroupLogic;
import com.tencent.mobileqq.businessCard.views.BusinessCardChildView;
import com.tencent.mobileqq.businessCard.views.BusinessCardView;
import com.tencent.mobileqq.businessCard.views.BusinessCardView.Callback;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardOptionBuilder;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class BusinessCardListActivity
  extends BaseActivity
  implements View.OnClickListener, BusinessCardView.Callback, IndexView.OnIndexChangedListener
{
  public int a;
  private Handler jdField_a_of_type_AndroidOsHandler = new abnp(this);
  public BusinessCardManager a;
  BusinessCardObserver jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver = new abnr(this);
  BusinessCardGroupLogic jdField_a_of_type_ComTencentMobileqqBusinessCardUtilitiesBusinessCardGroupLogic;
  public BusinessCardView a;
  ForwardBaseOption jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption = null;
  public IndexView a;
  public ArrayList a;
  public HashMap a;
  int b = 1;
  
  public BusinessCardListActivity()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public String a(long paramLong, Calendar paramCalendar)
  {
    Calendar localCalendar = Calendar.getInstance();
    if (paramLong > 0L) {
      localCalendar.setTimeInMillis(paramLong);
    }
    while (paramCalendar.get(1) - localCalendar.get(1) > 0)
    {
      return localCalendar.get(1) + "年";
      localCalendar.set(1, 2012);
      localCalendar.set(2, 5);
      localCalendar.set(5, 1);
    }
    if (paramCalendar.get(2) != localCalendar.get(2)) {
      return localCalendar.get(2) + 1 + "月";
    }
    if (paramCalendar.get(3) != localCalendar.get(3)) {
      return "一周前";
    }
    if (paramCalendar.get(6) != localCalendar.get(6)) {
      return "本周";
    }
    return "今天";
  }
  
  public String a(BusinessCard paramBusinessCard)
  {
    return paramBusinessCard.picUrl;
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  HashMap a(ArrayList paramArrayList)
  {
    long l1 = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    int j;
    int i;
    label80:
    Object localObject3;
    int k;
    try
    {
      if (this.jdField_a_of_type_Int == 1)
      {
        Collections.sort(paramArrayList, new BusinessCardListActivity.MyComparator(1));
        j = paramArrayList.size();
        i = 0;
        if (i >= j) {
          break label309;
        }
        BusinessCard localBusinessCard = (BusinessCard)paramArrayList.get(i);
        if (localBusinessCard.firstPinyin == null) {
          break label366;
        }
        if (localBusinessCard.firstPinyin.length() == 0) {
          break label366;
        }
        for (;;)
        {
          localObject3 = str;
          if (str.length() == 1)
          {
            k = str.charAt(0);
            if ((65 > k) || (k > 90)) {
              break label373;
            }
            label118:
            localObject3 = str.toUpperCase();
          }
          label125:
          localBusinessCard.sortDesc = ((String)localObject3);
          if (localHashMap.get(localObject3) != null) {
            break;
          }
          localHashMap.put(localObject3, Integer.valueOf(i));
          break label390;
          String str = localBusinessCard.firstPinyin.substring(0, 1);
        }
        localBusinessCard.sortDesc = null;
      }
    }
    finally {}
    Object localObject2;
    if (this.jdField_a_of_type_Int == 0)
    {
      Collections.sort(paramArrayList, new BusinessCardListActivity.MyComparator(0));
      localObject2 = Calendar.getInstance();
      ((Calendar)localObject2).setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000L);
      j = paramArrayList.size();
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        localObject3 = (BusinessCard)paramArrayList.get(i);
        ((BusinessCard)localObject3).sortDesc = a(((BusinessCard)localObject3).lastUpdateTime * 1000L, (Calendar)localObject2);
        if (localHashMap.get(((BusinessCard)localObject3).sortDesc) == null) {
          localHashMap.put(((BusinessCard)localObject3).sortDesc, Integer.valueOf(i + 1));
        } else {
          ((BusinessCard)localObject3).sortDesc = null;
        }
      }
      else
      {
        label309:
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("BusinessCardListActivity", 2, "constructHashStruct, time:" + (l2 - l1) + ", sortType:" + this.jdField_a_of_type_Int);
        }
        return localHashMap;
        label366:
        localObject2 = "#";
        break label80;
        label373:
        if ((97 <= k) && (k <= 122))
        {
          break label118;
          i += 1;
          break;
        }
        label390:
        localObject3 = "#";
        break label125;
      }
      i += 1;
    }
  }
  
  @TargetApi(14)
  protected void a()
  {
    super.setContentView(2130970255);
    Object localObject = findViewById(2131362711);
    ((View)localObject).setBackgroundColor(super.getResources().getColor(2131494235));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      ((View)localObject).setFitsSystemWindows(true);
      if (this.mSystemBarComp != null)
      {
        this.mSystemBarComp.setStatusDrawable(null);
        this.mSystemBarComp.setStatusColor(super.getResources().getColor(2131494235));
      }
    }
    ((LinearLayout)findViewById(2131363961)).setBackgroundColor(super.getResources().getColor(2131494235));
    localObject = (TextView)findViewById(2131363428);
    ImageView localImageView = (ImageView)findViewById(2131369864);
    TextView localTextView1 = (TextView)findViewById(2131363245);
    TextView localTextView2 = (TextView)findViewById(2131363381);
    ((TextView)localObject).setVisibility(0);
    ((TextView)localObject).setOnClickListener(this);
    localTextView1.setOnClickListener(this);
    localImageView.setOnClickListener(this);
    if (this.b == 1)
    {
      ((TextView)localObject).setVisibility(8);
      localImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardUtilitiesBusinessCardGroupLogic = new BusinessCardGroupLogic(this, localTextView2);
    }
    for (this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.b();; this.jdField_a_of_type_Int = 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView = ((BusinessCardView)findViewById(2131369863));
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.a(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131363830));
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
      return;
      ((TextView)localObject).setVisibility(0);
      localImageView.setVisibility(8);
      ((TextView)localObject).setText(2131433015);
      localTextView1.setVisibility(8);
      localTextView2.setText(2131434973);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int == 1) {
      ReportController.b(this.app, "CliOper", "", "", "0X80064D9", "0X80064D9", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.b(paramInt);
      a(this.jdField_a_of_type_JavaUtilArrayList, 0L, false);
      return;
      ReportController.b(this.app, "CliOper", "", "", "0X80064D8", "0X80064D8", 0, 0, "", "", "", "");
    }
  }
  
  public void a(BusinessCard paramBusinessCard)
  {
    if (this.b == 2)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("Extra_Result_Data", paramBusinessCard);
      setResult(-1, (Intent)localObject);
      if (!isFinishing()) {
        finish();
      }
    }
    while ((this.b != 3) || (paramBusinessCard.OCRInfo == null))
    {
      localObject = new Intent(this, BusinessCardEditActivity.class);
      if (QLog.isColorLevel()) {
        QLog.d("BusinessCardListActivity", 2, "cardType= " + paramBusinessCard.cardType + "id=" + paramBusinessCard.cardId);
      }
      if (paramBusinessCard.cardType != 2) {
        break;
      }
      b();
      return;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("uintype", 30);
    ((Bundle)localObject).putParcelable("business_card_ocr", paramBusinessCard.OCRInfo);
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(0, (Bundle)localObject);
    return;
    if (paramBusinessCard.cardType == 3)
    {
      ((Intent)localObject).putExtra("mode_type", 3);
      ((Intent)localObject).putExtra("cur_card_body", new BusinessCard());
      ((Intent)localObject).putExtra("is_edit_mode", true);
      ((Intent)localObject).putExtra("finish_immedia", true);
      ReportController.b(this.app, "CliOper", "", "", "0X80064DC", "0X80064DC", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      startActivity((Intent)localObject);
      return;
      if (paramBusinessCard.cardType == 1)
      {
        ((Intent)localObject).putExtra("mode_type", 3);
        ((Intent)localObject).putExtra("cur_card_id", paramBusinessCard.cardId);
      }
      else
      {
        ((Intent)localObject).putExtra("mode_type", 0);
        ((Intent)localObject).putExtra("cur_card_id", paramBusinessCard.cardId);
      }
    }
  }
  
  public void a(WeakReference paramWeakReference, BusinessCard paramBusinessCard)
  {
    if (paramWeakReference.get() != null) {
      if (paramBusinessCard.cardType == 1) {
        ((BusinessCardChildView)paramWeakReference.get()).a(paramBusinessCard, getString(2131433900), null, null, null, true);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      if ((paramBusinessCard.cardType == 3) || (paramBusinessCard.cardType == 2))
      {
        ((BusinessCardChildView)paramWeakReference.get()).a(paramBusinessCard, paramBusinessCard.cardName, null, null, null, true);
        return;
      }
      String str2 = "";
      String str1 = str2;
      if (paramBusinessCard.mobilesNum != null)
      {
        str1 = str2;
        if (paramBusinessCard.mobilesNum.size() > 0) {
          str1 = (String)paramBusinessCard.mobilesNum.get(0);
        }
      }
      ((BusinessCardChildView)paramWeakReference.get()).a(paramBusinessCard, paramBusinessCard.cardName, str1, paramBusinessCard.company, paramBusinessCard.sortDesc, false);
      return;
    }
    QLog.e("BusinessCardListActivity", 2, "weakView is null");
  }
  
  public void a(ArrayList paramArrayList, long paramLong, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = null;
    Object localObject1 = null;
    int k;
    int i;
    int j;
    if (paramArrayList != null)
    {
      k = paramArrayList.size();
      i = 0;
      j = 0;
      if (j < k)
      {
        localObject2 = (BusinessCard)paramArrayList.get(j);
        if (((BusinessCard)localObject2).cardType == 1) {
          localObject1 = localObject2;
        }
        for (;;)
        {
          j += 1;
          break;
          if (TextUtils.isEmpty(((BusinessCard)localObject2).picUrl)) {
            i += 1;
          } else if (((BusinessCard)localObject2).cardType == 0) {
            localArrayList.add(localObject2);
          }
        }
      }
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        localObject2 = localObject1;
        if (i > 0)
        {
          QLog.d("BusinessCardListActivity", 2, "initData emptyUrlCnt:" + i);
          localObject2 = localObject1;
        }
      }
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      j = localArrayList.size();
      i = 0;
      while (i < j)
      {
        paramArrayList = (BusinessCard)localArrayList.get(i);
        paramArrayList.allPinyin = ChnToSpell.a(paramArrayList.cardName, 1);
        paramArrayList.firstPinyin = ChnToSpell.a(paramArrayList.cardName, 2);
        if (!TextUtils.isEmpty(paramArrayList.firstPinyin))
        {
          k = paramArrayList.firstPinyin.charAt(0);
          if (((65 > k) || (k > 90)) && ((97 > k) || (k > 122))) {
            paramArrayList.firstPinyin = "#";
          }
        }
        i += 1;
      }
    }
    paramArrayList = a(localArrayList);
    if (this.b == 1)
    {
      if (localArrayList.size() == 0)
      {
        localObject1 = new BusinessCard();
        ((BusinessCard)localObject1).cardName = getString(2131437073);
        ((BusinessCard)localObject1).cardType = 2;
        localArrayList.add(localObject1);
      }
      if (localObject2 != null) {
        localArrayList.add(0, localObject2);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessCardListActivity", 2, "init data success listsize: \t" + localArrayList.size() + " isOnCreate:" + paramBoolean);
      }
      paramArrayList = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, new Object[] { localArrayList, paramArrayList, Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) });
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramArrayList, paramLong);
      return;
      localObject1 = new BusinessCard();
      ((BusinessCard)localObject1).cardName = getString(2131437114);
      ((BusinessCard)localObject1).cardType = 3;
      localArrayList.add(0, localObject1);
      continue;
      if ((this.b == 3) && (localObject2 != null) && (((BusinessCard)localObject2).OCRInfo != null) && (!TextUtils.isEmpty(((BusinessCard)localObject2).OCRInfo.b))) {
        localArrayList.add(localObject2);
      }
      localObject1 = (TextView)findViewById(2131366675);
      if (localArrayList.size() == 0) {
        ((TextView)localObject1).setVisibility(0);
      } else {
        ((TextView)localObject1).setVisibility(8);
      }
    }
  }
  
  void b()
  {
    ReportController.b(this.app, "CliOper", "", "", "0X80064DD", "0X80064DD", 0, 0, "", "", "", "");
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.b(2131437078);
    localActionSheet.b(2131437081);
    localActionSheet.a(new abnq(this, localActionSheet));
    localActionSheet.c(2131433015);
    localActionSheet.show();
  }
  
  public void b(String paramString)
  {
    paramString = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((paramString != null) && (paramString.intValue() != -1)) {
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.a(paramString.intValue());
    }
  }
  
  public void c() {}
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager = ((BusinessCardManager)this.app.getManager(111));
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.b = paramBundle.getIntExtra("Extra_Entrance", 1);
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption = ForwardOptionBuilder.a(paramBundle, this.app, this);
      if ((this.b != 3) || (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption != null)) {
        break label133;
      }
      finish();
    }
    for (;;)
    {
      a();
      a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.a(), 200L, true);
      int i = this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.a();
      BusinessCardServlet.a(this.app, i, 0, true);
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.a(true);
      return true;
      label133:
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.c();
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption != null) {
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.s();
    }
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.a();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    boolean bool = paramIntent.getBooleanExtra("is_upload_photo", false);
    if (QLog.isColorLevel()) {
      QLog.i("BusinessCardListActivity", 2, "initData isUploadPhoto: " + bool);
    }
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      if (bool)
      {
        paramIntent = new Intent(this, FlowCameraPhotoActivity.class);
        paramIntent.putExtra("is_upload_photo", true);
        paramIntent.putExtra("PhotoConst.PHOTO_PATHS", localArrayList);
        startActivity(paramIntent);
      }
    }
    while (!bool) {
      return;
    }
    ReportController.b(this.app, "CliOper", "", "", "0X80064E1", "0X80064E1", 0, 0, "", "", "", "");
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131368322: 
    case 2131363428: 
    case 2131369864: 
      do
      {
        return;
        c();
        return;
        if (this.b == 1)
        {
          b();
          return;
        }
        setResult(0);
      } while (isFinishing());
      finish();
      return;
    }
    super.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.BusinessCardListActivity
 * JD-Core Version:    0.7.0.1
 */