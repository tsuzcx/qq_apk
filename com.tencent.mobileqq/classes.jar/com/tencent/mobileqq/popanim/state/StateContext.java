package com.tencent.mobileqq.popanim.state;

import android.view.ViewGroup;
import android.widget.EditText;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.QQEmoticonPanelLinearLayoutHelper;
import com.tencent.mobileqq.popanim.PopOutAnimConfig;
import com.tencent.mobileqq.popanim.PopOutEmoticonGesture;
import com.tencent.mobileqq.popanim.util.PopOutEmoticonUtil;

public class StateContext
{
  public PopOutEmoticonGesture a;
  public EmoticonInfo b;
  public PopOutAnimConfig c;
  public ViewGroup d;
  public ViewGroup e;
  public EditText f;
  public QQEmoticonPanelLinearLayoutHelper g;
  protected boolean h;
  protected boolean i;
  protected boolean j;
  protected boolean k;
  protected boolean l;
  protected boolean m;
  
  public void a()
  {
    this.h = false;
    this.i = false;
    this.j = false;
    this.l = false;
    this.m = false;
    this.a.e();
  }
  
  public boolean b()
  {
    return PopOutEmoticonUtil.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.popanim.state.StateContext
 * JD-Core Version:    0.7.0.1
 */