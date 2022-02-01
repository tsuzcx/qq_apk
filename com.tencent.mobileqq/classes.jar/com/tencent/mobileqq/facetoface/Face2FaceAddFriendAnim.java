package com.tencent.mobileqq.facetoface;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Face2FaceAddFriendAnim
{
  public static byte[] a;
  double jdField_a_of_type_Double = 0.0D;
  float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int = 1;
  public Context a;
  RotateAnimation jdField_a_of_type_AndroidViewAnimationRotateAnimation;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public QQAppInterface a;
  Face2FaceUserData jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceUserData = null;
  public List<Face2FaceFriendBubbleView> a;
  Map<String, Integer> jdField_a_of_type_JavaUtilMap;
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float = 0.0F;
  int jdField_b_of_type_Int = -1;
  List<Integer> jdField_b_of_type_JavaUtilList;
  boolean jdField_b_of_type_Boolean = false;
  public int c;
  List<Integer> c;
  public int d;
  List<Integer> d;
  int jdField_e_of_type_Int = 0;
  List<Integer> jdField_e_of_type_JavaUtilList;
  int jdField_f_of_type_Int = -1;
  List<Integer> jdField_f_of_type_JavaUtilList = Arrays.asList(new Integer[] { Integer.valueOf(2131367227), Integer.valueOf(2131367229), Integer.valueOf(2131367230), Integer.valueOf(2131367231), Integer.valueOf(2131367232), Integer.valueOf(2131367233), Integer.valueOf(2131367234), Integer.valueOf(2131367235), Integer.valueOf(2131367236), Integer.valueOf(2131367228) });
  int g;
  int h = 0;
  int i = 0;
  int j = 0;
  int k = 0;
  
  static
  {
    jdField_a_of_type_ArrayOfByte = new byte[0];
  }
  
  public Face2FaceAddFriendAnim(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    double d1 = Math.random();
    double d2 = paramInt2 - paramInt1 + 1;
    Double.isNaN(d2);
    double d3 = paramInt1;
    Double.isNaN(d3);
    return (int)(d1 * d2 + d3);
  }
  
  public float a(int paramInt1, int paramInt2)
  {
    double d1 = Math.random();
    double d2 = paramInt2 - paramInt1;
    Double.isNaN(d2);
    double d3 = paramInt1;
    Double.isNaN(d3);
    return (float)(d1 * d2 + d3);
  }
  
  public Face2FaceFriendBubbleView a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      return (Face2FaceFriendBubbleView)this.jdField_a_of_type_JavaUtilList.get(((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramString)).intValue());
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_d_of_type_JavaUtilList.clear();
    this.jdField_e_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(int paramInt)
  {
    Face2FaceFriendBubbleView localFace2FaceFriendBubbleView = (Face2FaceFriendBubbleView)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if ((localFace2FaceFriendBubbleView != null) && (localFace2FaceFriendBubbleView.c() != null) && (this.jdField_a_of_type_JavaUtilMap.containsKey(localFace2FaceFriendBubbleView.c())))
    {
      this.jdField_a_of_type_JavaUtilMap.remove(localFace2FaceFriendBubbleView.c());
      localFace2FaceFriendBubbleView.setVisibility(4);
      localFace2FaceFriendBubbleView.setStatusWithoutAnimation(1);
      localFace2FaceFriendBubbleView.setClickable(false);
      if (QLog.isColorLevel())
      {
        String str = Face2FaceAddFriendActivity.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("removeShowedFriendMap uinToHoleIndex remove( ");
        localStringBuilder.append(localFace2FaceFriendBubbleView.c());
        localStringBuilder.append(", ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" )");
        QLog.d(str, 2, localStringBuilder.toString());
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    long l = 750L;
    if (paramInt == 1)
    {
      this.jdField_b_of_type_Float = a(45, 180);
      if (a(0, 1) < 0.5D) {
        this.jdField_b_of_type_Float *= -1.0F;
      }
      l = a(800, 1500);
    }
    RotateAnimation localRotateAnimation = new RotateAnimation(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(l);
    localRotateAnimation.setFillAfter(true);
    localRotateAnimation.setInterpolator(new Face2FaceAddFriendAnim.EaseInOutElasticInterpolator(this));
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localRotateAnimation);
    localRotateAnimation.setAnimationListener(new Face2FaceAddFriendAnim.3(this, paramInt, paramBoolean));
  }
  
  public void a(QQAppInterface paramQQAppInterface, View paramView, int paramInt, String paramString)
  {
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    if (localContext == null) {
      return;
    }
    this.jdField_c_of_type_Int = localContext.getResources().getDisplayMetrics().widthPixels;
    this.jdField_d_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().heightPixels;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365046));
    if ((paramInt == 1) && (!TextUtils.isEmpty(paramString)))
    {
      ((ImageView)paramView.findViewById(2131365047)).setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840096);
      paramString = paramQQAppInterface.getTroopFaceBitmap(paramString, (byte)3, false, false);
      paramQQAppInterface = paramString;
      if (paramString == null) {
        paramQQAppInterface = ImageUtil.d();
      }
      paramString = (ImageView)paramView.findViewById(2131379202);
      paramString.setImageBitmap(paramQQAppInterface);
      paramString.setVisibility(0);
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramInt = 0;
    while (paramInt < 10)
    {
      paramQQAppInterface = (Face2FaceFriendBubbleView)paramView.findViewById(((Integer)this.jdField_f_of_type_JavaUtilList.get(paramInt)).intValue());
      paramQQAppInterface.setStatusWithAnimation(1);
      paramQQAppInterface.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_JavaUtilList.add(paramQQAppInterface);
      paramInt += 1;
    }
    this.jdField_b_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_c_of_type_JavaUtilList = new LinkedList();
    this.jdField_c_of_type_JavaUtilList.addAll(Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9) }));
    this.jdField_d_of_type_JavaUtilList = new LinkedList();
    this.jdField_d_of_type_JavaUtilList.addAll(Arrays.asList(new Integer[] { Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7) }));
    this.jdField_e_of_type_JavaUtilList = new LinkedList();
    this.jdField_e_of_type_JavaUtilList.addAll(Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(8), Integer.valueOf(9) }));
  }
  
  public void a(Face2FaceUserData paramFace2FaceUserData, boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    if ((paramFace2FaceUserData != null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      localObject1 = paramFace2FaceUserData.e;
      if ((paramFace2FaceUserData instanceof Face2FaceGroupProfile))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramFace2FaceUserData.e);
        ((StringBuilder)localObject1).append("_");
        ((StringBuilder)localObject1).append(((Face2FaceGroupProfile)paramFace2FaceUserData).b);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      int m;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(localObject1)) {
        m = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(localObject1)).intValue();
      } else {
        m = -1;
      }
      if (m == -1)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = Face2FaceAddFriendActivity.a;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("startFriendDisappearAnimation disappear uin ");
          ((StringBuilder)localObject2).append(paramFace2FaceUserData.e.substring(0, 4));
          ((StringBuilder)localObject2).append(" is not in the hole");
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
          localObject1 = Face2FaceAddFriendActivity.b;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("startFriendDisappearAnimation disappear uin ");
          ((StringBuilder)localObject2).append(paramFace2FaceUserData.e.substring(0, 4));
          ((StringBuilder)localObject2).append(" is not in the hole");
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
          this.h += 1;
        }
        return;
      }
      localObject1 = (Face2FaceFriendBubbleView)this.jdField_a_of_type_JavaUtilList.get(m);
      if (paramBoolean)
      {
        localObject2 = new ScaleAnimation(1.0F, 0.4F, 1.0F, 0.4F, 1, 0.5F, 1, 0.5F);
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
        AnimationSet localAnimationSet = new AnimationSet(true);
        localAnimationSet.addAnimation((Animation)localObject2);
        localAnimationSet.addAnimation(localAlphaAnimation);
        localAnimationSet.setDuration(1000L);
        localAnimationSet.setFillAfter(true);
        localAnimationSet.setInterpolator(new Face2FaceAddFriendAnim.EaseOutQuartInterpolator(this));
        localAnimationSet.setAnimationListener(new Face2FaceAddFriendAnim.2(this));
        if (localObject1 != null) {
          ((Face2FaceFriendBubbleView)localObject1).startAnimation(localAnimationSet);
        }
      }
      if (localObject1 != null)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = Face2FaceAddFriendActivity.a;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("startFriendDisappearAnimation disappear uin ");
          ((StringBuilder)localObject2).append(paramFace2FaceUserData.e.substring(0, 4));
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
        if (this.jdField_b_of_type_JavaUtilList.contains(Integer.valueOf(m))) {
          this.jdField_b_of_type_JavaUtilList.remove(Integer.valueOf(m));
        }
        a(m);
        ((Face2FaceAddFriendActivity)this.jdField_a_of_type_AndroidContentContext).c(paramFace2FaceUserData);
        this.jdField_c_of_type_JavaUtilList.add(Integer.valueOf(m));
        if ((m >= 2) && (m <= 7))
        {
          this.jdField_d_of_type_JavaUtilList.add(Integer.valueOf(m));
          return;
        }
        if (((m >= 0) && (m <= 1)) || ((m >= 8) && (m <= 9))) {
          this.jdField_e_of_type_JavaUtilList.add(Integer.valueOf(m));
        }
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = Face2FaceAddFriendActivity.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("startFriendDisappearAnimation disappear data is ");
      ((StringBuilder)localObject2).append(paramFace2FaceUserData);
      ((StringBuilder)localObject2).append(" mContext ");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_AndroidContentContext);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  public void a(Face2FaceUserData paramFace2FaceUserData, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject1;
    label235:
    Object localObject2;
    if ((paramFace2FaceUserData != null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      if (this.jdField_c_of_type_JavaUtilList.size() == 1) {
        m = ((Integer)this.jdField_c_of_type_JavaUtilList.get(0)).intValue();
      }
      for (;;)
      {
        i1 = m;
        break label235;
        if (this.jdField_c_of_type_JavaUtilList.size() <= 1) {
          break;
        }
        if (this.jdField_d_of_type_JavaUtilList.size() == 1)
        {
          m = ((Integer)this.jdField_d_of_type_JavaUtilList.get(0)).intValue();
        }
        else if (this.jdField_d_of_type_JavaUtilList.size() > 1)
        {
          localObject1 = this.jdField_d_of_type_JavaUtilList;
          m = ((Integer)((List)localObject1).get(a(0, ((List)localObject1).size() - 1))).intValue();
        }
        else if (this.jdField_e_of_type_JavaUtilList.size() == 0)
        {
          m = ((Integer)this.jdField_e_of_type_JavaUtilList.get(0)).intValue();
        }
        else
        {
          if (this.jdField_e_of_type_JavaUtilList.size() <= 1) {
            break;
          }
          localObject1 = this.jdField_e_of_type_JavaUtilList;
          m = ((Integer)((List)localObject1).get(a(0, ((List)localObject1).size() - 1))).intValue();
        }
      }
      int i1 = -1;
      if (i1 == -1) {
        return;
      }
      localObject1 = (Face2FaceFriendBubbleView)this.jdField_a_of_type_JavaUtilList.get(i1);
      this.g = i1;
      if (localObject1 == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceUserData = paramFace2FaceUserData;
      ((Face2FaceFriendBubbleView)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFace2FaceUserData);
      ((Face2FaceFriendBubbleView)localObject1).setVisibility(0);
      ((Face2FaceFriendBubbleView)localObject1).setClickable(true);
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel()) {
        if (!TextUtils.isEmpty(paramFace2FaceUserData.e))
        {
          localObject2 = Face2FaceAddFriendActivity.a;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("startFriendInAnimation get ( currentUin= ");
          localStringBuilder.append(paramFace2FaceUserData.e.substring(0, 4));
          localStringBuilder.append(" , index = ");
          localStringBuilder.append(i1);
          localStringBuilder.append(" )");
          QLog.d((String)localObject2, 2, localStringBuilder.toString());
        }
        else
        {
          QLog.d(Face2FaceAddFriendActivity.a, 2, "startFriendInAnimation get  currentUin= null");
        }
      }
      this.jdField_a_of_type_Int = 1;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_b_of_type_Int = -1;
      localObject2 = new int[2];
      this.jdField_a_of_type_AndroidWidgetImageView.getLocationOnScreen((int[])localObject2);
      int i5 = localObject2[0] + (this.jdField_a_of_type_AndroidWidgetImageView.getWidth() >> 1);
      int i7 = localObject2[1] + (this.jdField_a_of_type_AndroidWidgetImageView.getHeight() >> 1);
      localObject2 = new int[2];
      ((Face2FaceFriendBubbleView)localObject1).getLocationOnScreen((int[])localObject2);
      int i6 = localObject2[0] + (((Face2FaceFriendBubbleView)localObject1).getWidth() >> 1);
      int i8 = localObject2[1] + (((Face2FaceFriendBubbleView)localObject1).getHeight() >> 1);
      int i3 = Math.abs(i5 - i6);
      int i4 = Math.abs(i7 - i8);
      double d1 = i3;
      double d2 = i4;
      Double.isNaN(d1);
      Double.isNaN(d2);
      this.jdField_a_of_type_Double = (d1 / d2);
      int m = ((Face2FaceFriendBubbleView)localObject1).getWidth();
      if (i3 == 0)
      {
        m = (((Face2FaceFriendBubbleView)localObject1).getHeight() >> 1) + i7;
        if (i8 > i7) {
          m = this.jdField_d_of_type_Int - i7 + (((Face2FaceFriendBubbleView)localObject1).getHeight() >> 1);
        }
      }
      else
      {
        m = ((m >> 1) + i5) * i4 / i3;
      }
      int n = localObject2[0] + ((Face2FaceFriendBubbleView)localObject1).getWidth();
      int i2 = m - i4;
      if (i8 > i7) {
        this.jdField_a_of_type_Int = 2;
      }
      if (i6 > i5)
      {
        n = this.jdField_c_of_type_Int - localObject2[0];
        if (i8 < i7) {
          this.jdField_a_of_type_Int = 5;
        } else {
          this.jdField_a_of_type_Int = 6;
        }
      }
      if ((m - i7 < ((Face2FaceFriendBubbleView)localObject1).getHeight() >> 1) && (m - (this.jdField_d_of_type_Int - i7) < ((Face2FaceFriendBubbleView)localObject1).getHeight() >> 1))
      {
        m = n;
        n = i2;
      }
      else
      {
        if (i8 < i7)
        {
          n = (((Face2FaceFriendBubbleView)localObject1).getHeight() >> 1) + i7;
          m = localObject2[1] + ((Face2FaceFriendBubbleView)localObject1).getHeight();
          if (i6 < i5) {
            this.jdField_a_of_type_Int = 3;
          } else {
            this.jdField_a_of_type_Int = 4;
          }
        }
        for (;;)
        {
          break;
          n = m;
          m = i2;
          if (i8 <= i7) {
            break;
          }
          n = this.jdField_d_of_type_Int - i7 + (((Face2FaceFriendBubbleView)localObject1).getHeight() >> 1);
          m = this.jdField_d_of_type_Int - localObject2[1];
          if (i6 < i5) {
            this.jdField_a_of_type_Int = 7;
          } else {
            this.jdField_a_of_type_Int = 8;
          }
        }
        i2 = n * i3 / i4 - i3;
        n = m;
        m = i2;
      }
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        break;
      case 8: 
        this.jdField_b_of_type_Int = 1;
        this.jdField_b_of_type_Boolean = true;
        break;
      case 7: 
        m = -m;
        this.jdField_b_of_type_Int = -1;
        this.jdField_b_of_type_Boolean = true;
        break;
      case 6: 
        this.jdField_b_of_type_Int = 1;
        this.jdField_b_of_type_Boolean = true;
        break;
      case 5: 
        n = -n;
        this.jdField_b_of_type_Int = 1;
        this.jdField_b_of_type_Boolean = false;
        break;
      case 4: 
        n = -n;
        this.jdField_b_of_type_Int = 1;
        this.jdField_b_of_type_Boolean = false;
        break;
      case 3: 
        m = -m;
        n = -n;
        this.jdField_b_of_type_Int = -1;
        this.jdField_b_of_type_Boolean = false;
        break;
      case 2: 
        m = -m;
        this.jdField_b_of_type_Int = -1;
        this.jdField_b_of_type_Boolean = true;
        break;
      case 1: 
        m = -m;
        n = -n;
        this.jdField_b_of_type_Int = -1;
        this.jdField_b_of_type_Boolean = false;
      }
      d1 = this.jdField_a_of_type_Double;
      boolean bool = this.jdField_b_of_type_Boolean;
      localObject2 = new TranslateAnimation(m, 0.0F, n, 0.0F);
      ((TranslateAnimation)localObject2).setDuration(400L);
      ((TranslateAnimation)localObject2).setInterpolator(new Face2FaceAddFriendAnim.EaseOutQuartInterpolator(this));
      ((TranslateAnimation)localObject2).setAnimationListener(new Face2FaceAddFriendAnim.1(this, paramFace2FaceUserData, i1, d1, bool, paramBoolean3, paramFace2FaceUserData, paramBoolean1, paramBoolean2, (Face2FaceFriendBubbleView)localObject1, paramInt));
      ((Face2FaceFriendBubbleView)localObject1).startAnimation((Animation)localObject2);
      localObject1 = paramFace2FaceUserData.e;
      if ((paramFace2FaceUserData instanceof Face2FaceGroupProfile))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramFace2FaceUserData.e);
        ((StringBuilder)localObject1).append("_");
        ((StringBuilder)localObject1).append(((Face2FaceGroupProfile)paramFace2FaceUserData).b);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      this.jdField_a_of_type_JavaUtilMap.put(localObject1, Integer.valueOf(i1));
      ((Face2FaceAddFriendActivity)this.jdField_a_of_type_AndroidContentContext).a(paramFace2FaceUserData, paramBoolean1, paramBoolean2);
      if (QLog.isColorLevel())
      {
        localObject2 = Face2FaceAddFriendActivity.b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("uinToHoleIndex put identify=");
        localStringBuilder.append((String)localObject1);
        QLog.d((String)localObject2, 2, localStringBuilder.toString());
      }
      this.jdField_c_of_type_JavaUtilList.remove(Integer.valueOf(i1));
      if (this.jdField_d_of_type_JavaUtilList.contains(Integer.valueOf(i1))) {
        this.jdField_d_of_type_JavaUtilList.remove(Integer.valueOf(i1));
      } else if (this.jdField_e_of_type_JavaUtilList.contains(Integer.valueOf(i1))) {
        this.jdField_e_of_type_JavaUtilList.remove(Integer.valueOf(i1));
      }
      if (QLog.isColorLevel())
      {
        localObject1 = Face2FaceAddFriendActivity.a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("startFriendInAnimation currentUIn= ");
        ((StringBuilder)localObject2).append(paramFace2FaceUserData.e.substring(0, 4));
        ((StringBuilder)localObject2).append(" startAnimation OK");
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = Face2FaceAddFriendActivity.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("startFriendInAnimation  data is ");
      ((StringBuilder)localObject2).append(paramFace2FaceUserData);
      ((StringBuilder)localObject2).append(" mContext ");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_AndroidContentContext);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) && (!this.jdField_b_of_type_JavaUtilList.contains(paramString))) {
      this.jdField_b_of_type_JavaUtilList.add(this.jdField_a_of_type_JavaUtilMap.get(paramString));
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    long l = a(800, 1200);
    float f1 = this.jdField_b_of_type_Float;
    int m = (int)a(5, 12);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Float = (this.jdField_a_of_type_Float - m);
    }
    else
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Float = (this.jdField_a_of_type_Float + m);
    }
    float f2 = this.jdField_b_of_type_Float;
    if (f1 == f2)
    {
      float f3 = this.jdField_a_of_type_Float;
      if (f2 > f3) {
        this.jdField_b_of_type_Float = (f3 - m);
      } else {
        this.jdField_b_of_type_Float = (f3 + m);
      }
    }
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(f1, this.jdField_b_of_type_Float, 1, 0.5F, 1, 0.5F);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setDuration(l);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setInterpolator(new Face2FaceAddFriendAnim.EaseInOutElasticInterpolator(this));
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationRotateAnimation);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setAnimationListener(new Face2FaceAddFriendAnim.4(this));
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      this.jdField_b_of_type_JavaUtilList.remove(this.jdField_a_of_type_JavaUtilMap.get(paramString));
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddFriendActivity", 2, "stopCompassShakeAnimation");
    }
    Object localObject = this.jdField_a_of_type_AndroidViewAnimationRotateAnimation;
    if (localObject != null) {
      ((RotateAnimation)localObject).cancel();
    }
    localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).clearAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendAnim
 * JD-Core Version:    0.7.0.1
 */