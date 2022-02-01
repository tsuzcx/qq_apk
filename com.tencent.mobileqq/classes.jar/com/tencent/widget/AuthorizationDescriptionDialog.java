package com.tencent.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

class AuthorizationDescriptionDialog
  extends ActionSheet
{
  AuthorizationDescriptionDialog(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  private void a()
  {
    LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(getContext()).inflate(2131559159, null);
    localLinearLayout.findViewById(2131369579).setOnClickListener(new AuthorizationDescriptionDialog.1(this));
    String str = getContext().getString(2131690307);
    TextView localTextView = (TextView)localLinearLayout.findViewById(2131380283);
    SpannableString localSpannableString = new SpannableString(str);
    localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#1B90EE")), str.length() - 3, str.length() - 1, 33);
    localSpannableString.setSpan(new AuthorizationDescriptionDialog.TextClick(getContext(), null), str.length() - 3, str.length() - 1, 33);
    localTextView.setText(localSpannableString);
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
    addView(localLinearLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.AuthorizationDescriptionDialog
 * JD-Core Version:    0.7.0.1
 */