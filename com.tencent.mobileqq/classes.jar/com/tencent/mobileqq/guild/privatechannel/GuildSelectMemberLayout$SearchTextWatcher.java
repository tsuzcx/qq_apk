package com.tencent.mobileqq.guild.privatechannel;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class GuildSelectMemberLayout$SearchTextWatcher
  implements TextWatcher
{
  private final boolean b;
  private EditText c;
  
  protected GuildSelectMemberLayout$SearchTextWatcher(GuildSelectMemberLayout paramGuildSelectMemberLayout, boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  private String a()
  {
    EditText localEditText = this.c;
    if (localEditText != null) {
      return localEditText.getText().toString().trim();
    }
    return "";
  }
  
  public void a(EditText paramEditText)
  {
    this.c = paramEditText;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = a();
    if (TextUtils.isEmpty(paramEditable))
    {
      GuildSelectMemberLayout.c(this.a).setVisibility(8);
      if (this.b)
      {
        GuildSelectMemberLayout.a(this.a, true);
        return;
      }
      GuildSelectMemberLayout.a(this.a, false);
      return;
    }
    GuildSelectMemberLayout.c(this.a).setVisibility(0);
    if (GuildSelectMemberLayout.b(this.a) != null) {
      GuildSelectMemberLayout.b(this.a).a(paramEditable);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.GuildSelectMemberLayout.SearchTextWatcher
 * JD-Core Version:    0.7.0.1
 */