package com.tencent.mobileqq.guild.base;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.guild.util.QQGuildTextUtils.CharacterCountInfo;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText.ITextEditEventListener;

public abstract class QQGuildNameBaseFragment
  extends QQGuildTitleBarFragment
  implements CharacterCountEditText.ITextEditEventListener
{
  protected int o = 2;
  protected int p = 32;
  protected CharacterCountEditText q;
  private TextView r;
  private ImageView s;
  
  protected void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.q = ((CharacterCountEditText)this.l.findViewById(2131434699));
    this.r = ((TextView)this.l.findViewById(2131434698));
    this.s = ((ImageView)this.l.findViewById(2131434734));
    if (this.o > 0)
    {
      paramLayoutInflater = this.r;
      paramViewGroup = new StringBuilder();
      paramViewGroup.append(this.p);
      paramViewGroup.append("/");
      paramViewGroup.append(this.p);
      paramLayoutInflater.setText(paramViewGroup.toString());
    }
    else
    {
      this.r.setVisibility(8);
    }
    this.q.setLimitCount(this.p);
    this.q.setCountChangeListener(this);
    if (!TextUtils.isEmpty(j())) {
      this.q.setHint(j());
    }
    this.s.setOnClickListener(new QQGuildNameBaseFragment.1(this));
    a(2131887648, new QQGuildNameBaseFragment.2(this));
    a(i());
    b(2131888784, new QQGuildNameBaseFragment.3(this));
    if (!TextUtils.isEmpty(k()))
    {
      this.q.setText(k());
      this.q.setSelection(k().length());
      a(true);
      return;
    }
    if (this.o > 0) {
      a(false);
    }
  }
  
  public void a(QQGuildTextUtils.CharacterCountInfo paramCharacterCountInfo)
  {
    if (this.o > 0)
    {
      int i = paramCharacterCountInfo.a();
      paramCharacterCountInfo = this.r;
      int j = this.p;
      boolean bool = false;
      paramCharacterCountInfo.setText(String.format("%s/%s", new Object[] { Integer.valueOf(j - i), Integer.valueOf(this.p) }));
      if (i >= this.o) {
        bool = true;
      }
      a(bool);
    }
  }
  
  protected abstract void a(String paramString);
  
  protected int b()
  {
    return 2131625096;
  }
  
  public void b(QQGuildTextUtils.CharacterCountInfo paramCharacterCountInfo) {}
  
  protected abstract String i();
  
  protected abstract String j();
  
  protected abstract String k();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.base.QQGuildNameBaseFragment
 * JD-Core Version:    0.7.0.1
 */