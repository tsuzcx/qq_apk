package com.tencent.mobileqq.guild.mainframe.joinchannel;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText;
import com.tencent.mobileqq.mvvm.BaseViewBinder;
import com.tencent.util.InputMethodUtil;

public class JoinChannelViewBinder
  extends BaseViewBinder
{
  private QBaseActivity a;
  private JoinChannelViewModel b;
  private View c;
  private CharacterCountEditText d;
  private Button e;
  
  @RequiresApi(api=21)
  public JoinChannelViewBinder(QBaseActivity paramQBaseActivity, JoinChannelViewModel paramJoinChannelViewModel)
  {
    this.a = paramQBaseActivity;
    this.b = paramJoinChannelViewModel;
    this.c = View.inflate(paramQBaseActivity, 2131625123, null);
    c();
    d();
    e();
  }
  
  private void a(EditText paramEditText)
  {
    paramEditText.setFocusableInTouchMode(false);
    paramEditText.clearFocus();
    paramEditText.setFocusableInTouchMode(true);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.e.setEnabled(true);
      this.e.setOnClickListener(new JoinChannelViewBinder.5(this));
      return;
    }
    this.e.setEnabled(false);
    this.e.setOnClickListener(null);
  }
  
  private void c()
  {
    View localView1 = this.c.findViewById(2131446623);
    View localView2 = this.c.findViewById(2131442928);
    Button localButton = (Button)this.c.findViewById(2131446561);
    this.e = localButton;
    this.e.setEnabled(false);
    this.b.a().observe(this.a, new JoinChannelViewBinder.1(this, localView1, localView2, localButton));
    a(false);
  }
  
  @RequiresApi(api=21)
  private void d()
  {
    TextView localTextView = (TextView)this.c.findViewById(2131442925);
    this.d = ((CharacterCountEditText)this.c.findViewById(2131428386));
    this.d.setLimitCount(30);
    this.b.b().observe(this.a, new JoinChannelViewBinder.2(this, localTextView));
    this.d.addTextChangedListener(new JoinChannelViewBinder.3(this));
  }
  
  private void e()
  {
    this.d.setFocusable(true);
    this.d.setFocusableInTouchMode(true);
    this.d.requestFocus();
    this.d.postDelayed(new JoinChannelViewBinder.4(this), 500L);
  }
  
  public View a()
  {
    return this.c;
  }
  
  public void b()
  {
    InputMethodUtil.b(this.d);
    a(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.joinchannel.JoinChannelViewBinder
 * JD-Core Version:    0.7.0.1
 */