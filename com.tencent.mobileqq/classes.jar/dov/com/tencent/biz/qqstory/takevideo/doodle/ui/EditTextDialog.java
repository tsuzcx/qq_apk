package dov.com.tencent.biz.qqstory.takevideo.doodle.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import anhn;
import anho;
import anhp;
import anhq;
import anhs;
import anht;
import anhu;
import anhv;
import anhw;
import anhx;
import anhy;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.XPanelContainer.PanelCallback;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import dov.com.qq.im.capture.text.DynamicTextBuilder;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.DynamicTextItem.TextMap;
import dov.com.qq.im.capture.text.EditTextPreView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.model.TextInfo;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel.EditTextPanel;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel.EditTextPanel.EditTextPanelListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import java.util.List;
import mqq.os.MqqHandler;

public class EditTextDialog
  extends Dialog
  implements Handler.Callback, View.OnClickListener, XPanelContainer.PanelCallback, EditTextPanel.EditTextPanelListener
{
  public int a;
  Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new anhv(this);
  public View a;
  public ViewGroup a;
  public EditText a;
  public ImageView a;
  public FitSystemWindowsRelativeLayout a;
  public XPanelContainer a;
  DynamicTextBuilder jdField_a_of_type_DovComQqImCaptureTextDynamicTextBuilder;
  public DynamicTextItem.TextMap a;
  public DynamicTextItem a;
  public EditTextPreView a;
  public TextInfo a;
  public EditTextDialog.EditTextDialogEventListener a;
  EditTextPanel jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextPanel;
  private Runnable jdField_a_of_type_JavaLangRunnable = new anhu(this);
  public String a;
  public final MqqHandler a;
  public boolean a;
  public int b = -1;
  public int c;
  public int d = XPanelContainer.jdField_a_of_type_Int;
  public int e = -1;
  public int f;
  private int g;
  
  public EditTextDialog(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, 2131624201);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo = new TextInfo();
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(getContext()).inflate(2130968953, null));
    this.jdField_a_of_type_AndroidViewViewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new anhy(this, null));
    this.jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout = ((FitSystemWindowsRelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364355));
    this.jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout.setFitsSystemWindows(true);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer = ((XPanelContainer)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131362822));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364357));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364358));
    this.jdField_a_of_type_AndroidWidgetEditText.setHighlightColor(Color.parseColor("#cceae8"));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364356);
    this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView = ((EditTextPreView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364359));
    this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.setOnClickListener(new anhn(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new anhp(this));
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(this.jdField_a_of_type_AndroidWidgetEditText);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(this);
    if ((this.f == 0) || (this.f == 1))
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(34);
      b(1);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new anhq(this));
      this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new anhs(this));
      return;
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      b(0);
    }
  }
  
  private void b()
  {
    Object localObject = super.getWindow();
    WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = DisplayUtil.b(getContext());
    localLayoutParams.flags |= 0x20;
    localLayoutParams.gravity = 80;
    ((Window)localObject).setAttributes(localLayoutParams);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      getWindow().addFlags(67108864);
      localObject = new SystemBarCompact(this, true, this.jdField_a_of_type_AndroidContentContext.getResources().getColor(17170445));
      ((SystemBarCompact)localObject).setStatusBarDrawable(null);
      ((SystemBarCompact)localObject).init();
    }
    setCanceledOnTouchOutside(false);
  }
  
  private void b(int paramInt)
  {
    this.g = paramInt;
    switch (this.g)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem == null);
          this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b();
        } while (this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView == null);
        this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.invalidate();
        return;
      } while (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem == null);
      paramInt = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b();
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a();
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a(paramInt, true);
    } while (this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView == null);
    this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.invalidate();
  }
  
  private void c()
  {
    getWindow().getDecorView().setSystemUiVisibility(4);
    getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new anht(this));
  }
  
  public int a()
  {
    int i = 0;
    if (this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView != null) {
      i = this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.getWidth() / 2 + this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.getLeft();
    }
    SLog.b("EditTextDialog", "getPreViewCenterX:" + i);
    return i;
  }
  
  public View a(int paramInt)
  {
    LinearLayout localLinearLayout = null;
    if (QLog.isColorLevel()) {
      QLog.d("EditTextDialog", 2, "onCreatePanel id = " + paramInt);
    }
    if (paramInt == 34)
    {
      XPanelContainer.jdField_a_of_type_Int = (int)(191.0F * this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density);
      localLinearLayout = (LinearLayout)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2130970668, null);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextPanel = ((EditTextPanel)localLinearLayout.findViewById(2131362952));
      localLinearLayout.findViewById(2131371549).setVisibility(8);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextPanel.setPanelListener(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextPanel.a(this.jdField_a_of_type_AndroidWidgetEditText);
    }
    return localLinearLayout;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditTextDialog", 2, "onPanelChanged oldPanel = " + paramInt1 + "newPanel=" + paramInt2);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(0, paramInt1, paramInt2).sendToTarget();
  }
  
  public void a(DynamicTextBuilder paramDynamicTextBuilder)
  {
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextBuilder = paramDynamicTextBuilder;
  }
  
  public void a(DynamicTextConfigManager.DynamicTextConfigBean paramDynamicTextConfigBean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditTextDialog", 2, "onPanelItemClick position = " + paramInt);
    }
    Object localObject;
    if ((this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null) && (this.jdField_a_of_type_AndroidWidgetEditText != null) && (paramDynamicTextConfigBean != null))
    {
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b();
      localObject = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a();
      if (paramDynamicTextConfigBean.text_id != this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.c()) {
        break label260;
      }
      paramDynamicTextConfigBean = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextBuilder.a(paramDynamicTextConfigBean.text_id, (List)localObject);
      paramDynamicTextConfigBean.a(0);
      paramDynamicTextConfigBean.a(0, paramDynamicTextConfigBean.a(0));
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a();
      if (!this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.equals(paramDynamicTextConfigBean)) {
        this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem = paramDynamicTextConfigBean;
      }
      this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.setPreViewDrawer(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem);
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a(-1, this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView, true, 3000, 500, new anho(this));
      this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a());
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.length());
      if (!this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a().equals(DynamicTextBuilder.a(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.c(), this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b()))) {
        break label294;
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelectAllOnFocus(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
      this.e = paramInt;
      return;
      label260:
      localObject = DynamicTextBuilder.a(DynamicTextBuilder.a(paramDynamicTextConfigBean.text_id), this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem);
      this.jdField_a_of_type_MqqOsMqqHandler.post(new anhx(this));
      break;
      label294:
      this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(null);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelectAllOnFocus(false);
    }
  }
  
  public void a(DynamicTextItem paramDynamicTextItem, int paramInt)
  {
    if (paramInt == -1) {}
    do
    {
      return;
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem = paramDynamicTextItem;
    } while (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem == null);
    String str2 = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a(paramInt);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    if (this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView != null)
    {
      this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.setPreViewDrawer(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem);
      this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.setText(paramInt, str1);
    }
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a(paramInt, str1);
    this.jdField_a_of_type_JavaLangString = str1;
    SLog.b("EditTextDialog", "setTextInfo:" + paramDynamicTextItem + " index:" + paramInt + " text:" + str1);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.jdField_a_of_type_JavaLangString = str1;
    this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.length());
    if (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a().equals(DynamicTextBuilder.a(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.c(), this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b())))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelectAllOnFocus(true);
      if (this.jdField_a_of_type_AndroidWidgetEditText.hasFocus()) {
        this.jdField_a_of_type_AndroidWidgetEditText.selectAll();
      }
    }
    for (;;)
    {
      paramInt = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextBuilder.a(paramDynamicTextItem);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextPanel != null) {
        this.e = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextPanel.a(paramInt);
      }
      if (this.g != 0) {
        break;
      }
      b(0);
      return;
      this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(null);
    }
  }
  
  public void a(EditTextDialog.EditTextDialogEventListener paramEditTextDialogEventListener)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog$EditTextDialogEventListener = paramEditTextDialogEventListener;
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EditTextDialog", 2, "dismiss isCancel:" + paramBoolean);
    }
    Object localObject = (InputMethodManager)getContext().getSystemService("input_method");
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      ((InputMethodManager)localObject).hideSoftInputFromInputMethod(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 2);
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog$EditTextDialogEventListener.a(false);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog$EditTextDialogEventListener.a(a(), b());
    this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.setPreViewDrawer(null);
    localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog$EditTextDialogEventListener;
    DynamicTextItem localDynamicTextItem = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((EditTextDialog.EditTextDialogEventListener)localObject).a(localDynamicTextItem, paramBoolean, this.f);
      getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(null);
      getWindow().getDecorView().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      super.dismiss();
      return;
    }
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public int b()
  {
    int i = 0;
    if (this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView != null) {
      i = this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.getHeight() / 2 + this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.getTop();
    }
    SLog.b("EditTextDialog", "getPreViewCenterY()=" + i);
    return i;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditTextDialog", 2, "doPanelChanged oldPanel = " + paramInt1 + "newPanel=" + paramInt2);
    }
    if (paramInt2 == 34)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840497);
      if ((this.e == -1) && (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null))
      {
        int i = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextBuilder.a(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem);
        this.e = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextPanel.a(i);
      }
      if (this.e != -1) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextPanel.a(-1, this.e);
      }
      b(1);
    }
    for (;;)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.post(new anhw(this, paramInt1, paramInt2));
      return;
      if (paramInt2 == 1)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845731);
        b(0);
      }
      else if (paramInt2 == 0)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840497);
        b(1);
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      b(paramMessage.arg1, paramMessage.arg2);
    }
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    a(true);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.d("EditTextDialog", 2, "onClick getCurrentPanel = " + this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a());
    }
    switch (i)
    {
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 1)
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(34);
        return;
      }
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 34)
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    XPanelContainer.jdField_a_of_type_Int = this.d;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog$EditTextDialogEventListener == null) {
      return;
    }
    Object localObject2 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "";
    }
    if (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null)
    {
      localObject2 = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a();
      if (!this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b()).equals(localObject1)) {
        this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b(), (String)localObject1);
      }
      if ((!((DynamicTextItem.TextMap)localObject2).equals(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap)) && (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.e())) {
        this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a(false);
      }
    }
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap = null;
  }
  
  public boolean onTouchEvent(@NonNull MotionEvent paramMotionEvent)
  {
    ((Activity)this.jdField_a_of_type_AndroidContentContext).dispatchTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      getWindow().getDecorView().setSystemUiVisibility(4);
    }
  }
  
  public void q() {}
  
  public void setContentView(int paramInt)
  {
    this.jdField_a_of_type_Int = AIOUtils.a(100.0F, getContext().getResources());
    b();
    a();
    if ((!this.jdField_a_of_type_Boolean) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      c();
    }
    super.setContentView(this.jdField_a_of_type_AndroidViewViewGroup);
  }
  
  public void show()
  {
    super.show();
    if (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null)
    {
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a();
      if (this.g == 0) {
        this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b(), true);
      }
      return;
    }
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog
 * JD-Core Version:    0.7.0.1
 */