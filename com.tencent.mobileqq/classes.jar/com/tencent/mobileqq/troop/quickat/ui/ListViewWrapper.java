package com.tencent.mobileqq.troop.quickat.ui;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.contacts.alphabet.IndexBar;
import com.tencent.mobileqq.activity.contacts.alphabet.IndexBar.OnIndexBarTouchListener;
import com.tencent.mobileqq.activity.contacts.alphabet.IndexBarTipsLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;

public class ListViewWrapper
  implements IndexBar.OnIndexBarTouchListener
{
  public XListView a;
  public QuickAtListAdapter b;
  public QQAppInterface c;
  public Context d;
  public IndexBarTipsLayout e;
  public IndexBar f;
  private final View g;
  private String h = "";
  
  public ListViewWrapper(QQAppInterface paramQQAppInterface, Context paramContext, TroopChatPie paramTroopChatPie, View paramView, XListView paramXListView)
  {
    this.c = paramQQAppInterface;
    this.d = paramContext;
    this.g = paramView;
    this.a = paramXListView;
    this.b = new QuickAtListAdapter(this, paramTroopChatPie);
    this.a.setAdapter(this.b);
    a();
  }
  
  private void a()
  {
    this.e = ((IndexBarTipsLayout)this.g.findViewById(2131435679));
    this.f = ((IndexBar)this.g.findViewById(2131435678));
    this.f.setOnIndexBarTouchListener(this);
    this.e.setVisibility(8);
  }
  
  public void a(String paramString, int paramInt, float paramFloat)
  {
    IndexBarTipsLayout localIndexBarTipsLayout = this.e;
    if (localIndexBarTipsLayout != null) {
      localIndexBarTipsLayout.setText(paramString, paramFloat);
    }
    if (!this.h.equals(paramString))
    {
      this.h = paramString;
      if ("★".equals(paramString))
      {
        this.a.setSelection(0);
        return;
      }
      paramInt = this.b.d(paramString);
      if (paramInt != -1)
      {
        paramString = this.a;
        paramString.setSelection(paramInt + paramString.getHeaderViewsCount());
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    boolean bool = QLog.isColorLevel();
    int i = 0;
    if (bool) {
      QLog.d("ListViewWrapper", 2, new Object[] { "onLetterTouching: invoked. ", " touching: ", Boolean.valueOf(paramBoolean) });
    }
    if (!paramBoolean) {
      this.h = "";
    }
    IndexBarTipsLayout localIndexBarTipsLayout = this.e;
    if (localIndexBarTipsLayout != null)
    {
      if (!paramBoolean) {
        i = 8;
      }
      localIndexBarTipsLayout.setVisibility(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.ListViewWrapper
 * JD-Core Version:    0.7.0.1
 */