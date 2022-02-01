package com.tencent.mobileqq.redtouch;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.qqsettingme.api.IRedTouchTextViewApi;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class RedTouchTextView
  extends TextView
{
  private int jdField_a_of_type_Int = 0;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  public Drawable a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private BusinessInfoCheckUpdate.AppInfo jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo;
  public String a;
  private List<BusinessInfoCheckUpdate.RedTypeInfo> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  public Drawable b;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean = false;
  private int c;
  public Drawable c;
  private int d = 0;
  private int e = 0;
  private int f;
  private int g = 100;
  
  public RedTouchTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RedTouchTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    int i = this.jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = i;
    this.jdField_c_of_type_Int = i;
    this.d = a(9);
    this.e = a(9);
    this.f = a(4);
  }
  
  private int a()
  {
    String str = getText().toString();
    TextPaint localTextPaint = getPaint();
    localTextPaint.getTextBounds(str, 0, str.length(), this.jdField_a_of_type_AndroidGraphicsRect);
    float f1 = Layout.getDesiredWidth(str, localTextPaint);
    return (int)(getWidth() - f1 - getPaddingLeft() - a(0) - a(0));
  }
  
  private int a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if (a(paramRedTypeInfo, this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo))
    {
      int j;
      int i;
      if (this.jdField_a_of_type_Boolean)
      {
        j = this.jdField_b_of_type_Int;
        i = this.f;
      }
      else
      {
        j = this.jdField_a_of_type_Int;
        i = this.f;
      }
      return j + i;
    }
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_b_of_type_Int;
    }
    return this.jdField_a_of_type_Int;
  }
  
  private int a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, boolean paramBoolean)
  {
    int i = 0;
    if (paramRedTypeInfo == null) {
      return 0;
    }
    int k = paramRedTypeInfo.red_type.get();
    if (k != 0)
    {
      int j;
      if (k != 9)
      {
        if (k != 15)
        {
          if (k != 3)
          {
            if ((k == 4) || (k == 5))
            {
              this.jdField_b_of_type_JavaLangString = paramRedTypeInfo.red_content.get();
              paramRedTypeInfo = new TextPaint();
              paramRedTypeInfo.setTextSize(a(11));
              j = (int)paramRedTypeInfo.measureText(this.jdField_b_of_type_JavaLangString);
              i = j;
              if (paramBoolean) {
                i = j + a(6) * 2;
              }
            }
          }
          else {
            i = a(paramRedTypeInfo);
          }
        }
        else {
          i = a(paramRedTypeInfo);
        }
      }
      else
      {
        paramRedTypeInfo = paramRedTypeInfo.red_content.get();
        try
        {
          j = Integer.valueOf(paramRedTypeInfo).intValue();
          i = j;
        }
        catch (Exception paramRedTypeInfo)
        {
          QLog.e("RedTouchTextView", 1, "getRedTypeInfoWidth exception e = ", paramRedTypeInfo);
        }
      }
    }
    else
    {
      i = this.d;
    }
    if (QLog.isColorLevel())
    {
      paramRedTypeInfo = new StringBuilder();
      paramRedTypeInfo.append("getRedTypeInfoWidth type = ");
      paramRedTypeInfo.append(k);
      paramRedTypeInfo.append(",width = ");
      paramRedTypeInfo.append(i);
      QLog.d("RedTouchTextView", 2, paramRedTypeInfo.toString());
    }
    return i;
  }
  
  private int a(List<BusinessInfoCheckUpdate.RedTypeInfo> paramList)
  {
    int k = 0;
    int j = 0;
    boolean bool;
    if ((paramList != null) && (paramList.size() <= 2)) {
      bool = true;
    } else {
      bool = false;
    }
    int i = k;
    if (paramList != null)
    {
      i = k;
      if (paramList.size() > 0)
      {
        i = 0;
        while (j < paramList.size())
        {
          i += a((BusinessInfoCheckUpdate.RedTypeInfo)paramList.get(j), bool);
          j += 1;
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getWidthByRedInfoList size = ");
          localStringBuilder.append(paramList.size());
          QLog.d("RedTouchTextView", 2, localStringBuilder.toString());
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("getWidthByRedInfoList width = ");
      paramList.append(i);
      QLog.d("RedTouchTextView", 2, paramList.toString());
    }
    return i;
  }
  
  private int a(List<BusinessInfoCheckUpdate.RedTypeInfo> paramList, int paramInt)
  {
    int k = 0;
    int i = 0;
    boolean bool;
    if ((paramList != null) && (paramList.size() <= 2)) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder;
    if ((paramList != null) && ((paramInt > paramList.size() - 1) || (paramInt < 0)))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getWidthByRedInfoListByPosition error, size = ");
        localStringBuilder.append(paramList.size());
        localStringBuilder.append(" position = ");
        localStringBuilder.append(paramInt);
        QLog.d("RedTouchTextView", 2, localStringBuilder.toString());
      }
      return 0;
    }
    int j = k;
    if (paramList != null)
    {
      j = k;
      if (paramList.size() > 0)
      {
        j = paramList.size() - 1;
        while (j >= paramInt)
        {
          i += a((BusinessInfoCheckUpdate.RedTypeInfo)paramList.get(j), bool);
          j -= 1;
        }
        j = i;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getWidthByRedInfoListByPosition size = ");
          localStringBuilder.append(paramList.size());
          QLog.d("RedTouchTextView", 2, localStringBuilder.toString());
          j = i;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("getWidthByRedInfoListByPosition width = ");
      paramList.append(j);
      QLog.d("RedTouchTextView", 2, paramList.toString());
    }
    return j;
  }
  
  public static List<BusinessInfoCheckUpdate.RedTypeInfo> a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {
      return null;
    }
    paramAppInfo = (BusinessInfoCheckUpdate.RedDisplayInfo)paramAppInfo.red_display_info.get();
    if (paramAppInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedTouchTextView", 2, "getRedTypeInfoFromAppInfo diplayInfo = null");
      }
      return null;
    }
    paramAppInfo = paramAppInfo.red_type_info.get();
    if (paramAppInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedTouchTextView", 2, "getRedTypeInfoFromAppInfo redInfos = null");
      }
      return null;
    }
    if (paramAppInfo.size() < 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedTouchTextView", 2, "getRedTypeInfoFromAppInfo redInfos.size < 2");
      }
      return null;
    }
    return paramAppInfo;
  }
  
  private void a(Canvas paramCanvas)
  {
    Object localObject1;
    int i;
    Object localObject2;
    int j;
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedTouchTextView", 2, "drawRed start draw");
      }
      localObject1 = this.jdField_a_of_type_JavaUtilList;
      if ((localObject1 != null) && (((List)localObject1).size() >= 1))
      {
        i = this.jdField_a_of_type_JavaUtilList.size() - 1;
        if (i < 0) {
          break label230;
        }
        localObject2 = (BusinessInfoCheckUpdate.RedTypeInfo)this.jdField_a_of_type_JavaUtilList.get(i);
        j = ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.get();
      }
    }
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_desc.get())) {
          localObject1 = new JSONObject();
        } else {
          localObject1 = new JSONObject(((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_desc.get());
        }
      }
      catch (Exception localException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("drawRed Exception ");
        ((StringBuilder)localObject2).append(localException);
        QLog.e("RedTouchTextView", 1, ((StringBuilder)localObject2).toString());
      }
      a(paramCanvas, i, j);
      c(paramCanvas, i, (BusinessInfoCheckUpdate.RedTypeInfo)localObject2, j, (JSONObject)localObject1);
      a(paramCanvas, i, (BusinessInfoCheckUpdate.RedTypeInfo)localObject2, j, (JSONObject)localObject1);
      b(paramCanvas, i, (BusinessInfoCheckUpdate.RedTypeInfo)localObject2, j, (JSONObject)localObject1);
      i -= 1;
      break;
      QLog.e("RedTouchTextView", 1, "drawRed showRedInfo = null");
      label230:
      return;
    }
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedTouchTextView", 2, "draw redtouchpoint");
      }
      paramInt1 = getWidth() - a(this.jdField_a_of_type_JavaUtilList, paramInt1) - a(0);
      paramInt2 = getHeight() / 2 - this.d / 2;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130850766);
      Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      int i = this.d;
      localDrawable.setBounds(paramInt1, paramInt2, paramInt1 + i, i + paramInt2);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
  }
  
  private void a(Canvas paramCanvas, int paramInt1, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, int paramInt2, JSONObject paramJSONObject)
  {
    if (paramInt2 == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedTouchTextView", 2, "draw redtouch img");
      }
      int j = getWidth() - a(this.jdField_a_of_type_JavaUtilList, paramInt1) - a(0);
      int k = getHeight() / 2 - this.jdField_c_of_type_Int / 2;
      if (paramJSONObject.has("av")) {
        paramInt1 = paramJSONObject.getInt("av");
      } else {
        paramInt1 = 0;
      }
      if (paramJSONObject.has("dot")) {
        paramInt2 = paramJSONObject.getInt("dot");
      } else {
        paramInt2 = 0;
      }
      int i;
      if (paramJSONObject.has("st")) {
        i = Integer.valueOf(paramJSONObject.getString("st")).intValue();
      } else {
        i = 0;
      }
      paramRedTypeInfo = paramRedTypeInfo.red_content.get();
      if (i == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RedTouchTextView", 2, "draw redtouch img gif ");
        }
        paramJSONObject = getResources().getDrawable(2130840321);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = paramJSONObject;
        localURLDrawableOptions.mFailedDrawable = paramJSONObject;
        localURLDrawableOptions.mRequestWidth = this.jdField_b_of_type_Int;
        localURLDrawableOptions.mRequestHeight = this.jdField_c_of_type_Int;
        localURLDrawableOptions.mPlayGifImage = true;
        paramRedTypeInfo = URLDrawable.getDrawable(paramRedTypeInfo, localURLDrawableOptions);
        paramRedTypeInfo.setCallback(this);
        paramRedTypeInfo.draw(paramCanvas);
        paramRedTypeInfo = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
        if (paramRedTypeInfo != null)
        {
          paramRedTypeInfo.setBounds(j, k, this.jdField_b_of_type_Int + j, this.jdField_c_of_type_Int + k);
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        }
      }
      else if (i == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RedTouchTextView", 2, "draw redtouch img static ");
        }
        paramJSONObject = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
        if (paramJSONObject != null)
        {
          paramJSONObject.setBounds(j, k, this.jdField_b_of_type_Int + j, this.jdField_c_of_type_Int + k);
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        }
        if (paramInt2 == 1)
        {
          paramJSONObject = getResources().getDrawable(2130850766);
          paramJSONObject.setBounds(getWidth() - a(0) - a(9), k - a(4), getWidth() - a(0), k + a(5));
          paramJSONObject.draw(paramCanvas);
        }
        if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) && (!TextUtils.isEmpty(paramRedTypeInfo))) {
          ThreadManager.post(new RedTouchTextView.1(this, paramRedTypeInfo, paramInt1), 8, null, true);
        }
      }
    }
  }
  
  private static void a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    try
    {
      JSONObject localJSONObject;
      if (TextUtils.isEmpty(paramRedTypeInfo.red_desc.get())) {
        localJSONObject = new JSONObject();
      } else {
        localJSONObject = new JSONObject(paramRedTypeInfo.red_desc.get());
      }
      if (localJSONObject.has("dot")) {
        localJSONObject.put("dot", 0);
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setImageRedNotShowRedPoint ,path = ");
        localStringBuilder.append(paramAppInfo.path.get());
        QLog.d("RedTouchTextView", 2, localStringBuilder.toString());
      }
      paramRedTypeInfo.red_desc.set(localJSONObject.toString());
      return;
    }
    catch (Exception paramRedTypeInfo)
    {
      paramAppInfo = new StringBuilder();
      paramAppInfo.append("setImageRedNotShowRedPoint json exception e = ");
      paramAppInfo.append(paramRedTypeInfo.getMessage());
      QLog.e("RedTouchTextView", 1, paramAppInfo.toString());
    }
  }
  
  private boolean a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo;
    if (localObject == null)
    {
      QLog.d("RedTouchTextView", 1, "isSupportRedTouch appinfo = null");
      return false;
    }
    if (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() != 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isSupportRedTouch inewflag = 0, path = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.path);
      QLog.d("RedTouchTextView", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    localObject = (BusinessInfoCheckUpdate.RedDisplayInfo)this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.red_display_info.get();
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getRedTypeInfoFromAppInfo diplayInfo = null, path = ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.path.get());
        QLog.d("RedTouchTextView", 2, ((StringBuilder)localObject).toString());
      }
      return false;
    }
    localObject = ((BusinessInfoCheckUpdate.RedDisplayInfo)localObject).red_type_info.get();
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getRedTypeInfoFromAppInfo redInfos = null, path = ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.path.get());
        QLog.d("RedTouchTextView", 2, ((StringBuilder)localObject).toString());
      }
      return false;
    }
    if (((List)localObject).size() < 2)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getRedTypeInfoFromAppInfo redInfos.size < 2, path = ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.path.get());
        QLog.d("RedTouchTextView", 2, ((StringBuilder)localObject).toString());
      }
      return false;
    }
    localObject = new ArrayList((Collection)localObject);
    int j = a((List)localObject);
    Iterator localIterator = ((List)localObject).iterator();
    int i = 0;
    while (localIterator.hasNext()) {
      if (((BusinessInfoCheckUpdate.RedTypeInfo)localIterator.next()).red_type.get() != 9) {
        i += 1;
      }
    }
    if (i == 0)
    {
      QLog.e("RedTouchTextView", 1, "isSupportRedTouch notSpaceInfoCount = 0");
      return false;
    }
    if (a((List)localObject, j, i)) {
      return false;
    }
    setShowRedInfo((List)localObject);
    return true;
  }
  
  public static boolean a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((paramRedTypeInfo != null) && (paramRedTypeInfo.red_type.get() == 3)) {
      return c(paramRedTypeInfo, paramAppInfo);
    }
    return false;
  }
  
  private boolean a(List<BusinessInfoCheckUpdate.RedTypeInfo> paramList, int paramInt1, int paramInt2)
  {
    int i1 = a();
    int i = paramInt1;
    for (;;)
    {
      int m = 0;
      if ((i <= i1) || (paramInt2 <= 1)) {
        break;
      }
      int n = paramList.size();
      int k = 0;
      int j;
      for (;;)
      {
        i = m;
        j = n;
        paramInt1 = paramInt2;
        if (k >= n) {
          break;
        }
        if (((BusinessInfoCheckUpdate.RedTypeInfo)paramList.get(k)).red_type.get() != 9)
        {
          paramList.remove(k);
          paramInt1 = paramInt2 - 1;
          j = n - 1;
          i = m;
          break;
        }
        k += 1;
      }
      while (i < j - 1)
      {
        if ((((BusinessInfoCheckUpdate.RedTypeInfo)paramList.get(i)).red_type.get() == 9) && (((BusinessInfoCheckUpdate.RedTypeInfo)paramList.get(i + 1)).red_type.get() == 9))
        {
          paramList.remove(i);
          break;
        }
        i += 1;
      }
      i = a(paramList);
      paramInt2 = paramInt1;
    }
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo;
    if ((i > i1) && (paramInt2 == 1))
    {
      paramInt1 = 0;
      while (paramInt1 < paramList.size())
      {
        localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)paramList.get(paramInt1);
        if ((localRedTypeInfo.red_type.get() == 3) && (a(localRedTypeInfo, this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo))) {
          setImageRedNotShowRedPoint(localRedTypeInfo, this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
        }
        paramInt1 += 1;
      }
    }
    if ((a(paramList) > i1) && (paramInt2 == 1))
    {
      paramInt1 = 0;
      while (paramInt1 < paramList.size())
      {
        localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)paramList.get(paramInt1);
        if ((localRedTypeInfo.red_type.get() != 9) && (localRedTypeInfo.red_type.get() != 0))
        {
          localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
          localRedTypeInfo.red_type.set(0);
          paramList.set(paramInt1, localRedTypeInfo);
        }
        paramInt1 += 1;
      }
    }
    return a(paramList) > i1;
  }
  
  private boolean a(List<BusinessInfoCheckUpdate.RedTypeInfo> paramList1, List<BusinessInfoCheckUpdate.RedTypeInfo> paramList2)
  {
    if (paramList1 != null)
    {
      if (paramList2 == null) {
        return false;
      }
      if ((paramList1.size() == paramList2.size()) && (paramList1.size() != 0))
      {
        int i = 0;
        while (i < paramList1.size())
        {
          BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo1 = (BusinessInfoCheckUpdate.RedTypeInfo)paramList1.get(i);
          BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo2 = (BusinessInfoCheckUpdate.RedTypeInfo)paramList2.get(i);
          if (localRedTypeInfo1.red_type.get() != localRedTypeInfo2.red_type.get()) {
            return false;
          }
          if (!localRedTypeInfo1.red_content.get().equals(localRedTypeInfo2.red_content.get())) {
            return false;
          }
          if (!localRedTypeInfo1.red_desc.get().equals(localRedTypeInfo2.red_desc.get())) {
            return false;
          }
          if (localRedTypeInfo1.red_priority.get() != localRedTypeInfo2.red_priority.get()) {
            return false;
          }
          i += 1;
        }
        return true;
      }
    }
    return false;
  }
  
  private void b(Canvas paramCanvas, int paramInt1, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, int paramInt2, JSONObject paramJSONObject)
  {
    if (paramInt2 == 15)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedTouchTextView", 2, "draw redtouch diffimg");
      }
      paramInt2 = getWidth() - a(this.jdField_a_of_type_JavaUtilList, paramInt1) - a(0);
      int i = getHeight() / 2 - this.jdField_c_of_type_Int / 2;
      if (paramJSONObject.has("av")) {
        paramJSONObject.getInt("av");
      }
      if (paramJSONObject.has("dot")) {
        paramInt1 = paramJSONObject.getInt("dot");
      } else {
        paramInt1 = 0;
      }
      if (paramInt1 == 1)
      {
        paramRedTypeInfo = getResources().getDrawable(2130850766);
        paramRedTypeInfo.setBounds(getWidth() - a(0) - a(9), i - a(4), getWidth() - a(0), a(5) + i);
        paramRedTypeInfo.draw(paramCanvas);
      }
      paramRedTypeInfo = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
      if (paramRedTypeInfo != null)
      {
        paramInt1 = paramRedTypeInfo.getIntrinsicWidth() / 2;
        this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.jdField_b_of_type_Int + paramInt2 - a(paramInt1), i, paramInt2 + this.jdField_b_of_type_Int, this.jdField_c_of_type_Int + i);
        this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setCallback(this);
        this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
    }
  }
  
  public static boolean b(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((paramRedTypeInfo != null) && (paramRedTypeInfo.red_type.get() == 15)) {
      return c(paramRedTypeInfo, paramAppInfo);
    }
    return false;
  }
  
  private void c(Canvas paramCanvas, int paramInt1, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, int paramInt2, JSONObject paramJSONObject)
  {
    if ((paramInt2 == 4) || (paramInt2 == 5))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedTouchTextView", 2, "draw redtouch text");
      }
      paramInt2 = -1;
      if (paramJSONObject.has("cr")) {
        paramInt2 = a(paramJSONObject.getString("cr"));
      }
      int i;
      if (paramJSONObject.has("cn")) {
        i = a(paramJSONObject.getString("cn"));
      } else {
        i = 0;
      }
      paramRedTypeInfo = paramRedTypeInfo.red_content.get();
      paramJSONObject = new Paint(1);
      paramJSONObject.setTextSize(a(11));
      paramJSONObject.setTextAlign(Paint.Align.LEFT);
      int k = (int)paramJSONObject.measureText(paramRedTypeInfo);
      Object localObject = paramJSONObject.getFontMetrics();
      int m = (int)(((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).top);
      int j = getWidth() - a(0) - a(this.jdField_a_of_type_JavaUtilList, paramInt1);
      paramInt1 = getHeight() / 2 - m / 2 - a(2);
      Rect localRect = new Rect();
      localRect.left = j;
      localRect.top = paramInt1;
      localRect.right = (k + j);
      if (this.jdField_a_of_type_JavaUtilList.size() <= 2) {
        localRect.right += a(6) * 2;
      }
      localRect.bottom = (m + paramInt1 + a(2) * 2);
      float f1 = a(2) + paramInt1;
      float f2 = ((Paint.FontMetrics)localObject).top;
      if (i != 0)
      {
        localObject = getResources().getDrawable(2130850770);
        ((Drawable)localObject).getBounds();
        ((Drawable)localObject).setBounds(j, paramInt1, localRect.right, localRect.bottom);
        ((Drawable)localObject).draw(paramCanvas);
      }
      paramJSONObject.setColor(paramInt2);
      paramInt1 = j;
      if (this.jdField_a_of_type_JavaUtilList.size() <= 2) {
        paramInt1 = j + a(6);
      }
      paramCanvas.drawText(paramRedTypeInfo, paramInt1, f1 - f2, paramJSONObject);
    }
  }
  
  private static boolean c(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    boolean bool = false;
    int i;
    try
    {
      if (TextUtils.isEmpty(paramRedTypeInfo.red_desc.get())) {
        paramRedTypeInfo = new JSONObject();
      } else {
        paramRedTypeInfo = new JSONObject(paramRedTypeInfo.red_desc.get());
      }
      if (paramRedTypeInfo.has("dot")) {
        i = paramRedTypeInfo.getInt("dot");
      } else {
        i = 0;
      }
      j = i;
      try
      {
        if (!QLog.isColorLevel()) {
          break label174;
        }
        paramRedTypeInfo = new StringBuilder();
        paramRedTypeInfo.append("isSupportRedTouch had dot = ");
        paramRedTypeInfo.append(i);
        paramRedTypeInfo.append(",path = ");
        paramRedTypeInfo.append(paramAppInfo.path.get());
        QLog.d("RedTouchTextView", 2, paramRedTypeInfo.toString());
        j = i;
      }
      catch (Exception paramRedTypeInfo) {}
      paramAppInfo = new StringBuilder();
    }
    catch (Exception paramRedTypeInfo)
    {
      i = 0;
    }
    paramAppInfo.append("isSupportRedTouch json exception e = ");
    paramAppInfo.append(paramRedTypeInfo.getMessage());
    QLog.e("RedTouchTextView", 1, paramAppInfo.toString());
    int j = i;
    label174:
    if (j == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static void setDiffImageRedNotShowRedPoint(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramRedTypeInfo != null)
    {
      if (paramRedTypeInfo.red_type.get() != 15) {
        return;
      }
      a(paramRedTypeInfo, paramAppInfo);
    }
  }
  
  public static void setImageRedNotShowRedPoint(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramRedTypeInfo != null)
    {
      if (paramRedTypeInfo.red_type.get() != 3) {
        return;
      }
      a(paramRedTypeInfo, paramAppInfo);
    }
  }
  
  protected int a(int paramInt)
  {
    Resources localResources = getResources();
    return (int)TypedValue.applyDimension(1, paramInt, localResources.getDisplayMetrics());
  }
  
  protected int a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals("#"))) {
      return Color.parseColor(paramString);
    }
    return 0;
  }
  
  /* Error */
  protected android.graphics.Bitmap a(java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_1
    //   7: invokevirtual 569	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   10: astore_3
    //   11: new 571	android/graphics/BitmapFactory$Options
    //   14: dup
    //   15: invokespecial 572	android/graphics/BitmapFactory$Options:<init>	()V
    //   18: astore 4
    //   20: new 574	java/io/BufferedInputStream
    //   23: dup
    //   24: new 576	java/io/FileInputStream
    //   27: dup
    //   28: aload_3
    //   29: invokespecial 577	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   32: invokespecial 580	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   35: astore_2
    //   36: aload_2
    //   37: astore_1
    //   38: aload_0
    //   39: getfield 35	com/tencent/mobileqq/redtouch/RedTouchTextView:jdField_a_of_type_Boolean	Z
    //   42: ifne +34 -> 76
    //   45: aload_2
    //   46: astore_1
    //   47: aload 4
    //   49: ldc_w 582
    //   52: invokestatic 588	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   55: checkcast 582	com/tencent/mobileqq/activity/qqsettingme/api/IRedTouchTextViewApi
    //   58: aload_2
    //   59: aload_0
    //   60: getfield 39	com/tencent/mobileqq/redtouch/RedTouchTextView:e	I
    //   63: aload_0
    //   64: getfield 39	com/tencent/mobileqq/redtouch/RedTouchTextView:e	I
    //   67: invokeinterface 592 4 0
    //   72: d2i
    //   73: putfield 595	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   76: aload_2
    //   77: astore_1
    //   78: new 574	java/io/BufferedInputStream
    //   81: dup
    //   82: new 576	java/io/FileInputStream
    //   85: dup
    //   86: aload_3
    //   87: invokespecial 577	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   90: invokespecial 580	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   93: aconst_null
    //   94: aload 4
    //   96: invokestatic 601	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   99: astore_3
    //   100: aload_2
    //   101: invokevirtual 604	java/io/BufferedInputStream:close	()V
    //   104: aload_3
    //   105: areturn
    //   106: astore_1
    //   107: new 162	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   114: astore_2
    //   115: aload_2
    //   116: ldc_w 606
    //   119: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload_2
    //   124: aload_1
    //   125: invokevirtual 391	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   128: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: ldc 149
    //   134: iconst_1
    //   135: aload_2
    //   136: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 272	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   142: aload_3
    //   143: areturn
    //   144: astore_3
    //   145: goto +16 -> 161
    //   148: astore_3
    //   149: goto +110 -> 259
    //   152: astore_2
    //   153: aconst_null
    //   154: astore_1
    //   155: goto +200 -> 355
    //   158: astore_3
    //   159: aconst_null
    //   160: astore_2
    //   161: aload_2
    //   162: astore_1
    //   163: new 162	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   170: astore 4
    //   172: aload_2
    //   173: astore_1
    //   174: aload 4
    //   176: ldc_w 606
    //   179: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload_2
    //   184: astore_1
    //   185: aload 4
    //   187: aload_3
    //   188: invokevirtual 607	java/lang/Error:getMessage	()Ljava/lang/String;
    //   191: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload_2
    //   196: astore_1
    //   197: ldc 149
    //   199: iconst_1
    //   200: aload 4
    //   202: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 272	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   208: aload_2
    //   209: ifnull +45 -> 254
    //   212: aload_2
    //   213: invokevirtual 604	java/io/BufferedInputStream:close	()V
    //   216: aconst_null
    //   217: areturn
    //   218: astore_1
    //   219: new 162	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   226: astore_2
    //   227: aload_2
    //   228: ldc_w 606
    //   231: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload_2
    //   236: aload_1
    //   237: invokevirtual 391	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   240: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: ldc 149
    //   246: iconst_1
    //   247: aload_2
    //   248: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokestatic 272	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   254: aconst_null
    //   255: areturn
    //   256: astore_3
    //   257: aconst_null
    //   258: astore_2
    //   259: aload_2
    //   260: astore_1
    //   261: new 162	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   268: astore 4
    //   270: aload_2
    //   271: astore_1
    //   272: aload 4
    //   274: ldc_w 609
    //   277: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload_2
    //   282: astore_1
    //   283: aload 4
    //   285: aload_3
    //   286: invokevirtual 391	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   289: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload_2
    //   294: astore_1
    //   295: ldc 149
    //   297: iconst_1
    //   298: aload 4
    //   300: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 272	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   306: aload_2
    //   307: ifnull +45 -> 352
    //   310: aload_2
    //   311: invokevirtual 604	java/io/BufferedInputStream:close	()V
    //   314: aconst_null
    //   315: areturn
    //   316: astore_1
    //   317: new 162	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   324: astore_2
    //   325: aload_2
    //   326: ldc_w 606
    //   329: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: aload_2
    //   334: aload_1
    //   335: invokevirtual 391	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   338: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: ldc 149
    //   344: iconst_1
    //   345: aload_2
    //   346: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokestatic 272	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   352: aconst_null
    //   353: areturn
    //   354: astore_2
    //   355: aload_1
    //   356: ifnull +46 -> 402
    //   359: aload_1
    //   360: invokevirtual 604	java/io/BufferedInputStream:close	()V
    //   363: goto +39 -> 402
    //   366: astore_1
    //   367: new 162	java/lang/StringBuilder
    //   370: dup
    //   371: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   374: astore_3
    //   375: aload_3
    //   376: ldc_w 606
    //   379: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: aload_3
    //   384: aload_1
    //   385: invokevirtual 391	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   388: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: ldc 149
    //   394: iconst_1
    //   395: aload_3
    //   396: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: invokestatic 272	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   402: aload_2
    //   403: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	404	0	this	RedTouchTextView
    //   0	404	1	paramFile	java.io.File
    //   35	101	2	localObject1	Object
    //   152	1	2	localObject2	Object
    //   160	186	2	localStringBuilder1	StringBuilder
    //   354	49	2	localObject3	Object
    //   10	133	3	localObject4	Object
    //   144	1	3	localError1	java.lang.Error
    //   148	1	3	localException1	Exception
    //   158	30	3	localError2	java.lang.Error
    //   256	30	3	localException2	Exception
    //   374	22	3	localStringBuilder2	StringBuilder
    //   18	281	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   100	104	106	java/lang/Exception
    //   38	45	144	java/lang/Error
    //   47	76	144	java/lang/Error
    //   78	100	144	java/lang/Error
    //   38	45	148	java/lang/Exception
    //   47	76	148	java/lang/Exception
    //   78	100	148	java/lang/Exception
    //   6	36	152	finally
    //   6	36	158	java/lang/Error
    //   212	216	218	java/lang/Exception
    //   6	36	256	java/lang/Exception
    //   310	314	316	java/lang/Exception
    //   38	45	354	finally
    //   47	76	354	finally
    //   78	100	354	finally
    //   163	172	354	finally
    //   174	183	354	finally
    //   185	195	354	finally
    //   197	208	354	finally
    //   261	270	354	finally
    //   272	281	354	finally
    //   283	293	354	finally
    //   295	306	354	finally
    //   359	363	366	java/lang/Exception
  }
  
  public BusinessInfoCheckUpdate.AppInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    Drawable localDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
    if ((localDrawable != null) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_b_of_type_Int = ((int)(this.jdField_c_of_type_Int * (localDrawable.getIntrinsicWidth() / this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight())));
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new RedTouchTextView.2(this));
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    super.invalidateDrawable(paramDrawable);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    a();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void setAppInfo(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedTouchTextView", 2, "setAppInfo appInfo is null");
      }
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setAppInfo path = ");
      ((StringBuilder)localObject).append(paramAppInfo.path.get());
      ((StringBuilder)localObject).append("; inewflag = ");
      ((StringBuilder)localObject).append(paramAppInfo.iNewFlag.get());
      QLog.d("RedTouchTextView", 2, ((StringBuilder)localObject).toString());
    }
    if (!a(a(paramAppInfo), this.jdField_a_of_type_JavaUtilList))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo = paramAppInfo;
    if ((paramAppInfo.red_display_info != null) && (paramAppInfo.red_display_info.red_type_info != null))
    {
      paramAppInfo = paramAppInfo.red_display_info.red_type_info.get();
      int i = paramAppInfo.size() - 1;
      while (i >= 0)
      {
        localObject = (BusinessInfoCheckUpdate.RedTypeInfo)paramAppInfo.get(i);
        if (((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_type.get() == 15)
        {
          localObject = ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_content.get();
          this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = ((IRedTouchTextViewApi)QRoute.api(IRedTouchTextViewApi.class)).getApngURLDrawable((String)localObject);
        }
        i -= 1;
      }
    }
    invalidate();
  }
  
  public void setIsNeedRedImageAutoFix(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setShowRedInfo(List<BusinessInfoCheckUpdate.RedTypeInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchTextView
 * JD-Core Version:    0.7.0.1
 */