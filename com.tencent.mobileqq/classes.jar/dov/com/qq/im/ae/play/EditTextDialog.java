package dov.com.qq.im.ae.play;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.ttpic.baseutils.string.StringUtils;
import com.tencent.ttpic.openapi.model.TextWMElement;

public class EditTextDialog
  extends ReportDialog
{
  private float autoTextSize;
  private TextView mCancelView;
  private ImageView mCleanTextView;
  private Button mConfirmView;
  private EditText mEditText;
  private TextView mEditTip;
  private int mMaxLength = 12;
  private EditTextDialog.OnConfirmClickLister mOnConfirmClickLister;
  private int mTextColor;
  private transient TextPaint mTextPaint;
  
  public EditTextDialog(@NonNull Context paramContext)
  {
    super(paramContext, 2131755359);
    initView(paramContext);
    paramContext = getWindow();
    if (paramContext != null) {
      paramContext.setSoftInputMode(21);
    }
    setCanceledOnTouchOutside(true);
  }
  
  private void initTextPaint()
  {
    this.mTextPaint = new TextPaint(1);
    this.mTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
    this.mTextPaint.setAntiAlias(true);
  }
  
  private void initView(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131558499, null);
    this.mEditText = ((EditText)paramContext.findViewById(2131365861));
    this.mEditTip = ((TextView)paramContext.findViewById(2131365863));
    this.mCancelView = ((TextView)paramContext.findViewById(2131364175));
    this.mConfirmView = ((Button)paramContext.findViewById(2131364983));
    this.mCleanTextView = ((ImageView)paramContext.findViewById(2131363996));
    this.mEditText.addTextChangedListener(new EditTextDialog.1(this));
    this.mConfirmView.setOnClickListener(new EditTextDialog.2(this));
    this.mCancelView.setOnClickListener(new EditTextDialog.3(this));
    this.mCleanTextView.setOnClickListener(new EditTextDialog.4(this));
    setContentView(paramContext);
  }
  
  public void setDefaultEditText(TextWMElement paramTextWMElement, boolean paramBoolean)
  {
    String str1 = paramTextWMElement.userValue;
    String str2 = paramTextWMElement.color;
    initTextPaint();
    if ((TextUtils.isEmpty(str1)) && (paramBoolean)) {
      if (!TextUtils.isEmpty(paramTextWMElement.fmtstr))
      {
        this.mEditText.setText(paramTextWMElement.fmtstr);
        this.mEditText.setSelection(paramTextWMElement.fmtstr.length());
      }
    }
    for (;;)
    {
      this.mEditText.selectAll();
      return;
      paramTextWMElement = StringUtils.removeUTF8Emoji(str1);
      this.mEditText.setText(paramTextWMElement);
      this.mEditText.setSelection(paramTextWMElement.length());
    }
  }
  
  public void setEditMaxLength(int paramInt)
  {
    this.mMaxLength = paramInt;
  }
  
  public void setOnConfirmClickListener(EditTextDialog.OnConfirmClickLister paramOnConfirmClickLister)
  {
    this.mOnConfirmClickLister = paramOnConfirmClickLister;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.EditTextDialog
 * JD-Core Version:    0.7.0.1
 */