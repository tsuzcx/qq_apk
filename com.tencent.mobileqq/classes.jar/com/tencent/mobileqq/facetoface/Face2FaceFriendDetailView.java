package com.tencent.mobileqq.facetoface;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;

public class Face2FaceFriendDetailView
  extends Face2FaceDetailBaseView
{
  private String o = null;
  private HashMap<String, String> p = null;
  private Face2FaceAddFriendActivity q = null;
  
  public Face2FaceFriendDetailView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void a()
  {
    this.a = findViewById(2131433769);
    this.b = findViewById(2131433822);
    this.f = findViewById(2131433757);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.f.setPadding(AIOUtils.b(10.0F, this.f.getResources()), AIOUtils.b(15.0F, this.f.getResources()) + ImmersiveUtils.getStatusBarHeight(this.f.getContext()), AIOUtils.b(10.0F, this.f.getResources()), AIOUtils.b(15.0F, this.f.getResources()));
    }
    this.f.setOnClickListener(new Face2FaceFriendDetailView.1(this));
  }
  
  public void a(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity, View paramView, Face2FaceFriendBubbleView paramFace2FaceFriendBubbleView, String paramString, HashMap<String, String> paramHashMap, View.OnClickListener paramOnClickListener)
  {
    this.q = paramFace2FaceAddFriendActivity;
    this.o = paramString;
    this.p = paramHashMap;
    this.a.setOnClickListener(paramOnClickListener);
    super.a(paramView, paramFace2FaceFriendBubbleView);
  }
  
  public boolean e()
  {
    c();
    return true;
  }
  
  public void f()
  {
    c();
    EditText localEditText = (EditText)findViewById(2131433768);
    this.p.put(this.o, localEditText.getText().toString());
    ((InputMethodManager)this.q.getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    this.q.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceFriendDetailView
 * JD-Core Version:    0.7.0.1
 */