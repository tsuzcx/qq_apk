package dov.com.tencent.biz.qqstory.takevideo.vote;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.biz.qqstory.utils.PollWidgetUtils;
import com.tencent.biz.qqstory.utils.PollWidgetUtils.IPollWidget;
import com.tencent.biz.qqstory.utils.PollWidgetUtils.OnWidgetElementClickListener;
import com.tencent.biz.qqstory.utils.PollWidgetUtils.OptionElement;
import com.tencent.biz.qqstory.utils.PollWidgetUtils.QuestionElement;
import com.tencent.biz.qqstory.utils.PollWidgetUtils.WidgetElement;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoVote;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoVote.VoteInfo;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;

public class VoteDialog
  extends Dialog
  implements TextWatcher, View.OnClickListener, TextView.OnEditorActionListener, PollWidgetUtils.OnWidgetElementClickListener
{
  private int jdField_a_of_type_Int = 1;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  PollWidgetUtils.IPollWidget jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget;
  private PollWidgetUtils.WidgetElement jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$WidgetElement;
  private FitSystemWindowsRelativeLayout jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout;
  private EditVideoVote.VoteInfo jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoVote$VoteInfo;
  private EditVideoVote jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoVote;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  
  public VoteDialog(@NonNull Context paramContext, @NonNull EditVideoVote paramEditVideoVote, EditVideoVote.VoteInfo paramVoteInfo, int paramInt)
  {
    super(paramContext, 2131624201);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoVote = paramEditVideoVote;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoVote$VoteInfo = paramVoteInfo;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  private void a()
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
    setCanceledOnTouchOutside(true);
  }
  
  private void a(CharSequence paramCharSequence)
  {
    if (this.jdField_b_of_type_Int == 0) {}
    for (int i = 36;; i = 16)
    {
      int j = StringUtil.b(paramCharSequence.toString());
      if (i - j > 6) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format("%s/%s", new Object[] { Integer.valueOf(j / 2), Integer.valueOf(i / 2) }));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  private void a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(paramCharSequence);
      this.jdField_a_of_type_AndroidWidgetEditText.getText().clear();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setText(paramCharSequence);
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout = ((FitSystemWindowsRelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364404));
    this.jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout.setFitsSystemWindows(true);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131372175));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131371833).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget = PollWidgetUtils.a(this.jdField_a_of_type_AndroidContentContext, 0, 0, null);
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a(false);
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a().b("向好友提问…");
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a();
    Object localObject = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_b_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131372174));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372173));
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoVote$VoteInfo == null)
    {
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$WidgetElement = this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a();
      this.jdField_a_of_type_Int = 1;
      a(this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$WidgetElement.b(), true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$WidgetElement.a(true);
      a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      return;
      if (this.jdField_b_of_type_Int >= 0) {
        break;
      }
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a();
      i = 0;
      while (i < localObject.length)
      {
        localObject[i].a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoVote$VoteInfo.a[i]);
        i += 1;
      }
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$WidgetElement = this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a();
      this.jdField_a_of_type_Int = 2;
      a(this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$WidgetElement.a(), false);
    }
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a();
    int i = 0;
    while (i < localObject.length)
    {
      localObject[i].a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoVote$VoteInfo.a[i]);
      i += 1;
    }
    if (this.jdField_b_of_type_Int == 0) {}
    for (this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$WidgetElement = this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a();; this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$WidgetElement = this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a(this.jdField_b_of_type_Int - 1))
    {
      this.jdField_a_of_type_Int = 3;
      a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoVote$VoteInfo.a[this.jdField_b_of_type_Int], false);
      break;
    }
  }
  
  public void a(PollWidgetUtils.IPollWidget paramIPollWidget, PollWidgetUtils.WidgetElement paramWidgetElement)
  {
    if ((paramWidgetElement instanceof PollWidgetUtils.QuestionElement))
    {
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$WidgetElement.a(false);
      this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$WidgetElement = paramWidgetElement;
      this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$WidgetElement.a(true);
      if (this.jdField_a_of_type_Int != 1) {
        break label119;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$WidgetElement.a())) {
        break label104;
      }
      a(this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$WidgetElement.b(), true);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      return;
      if (!(paramWidgetElement instanceof PollWidgetUtils.OptionElement)) {
        break;
      }
      this.jdField_b_of_type_Int = (((PollWidgetUtils.OptionElement)paramWidgetElement).a() + 1);
      break;
      label104:
      a(this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$WidgetElement.a(), false);
      continue;
      label119:
      a(this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$WidgetElement.a(), false);
    }
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    dismiss();
  }
  
  public void onDetachedFromWindow()
  {
    int j = 0;
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a();
    int k = localObject.length;
    int i = 0;
    boolean bool = false;
    PollWidgetUtils.WidgetElement[] arrayOfWidgetElement;
    if (i < k)
    {
      arrayOfWidgetElement = localObject[i];
      arrayOfWidgetElement.a(false);
      if (((arrayOfWidgetElement instanceof PollWidgetUtils.OptionElement)) && (TextUtils.isEmpty(arrayOfWidgetElement.a()))) {}
      for (;;)
      {
        i += 1;
        break;
        if ((arrayOfWidgetElement instanceof PollWidgetUtils.OptionElement)) {
          bool = true;
        }
      }
    }
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a();
    if (localObject != null)
    {
      arrayOfWidgetElement = this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a();
      Rect[] arrayOfRect = new Rect[arrayOfWidgetElement.length];
      String[] arrayOfString = new String[arrayOfWidgetElement.length];
      i = j;
      while (i < arrayOfWidgetElement.length)
      {
        arrayOfRect[i] = arrayOfWidgetElement[i].a();
        arrayOfString[i] = arrayOfWidgetElement[i].a().toString();
        i += 1;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoVote.a(arrayOfString, (Bitmap)localObject, arrayOfRect, bool);
    }
    super.onDetachedFromWindow();
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$WidgetElement != null)
      {
        paramTextView = this.jdField_a_of_type_AndroidWidgetEditText.getText();
        this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$WidgetElement.a(paramTextView);
      }
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        return true;
      case 1: 
        if (this.jdField_b_of_type_Int < this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a())
        {
          if (this.jdField_b_of_type_Int == this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a() - 1)
          {
            dismiss();
            return true;
          }
          if (this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$WidgetElement != null) {
            this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$WidgetElement.a(false);
          }
          this.jdField_b_of_type_Int += 1;
          this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$WidgetElement = this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a(this.jdField_b_of_type_Int - 1);
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$WidgetElement.a())) {
            a(this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$WidgetElement.b(), true);
          }
          for (;;)
          {
            a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
            this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$WidgetElement.a(true);
            return true;
            a(this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$WidgetElement.a(), false);
          }
        }
        dismiss();
        return true;
      case 2: 
        dismiss();
        return true;
      }
      dismiss();
      return true;
    }
    return false;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_b_of_type_Int == 0)
    {
      paramInt1 = 24;
      paramInt3 = StringUtil.b(paramCharSequence.toString());
      if (paramInt1 - paramInt3 > 6) {
        break label153;
      }
      paramInt2 = paramInt3;
      Object localObject = paramCharSequence;
      if (paramInt1 - paramInt3 < 0)
      {
        localObject = StringUtil.b(paramCharSequence.toString(), 0, paramInt1);
        paramInt2 = StringUtil.b(((CharSequence)localObject).toString());
        a((CharSequence)localObject, false);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format("%s/%s", new Object[] { Integer.valueOf(paramInt2 / 2), Integer.valueOf(paramInt1 / 2) }));
      paramCharSequence = (CharSequence)localObject;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$WidgetElement.a(paramCharSequence);
      if (TextUtils.isEmpty(paramCharSequence)) {
        a(this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$WidgetElement.b(), true);
      }
      return;
      paramInt1 = 16;
      break;
      label153:
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  public void setContentView(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(paramInt, null);
    a();
    b();
    super.setContentView(this.jdField_a_of_type_AndroidViewView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.vote.VoteDialog
 * JD-Core Version:    0.7.0.1
 */