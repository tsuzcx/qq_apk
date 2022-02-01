package com.tencent.mobileqq.vas;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener;
import com.tencent.mobileqq.emoticonview.ISmallEmoticonInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.text.ReplyedMessageSpan;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.troopnick.TroopNickNameHelper;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.widget.ColorClearableEditText;
import com.tencent.mobileqq.widget.ColorClearableEditText.Paragraph;
import com.tencent.mobileqq.widget.ColorClearableEditText.SpanComparator;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.mobileqq.widget.QColorNickTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.CommCardNameBuf;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.RichCardNameElem;

public class ColorNickManager
  implements Manager
{
  private static ColorNickManager.AtParagraphComparator jdField_a_of_type_ComTencentMobileqqVasColorNickManager$AtParagraphComparator = new ColorNickManager.AtParagraphComparator(null);
  public static final String a;
  public static AtomicBoolean a;
  public Handler a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EmotionJsonDownloadListener jdField_a_of_type_ComTencentMobileqqEmoticonEmotionJsonDownloadListener = new ColorNickManager.3(this);
  public ColorNickManager.ColorNickEmoticonListProvider a;
  private CallBacker jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker = new ColorNickManager.4(this);
  private Vector<Integer> jdField_a_of_type_JavaUtilVector = new Vector();
  ConcurrentHashMap<Integer, ColorNickManager.ColorNickColor> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append(".CorlorNick/");
    jdField_a_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public ColorNickManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqVasColorNickManager$ColorNickEmoticonListProvider = new ColorNickManager.ColorNickEmoticonListProvider(this);
  }
  
  public static int a(List<ColorClearableEditText.Paragraph> paramList, Paint paramPaint, Rect paramRect)
  {
    Rect localRect = new Rect();
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      ColorClearableEditText.Paragraph localParagraph = (ColorClearableEditText.Paragraph)paramList.next();
      int j = localParagraph.c;
      if (j != 1)
      {
        if (j == 2)
        {
          i += ((EmoticonSpan)localParagraph.jdField_a_of_type_AndroidTextStyleCharacterStyle).getDrawable().getBounds().width();
          paramRect.bottom = Math.max(paramRect.bottom, ((EmoticonSpan)localParagraph.jdField_a_of_type_AndroidTextStyleCharacterStyle).getDrawable().getBounds().height());
        }
      }
      else
      {
        i += (int)Math.ceil(paramPaint.measureText(localParagraph.jdField_a_of_type_JavaLangString));
        paramPaint.getTextBounds(localParagraph.jdField_a_of_type_JavaLangString, 0, localParagraph.jdField_a_of_type_JavaLangString.length(), localRect);
        paramRect.bottom = Math.max(paramRect.bottom, localRect.height());
      }
    }
    paramRect.left = 0;
    paramRect.right = i;
    paramRect.top = 0;
    return i;
  }
  
  public static int a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte).jdField_a_of_type_Int;
  }
  
  @NotNull
  private Shader a(float paramFloat1, float paramFloat2, Rect paramRect, ColorNickManager.ColorNickColor paramColorNickColor)
  {
    float f1;
    if (paramColorNickColor.b == 1) {
      f1 = paramFloat1;
    } else {
      f1 = paramRect.width() * 0.5F + paramFloat1;
    }
    float f2;
    if (paramColorNickColor.b == 1) {
      f2 = paramRect.height() * 0.5F + paramFloat2;
    } else {
      f2 = paramFloat2;
    }
    float f3;
    if (paramColorNickColor.b == 1) {
      f3 = paramRect.width();
    } else {
      f3 = paramRect.width() * 0.5F;
    }
    float f4;
    if (paramColorNickColor.b == 1) {
      f4 = paramRect.height() * 0.5F;
    } else {
      f4 = paramRect.height();
    }
    return new LinearGradient(f1, f2, paramFloat1 + f3, paramFloat2 + f4, paramColorNickColor.jdField_a_of_type_ArrayOfInt, paramColorNickColor.jdField_a_of_type_ArrayOfFloat, Shader.TileMode.CLAMP);
  }
  
  @NotNull
  private Shader a(List<ColorClearableEditText.Paragraph> paramList, float paramFloat, Paint paramPaint, int paramInt1, int paramInt2, ColorNickManager.ColorNickColor paramColorNickColor)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint(paramPaint);
    paramInt1 = 0;
    int i = 0;
    while (i < paramList.size())
    {
      ColorClearableEditText.Paragraph localParagraph = (ColorClearableEditText.Paragraph)paramList.get(i);
      int j = localParagraph.c;
      if (j != 1)
      {
        if (j == 2) {
          paramFloat += ((EmoticonSpan)localParagraph.jdField_a_of_type_AndroidTextStyleCharacterStyle).getDrawable().getBounds().width();
        }
      }
      else
      {
        int k;
        for (j = 0; j < localParagraph.jdField_a_of_type_JavaLangString.length(); j = k)
        {
          String str = localParagraph.jdField_a_of_type_JavaLangString;
          k = j + 1;
          float f = paramPaint.measureText(str, j, k);
          localPaint.setColor(paramColorNickColor.jdField_a_of_type_ArrayOfInt[(paramInt1 % paramColorNickColor.jdField_a_of_type_ArrayOfInt.length)]);
          localPaint.setStyle(Paint.Style.FILL);
          f = paramFloat + f;
          localCanvas.drawRect(paramFloat, 0.0F, f, paramInt2, localPaint);
          paramInt1 += 1;
          paramFloat = f;
        }
      }
      i += 1;
    }
    return new BitmapShader(localBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
  }
  
  private ColorNickManager.ColorNickColor a(File paramFile, int paramInt)
  {
    paramFile = FileUtils.readFileToStringEx(paramFile, -1);
    try
    {
      Object localObject = new JSONObject(paramFile);
      paramFile = new ColorNickManager.ColorNickColor();
      localObject = ((JSONObject)localObject).optJSONArray("baseInfo");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        int i = 0;
        localObject = ((JSONArray)localObject).getJSONObject(0);
        paramFile.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("type");
        if (paramFile.jdField_a_of_type_Int == 5)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject).append(paramInt);
          ((StringBuilder)localObject).append(File.separator);
          ((StringBuilder)localObject).append("shaderImg.png");
          localObject = ((StringBuilder)localObject).toString();
          if (new File((String)localObject).exists())
          {
            paramFile.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a((String)localObject, null);
            return paramFile;
          }
        }
        else
        {
          paramFile.b = ((JSONObject)localObject).optInt("orientation");
          JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("colors");
          if ((localJSONArray != null) && (localJSONArray.length() > 0))
          {
            paramFile.jdField_a_of_type_ArrayOfInt = new int[localJSONArray.length()];
            paramInt = i;
            while (paramInt < localJSONArray.length())
            {
              String str = localJSONArray.getString(paramInt);
              paramFile.jdField_a_of_type_ArrayOfInt[paramInt] = Color.parseColor(str);
              paramInt += 1;
            }
          }
          a(paramFile, (JSONObject)localObject);
        }
        return paramFile;
      }
    }
    catch (Exception paramFile)
    {
      QLog.e("ColorNick", 1, "loadGradientConfig error: ", paramFile);
    }
    return null;
  }
  
  @NotNull
  public static ColorNickManager.ColorNickNameData a(byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    Iterator localIterator = null;
    int j = 0;
    if (paramArrayOfByte == null) {
      return new ColorNickManager.ColorNickNameData(null, 0);
    }
    Object localObject1 = localObject2;
    int i;
    try
    {
      Oidb_0x8fc.CommCardNameBuf localCommCardNameBuf = new Oidb_0x8fc.CommCardNameBuf();
      localObject1 = localObject2;
      localCommCardNameBuf.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = localIterator;
      localObject1 = localObject2;
      if (localCommCardNameBuf.rpt_rich_card_name.has())
      {
        localObject1 = localObject2;
        paramArrayOfByte = new StringBuilder();
        localObject1 = localObject2;
        localIterator = localCommCardNameBuf.rpt_rich_card_name.get().iterator();
        for (;;)
        {
          localObject1 = localObject2;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = localObject2;
          Oidb_0x8fc.RichCardNameElem localRichCardNameElem = (Oidb_0x8fc.RichCardNameElem)localIterator.next();
          localObject1 = localObject2;
          if (localRichCardNameElem.bytes_ctrl.has())
          {
            localObject1 = localObject2;
            paramArrayOfByte.append("<");
            localObject1 = localObject2;
            paramArrayOfByte.append(localRichCardNameElem.bytes_ctrl.get().toStringUtf8());
            localObject1 = localObject2;
            paramArrayOfByte.append(">");
          }
          else
          {
            localObject1 = localObject2;
            if (localRichCardNameElem.bytes_text.has())
            {
              localObject1 = localObject2;
              paramArrayOfByte.append(localRichCardNameElem.bytes_text.get().toStringUtf8());
            }
          }
        }
        localObject1 = localObject2;
        paramArrayOfByte = paramArrayOfByte.toString();
      }
      localObject1 = paramArrayOfByte;
      localObject2 = paramArrayOfByte;
      i = j;
      if (localCommCardNameBuf.uint32_cool_id.has())
      {
        localObject1 = paramArrayOfByte;
        i = localCommCardNameBuf.uint32_cool_id.get();
        localObject2 = paramArrayOfByte;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      localObject2 = localObject1;
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("ColorNick", 1, paramArrayOfByte, new Object[0]);
        i = j;
        localObject2 = localObject1;
      }
    }
    return new ColorNickManager.ColorNickNameData((String)localObject2, i);
  }
  
  public static ColorNickManager a(AppInterface paramAppInterface)
  {
    return ((VasExtensionManager)paramAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a;
  }
  
  public static CharSequence a(MessageRecord paramMessageRecord, MsgSummary paramMsgSummary)
  {
    if ((!TextUtils.isEmpty(paramMsgSummary.strContent)) || (!TextUtils.isEmpty(paramMsgSummary.suffix)))
    {
      SpannableString localSpannableString = null;
      if (!TextUtils.isEmpty(paramMsgSummary.strContent))
      {
        String str = paramMsgSummary.strContent.toString();
        localObject = str;
        if (!TextUtils.isEmpty(paramMsgSummary.strPrefix))
        {
          localObject = str;
          if (TextUtils.indexOf(paramMsgSummary.strContent, paramMsgSummary.strPrefix) == 0) {
            if (paramMsgSummary.strContent.length() > paramMsgSummary.strPrefix.length() + 2) {
              localObject = (String)str.subSequence(paramMsgSummary.strPrefix.length() + 2, paramMsgSummary.strContent.length());
            } else {
              localObject = "";
            }
          }
        }
      }
      else
      {
        localObject = paramMsgSummary.suffix.toString();
      }
      if (!TextUtils.isEmpty(paramMsgSummary.strPrefix)) {
        localSpannableString = new ColorNickText(paramMsgSummary.strPrefix, 16).a();
      }
      paramMessageRecord = a((String)localObject, paramMessageRecord, 16, 5);
      Object localObject = new SpannableStringBuilder();
      if (localSpannableString != null) {
        ((SpannableStringBuilder)localObject).append(localSpannableString).append(": ");
      }
      ((SpannableStringBuilder)localObject).append(paramMessageRecord);
      paramMsgSummary.strContent = new QQText((CharSequence)localObject, 5, 16);
    }
    return paramMsgSummary.strContent;
  }
  
  @org.jetbrains.annotations.Nullable
  private static CharSequence a(String paramString, int paramInt1, MessageRecord paramMessageRecord, int paramInt2, ArrayList<ColorNickManager.AtTroopMemberParagraph> paramArrayList)
  {
    if (paramArrayList.size() > 0)
    {
      paramArrayList = (ColorNickManager.AtTroopMemberParagraph[])paramArrayList.toArray(new ColorNickManager.AtTroopMemberParagraph[paramArrayList.size()]);
      Arrays.sort(paramArrayList, jdField_a_of_type_ComTencentMobileqqVasColorNickManager$AtParagraphComparator);
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      int k = paramArrayList.length;
      int i = 0;
      int j = 0;
      while (i < k)
      {
        Object localObject = paramArrayList[i];
        if (localObject.jdField_a_of_type_Int >= j) {
          localSpannableStringBuilder.append(new QQText(paramString.subSequence(j, localObject.b), paramInt2, paramInt1, paramMessageRecord));
        } else {
          localSpannableStringBuilder.append(localObject.jdField_a_of_type_AndroidTextSpannableString);
        }
        j = localObject.b;
        i += 1;
      }
      if (j < paramString.length()) {
        localSpannableStringBuilder.append(new QQText(paramString.subSequence(j, paramString.length()), paramInt2, paramInt1, paramMessageRecord));
      }
      return localSpannableStringBuilder;
    }
    return null;
  }
  
  public static CharSequence a(String paramString, MessageRecord paramMessageRecord, int paramInt1, int paramInt2)
  {
    Object localObject1;
    if (paramMessageRecord != null)
    {
      localObject2 = paramMessageRecord.getExtInfoFromExtStr(MessageConstants.i);
      localObject1 = localObject2;
      if ((paramMessageRecord instanceof MessageForReplyText))
      {
        MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramMessageRecord;
        localObject1 = localObject2;
        if (localMessageForReplyText.mSourceMsgInfo != null) {
          localObject1 = ReplyedMessageSpan.a(localMessageForReplyText.mSourceMsgInfo.mSourceMsgSenderUin, (String)localObject2);
        }
      }
      localObject1 = a(paramString, (String)localObject1, paramInt1, paramMessageRecord, paramInt2);
    }
    else
    {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new QQText(paramString, paramInt2, paramInt1, paramMessageRecord);
    }
    return localObject2;
  }
  
  public static CharSequence a(String paramString1, String paramString2, int paramInt1, MessageRecord paramMessageRecord, int paramInt2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString2 = MessageForText.getTroopMemberInfoFromExtrJson(paramString2);
      if ((paramString2 != null) && (paramString2.size() > 0))
      {
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < paramString2.size())
        {
          AtTroopMemberInfo localAtTroopMemberInfo = (AtTroopMemberInfo)paramString2.get(i);
          if ((localAtTroopMemberInfo.startPos >= 0) && (localAtTroopMemberInfo.startPos + localAtTroopMemberInfo.textLen <= paramString1.length()))
          {
            ColorNickManager.AtTroopMemberParagraph localAtTroopMemberParagraph = new ColorNickManager.AtTroopMemberParagraph(null);
            localAtTroopMemberParagraph.jdField_a_of_type_Int = localAtTroopMemberInfo.startPos;
            int j;
            if (localAtTroopMemberInfo.startPos + localAtTroopMemberInfo.textLen > paramString1.length())
            {
              j = paramString1.length();
            }
            else
            {
              j = localAtTroopMemberInfo.startPos;
              j = localAtTroopMemberInfo.textLen + j;
            }
            localAtTroopMemberParagraph.b = j;
            localAtTroopMemberParagraph.jdField_a_of_type_AndroidTextSpannableString = new ColorNickText(paramString1.subSequence(localAtTroopMemberParagraph.jdField_a_of_type_Int, localAtTroopMemberParagraph.b), paramInt1).a();
            localArrayList.add(localAtTroopMemberParagraph);
          }
          i += 1;
        }
        paramString2 = a(paramString1, paramInt1, paramMessageRecord, paramInt2, localArrayList);
        if (paramString2 != null) {
          return paramString2;
        }
      }
    }
    return new QQText(paramString1, paramInt2, paramInt1, paramMessageRecord);
  }
  
  @NotNull
  public static String a(ByteStringMicro paramByteStringMicro)
  {
    String str2 = b(paramByteStringMicro.toByteArray());
    String str1 = str2;
    if (str2 == null) {
      str1 = paramByteStringMicro.toStringUtf8();
    }
    return str1;
  }
  
  public static String a(ColorNickColorPanelAdapter.ColorItem paramColorItem)
  {
    char[] arrayOfChar = new char[7];
    int i = 0;
    arrayOfChar[0] = '<';
    arrayOfChar[1] = '%';
    arrayOfChar[2] = ((char)(paramColorItem.b >>> 24 & 0xFF));
    arrayOfChar[3] = ((char)(paramColorItem.b >>> 16 & 0xFF));
    arrayOfChar[4] = ((char)(paramColorItem.b >>> 8 & 0xFF));
    arrayOfChar[5] = ((char)(paramColorItem.b & 0xFF));
    arrayOfChar[6] = '>';
    if (paramColorItem.jdField_a_of_type_Int == 2)
    {
      if (paramColorItem.b == 0) {
        return "";
      }
      arrayOfChar[1] = '&';
    }
    while (i < arrayOfChar.length)
    {
      if (arrayOfChar[i] == 0) {
        arrayOfChar[i] = 'Ā';
      }
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append(paramString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("xydata.json");
    return localStringBuilder.toString();
  }
  
  @NotNull
  public static String a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, Charset.forName("UTF-8"));
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      label17:
      break label17;
    }
    return "";
  }
  
  public static List<ColorClearableEditText.Paragraph> a(int paramInt1, String paramString, Paint paramPaint, ColorClearableEditText.SpanComparator paramSpanComparator, int paramInt2)
  {
    Object localObject = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    ColorClearableEditText.a((List)localObject, paramSpanComparator, new ColorNickText(paramString, paramInt2).a());
    int i = (int)Math.ceil(paramPaint.measureText("..."));
    paramString = ((ArrayList)localObject).iterator();
    paramInt2 = 0;
    while (paramString.hasNext())
    {
      paramSpanComparator = (ColorClearableEditText.Paragraph)paramString.next();
      int j = paramSpanComparator.c;
      if (j != 1)
      {
        if (j != 2)
        {
          if (j == 3) {
            localArrayList.add(paramSpanComparator);
          }
        }
        else
        {
          j = ((EmoticonSpan)paramSpanComparator.jdField_a_of_type_AndroidTextStyleCharacterStyle).getDrawable().getBounds().width();
          if (j > paramInt1 - paramInt2 - i)
          {
            localArrayList.add(new ColorClearableEditText.Paragraph(1, paramSpanComparator.jdField_a_of_type_Int, paramSpanComparator.b, "...", null));
            return localArrayList;
          }
          localArrayList.add(paramSpanComparator);
          paramInt2 += j;
        }
      }
      else
      {
        localObject = SceneBuilder.a(paramInt1 - paramInt2, paramSpanComparator.jdField_a_of_type_JavaLangString, paramPaint);
        if (((String)localObject).equals(paramSpanComparator.jdField_a_of_type_JavaLangString))
        {
          paramInt2 += (int)Math.ceil(paramPaint.measureText(paramSpanComparator.jdField_a_of_type_JavaLangString));
          localArrayList.add(paramSpanComparator);
        }
        else
        {
          paramSpanComparator.jdField_a_of_type_JavaLangString = ((String)localObject);
          localArrayList.add(paramSpanComparator);
        }
      }
    }
    return localArrayList;
  }
  
  public static void a(TextView paramTextView, Spannable paramSpannable, int paramInt)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      a((QQAppInterface)localAppRuntime, paramTextView, paramSpannable, paramInt, false);
    }
  }
  
  private static void a(TextView paramTextView, ColorNickManager.ColorNickColor paramColorNickColor)
  {
    if (paramColorNickColor != null)
    {
      if ((paramTextView instanceof ColorClearableEditText))
      {
        paramTextView.setTextColor(-16777216);
        ((ColorClearableEditText)paramTextView).setSpecialColor(paramColorNickColor.jdField_a_of_type_Int, paramColorNickColor.jdField_a_of_type_ArrayOfInt, paramColorNickColor.jdField_a_of_type_ArrayOfFloat, paramColorNickColor.b, paramColorNickColor.jdField_a_of_type_AndroidGraphicsBitmap);
        return;
      }
      if ((paramTextView instanceof ColorNickTextView))
      {
        paramTextView.setTextColor(-16777216);
        paramTextView = (ColorNickTextView)paramTextView;
        paramTextView.setSpecialColor(paramColorNickColor.jdField_a_of_type_Int, paramColorNickColor.jdField_a_of_type_ArrayOfInt, paramColorNickColor.jdField_a_of_type_ArrayOfFloat, paramColorNickColor.b, paramColorNickColor.jdField_a_of_type_AndroidGraphicsBitmap);
        paramTextView.a = false;
        return;
      }
      if ((paramTextView instanceof QColorNickTextView))
      {
        paramTextView.setTextColor(-16777216);
        paramTextView = (QColorNickTextView)paramTextView;
        paramTextView.setSpecialColor(paramColorNickColor.jdField_a_of_type_Int, paramColorNickColor.jdField_a_of_type_ArrayOfInt, paramColorNickColor.jdField_a_of_type_ArrayOfFloat, paramColorNickColor.b, paramColorNickColor.jdField_a_of_type_AndroidGraphicsBitmap);
        paramTextView.needRefreshSpecialColor = false;
      }
    }
    else
    {
      if ((paramTextView instanceof ColorNickTextView))
      {
        ((ColorNickTextView)paramTextView).a = true;
        return;
      }
      if ((paramTextView instanceof QColorNickTextView)) {
        ((QColorNickTextView)paramTextView).needRefreshSpecialColor = true;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, TextView paramTextView, Spannable paramSpannable)
  {
    a(paramTextView, paramSpannable, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, TextView paramTextView, Spannable paramSpannable, int paramInt, boolean paramBoolean)
  {
    if (SimpleUIUtil.a()) {
      return;
    }
    Object localObject = (ColorSpan[])paramSpannable.getSpans(0, paramSpannable.length(), ColorSpan.class);
    if ((localObject != null) && (localObject.length > 0))
    {
      localObject = localObject[0];
      if (((ColorSpan)localObject).jdField_a_of_type_Int == 2)
      {
        paramTextView.setTextColor(((ColorSpan)localObject).b);
        if ((paramTextView instanceof ColorClearableEditText)) {
          ((ColorClearableEditText)paramTextView).setSpecialColor(0, null, null, 0, null);
        } else if ((paramTextView instanceof ColorNickTextView)) {
          ((ColorNickTextView)paramTextView).setSpecialColor(0, null, null, 0, null);
        } else if ((paramSpannable instanceof QColorNickTextView)) {
          ((QColorNickTextView)paramTextView).setSpecialColor(0, null, null, 0, null);
        }
      }
      else if (((ColorSpan)localObject).jdField_a_of_type_Int == 3)
      {
        a(paramTextView, a(paramQQAppInterface).a(((ColorSpan)localObject).b));
      }
    }
    else if ((paramTextView instanceof ColorClearableEditText))
    {
      ((ColorClearableEditText)paramTextView).setSpecialColor(0, null, null, 0, null);
    }
    else if ((paramTextView instanceof ColorNickTextView))
    {
      ((ColorNickTextView)paramTextView).setSpecialColor(0, null, null, 0, null);
    }
    TroopNickNameHelper.a(paramTextView, paramTextView.getContext(), paramInt, paramBoolean);
  }
  
  public static void a(DraftTextInfo paramDraftTextInfo, XEditTextEx paramXEditTextEx, String paramString1, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, String paramString2)
  {
    if ((paramDraftTextInfo != null) && (!TextUtils.isEmpty(paramDraftTextInfo.mAtInfoStr)) && (!TextUtils.isEmpty(paramString1)))
    {
      paramDraftTextInfo = MessageForText.getTroopMemberInfoFromExtrJson(paramDraftTextInfo.mAtInfoStr);
      if (paramDraftTextInfo != null)
      {
        paramDraftTextInfo = paramDraftTextInfo.iterator();
        while (paramDraftTextInfo.hasNext())
        {
          AtTroopMemberInfo localAtTroopMemberInfo = (AtTroopMemberInfo)paramDraftTextInfo.next();
          if (localAtTroopMemberInfo.startPos <= paramXEditTextEx.getEditableText().length()) {
            if (localAtTroopMemberInfo.startPos + localAtTroopMemberInfo.textLen + 1 <= paramXEditTextEx.getEditableText().length())
            {
              SpannableString localSpannableString = AtTroopMemberSpan.a(paramQQAppInterface, paramBaseActivity, paramString2, Long.toString(localAtTroopMemberInfo.uin), paramString1.substring(localAtTroopMemberInfo.startPos + 1, localAtTroopMemberInfo.startPos + localAtTroopMemberInfo.textLen), false, paramXEditTextEx, true);
              if (localSpannableString != null) {
                paramXEditTextEx.getEditableText().replace(localAtTroopMemberInfo.startPos, localAtTroopMemberInfo.startPos + localAtTroopMemberInfo.textLen + 1, localSpannableString);
              }
            }
          }
        }
      }
    }
  }
  
  public static void a(ISmallEmoticonInfo paramISmallEmoticonInfo, QQAppInterface paramQQAppInterface, EditText paramEditText)
  {
    if (paramISmallEmoticonInfo.getEmoticon() == null)
    {
      VasReportUtils.a("emotionType", "emotionActionSend", "1", "", "", "", "", "", "", "");
      QLog.e("ColorNick", 1, "fail to send small_emotion.");
      return;
    }
    try
    {
      int i = Integer.parseInt(paramISmallEmoticonInfo.getEmoticon().eId);
      int j = Integer.parseInt(paramISmallEmoticonInfo.getEmoticon().epId);
      ((IEmoticonManagerService)paramQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticonPackage(String.valueOf(j), new ColorNickManager.1(j, i, paramEditText));
      return;
    }
    catch (NumberFormatException paramISmallEmoticonInfo)
    {
      label112:
      break label112;
    }
    VasReportUtils.a("emotionType", "emotionActionSend", "4", "", "", "", "", "", "", "");
    QLog.e("ColorNick", 1, "fail to send small_emotion. id is not Int.");
  }
  
  private void a(ColorNickManager.ColorNickColor paramColorNickColor, JSONObject paramJSONObject)
  {
    if ((paramColorNickColor.jdField_a_of_type_Int == 1) || (paramColorNickColor.jdField_a_of_type_Int == 2) || (paramColorNickColor.jdField_a_of_type_Int == 3))
    {
      paramJSONObject = paramJSONObject.optJSONArray("positions");
      if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
      {
        paramColorNickColor.jdField_a_of_type_ArrayOfFloat = new float[paramJSONObject.length()];
        int i = 0;
        while (i < paramJSONObject.length())
        {
          String str = paramJSONObject.getString(i);
          if (TextUtils.isDigitsOnly(str))
          {
            int j = Integer.parseInt(str);
            paramColorNickColor.jdField_a_of_type_ArrayOfFloat[i] = (j / 100.0F);
          }
          i += 1;
        }
      }
    }
  }
  
  private void a(List<ColorClearableEditText.Paragraph> paramList, Paint paramPaint, ColorNickManager.ColorNickColor paramColorNickColor, Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    Paint localPaint = new Paint(paramPaint);
    Rect localRect = new Rect();
    int j = 0;
    int k = 0;
    while (k < paramList.size())
    {
      ColorClearableEditText.Paragraph localParagraph = (ColorClearableEditText.Paragraph)paramList.get(k);
      int i = localParagraph.c;
      if (i != 1)
      {
        if (i == 2) {
          paramFloat1 += ((EmoticonSpan)localParagraph.jdField_a_of_type_AndroidTextStyleCharacterStyle).getDrawable().getBounds().width();
        }
      }
      else
      {
        i = j;
        if (j == 0)
        {
          paramPaint.getTextBounds(localParagraph.jdField_a_of_type_JavaLangString, 0, localParagraph.jdField_a_of_type_JavaLangString.length(), localRect);
          i = localRect.height();
        }
        int m;
        for (j = 0; j < localParagraph.jdField_a_of_type_JavaLangString.length(); j = m)
        {
          String str = localParagraph.jdField_a_of_type_JavaLangString;
          m = j + 1;
          float f5 = paramPaint.measureText(str, j, m);
          if (paramColorNickColor.b == 1) {
            f1 = paramFloat1;
          } else {
            f1 = f5 * 0.5F + paramFloat1;
          }
          if (paramColorNickColor.b == 1)
          {
            f2 = i;
            f2 = f2 * 0.5F + paramFloat2 - f2;
          }
          else
          {
            f2 = paramFloat2 - i;
          }
          float f3;
          if (paramColorNickColor.b == 1) {
            f3 = paramFloat1 + f5;
          } else {
            f3 = f5 * 0.5F + paramFloat1;
          }
          float f4;
          if (paramColorNickColor.b == 1)
          {
            f4 = i;
            f4 = 0.5F * f4 + paramFloat2 - f4;
          }
          else
          {
            f4 = i;
          }
          localPaint.setShader(new LinearGradient(f1, f2, f3, f4, paramColorNickColor.jdField_a_of_type_ArrayOfInt, paramColorNickColor.jdField_a_of_type_ArrayOfFloat, Shader.TileMode.CLAMP));
          localPaint.setStyle(Paint.Style.FILL);
          float f2 = i;
          float f1 = paramFloat1 + f5;
          paramCanvas.drawRect(paramFloat1, paramFloat2 - f2, f1, paramFloat2, localPaint);
          paramFloat1 = f1;
        }
        j = i;
      }
      k += 1;
    }
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramString.length())
    {
      if (paramString.charAt(i) == '<')
      {
        int j = paramString.indexOf('>', i);
        if (j > 0) {
          i = j;
        }
      }
      else
      {
        localStringBuilder.append(paramString.charAt(i));
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  @androidx.annotation.Nullable
  public static String b(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte).jdField_a_of_type_JavaLangString;
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilVector.contains(Integer.valueOf(paramInt)))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("downloadGradientConfig id = ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(" is downloading");
        QLog.d("ColorNick", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(paramInt));
    Object localObject = (IVasQuickUpdateService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "");
    ((IVasQuickUpdateService)localObject).addCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("groupnickitem.");
    localStringBuilder.append(paramInt);
    ((IVasQuickUpdateService)localObject).downloadItem(27L, localStringBuilder.toString(), "ColorNickManager");
  }
  
  public Shader a(int paramInt1, List<ColorClearableEditText.Paragraph> paramList, float paramFloat1, float paramFloat2, Rect paramRect, Paint paramPaint, int paramInt2, int paramInt3)
  {
    ColorNickManager.ColorNickColor localColorNickColor = a(paramInt1);
    if (localColorNickColor == null) {
      return null;
    }
    paramInt1 = localColorNickColor.jdField_a_of_type_Int;
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3)
        {
          if (paramInt1 != 4)
          {
            if (paramInt1 != 5) {
              return null;
            }
            if (localColorNickColor.jdField_a_of_type_AndroidGraphicsBitmap != null)
            {
              paramList = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
              localObject = new Canvas(paramList);
              paramInt1 = localColorNickColor.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
              Rect localRect1 = new Rect();
              Rect localRect2 = new Rect(0, 0, paramInt1, localColorNickColor.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
              paramFloat1 = 0.0F;
              while (paramFloat1 < paramRect.width())
              {
                paramInt2 = (int)paramFloat1;
                paramFloat1 += paramInt1;
                localRect1.set(paramInt2, 0, (int)paramFloat1, paramInt3);
                ((Canvas)localObject).drawBitmap(localColorNickColor.jdField_a_of_type_AndroidGraphicsBitmap, localRect2, localRect1, paramPaint);
              }
              return new BitmapShader(paramList, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
            }
            return null;
          }
          return a(paramList, paramFloat1, paramPaint, paramInt2, paramInt3, localColorNickColor);
        }
        return new RadialGradient(paramFloat1 + paramRect.width() / 2, paramFloat2 + paramRect.height() / 2, paramRect.width() / 2, localColorNickColor.jdField_a_of_type_ArrayOfInt, localColorNickColor.jdField_a_of_type_ArrayOfFloat, Shader.TileMode.CLAMP);
      }
      Object localObject = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
      a(paramList, paramPaint, localColorNickColor, new Canvas((Bitmap)localObject), paramFloat1, paramFloat2 + paramRect.height());
      return new BitmapShader((Bitmap)localObject, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }
    return a(paramFloat1, paramFloat2, paramRect, localColorNickColor);
  }
  
  public ColorNickManager.ColorNickColor a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt))) {
      return (ColorNickManager.ColorNickColor)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    }
    a(paramInt);
    return null;
  }
  
  void a(int paramInt)
  {
    ThreadManagerV2.excute(new ColorNickManager.2(this, paramInt), 64, null, true);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ColorNickManager
 * JD-Core Version:    0.7.0.1
 */