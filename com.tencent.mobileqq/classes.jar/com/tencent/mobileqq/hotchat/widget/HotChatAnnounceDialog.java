package com.tencent.mobileqq.hotchat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class HotChatAnnounceDialog
  extends QQCustomDialog
  implements View.OnClickListener
{
  String a;
  String b;
  Context c;
  View d;
  View e;
  Button f;
  TextView g;
  TextView h;
  QQAppInterface i;
  
  public HotChatAnnounceDialog(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext, 2131953338);
    this.c = paramContext;
    this.i = paramQQAppInterface;
    this.a = paramString1;
    this.b = paramString2;
    a();
  }
  
  public void a()
  {
    this.d = LayoutInflater.from(this.c).inflate(2131627469, null);
    this.e = this.d.findViewById(2131447534);
    this.e.setOnClickListener(this);
    this.h = ((TextView)this.d.findViewById(2131447545));
    this.h.setOnClickListener(this);
    if (TextUtils.isEmpty(this.b)) {
      this.h.setVisibility(8);
    }
    this.g = ((TextView)this.d.findViewById(2131431367));
    this.g.setText(this.a);
    this.f = ((Button)this.d.findViewById(2131430817));
    this.f.setOnClickListener(this);
    this.f.setContentDescription(this.c.getString(2131895406));
    setContentView(this.d);
    setCancelable(true);
    Object localObject = this.c.getResources().getDisplayMetrics();
    ViewGroup.LayoutParams localLayoutParams = this.d.getLayoutParams();
    localLayoutParams.width = ((int)(((DisplayMetrics)localObject).widthPixels - DisplayUtils.a(this.c, 30.0F)));
    this.d.setLayoutParams(localLayoutParams);
    localObject = getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject).gravity = 48;
    int j = (int)DisplayUtils.a(this.c, 10.0F);
    ((WindowManager.LayoutParams)localObject).y = (AIOUtils.b(50.0F, this.c.getResources()) + j);
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    if (j != 2131430817)
    {
      if ((j != 2131447534) && (j != 2131447545)) {
        return;
      }
      paramView = JumpParser.a(this.i, this.c, this.b);
      if (paramView != null)
      {
        paramView.a();
        return;
      }
      paramView = new Intent(this.c, QQBrowserActivity.class);
      paramView.putExtra("url", this.b);
      this.c.startActivity(paramView);
      return;
    }
    dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.widget.HotChatAnnounceDialog
 * JD-Core Version:    0.7.0.1
 */