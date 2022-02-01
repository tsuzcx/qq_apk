package com.tencent.mobileqq.redtouch;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
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
import beyq;
import bhmq;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class RedTouchTextView
  extends TextView
{
  private int jdField_a_of_type_Int = a(30);
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  public Drawable a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private BusinessInfoCheckUpdate.AppInfo jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  public String a;
  private List<BusinessInfoCheckUpdate.RedTypeInfo> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = this.jdField_a_of_type_Int;
  public Drawable b;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean;
  private int c;
  public Drawable c;
  private int d = a(9);
  private int e = a(9);
  private int f = a(4);
  private int g = 100;
  
  public RedTouchTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RedTouchTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
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
    if (a(paramRedTypeInfo, this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo))
    {
      if (this.jdField_a_of_type_Boolean) {
        return this.jdField_b_of_type_Int + this.f;
      }
      return this.jdField_a_of_type_Int + this.f;
    }
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_b_of_type_Int;
    }
    return this.jdField_a_of_type_Int;
  }
  
  private int a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    if (paramRedTypeInfo == null) {
      return j;
    }
    int k = paramRedTypeInfo.red_type.get();
    switch (k)
    {
    }
    for (;;)
    {
      j = i;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("RedTouchTextView", 2, "getRedTypeInfoWidth type = " + k + ",width = " + i);
      return i;
      i = this.d;
      continue;
      i = a(paramRedTypeInfo);
      continue;
      i = a(paramRedTypeInfo);
      continue;
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
      continue;
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
  
  private int a(List<BusinessInfoCheckUpdate.RedTypeInfo> paramList)
  {
    int j = 0;
    boolean bool;
    if (paramList != null) {
      if (paramList.size() <= 2) {
        bool = true;
      }
    }
    for (;;)
    {
      int i;
      if ((paramList != null) && (paramList.size() > 0))
      {
        i = 0;
        for (;;)
        {
          if (j < paramList.size())
          {
            int k = a((BusinessInfoCheckUpdate.RedTypeInfo)paramList.get(j), bool);
            j += 1;
            i = k + i;
            continue;
            bool = false;
            break;
          }
        }
        j = i;
        if (QLog.isColorLevel()) {
          QLog.d("RedTouchTextView", 2, "getWidthByRedInfoList size = " + paramList.size());
        }
      }
      for (j = i;; j = 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RedTouchTextView", 2, "getWidthByRedInfoList width = " + j);
        }
        return j;
      }
      bool = false;
    }
  }
  
  private int a(List<BusinessInfoCheckUpdate.RedTypeInfo> paramList, int paramInt)
  {
    int j = 0;
    int k = 0;
    int i = 0;
    boolean bool;
    if (paramList != null) {
      if (paramList.size() <= 2) {
        bool = true;
      }
    }
    for (;;)
    {
      if ((paramList != null) && ((paramInt > paramList.size() - 1) || (paramInt < 0)))
      {
        j = i;
        if (QLog.isColorLevel())
        {
          QLog.d("RedTouchTextView", 2, "getWidthByRedInfoListByPosition error, size = " + paramList.size() + " position = " + paramInt);
          j = i;
        }
      }
      do
      {
        return j;
        bool = false;
        break;
        i = k;
        if (paramList != null)
        {
          i = k;
          if (paramList.size() > 0)
          {
            i = paramList.size() - 1;
            while (i >= paramInt)
            {
              j += a((BusinessInfoCheckUpdate.RedTypeInfo)paramList.get(i), bool);
              i -= 1;
            }
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.d("RedTouchTextView", 2, "getWidthByRedInfoListByPosition size = " + paramList.size());
              i = j;
            }
          }
        }
        j = i;
      } while (!QLog.isColorLevel());
      QLog.d("RedTouchTextView", 2, "getWidthByRedInfoListByPosition width = " + i);
      return i;
      bool = false;
    }
  }
  
  public static List<BusinessInfoCheckUpdate.RedTypeInfo> a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {
      paramAppInfo = null;
    }
    List localList;
    do
    {
      return paramAppInfo;
      paramAppInfo = (BusinessInfoCheckUpdate.RedDisplayInfo)paramAppInfo.red_display_info.get();
      if (paramAppInfo == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RedTouchTextView", 2, "getRedTypeInfoFromAppInfo diplayInfo = null");
        }
        return null;
      }
      localList = paramAppInfo.red_type_info.get();
      if (localList == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RedTouchTextView", 2, "getRedTypeInfoFromAppInfo redInfos = null");
        }
        return null;
      }
      paramAppInfo = localList;
    } while (localList.size() >= 2);
    if (QLog.isColorLevel()) {
      QLog.d("RedTouchTextView", 2, "getRedTypeInfoFromAppInfo redInfos.size < 2");
    }
    return null;
  }
  
  private void a(Canvas paramCanvas)
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedTouchTextView", 2, "drawRed start draw");
      }
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() < 1)) {
        QLog.e("RedTouchTextView", 1, "drawRed showRedInfo = null");
      }
    }
    else
    {
      return;
    }
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    while (i >= 0)
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      int j = localRedTypeInfo.red_type.get();
      try
      {
        if (TextUtils.isEmpty(localRedTypeInfo.red_desc.get())) {}
        for (JSONObject localJSONObject = new JSONObject();; localJSONObject = new JSONObject(localRedTypeInfo.red_desc.get()))
        {
          a(paramCanvas, i, j);
          c(paramCanvas, i, localRedTypeInfo, j, localJSONObject);
          a(paramCanvas, i, localRedTypeInfo, j, localJSONObject);
          b(paramCanvas, i, localRedTypeInfo, j, localJSONObject);
          break;
        }
      }
      catch (Exception localException)
      {
        QLog.e("RedTouchTextView", 1, "drawRed Exception " + localException);
        i -= 1;
      }
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
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130850400);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(paramInt1, paramInt2, this.d + paramInt1, this.d + paramInt2);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
  }
  
  private void a(Canvas paramCanvas, int paramInt1, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, int paramInt2, JSONObject paramJSONObject)
  {
    int j;
    int k;
    if (paramInt2 == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedTouchTextView", 2, "draw redtouch img");
      }
      j = getWidth() - a(this.jdField_a_of_type_JavaUtilList, paramInt1) - a(0);
      k = getHeight() / 2 - this.jdField_c_of_type_Int / 2;
      if (!paramJSONObject.has("av")) {
        break label447;
      }
    }
    label447:
    for (paramInt1 = paramJSONObject.getInt("av");; paramInt1 = 0)
    {
      if (paramJSONObject.has("dot")) {}
      for (paramInt2 = paramJSONObject.getInt("dot");; paramInt2 = 0)
      {
        if (paramJSONObject.has("st")) {}
        for (int i = Integer.valueOf(paramJSONObject.getString("st")).intValue();; i = 0)
        {
          paramRedTypeInfo = paramRedTypeInfo.red_content.get();
          if (i == 1)
          {
            if (QLog.isColorLevel()) {
              QLog.d("RedTouchTextView", 2, "draw redtouch img gif ");
            }
            paramJSONObject = getResources().getDrawable(2130840274);
            localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mLoadingDrawable = paramJSONObject;
            localURLDrawableOptions.mFailedDrawable = paramJSONObject;
            localURLDrawableOptions.mRequestWidth = this.jdField_b_of_type_Int;
            localURLDrawableOptions.mRequestHeight = this.jdField_c_of_type_Int;
            localURLDrawableOptions.mPlayGifImage = true;
            paramRedTypeInfo = URLDrawable.getDrawable(paramRedTypeInfo, localURLDrawableOptions);
            paramRedTypeInfo.setCallback(this);
            paramRedTypeInfo.draw(paramCanvas);
            if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null)
            {
              this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(j, k, this.jdField_b_of_type_Int + j, this.jdField_c_of_type_Int + k);
              this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
            }
          }
          while (i != 0)
          {
            URLDrawable.URLDrawableOptions localURLDrawableOptions;
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("RedTouchTextView", 2, "draw redtouch img static ");
          }
          if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {}
          for (;;)
          {
            if (paramInt2 == 1)
            {
              paramJSONObject = getResources().getDrawable(2130850400);
              paramJSONObject.setBounds(getWidth() - a(0) - a(9), k - a(4), getWidth() - a(0), k + a(5));
              paramJSONObject.draw(paramCanvas);
            }
            if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) || (TextUtils.isEmpty(paramRedTypeInfo))) {
              break;
            }
            ThreadManager.post(new RedTouchTextView.1(this, paramRedTypeInfo, paramInt1), 8, null, true);
            return;
            this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(j, k, this.jdField_b_of_type_Int + j, this.jdField_c_of_type_Int + k);
            this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
          }
        }
      }
    }
  }
  
  private static void a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    try
    {
      if (TextUtils.isEmpty(paramRedTypeInfo.red_desc.get())) {}
      for (JSONObject localJSONObject = new JSONObject();; localJSONObject = new JSONObject(paramRedTypeInfo.red_desc.get()))
      {
        if (localJSONObject.has("dot")) {
          localJSONObject.put("dot", 0);
        }
        if (QLog.isColorLevel()) {
          QLog.d("RedTouchTextView", 2, "setImageRedNotShowRedPoint ,path = " + paramAppInfo.path.get());
        }
        paramRedTypeInfo.red_desc.set(localJSONObject.toString());
        return;
      }
      return;
    }
    catch (Exception paramRedTypeInfo)
    {
      QLog.e("RedTouchTextView", 1, "setImageRedNotShowRedPoint json exception e = " + paramRedTypeInfo.getMessage());
    }
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo == null) {
      QLog.d("RedTouchTextView", 1, "isSupportRedTouch appinfo = null");
    }
    do
    {
      do
      {
        do
        {
          return false;
          if (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() != 1)
          {
            QLog.d("RedTouchTextView", 1, "isSupportRedTouch inewflag = 0, path = " + this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.path);
            return false;
          }
          localObject = (BusinessInfoCheckUpdate.RedDisplayInfo)this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.red_display_info.get();
          if (localObject != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("RedTouchTextView", 2, "getRedTypeInfoFromAppInfo diplayInfo = null, path = " + this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.path.get());
        return false;
        localObject = ((BusinessInfoCheckUpdate.RedDisplayInfo)localObject).red_type_info.get();
        if (localObject != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("RedTouchTextView", 2, "getRedTypeInfoFromAppInfo redInfos = null, path = " + this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.path.get());
      return false;
      if (((List)localObject).size() >= 2) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("RedTouchTextView", 2, "getRedTypeInfoFromAppInfo redInfos.size < 2, path = " + this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.path.get());
    return false;
    Object localObject = new ArrayList((Collection)localObject);
    int j = a((List)localObject);
    Iterator localIterator = ((List)localObject).iterator();
    int i = 0;
    label260:
    if (localIterator.hasNext())
    {
      if (((BusinessInfoCheckUpdate.RedTypeInfo)localIterator.next()).red_type.get() == 9) {
        break label330;
      }
      i += 1;
    }
    label330:
    for (;;)
    {
      break label260;
      if (i == 0)
      {
        QLog.e("RedTouchTextView", 1, "isSupportRedTouch notSpaceInfoCount = 0");
        return false;
      }
      if (a((List)localObject, j, i)) {
        break;
      }
      setShowRedInfo((List)localObject);
      return true;
    }
  }
  
  public static boolean a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((paramRedTypeInfo == null) || (paramRedTypeInfo.red_type.get() != 3)) {
      return false;
    }
    return c(paramRedTypeInfo, paramAppInfo);
  }
  
  private boolean a(List<BusinessInfoCheckUpdate.RedTypeInfo> paramList, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    int m = a();
    int i = paramInt1;
    paramInt1 = paramInt2;
    if ((i > m) && (paramInt1 > 1))
    {
      int k = paramList.size();
      int j = 0;
      label37:
      i = k;
      paramInt2 = paramInt1;
      if (j < k)
      {
        if (((BusinessInfoCheckUpdate.RedTypeInfo)paramList.get(j)).red_type.get() != 9)
        {
          paramList.remove(j);
          paramInt2 = paramInt1 - 1;
          i = k - 1;
        }
      }
      else {
        paramInt1 = 0;
      }
      for (;;)
      {
        if (paramInt1 < i - 1)
        {
          if ((((BusinessInfoCheckUpdate.RedTypeInfo)paramList.get(paramInt1)).red_type.get() == 9) && (((BusinessInfoCheckUpdate.RedTypeInfo)paramList.get(paramInt1 + 1)).red_type.get() == 9)) {
            paramList.remove(paramInt1);
          }
        }
        else
        {
          i = a(paramList);
          paramInt1 = paramInt2;
          break;
          j += 1;
          break label37;
        }
        paramInt1 += 1;
      }
    }
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo;
    if ((i > m) && (paramInt1 == 1))
    {
      paramInt2 = 0;
      while (paramInt2 < paramList.size())
      {
        localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)paramList.get(paramInt2);
        if ((localRedTypeInfo.red_type.get() == 3) && (a(localRedTypeInfo, this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo))) {
          setImageRedNotShowRedPoint(localRedTypeInfo, this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
        }
        paramInt2 += 1;
      }
    }
    if ((a(paramList) > m) && (paramInt1 == 1))
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
    if (a(paramList) > m) {
      bool = true;
    }
    return bool;
  }
  
  private boolean a(List<BusinessInfoCheckUpdate.RedTypeInfo> paramList1, List<BusinessInfoCheckUpdate.RedTypeInfo> paramList2)
  {
    if ((paramList1 == null) || (paramList2 == null)) {}
    while ((paramList1.size() != paramList2.size()) || (paramList1.size() == 0)) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramList1.size()) {
        break label159;
      }
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo1 = (BusinessInfoCheckUpdate.RedTypeInfo)paramList1.get(i);
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo2 = (BusinessInfoCheckUpdate.RedTypeInfo)paramList2.get(i);
      if ((localRedTypeInfo1.red_type.get() != localRedTypeInfo2.red_type.get()) || (!localRedTypeInfo1.red_content.get().equals(localRedTypeInfo2.red_content.get())) || (!localRedTypeInfo1.red_desc.get().equals(localRedTypeInfo2.red_desc.get())) || (localRedTypeInfo1.red_priority.get() != localRedTypeInfo2.red_priority.get())) {
        break;
      }
      i += 1;
    }
    label159:
    return true;
  }
  
  private void b(Canvas paramCanvas, int paramInt1, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, int paramInt2, JSONObject paramJSONObject)
  {
    int i;
    if (paramInt2 == 15)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedTouchTextView", 2, "draw redtouch diffimg");
      }
      paramInt2 = getWidth() - a(this.jdField_a_of_type_JavaUtilList, paramInt1) - a(0);
      i = getHeight() / 2 - this.jdField_c_of_type_Int / 2;
      if (paramJSONObject.has("av")) {
        paramJSONObject.getInt("av");
      }
      if (!paramJSONObject.has("dot")) {
        break label237;
      }
    }
    label237:
    for (paramInt1 = paramJSONObject.getInt("dot");; paramInt1 = 0)
    {
      if (paramInt1 == 1)
      {
        paramRedTypeInfo = getResources().getDrawable(2130850400);
        paramRedTypeInfo.setBounds(getWidth() - a(0) - a(9), i - a(4), getWidth() - a(0), a(5) + i);
        paramRedTypeInfo.draw(paramCanvas);
      }
      if (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        paramInt1 = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() / 2;
        this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.jdField_b_of_type_Int + paramInt2 - a(paramInt1), i, paramInt2 + this.jdField_b_of_type_Int, this.jdField_c_of_type_Int + i);
        this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setCallback(this);
        this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
      return;
    }
  }
  
  public static boolean b(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((paramRedTypeInfo == null) || (paramRedTypeInfo.red_type.get() != 15)) {
      return false;
    }
    return c(paramRedTypeInfo, paramAppInfo);
  }
  
  private void c(Canvas paramCanvas, int paramInt1, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, int paramInt2, JSONObject paramJSONObject)
  {
    float f1;
    float f2;
    if ((paramInt2 == 4) || (paramInt2 == 5))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedTouchTextView", 2, "draw redtouch text");
      }
      paramInt2 = -1;
      int i = 0;
      if (paramJSONObject.has("cr")) {
        paramInt2 = a(paramJSONObject.getString("cr"));
      }
      if (paramJSONObject.has("cn")) {
        i = a(paramJSONObject.getString("cn"));
      }
      paramRedTypeInfo = paramRedTypeInfo.red_content.get();
      paramJSONObject = new Paint(1);
      paramJSONObject.setTextSize(a(11));
      paramJSONObject.setTextAlign(Paint.Align.LEFT);
      int j = (int)paramJSONObject.measureText(paramRedTypeInfo);
      Object localObject = paramJSONObject.getFontMetrics();
      int k = (int)(((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).top);
      paramInt1 = getWidth() - a(0) - a(this.jdField_a_of_type_JavaUtilList, paramInt1);
      int m = getHeight() / 2 - k / 2 - a(2);
      Rect localRect = new Rect();
      localRect.left = paramInt1;
      localRect.top = m;
      localRect.right = (j + paramInt1);
      if (this.jdField_a_of_type_JavaUtilList.size() <= 2) {
        localRect.right += a(6) * 2;
      }
      localRect.bottom = (m + k + a(2) * 2);
      f1 = a(2) + m;
      f2 = ((Paint.FontMetrics)localObject).top;
      if (i != 0)
      {
        localObject = getResources().getDrawable(2130850404);
        ((Drawable)localObject).getBounds();
        ((Drawable)localObject).setBounds(paramInt1, m, localRect.right, localRect.bottom);
        ((Drawable)localObject).draw(paramCanvas);
      }
      paramJSONObject.setColor(paramInt2);
      if (this.jdField_a_of_type_JavaUtilList.size() > 2) {
        break label381;
      }
      paramInt1 = a(6) + paramInt1;
    }
    label381:
    for (;;)
    {
      paramCanvas.drawText(paramRedTypeInfo, paramInt1, f1 - f2, paramJSONObject);
      return;
    }
  }
  
  private static boolean c(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramRedTypeInfo.red_desc.get()))
        {
          paramRedTypeInfo = new JSONObject();
          if (!paramRedTypeInfo.has("dot")) {
            break label159;
          }
          i = paramRedTypeInfo.getInt("dot");
          j = i;
        }
      }
      catch (Exception paramRedTypeInfo)
      {
        i = 0;
        QLog.e("RedTouchTextView", 1, "isSupportRedTouch json exception e = " + paramRedTypeInfo.getMessage());
        int j = i;
        continue;
      }
      try
      {
        if (QLog.isColorLevel())
        {
          QLog.d("RedTouchTextView", 2, "isSupportRedTouch had dot = " + i + ",path = " + paramAppInfo.path.get());
          j = i;
        }
        if (j != 1) {
          break label153;
        }
        return true;
      }
      catch (Exception paramRedTypeInfo)
      {
        continue;
      }
      paramRedTypeInfo = new JSONObject(paramRedTypeInfo.red_desc.get());
      continue;
      label153:
      return false;
      label159:
      int i = 0;
    }
  }
  
  public static void setDiffImageRedNotShowRedPoint(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((paramRedTypeInfo == null) || (paramRedTypeInfo.red_type.get() != 15)) {
      return;
    }
    a(paramRedTypeInfo, paramAppInfo);
  }
  
  public static void setImageRedNotShowRedPoint(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((paramRedTypeInfo == null) || (paramRedTypeInfo.red_type.get() != 3)) {
      return;
    }
    a(paramRedTypeInfo, paramAppInfo);
  }
  
  protected int a(int paramInt)
  {
    Resources localResources = getResources();
    return (int)TypedValue.applyDimension(1, paramInt, localResources.getDisplayMetrics());
  }
  
  protected int a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals("#"))) {
      return 0;
    }
    return Color.parseColor(paramString);
  }
  
  protected Bitmap a(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    try
    {
      paramFile = paramFile.getAbsolutePath();
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      BufferedInputStream localBufferedInputStream = new BufferedInputStream(new FileInputStream(paramFile));
      if (!this.jdField_a_of_type_Boolean) {
        localOptions.inSampleSize = ((int)bhmq.a(localBufferedInputStream, this.e, this.e));
      }
      paramFile = SafeBitmapFactory.decodeStream(new BufferedInputStream(new FileInputStream(paramFile)), null, localOptions);
      return paramFile;
    }
    catch (Exception paramFile)
    {
      QLog.e("RedTouchTextView", 1, "getIconFromFile exception e = " + paramFile.getMessage());
      return null;
    }
    catch (Error paramFile)
    {
      QLog.e("RedTouchTextView", 1, "getIconFromFile error e = " + paramFile.getMessage());
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_b_of_type_Int = ((int)(this.jdField_c_of_type_Int * (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() / this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight())));
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
    if (QLog.isColorLevel()) {
      QLog.d("RedTouchTextView", 2, "setAppInfo path = " + paramAppInfo.path.get() + "; inewflag = " + paramAppInfo.iNewFlag.get());
    }
    if (!a(a(paramAppInfo), this.jdField_a_of_type_JavaUtilList))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
    }
    this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = paramAppInfo;
    if ((paramAppInfo.red_display_info != null) && (paramAppInfo.red_display_info.red_type_info != null))
    {
      paramAppInfo = paramAppInfo.red_display_info.red_type_info.get();
      int i = paramAppInfo.size() - 1;
      while (i >= 0)
      {
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)paramAppInfo.get(i);
        if (localRedTypeInfo.red_type.get() == 15) {
          this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = VasApngUtil.getApngURLDrawable(localRedTypeInfo.red_content.get(), VasApngUtil.VIP_APNG_TAGS, beyq.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchTextView
 * JD-Core Version:    0.7.0.1
 */