package com.tencent.mobileqq.teamworkforgroup;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.rely.CountdownTimeTask;
import com.tencent.mobileqq.rely.SingleLineHotwordTextView;
import com.tencent.mobileqq.teamwork.OnItemLongClickListener;
import com.tencent.mobileqq.teamwork.PadInfo;
import com.tencent.mobileqq.teamwork.api.IGroupTeamWorkHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.VersionUtils;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.List;
import mqq.os.MqqHandler;

public class TroopTeamWorkFileSearchDialog
  extends ReportDialog
  implements Handler.Callback, OnItemLongClickListener
{
  public static int d = 10;
  public static int e = 16;
  protected int a;
  protected long a;
  protected Activity a;
  private Bitmap a;
  protected Handler a;
  protected View a;
  protected ViewGroup a;
  protected EditText a;
  protected ImageButton a;
  protected RelativeLayout a;
  protected TextView a;
  protected AppInterface a;
  protected CountdownTimeTask a;
  protected IGroupTeamWorkHandler a;
  public GroupTeamWordkMoreView a;
  protected GroupTeamWorkAdapter a;
  protected GroupTeamWorkObserver a;
  protected XListView a;
  protected Object a;
  protected String a;
  protected List<GPadInfo> a;
  protected boolean a;
  protected int b;
  protected long b;
  protected TextView b;
  protected boolean b;
  protected int c;
  protected boolean c = false;
  protected boolean d = false;
  protected boolean e = false;
  
  public TroopTeamWorkFileSearchDialog(Activity paramActivity, View paramView, AppInterface paramAppInterface, long paramLong)
  {
    super(paramActivity, 2131755540);
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_ComTencentMobileqqRelyCountdownTimeTask = null;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkObserver = new TroopTeamWorkFileSearchDialog.9(this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTeamworkApiIGroupTeamWorkHandler = ((IGroupTeamWorkHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITeamWorkFacadeCreator)QRoute.api(ITeamWorkFacadeCreator.class)).getGroupTeamWorkHandlerName()));
    this.jdField_a_of_type_Long = paramLong;
    a(paramActivity);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376483));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131377082));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131370362));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370364));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379865));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131364664);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131368340));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    a();
    e();
    a(paramActivity, paramAppInterface);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkObserver);
    a(paramView);
  }
  
  public static String a(String paramString1, String paramString2)
  {
    Object localObject1 = paramString1;
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return paramString1;
      }
      if (paramString1.contains("#"))
      {
        Object localObject2 = paramString1.split("\\#");
        localObject1 = localObject2[0];
        int j = localObject2.length;
        int i = 1;
        paramString1 = "";
        StringBuilder localStringBuilder;
        while (i < j)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString1);
          localStringBuilder.append("#");
          localStringBuilder.append(localObject2[i]);
          paramString1 = localStringBuilder.toString();
          i += 1;
        }
        if (((String)localObject1).contains("?"))
        {
          localObject2 = new StringBuilder();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("?");
          localStringBuilder.append(paramString2);
          localStringBuilder.append("&");
          ((StringBuilder)localObject2).append(((String)localObject1).replace("?", localStringBuilder.toString()));
          ((StringBuilder)localObject2).append(paramString1);
          return ((StringBuilder)localObject2).toString();
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("?");
        ((StringBuilder)localObject2).append(paramString2);
        ((StringBuilder)localObject2).append(paramString1);
        return ((StringBuilder)localObject2).toString();
      }
      if (paramString1.contains("?"))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("?");
        ((StringBuilder)localObject1).append(paramString2);
        ((StringBuilder)localObject1).append("&");
        return paramString1.replace("?", ((StringBuilder)localObject1).toString());
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append("?");
      ((StringBuilder)localObject1).append(paramString2);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    return localObject1;
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new TroopTeamWorkFileSearchDialog.7(this));
    Button localButton = (Button)findViewById(2131363868);
    localButton.setVisibility(0);
    localButton.setOnClickListener(new TroopTeamWorkFileSearchDialog.8(this));
  }
  
  protected float a()
  {
    float f2 = this.jdField_a_of_type_AndroidWidgetEditText.getWidth() - DisplayUtils.a(this.jdField_a_of_type_AndroidAppActivity, 20.0F);
    float f1 = f2;
    if (this.jdField_b_of_type_Int > 0) {
      f1 = f2 - (this.jdField_a_of_type_AndroidWidgetEditText.getPaint().measureText(a(this.jdField_b_of_type_Int)) + DisplayUtils.a(this.jdField_a_of_type_AndroidAppActivity, 16.0F));
    }
    f2 = f1;
    if (this.jdField_a_of_type_AndroidWidgetImageButton.getVisibility() == 0) {
      f2 = f1 - (this.jdField_a_of_type_AndroidWidgetImageButton.getWidth() + DisplayUtils.a(this.jdField_a_of_type_AndroidAppActivity, 8.0F));
    }
    return f2;
  }
  
  protected String a(int paramInt)
  {
    if (paramInt > 1000) {
      return this.jdField_a_of_type_AndroidAppActivity.getString(2131697362);
    }
    return this.jdField_a_of_type_AndroidAppActivity.getString(2131697360, new Object[] { Integer.valueOf(paramInt) });
  }
  
  protected String a(String paramString)
  {
    float f = a();
    TextPaint localTextPaint = this.jdField_a_of_type_AndroidWidgetEditText.getPaint();
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      if (localTextPaint.measureText(paramString) <= f) {
        return paramString;
      }
      paramString = new StringBuilder(paramString.substring(0, localTextPaint.breakText(paramString, true, f - localTextPaint.measureText("…"), null)));
      paramString.append("…");
      str = paramString.toString();
    }
    return str;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131366333));
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718606));
    this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(3);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new TroopTeamWorkFileSearchDialog.5(this));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new TroopTeamWorkFileSearchDialog.6(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
  }
  
  public final void a(long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      int i = this.jdField_a_of_type_Int;
      if (i > 0) {
        return;
      }
      if (TextUtils.isEmpty(paramString))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("doReqTroopFileSearch err keyWord =");
          localStringBuilder.append(paramString);
          QLog.i("TroopTeamWorkFileSearchDialog", 4, localStringBuilder.toString());
        }
      }
      else
      {
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_Int += 1;
        if (this.jdField_a_of_type_ComTencentMobileqqTeamworkApiIGroupTeamWorkHandler != null) {
          this.jdField_a_of_type_ComTencentMobileqqTeamworkApiIGroupTeamWorkHandler.reqSearchGroupTeamWorkList(paramLong, paramString, paramInt1, paramInt2, paramInt3);
        }
      }
      return;
    }
    finally {}
  }
  
  protected void a(Activity paramActivity)
  {
    requestWindowFeature(1);
    getWindow().setSoftInputMode(36);
    if (!VersionUtils.e()) {
      getWindow().setBackgroundDrawable(new ColorDrawable());
    } else {
      getWindow().setBackgroundDrawable(new ColorDrawable(paramActivity.getResources().getColor(2131165700)));
    }
    setContentView(2131559905);
    findViewById(2131370406).setOnClickListener(new TroopTeamWorkFileSearchDialog.1(this));
    Object localObject = getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject).x = 0;
    ((WindowManager.LayoutParams)localObject).y = 0;
    ((WindowManager.LayoutParams)localObject).width = -1;
    ((WindowManager.LayoutParams)localObject).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject).gravity = 51;
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      getWindow().addFlags(67108864);
      int i = paramActivity.getResources().getColor(2131167114);
      if (ImmersiveUtils.setStatusBarDarkMode(getWindow(), true)) {
        i = paramActivity.getResources().getColor(2131167295);
      }
      new SystemBarCompact(this, true, i).init();
      localObject = (LinearLayout)findViewById(2131370406);
      ((LinearLayout)localObject).setFitsSystemWindows(true);
      ((LinearLayout)localObject).setPadding(0, ImmersiveUtils.getStatusBarHeight(paramActivity), 0, 0);
    }
  }
  
  protected void a(Activity paramActivity, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWordkMoreView = new GroupTeamWordkMoreView(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWordkMoreView.setBackgroundResource(2130838739);
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWordkMoreView.setTextColor(paramActivity.getResources().getColor(2131167056));
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWordkMoreView);
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWordkMoreView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkAdapter = new GroupTeamWorkAdapter(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidAppActivity, this, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new TroopTeamWorkFileSearchDialog.2(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new TroopTeamWorkFileSearchDialog.3(this));
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkAdapter.a(new TroopTeamWorkFileSearchDialog.4(this));
  }
  
  public void a(View paramView)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setBackgroundViewBlur, view :");
      ((StringBuilder)localObject1).append(paramView.getHeight());
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append(paramView.getWidth());
      QLog.d("TroopTeamWorkFileSearchDialog", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramView == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopTeamWorkFileSearchDialog", 2, "setBackgroundViewBlur, isDrawingCacheEnabled");
    }
    boolean bool = paramView.isDrawingCacheEnabled();
    if (!bool) {
      paramView.setDrawingCacheEnabled(true);
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopTeamWorkFileSearchDialog", 2, "setBackgroundViewBlur, getDrawingCache");
      }
      localObject1 = paramView.getDrawingCache(true);
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopTeamWorkFileSearchDialog", 2, "getDrawingCache is return null");
        }
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopTeamWorkFileSearchDialog", 2, "setBackgroundViewBlur, start thread");
      }
      Object localObject2 = null;
      try
      {
        localObject1 = Bitmap.createBitmap((Bitmap)localObject1);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("TroopTeamWorkFileSearchDialog", 2, "blurBitmap error", localOutOfMemoryError);
          localObject1 = localObject2;
        }
      }
      a(paramView, bool, (Bitmap)localObject1);
      return;
    }
    catch (Exception paramView)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getDrawingCache exception, ");
        ((StringBuilder)localObject1).append(paramView.getMessage());
        QLog.d("TroopTeamWorkFileSearchDialog", 2, ((StringBuilder)localObject1).toString());
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopTeamWorkFileSearchDialog", 2, "getDrawingCache is return null");
      }
      return;
      label258:
      if (QLog.isColorLevel()) {
        QLog.d("TroopTeamWorkFileSearchDialog", 2, "getDrawingCache is return null");
      }
      return;
    }
    finally
    {
      break label258;
    }
  }
  
  protected void a(View paramView, boolean paramBoolean, Bitmap paramBitmap)
  {
    ThreadManager.post(new TroopTeamWorkFileSearchDialog.10(this, paramBitmap, paramView, paramBoolean), 8, null, true);
  }
  
  public void a(PadInfo paramPadInfo) {}
  
  protected void a(String paramString)
  {
    try
    {
      boolean bool = this.c;
      if (bool) {
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      a(this.jdField_a_of_type_Long, paramString, 0, 50, 0);
      return;
    }
    finally {}
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Int <= 0)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    long l = System.currentTimeMillis();
    TextPaint localTextPaint = this.jdField_a_of_type_AndroidWidgetEditText.getPaint();
    float f = a() - localTextPaint.measureText(paramString);
    if (f < 0.0F)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    else if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(a(this.jdField_b_of_type_Int));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("resetResultNumTextVisible compareWidth = ");
      paramString.append(f);
      paramString.append(", time = ");
      paramString.append(System.currentTimeMillis() - l);
      QLog.e("zivonchen", 2, paramString.toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Drawable localDrawable;
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130839403, 0, 0, 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694879);
      localDrawable = this.jdField_a_of_type_AndroidWidgetTextView.getCompoundDrawables()[0];
      if ((localDrawable instanceof Animatable)) {
        ((Animatable)localDrawable).start();
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      localDrawable = this.jdField_a_of_type_AndroidWidgetTextView.getCompoundDrawables()[0];
      if ((localDrawable instanceof Animatable)) {
        ((Animatable)localDrawable).stop();
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131694424));
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
  }
  
  protected void b(View paramView, boolean paramBoolean, Bitmap paramBitmap)
  {
    ThreadManager.getUIHandler().post(new TroopTeamWorkFileSearchDialog.11(this, paramView, paramBoolean));
    if (paramBitmap != null) {
      paramBitmap.recycle();
    }
  }
  
  public void b(PadInfo paramPadInfo) {}
  
  public void b(boolean paramBoolean)
  {
    a(false);
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131697357, new Object[] { this.jdField_a_of_type_JavaLangString }));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130843892, 0, 0);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    Drawable localDrawable = this.jdField_a_of_type_AndroidWidgetTextView.getCompoundDrawables()[0];
    if ((localDrawable instanceof Animatable)) {
      ((Animatable)localDrawable).stop();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  protected void c()
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.c = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    CountdownTimeTask localCountdownTimeTask = this.jdField_a_of_type_ComTencentMobileqqRelyCountdownTimeTask;
    if (localCountdownTimeTask != null)
    {
      localCountdownTimeTask.b();
      this.jdField_a_of_type_ComTencentMobileqqRelyCountdownTimeTask = null;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    InputMethodUtil.a(this.jdField_a_of_type_AndroidWidgetEditText);
  }
  
  protected void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition() == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWordkMoreView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWordkMoreView.setVisibility(0);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWordkMoreView.setText(2131719254);
      this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWordkMoreView.a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWordkMoreView.setText(2131694879);
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWordkMoreView.setTextLeftDrawable(2130839403);
  }
  
  protected void d()
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(a(this.jdField_b_of_type_Int));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.d = true;
      String str = a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setText(str);
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(str.length());
      }
    }
  }
  
  public void dismiss()
  {
    this.c = true;
    InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
    SingleLineHotwordTextView.a();
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      ((List)localObject).clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqRelyCountdownTimeTask;
    if (localObject != null)
    {
      ((CountdownTimeTask)localObject).b();
      this.jdField_a_of_type_ComTencentMobileqqRelyCountdownTimeTask = null;
    }
    localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkAdapter;
    if (localObject != null)
    {
      ((GroupTeamWorkAdapter)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkAdapter = null;
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkObserver);
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.c) {
      return true;
    }
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return false;
            }
            a(false);
            a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), true);
            if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
              this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            }
            if (this.jdField_b_of_type_Boolean) {
              this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkAdapter.a();
            }
            if (this.jdField_a_of_type_Boolean)
            {
              this.jdField_a_of_type_Boolean = false;
              InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
            }
            c(this.e);
            this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkAdapter.b(this.jdField_a_of_type_JavaUtilList);
            this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkAdapter.notifyDataSetChanged();
            if (this.jdField_b_of_type_Boolean) {
              this.jdField_b_of_type_Boolean = false;
            }
            long l = System.currentTimeMillis() - this.jdField_b_of_type_Long;
            paramMessage = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim().toLowerCase();
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("REFRESH_LIST text = ");
              localStringBuilder.append(paramMessage);
              localStringBuilder.append(", lastHotword = ");
              localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
              localStringBuilder.append(", time = ");
              localStringBuilder.append(l);
              QLog.e("zivonchen", 2, localStringBuilder.toString());
            }
            if ((!paramMessage.equals(this.jdField_a_of_type_JavaLangString)) && (l >= 800L))
            {
              this.jdField_b_of_type_Boolean = true;
              this.jdField_a_of_type_JavaLangString = paramMessage;
              a(this.jdField_a_of_type_JavaLangString);
              this.jdField_a_of_type_ComTencentMobileqqRelyCountdownTimeTask = null;
              return false;
            }
          }
          else
          {
            b(false);
            return false;
          }
        }
        else
        {
          b(true);
          return false;
        }
      }
      else
      {
        a(false);
        return false;
      }
    }
    else {
      a(true);
    }
    return false;
  }
  
  protected void onStop()
  {
    super.onStop();
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.TroopTeamWorkFileSearchDialog
 * JD-Core Version:    0.7.0.1
 */