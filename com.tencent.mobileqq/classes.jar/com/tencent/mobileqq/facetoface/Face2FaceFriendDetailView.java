package com.tencent.mobileqq.facetoface;

import agej;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import atgw;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;

public class Face2FaceFriendDetailView
  extends Face2FaceDetailBaseView
{
  private Face2FaceAddFriendActivity jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  
  public Face2FaceFriendDetailView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131367223);
    this.b = findViewById(2131367273);
    this.e = findViewById(2131367217);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.e.setPadding(agej.a(10.0F, this.e.getResources()), agej.a(15.0F, this.e.getResources()) + ImmersiveUtils.getStatusBarHeight(this.e.getContext()), agej.a(10.0F, this.e.getResources()), agej.a(15.0F, this.e.getResources()));
    }
    this.e.setOnClickListener(new atgw(this));
  }
  
  public void a(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity, View paramView, Face2FaceFriendBubbleView paramFace2FaceFriendBubbleView, String paramString, HashMap<String, String> paramHashMap, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity = paramFace2FaceAddFriendActivity;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(paramOnClickListener);
    super.a(paramView, paramFace2FaceFriendBubbleView);
  }
  
  public boolean b()
  {
    c();
    return true;
  }
  
  public void d()
  {
    c();
    EditText localEditText = (EditText)findViewById(2131367222);
    this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_JavaLangString, localEditText.getText().toString());
    ((InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceFriendDetailView
 * JD-Core Version:    0.7.0.1
 */