package com.tencent.mobileqq.facetoface;

import alud;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import aqkp;
import aqkq;
import aqkr;
import aqkt;
import aqkw;
import aqkx;
import aqky;
import bdbk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class Face2FaceFriendBubbleView
  extends FrameLayout
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131366954, 2131366935 };
  private int jdField_a_of_type_Int = 1;
  private View jdField_a_of_type_AndroidViewView;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new aqkp(this);
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<View, Integer> jdField_a_of_type_JavaUtilHashMap;
  private int jdField_b_of_type_Int;
  private Animation.AnimationListener jdField_b_of_type_AndroidViewAnimationAnimation$AnimationListener = new aqkq(this);
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private String jdField_b_of_type_JavaLangString = "";
  private int jdField_c_of_type_Int;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private int d = 1;
  
  public Face2FaceFriendBubbleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public Face2FaceFriendBubbleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, 0);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131559095, this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131366951));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366914));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378390));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131366954);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366953));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131377018));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366937));
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("");
    this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(paramContext, 2130772035);
    this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(paramContext, 2130772034);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_b_of_type_AndroidViewAnimationAnimation$AnimationListener);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public aqkw a()
  {
    if (getTag() != null) {
      return (aqkw)getTag();
    }
    return null;
  }
  
  public String a()
  {
    String str2 = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
    String str1 = str2;
    if (TextUtils.isEmpty(str2.trim())) {
      str1 = this.jdField_a_of_type_JavaLangString;
    }
    return str1;
  }
  
  public void a()
  {
    int j = jdField_a_of_type_ArrayOfInt.length;
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap(j);
    }
    for (;;)
    {
      int i = 0;
      while (i < j)
      {
        View localView = findViewById(jdField_a_of_type_ArrayOfInt[i]);
        int k = localView.getVisibility();
        this.jdField_a_of_type_JavaUtilHashMap.put(localView, Integer.valueOf(k));
        if (k == 0)
        {
          Animation localAnimation = AnimationUtils.loadAnimation(BaseApplicationImpl.getContext(), 2130772032);
          localAnimation.setAnimationListener(new aqkr(this, 1, localView));
          localView.startAnimation(localAnimation);
        }
        i += 1;
      }
      if (!this.jdField_a_of_type_JavaUtilHashMap.isEmpty()) {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, aqkw paramaqkw)
  {
    if (paramaqkw == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "bindFriendInfo Face2FaceUserData is Null~~~~~");
      }
      return;
    }
    setTag(paramaqkw);
    this.jdField_a_of_type_JavaLangString = paramaqkw.e;
    this.jdField_a_of_type_Int = paramaqkw.jdField_a_of_type_Int;
    this.jdField_b_of_type_JavaLangString = paramaqkw.e;
    if ((paramaqkw instanceof aqkt)) {
      this.jdField_b_of_type_JavaLangString = (paramaqkw.e + "_" + ((aqkt)paramaqkw).jdField_b_of_type_JavaLangString);
    }
    String str = paramaqkw.e;
    int j = this.jdField_a_of_type_Int;
    Object localObject;
    int i;
    if (this.jdField_a_of_type_Int == 1)
    {
      paramaqkw = (aqky)paramaqkw;
      if (TextUtils.isEmpty(paramaqkw.jdField_a_of_type_JavaLangString))
      {
        localObject = paramaqkw.jdField_b_of_type_JavaLangString;
        this.jdField_a_of_type_AndroidWidgetTextView.setLines(1);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        i = j;
        label153:
        if (localObject != null) {
          break label423;
        }
        paramaqkw = this.jdField_a_of_type_JavaLangString;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramaqkw);
      a(paramQQAppInterface, this.jdField_a_of_type_JavaLangString, i);
      return;
      localObject = paramaqkw.jdField_a_of_type_JavaLangString;
      break;
      localObject = str;
      i = j;
      if (this.jdField_a_of_type_Int != 2) {
        break label153;
      }
      if ((paramaqkw instanceof aqkx))
      {
        localObject = ((aqkx)paramaqkw).jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_AndroidWidgetTextView.setLines(1);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        i = 1;
        break label153;
      }
      localObject = str;
      i = j;
      if (!(paramaqkw instanceof aqkt)) {
        break label153;
      }
      paramaqkw = ((aqkt)paramaqkw).jdField_a_of_type_JavaLangString;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (this.jdField_b_of_type_Int < 1)
      {
        this.jdField_c_of_type_Int = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131296850);
        this.jdField_b_of_type_Int = BaseApplicationImpl.getContext().getResources().getDrawable(2130839694).getIntrinsicWidth();
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setLines(2);
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.jdField_c_of_type_Int - this.jdField_b_of_type_Int);
      localObject = paramaqkw;
      i = j;
      if (!QLog.isColorLevel()) {
        break label153;
      }
      QLog.e("zivonchen", 2, "nickMaxWidth = " + this.jdField_c_of_type_Int + ", flagWidth = " + this.jdField_b_of_type_Int + ", realWidth = " + (this.jdField_c_of_type_Int - this.jdField_b_of_type_Int));
      localObject = paramaqkw;
      i = j;
      break label153;
      label423:
      paramaqkw = (aqkw)localObject;
      if (TextUtils.isEmpty(((String)localObject).trim())) {
        paramaqkw = this.jdField_a_of_type_JavaLangString;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (paramInt == 1)
    {
      paramQQAppInterface = bdbk.a(paramQQAppInterface, 1, paramString);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramQQAppInterface);
    }
    while (paramInt != 2) {
      return;
    }
    paramQQAppInterface = bdbk.a(paramQQAppInterface, 4, paramString);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramQQAppInterface);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public int b()
  {
    return this.d;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void b()
  {
    int j = jdField_a_of_type_ArrayOfInt.length;
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() != j))
    {
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
      }
      if (QLog.isColorLevel()) {
        QLog.e(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "restoreAndHideLables error: ids.size not equals cache.size~~~~~");
      }
      return;
    }
    int i = 0;
    while (i < j)
    {
      View localView = findViewById(jdField_a_of_type_ArrayOfInt[i]);
      if ((((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localView)).intValue() == 0) && (localView.getVisibility() == 4))
      {
        Animation localAnimation = AnimationUtils.loadAnimation(BaseApplicationImpl.getContext(), 2130772033);
        localAnimation.setAnimationListener(new aqkr(this, 0, localView));
        localView.startAnimation(localAnimation);
      }
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public String c()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void setStatusWithAnimation(int paramInt)
  {
    String str2;
    String str1;
    switch (paramInt)
    {
    default: 
      str2 = a();
      if (paramInt == 2) {
        str1 = str2 + alud.a(2131704674);
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(str1);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setContentDescription(str1);
      return;
      this.d = paramInt;
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0) {
        break;
      }
      this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
      break;
      this.d = paramInt;
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)
      {
        this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
        break;
      }
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 8) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      }
      this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      break;
      if (paramInt == 3)
      {
        str1 = str2 + alud.a(2131704672);
      }
      else
      {
        str1 = str2;
        if (paramInt == 4) {
          str1 = str2 + alud.a(2131704676);
        }
      }
    }
  }
  
  public void setStatusWithoutAnimation(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.d = paramInt;
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    case 2: 
      this.d = paramInt;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130839675);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    case 3: 
      this.d = paramInt;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130839676);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.d = paramInt;
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130839677);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceFriendBubbleView
 * JD-Core Version:    0.7.0.1
 */