package com.tencent.mobileqq.troop.text;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.DynamicDrawableSpan;
import android.util.SparseIntArray;
import android.widget.EditText;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.mobileqq.widget.ColorClearableEditText.Paragraph;
import com.tencent.mobileqq.widget.ColorClearableEditText.SpanComparator;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AtTroopMemberSpan
  extends DynamicDrawableSpan
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ColorClearableEditText.SpanComparator jdField_a_of_type_ComTencentMobileqqWidgetColorClearableEditText$SpanComparator = new ColorClearableEditText.SpanComparator();
  private String jdField_a_of_type_JavaLangString = "";
  private int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString = "";
  private String c = "";
  private String d;
  
  private AtTroopMemberSpan(Context paramContext, String paramString1, String paramString2, int paramInt, Paint paramPaint)
  {
    super(0);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = a(String.format("%s%s", new Object[] { "@", new ColorNickText(paramString2, 32).a() }));
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramPaint);
  }
  
  private AtTroopMemberSpan(Context paramContext, String paramString1, String paramString2, int paramInt, Paint paramPaint, String paramString3)
  {
    this(paramContext, paramString1, paramString2, paramInt, paramPaint);
    this.d = a(String.format("%s%s", new Object[] { "@", new ColorNickText(paramString3, 32).a() }));
  }
  
  public static Spannable a(Spannable paramSpannable, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    if ((paramArrayList != null) && (paramSpannable != null))
    {
      paramArrayList.clear();
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramSpannable);
      int m = localSpannableStringBuilder.length();
      AtTroopMemberSpan[] arrayOfAtTroopMemberSpan = (AtTroopMemberSpan[])paramSpannable.getSpans(0, m - 1, AtTroopMemberSpan.class);
      if (arrayOfAtTroopMemberSpan.length == 0) {
        return localSpannableStringBuilder;
      }
      if (arrayOfAtTroopMemberSpan.length > 1) {
        Arrays.sort(arrayOfAtTroopMemberSpan, new AtTroopMemberSpan.1(paramSpannable));
      }
      int i = 0;
      for (int j = 0; i < arrayOfAtTroopMemberSpan.length; j = k)
      {
        AtTroopMemberSpan localAtTroopMemberSpan = arrayOfAtTroopMemberSpan[i];
        int n = paramSpannable.getSpanStart(localAtTroopMemberSpan) + j;
        int i1 = paramSpannable.getSpanEnd(localAtTroopMemberSpan) + j;
        Object localObject = localAtTroopMemberSpan.jdField_b_of_type_JavaLangString;
        if (!TextUtils.isEmpty(localAtTroopMemberSpan.d)) {
          localObject = localAtTroopMemberSpan.d;
        }
        try
        {
          localSpannableStringBuilder.replace(n, i1, (CharSequence)localObject);
          AtTroopMemberInfo localAtTroopMemberInfo = new AtTroopMemberInfo();
          String str = localAtTroopMemberSpan.jdField_a_of_type_JavaLangString;
          if (str != null)
          {
            localAtTroopMemberInfo.uin = Long.valueOf(str).longValue();
            if (localAtTroopMemberSpan.jdField_a_of_type_JavaLangString.equalsIgnoreCase("0")) {
              localAtTroopMemberInfo.flag = 1;
            }
          }
          localAtTroopMemberInfo.startPos = ((short)n);
          localAtTroopMemberInfo.textLen = ((short)((String)localObject).length());
          paramArrayList.add(localAtTroopMemberInfo);
          k = j + (localAtTroopMemberInfo.textLen - (i1 - n));
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
        {
          int k;
          label254:
          break label254;
        }
        k = j;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(localSpannableStringBuilder.toString());
          ((StringBuilder)localObject).append(",IndexOutOfBoundsException, convertToSendMsg, start:%d | end:%d | msgBLen:%d");
          QLog.e("AtTroopMemberSpan", 2, String.format(((StringBuilder)localObject).toString(), new Object[] { Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(m) }));
          k = j;
        }
        i += 1;
      }
      return localSpannableStringBuilder;
    }
    else
    {
      return new SpannableStringBuilder();
    }
  }
  
  public static SpannableString a(AppRuntime paramAppRuntime, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, EditText paramEditText)
  {
    int i;
    int j;
    int k;
    if ((paramAppRuntime != null) && (paramContext != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (paramEditText == null) {
        return null;
      }
      i = paramEditText.getWidth();
      j = paramEditText.getPaddingLeft();
      k = paramEditText.getPaddingRight();
    }
    try
    {
      paramAppRuntime = new AtTroopMemberSpan(paramContext, paramString2, paramString3, i - j - k, paramEditText.getPaint(), paramString4);
    }
    catch (OutOfMemoryError paramAppRuntime)
    {
      label80:
      break label80;
    }
    paramAppRuntime = null;
    if (paramAppRuntime == null) {
      return null;
    }
    paramContext = paramAppRuntime.jdField_b_of_type_JavaLangString;
    paramString1 = new StringBuilder();
    paramString1.append(paramContext);
    paramString1.append(" ");
    paramString1 = new SpannableString(new ColorNickText(paramString1.toString(), 16).a());
    paramString1.setSpan(paramAppRuntime, 0, paramContext.length(), 33);
    return paramString1;
    return null;
  }
  
  public static SpannableString a(AppRuntime paramAppRuntime, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, EditText paramEditText, boolean paramBoolean2)
  {
    return a(paramAppRuntime, paramContext, paramString1, paramString2, paramString3, paramBoolean1, paramEditText, paramBoolean2, false);
  }
  
  public static SpannableString a(AppRuntime paramAppRuntime, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, EditText paramEditText, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i;
    int j;
    int k;
    if ((paramAppRuntime != null) && (paramContext != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (paramEditText == null) {
        return null;
      }
      AtTroopMemberSpan[] arrayOfAtTroopMemberSpan = (AtTroopMemberSpan[])paramEditText.getEditableText().getSpans(0, paramEditText.getEditableText().toString().length(), AtTroopMemberSpan.class);
      i = paramEditText.getWidth();
      j = paramEditText.getPaddingLeft();
      k = paramEditText.getPaddingRight();
    }
    try
    {
      paramAppRuntime = a(paramAppRuntime, paramContext, paramString1, paramString2, paramString3, paramBoolean1, i - j - k, paramEditText.getPaint(), paramBoolean2);
    }
    catch (OutOfMemoryError paramAppRuntime)
    {
      label109:
      break label109;
    }
    paramAppRuntime = null;
    if (paramAppRuntime == null) {
      return null;
    }
    paramContext = paramAppRuntime.jdField_b_of_type_JavaLangString;
    paramString1 = new StringBuilder();
    paramString1.append(paramContext);
    paramString1.append(" ");
    paramString1 = new SpannableString(new ColorNickText(paramString1.toString(), 16).a());
    paramString1.setSpan(paramAppRuntime, 0, paramContext.length(), 33);
    return paramString1;
    return null;
  }
  
  public static SpannableString a(AppRuntime paramAppRuntime, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramAppRuntime != null) && (paramContext != null) && (!TextUtils.isEmpty(paramString1))) {
      if (TextUtils.isEmpty(paramString2)) {
        return null;
      }
    }
    try
    {
      paramAppRuntime = a(paramAppRuntime, paramContext, paramString1, paramString2, paramString3, paramBoolean1, 400, new Paint(), paramBoolean2);
    }
    catch (OutOfMemoryError paramAppRuntime)
    {
      label51:
      break label51;
    }
    paramAppRuntime = null;
    if (paramAppRuntime == null) {
      return null;
    }
    paramContext = paramAppRuntime.jdField_b_of_type_JavaLangString;
    paramString1 = new StringBuilder();
    paramString1.append(paramContext);
    paramString1.append(" ");
    paramString1 = new SpannableString(paramString1.toString());
    paramString1.setSpan(paramAppRuntime, 0, paramContext.length(), 33);
    return paramString1;
    return null;
  }
  
  public static SpannableString a(AppRuntime paramAppRuntime, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, String paramString4)
  {
    if ((paramAppRuntime != null) && (paramContext != null) && (!TextUtils.isEmpty(paramString1))) {
      if (TextUtils.isEmpty(paramString2)) {
        return null;
      }
    }
    try
    {
      paramAppRuntime = a(paramAppRuntime, paramContext, paramString1, paramString2, paramString3, paramBoolean1, 400, new Paint(), paramBoolean2);
    }
    catch (OutOfMemoryError paramAppRuntime)
    {
      label51:
      break label51;
    }
    paramAppRuntime = null;
    if (paramAppRuntime == null) {
      return null;
    }
    paramContext = paramAppRuntime.jdField_b_of_type_JavaLangString;
    paramString1 = new StringBuilder();
    paramString1.append(paramString4);
    paramString1.append(paramContext);
    paramString1.append(" ");
    paramString1 = new SpannableString(paramString1.toString());
    paramString1.setSpan(paramAppRuntime, paramString4.length(), paramString4.length() + paramContext.length(), 33);
    return paramString1;
    return null;
  }
  
  private static AtTroopMemberSpan a(AppRuntime paramAppRuntime, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, int paramInt, Paint paramPaint, boolean paramBoolean2)
  {
    if ((paramAppRuntime != null) && (paramContext != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (paramInt <= 0) {
        return null;
      }
      if (paramBoolean2)
      {
        if ((paramBoolean1) || (paramString2.equalsIgnoreCase("0"))) {
          break label111;
        }
        paramString1 = ContactUtils.a(paramAppRuntime, paramString1, paramString2);
        paramAppRuntime = paramString1;
        if (TextUtils.isEmpty(paramString1))
        {
          paramAppRuntime = paramString1;
          if (!TextUtils.isEmpty(paramString3)) {
            break label111;
          }
        }
      }
      else
      {
        if (paramString2.equalsIgnoreCase("0")) {
          break label111;
        }
        paramString1 = ContactUtils.b(paramAppRuntime, paramString2, true);
        paramAppRuntime = paramString1;
        if (a(paramString2, paramString1, paramString3)) {
          break label111;
        }
      }
      break label114;
      label111:
      paramAppRuntime = paramString3;
      label114:
      if (TextUtils.isEmpty(paramAppRuntime)) {
        return null;
      }
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append(" memUin:");
        paramString1.append(paramString2);
        paramString1.append(" troopMemName:");
        paramString1.append(MessageRecordUtil.a(paramAppRuntime));
        paramString1.append(" isTroop:");
        paramString1.append(paramBoolean2);
        QLog.d("_At_Me_DISC", 2, paramString1.toString());
      }
      return new AtTroopMemberSpan(paramContext, paramString2, paramAppRuntime, paramInt, paramPaint);
    }
    return null;
  }
  
  public static String a(Spannable paramSpannable, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    return a(paramSpannable, paramArrayList).toString();
  }
  
  private static String a(CharSequence paramCharSequence)
  {
    paramCharSequence = new StringBuffer(paramCharSequence);
    int j;
    for (int i = 0; i < paramCharSequence.length(); i = j + 1)
    {
      int k = paramCharSequence.codePointAt(i);
      if ((k == 20) && (i < paramCharSequence.length() - 1)) {
        paramCharSequence.delete(i, i + 2);
      }
      for (;;)
      {
        j = i - 1;
        break;
        j = i;
        if (EmotcationConstants.EMOJI_MAP.get(k, -1) < 0) {
          break;
        }
        if (k > 65535)
        {
          j = paramCharSequence.length();
          k = i + 2;
          if (j >= k)
          {
            paramCharSequence.delete(i, k);
            continue;
          }
        }
        paramCharSequence.delete(i, i + 1);
      }
    }
    return paramCharSequence.toString();
  }
  
  public static String a(ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray();
      int i = 0;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localJSONArray.put(i, ((AtTroopMemberInfo)paramArrayList.next()).toJsonObject());
        i += 1;
      }
      paramArrayList = localJSONArray.toString();
      return paramArrayList;
    }
    catch (Exception paramArrayList)
    {
      QLog.e("AtTroopMemberSpan", 1, "convertAtinfo2Json fail: ", paramArrayList);
    }
    return null;
  }
  
  public static StringBuilder a(QQAppInterface paramQQAppInterface, StringBuilder paramStringBuilder, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramStringBuilder.toString())) && (!TextUtils.isEmpty(paramString2)) && (!paramBoolean))
    {
      StringBuilder localStringBuilder;
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString1);
        int m = localJSONArray.length();
        int i = 0;
        int j = 0;
        for (;;)
        {
          localStringBuilder = paramStringBuilder;
          if (i >= m) {
            break label307;
          }
          paramString1 = paramStringBuilder;
          localStringBuilder = paramStringBuilder;
          try
          {
            Object localObject = localJSONArray.getJSONObject(i);
            paramString1 = paramStringBuilder;
            localStringBuilder = paramStringBuilder;
            int i1 = (byte)((JSONObject)localObject).optInt("flag", 1);
            paramString1 = paramStringBuilder;
            localStringBuilder = paramStringBuilder;
            String str = ((JSONObject)localObject).optString("uin");
            paramString1 = paramStringBuilder;
            localStringBuilder = paramStringBuilder;
            int i2 = ((JSONObject)localObject).optInt("startPos", 0);
            paramString1 = paramStringBuilder;
            localStringBuilder = paramStringBuilder;
            int n = ((JSONObject)localObject).optInt("textLen", 0);
            paramString1 = paramStringBuilder;
            int k = j;
            if (i1 == 0)
            {
              paramString1 = paramStringBuilder;
              localStringBuilder = paramStringBuilder;
              localObject = new StringBuilder();
              paramString1 = paramStringBuilder;
              localStringBuilder = paramStringBuilder;
              ((StringBuilder)localObject).append("@");
              paramString1 = paramStringBuilder;
              localStringBuilder = paramStringBuilder;
              ((StringBuilder)localObject).append(ContactUtils.a(paramQQAppInterface, paramString2, str));
              paramString1 = paramStringBuilder;
              localStringBuilder = paramStringBuilder;
              str = ((StringBuilder)localObject).toString();
              paramString1 = paramStringBuilder;
              localStringBuilder = paramStringBuilder;
              paramStringBuilder = paramStringBuilder.replace(i2 + j, i2 + n + j, str);
              paramString1 = paramStringBuilder;
              localStringBuilder = paramStringBuilder;
              k = str.length();
              k = j + (k - n);
              paramString1 = paramStringBuilder;
            }
            i += 1;
            paramStringBuilder = paramString1;
            j = k;
          }
          catch (Exception paramQQAppInterface)
          {
            paramStringBuilder = paramString1;
          }
          catch (JSONException paramQQAppInterface) {}
        }
        QLog.e("_At_Me_DISC", 1, "replaceAtMsgByMarkName_1 ", paramQQAppInterface);
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("_At_Me_DISC", 1, "replaceAtMsgByMarkName_2", paramQQAppInterface);
        return paramStringBuilder;
      }
      catch (JSONException paramQQAppInterface)
      {
        localStringBuilder = paramStringBuilder;
      }
      label307:
      return localStringBuilder;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("Recv replaceAtMsgByMarkName return discUin:");
      paramQQAppInterface.append(paramString2);
      QLog.d("AtTroopMemberSpan_At_Me_DISC", 2, paramQQAppInterface.toString());
    }
    return paramStringBuilder;
  }
  
  private List<ColorClearableEditText.Paragraph> a(Paint paramPaint)
  {
    int i = (int)Math.ceil(paramPaint.measureText(" "));
    List localList = ColorNickManager.a(this.jdField_b_of_type_Int - i * 2, this.jdField_b_of_type_JavaLangString, paramPaint, this.jdField_a_of_type_ComTencentMobileqqWidgetColorClearableEditText$SpanComparator, 16);
    localList.add(new ColorClearableEditText.Paragraph(1, 0, 0, "  ", null));
    this.jdField_a_of_type_Int = ColorNickManager.a(localList, paramPaint, new Rect());
    return localList;
  }
  
  public static void a(int paramInt, String paramString, ChatMessage paramChatMessage)
  {
    if (paramInt == 1)
    {
      paramChatMessage.saveExtInfoToExtStr("troop_at_info_list", paramString);
      return;
    }
    if (paramInt == 3000) {
      paramChatMessage.saveExtInfoToExtStr("disc_at_info_list", paramString);
    }
  }
  
  public static void a(int paramInt, ArrayList<AtTroopMemberInfo> paramArrayList, ChatMessage paramChatMessage)
  {
    if (((paramInt == 3000) || (paramInt == 1)) && (paramArrayList.size() > 0))
    {
      try
      {
        JSONArray localJSONArray = new JSONArray();
        int i = 0;
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          localJSONArray.put(i, ((AtTroopMemberInfo)paramArrayList.next()).toJsonObject());
          i += 1;
        }
        if (paramInt == 1)
        {
          paramChatMessage.saveExtInfoToExtStr("troop_at_info_list", localJSONArray.toString());
          return;
        }
        if (paramInt != 3000) {
          return;
        }
        paramChatMessage.saveExtInfoToExtStr("disc_at_info_list", localJSONArray.toString());
        return;
      }
      catch (JSONException paramArrayList)
      {
        paramArrayList.printStackTrace();
        return;
      }
    }
    else if (((paramInt == 3000) || (paramInt == 1)) && (paramArrayList.size() == 0))
    {
      if (paramInt == 1)
      {
        paramChatMessage.removeExtInfoToExtStr("troop_at_info_list");
        return;
      }
      if (paramInt == 3000) {
        paramChatMessage.removeExtInfoToExtStr("disc_at_info_list");
      }
    }
  }
  
  private void a(Paint paramPaint)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      return;
    }
    Object localObject2 = a(paramPaint);
    Object localObject1 = paramPaint.getFontMetrics();
    float f3 = -((Paint.FontMetrics)localObject1).top;
    int i = (int)Math.ceil(((Paint.FontMetrics)localObject1).bottom - ((Paint.FontMetrics)localObject1).top);
    Object localObject3 = new RectF(0.0F, ((Paint.FontMetrics)localObject1).ascent - ((Paint.FontMetrics)localObject1).top, this.jdField_a_of_type_Int - 2, ((Paint.FontMetrics)localObject1).descent + f3);
    Bitmap localBitmap = Bitmap.createBitmap(this.jdField_a_of_type_Int, i, Bitmap.Config.ARGB_8888);
    localObject1 = new Canvas(localBitmap);
    int j = paramPaint.getColor();
    paramPaint.setColor(-4331268);
    ((Canvas)localObject1).drawRect((RectF)localObject3, paramPaint);
    paramPaint.setColor(j);
    localObject2 = ((List)localObject2).iterator();
    float f1 = 0.0F;
    label294:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ColorClearableEditText.Paragraph)((Iterator)localObject2).next();
      j = ((ColorClearableEditText.Paragraph)localObject3).c;
      float f2;
      if (j != 1)
      {
        if (j != 2) {
          break label294;
        }
        localObject3 = (EmoticonSpan)((ColorClearableEditText.Paragraph)localObject3).jdField_a_of_type_AndroidTextStyleCharacterStyle;
        int k = ((EmoticonSpan)localObject3).getDrawable().getBounds().height();
        j = (i - k) / 2;
        k = (k + i) / 2;
        ((EmoticonSpan)localObject3).draw((Canvas)localObject1, "", 0, 0, f1, j, k, k, paramPaint);
        f2 = ((EmoticonSpan)localObject3).getDrawable().getBounds().width();
      }
      else
      {
        ((Canvas)localObject1).drawText(((ColorClearableEditText.Paragraph)localObject3).jdField_a_of_type_JavaLangString, f1, f3, paramPaint);
        f2 = paramPaint.measureText(((ColorClearableEditText.Paragraph)localObject3).jdField_a_of_type_JavaLangString);
      }
      f1 += f2;
    }
    ((Canvas)localObject1).save();
    ((Canvas)localObject1).restore();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_a_of_type_Int, i);
  }
  
  private static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!paramString2.equals(paramString1))) {
      return false;
    }
    return TextUtils.isEmpty(paramString3) ^ true;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void draw(@NonNull Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, @NonNull Paint paramPaint)
  {
    if ((paramInt2 - paramInt1 == 1) && (this.c.length() != 1) && (paramInt1 != 0)) {
      return;
    }
    super.draw(paramCanvas, paramCharSequence, paramInt1, paramInt2, paramFloat, paramInt3, paramInt4, paramInt5, paramPaint);
  }
  
  public Drawable getDrawable()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public int getSize(@NonNull Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, @Nullable Paint.FontMetricsInt paramFontMetricsInt)
  {
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && ((paramInt2 - paramInt1 != 1) || (this.c.length() == 1) || (paramInt1 == 0))) {
      return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds().right;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.text.AtTroopMemberSpan
 * JD-Core Version:    0.7.0.1
 */