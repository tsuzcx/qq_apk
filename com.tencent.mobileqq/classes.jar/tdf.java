import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.weishi_new.comment.WsCommentInputPopupWindow.10;
import com.tencent.biz.pubaccount.weishi_new.comment.WsCommentInputPopupWindow.11;
import com.tencent.biz.pubaccount.weishi_new.comment.WsCommentInputPopupWindow.8;
import com.tencent.biz.pubaccount.weishi_new.comment.WsCommentInputPopupWindow.9;
import com.tencent.biz.subscribe.comment.CommentEditText;
import com.tencent.biz.subscribe.comment.EmoView;
import com.tencent.biz.subscribe.comment.WorkSpaceView;
import com.tencent.mobileqq.widget.QQToast;

public class tdf
  extends ydh
  implements DialogInterface.OnDismissListener, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private SharedPreferences.Editor jdField_a_of_type_AndroidContentSharedPreferences$Editor;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private CommentEditText jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText;
  private EmoView jdField_a_of_type_ComTencentBizSubscribeCommentEmoView;
  private tdm jdField_a_of_type_Tdm;
  private ybf jdField_a_of_type_Ybf;
  private ydi jdField_a_of_type_Ydi;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private View jdField_b_of_type_AndroidViewView;
  private ImageButton jdField_b_of_type_AndroidWidgetImageButton;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 140;
  private ImageButton jdField_c_of_type_AndroidWidgetImageButton;
  private boolean jdField_c_of_type_Boolean;
  private ImageButton d;
  
  public tdf(Activity paramActivity)
  {
    super(paramActivity, 2131755395);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131559854, null);
    b();
    setCancelable(true);
    setContentView(this.jdField_a_of_type_AndroidViewView);
    c();
    d();
    setOnDismissListener(this);
    P_();
  }
  
  private Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentEmoView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentEmoView.setVisibility(8);
    }
    d(this.jdField_b_of_type_AndroidViewView);
    if (paramBoolean)
    {
      a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
      return;
    }
    b(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
  }
  
  private void b()
  {
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localWindow.setAttributes(localLayoutParams);
    localWindow.setSoftInputMode(16);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364869));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131363574));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText = ((CommentEditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131377631));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setOnInputBackListener(new tdg(this));
    this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131363615));
    this.jdField_c_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131363606));
    this.jdField_c_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.d = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131363587));
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363656));
    this.jdField_a_of_type_AndroidContentSharedPreferences = getContext().getSharedPreferences("weishi_comment_prefs_version", 0);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("GroupSoftKeyboardHeight", aekt.a(250.0F, getContext().getResources()));
    tlo.b("CommentInputPopupWindow", 1, "mEmojiPanel initView() step1 :" + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Int = azgq.a(250.0F);
      tlo.b("CommentInputPopupWindow", 1, "mEmojiPanel initView() step2 :" + this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentBizSubscribeCommentEmoView = ((EmoView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365646));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentEmoView.a(this.jdField_a_of_type_AndroidAppActivity, getContext(), this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText, null);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131363335);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new tdh(this));
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("input_method"));
    this.jdField_a_of_type_Boolean = true;
    e();
  }
  
  private void c(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.height = paramView.getHeight();
    localLayoutParams.weight = 0.0F;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    g();
  }
  
  private void d(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.height = 0;
    localLayoutParams.weight = 1.0F;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeCommentEmoView.getLayoutParams().height = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentBizSubscribeCommentEmoView.invalidate();
    tlo.b("CommentInputPopupWindow", 1, "mEmojiPanel onGetKeyBoardHeight() :" + this.jdField_a_of_type_Int);
  }
  
  private void f()
  {
    this.jdField_a_of_type_Ydi = new ydi(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_Ydi.a(new tdi(this));
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver();
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setImeOptions(268435456);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setOnFocusChangeListener(new tdj(this));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setOnEditorActionListener(new tdk(this));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.addTextChangedListener(new tdl(this));
  }
  
  private void h()
  {
    if (this.jdField_b_of_type_Boolean) {
      c(this.jdField_b_of_type_AndroidViewView);
    }
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizSubscribeCommentEmoView.setVisibility(0);
    WorkSpaceView localWorkSpaceView = (WorkSpaceView)this.jdField_a_of_type_ComTencentBizSubscribeCommentEmoView.getChildAt(0);
    if (localWorkSpaceView != null) {
      a().post(new WsCommentInputPopupWindow.9(this, localWorkSpaceView));
    }
    StringBuilder localStringBuilder = new StringBuilder().append("workSpaceView is empty ");
    if (localWorkSpaceView != null) {}
    for (boolean bool = true;; bool = false)
    {
      tlo.b("CommentInputPopupWindow", bool);
      b(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
      return;
    }
  }
  
  @TargetApi(19)
  public void P_()
  {
    int i = 0;
    super.P_();
    Object localObject = getWindow();
    if (localObject == null) {}
    label102:
    for (;;)
    {
      return;
      localObject = ((Window)localObject).getDecorView();
      if ((localObject instanceof ViewGroup))
      {
        localObject = ((ViewGroup)localObject).getChildAt(0);
        if ((localObject instanceof ViewGroup))
        {
          int j = ((ViewGroup)localObject).getChildCount();
          for (;;)
          {
            if (i >= j) {
              break label102;
            }
            View localView = ((ViewGroup)localObject).getChildAt(i);
            if ((localView == null) || (localView.getId() == 16908290)) {
              break;
            }
            if (!(localView instanceof ViewStub)) {
              localView.setAlpha(0.0F);
            }
            i += 1;
          }
        }
      }
    }
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText == null) {
      return "";
    }
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getText() == null) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getText().toString().trim();
  }
  
  public void a(int paramInt)
  {
    show();
    f();
    if (paramInt > 0)
    {
      a().post(new WsCommentInputPopupWindow.10(this, paramInt));
      return;
    }
    a().post(new WsCommentInputPopupWindow.11(this));
  }
  
  public void a(View paramView)
  {
    paramView.requestFocus();
    paramView.post(new WsCommentInputPopupWindow.8(this, paramView));
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setText(paramString);
  }
  
  public void a(tdm paramtdm)
  {
    this.jdField_a_of_type_Tdm = paramtdm;
  }
  
  public void a(ybf paramybf)
  {
    this.jdField_a_of_type_Ybf = paramybf;
  }
  
  public void b(View paramView)
  {
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    paramView.clearFocus();
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setHint(paramString);
    }
  }
  
  public void dismiss()
  {
    b(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
    a(false);
    super.dismiss();
  }
  
  public void onClick(View paramView)
  {
    tlo.b("CommentInputPopupWindow", 1, "onClick:" + paramView.getId());
    switch (paramView.getId())
    {
    default: 
    case 2131363606: 
    case 2131363587: 
    case 2131363574: 
    case 2131377631: 
    case 2131363656: 
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.length() > this.jdField_c_of_type_Int) {
          QQToast.a(getContext(), alpo.a(2131702555) + this.jdField_c_of_type_Int + alpo.a(2131702556), 0).a();
        }
        this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.append("[em]e166[/em]");
        return;
        if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.length() > this.jdField_c_of_type_Int) {
          QQToast.a(getContext(), alpo.a(2131702555) + this.jdField_c_of_type_Int + alpo.a(2131702556), 0).a();
        }
        this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.append("[em]e163[/em]");
        return;
        tlo.b("CommentInputPopupWindow", 1, "btn_emotion");
        h();
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetImageButton.setVisibility(0);
        this.d.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
        return;
        tlo.b("CommentInputPopupWindow", 1, "text_input");
        a(true);
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetImageButton.setVisibility(8);
        this.d.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
        return;
      } while (this.jdField_a_of_type_Ybf == null);
      this.jdField_a_of_type_Ybf.a();
      return;
    }
    tlo.b("CommentInputPopupWindow", 1, "btn_keyboard");
    a(true);
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Ydi.a();
    this.jdField_a_of_type_Ydi = null;
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Tdm != null) {
      this.jdField_a_of_type_Tdm.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tdf
 * JD-Core Version:    0.7.0.1
 */