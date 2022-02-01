package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.Editable;
import android.widget.EditText;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.api.IEmoticonInfoService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class SystemEmoticonInfo
  extends EmoticonInfo
  implements Parcelable
{
  public static final int[] APOLLO_EMOTICON_ORDER;
  public static final Parcelable.Creator<SystemEmoticonInfo> CREATOR = new SystemEmoticonInfo.1();
  public static final String KEY_STATIC_DRAWABLE_ID = "KEY_STATIC_DRAWABLE_ID";
  private static int[] SYS_EMOTION_ORDER = { 23, 40, 19, 43, 21, 9, 20, 106, 35, 10, 25, 24, 1, 0, 33, 32, 12, 27, 13, 22, 3, 18, 30, 31, 81, 82, 26, 2, 37, 50, 42, 83, 34, 11, 49, 84, 39, 78, 5, 4, 6, 85, 86, 87, 46, 88, 44, 89, 48, 14, 90, 41, 36, 91, 51, 164, 174, 171, 165, 166, 161, 167, 170, 169, 172, 173, 168, 175, 17, 60, 61, 92, 93, 163, 66, 58, 7, 8, 57, 29, 28, 74, 59, 80, 16, 70, 77, 62, 15, 68, 75, 76, 45, 52, 53, 54, 55, 56, 63, 73, 72, 65, 94, 64, 38, 47, 95, 71, 96, 97, 98, 99, 100, 79, 101, 102, 103, 104, 105, 108, 109, 110, 112, 116, 118, 119, 120, 123, 130, 140, 141, 180, 184, 176, 177, 182, 179, 185, 143, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 159, 160, 214, 215, 216, 187, 209, 198, 186, 189, 212, 188, 190, 201, 210, 191, 197, 203, 205, 193, 194, 211, 204, 192, 207, 213, 202, 196, 208, 200, 206, 195, 199 };
  private static final String TAG = "SystemEmoticonInfo";
  private static boolean parsed;
  public static HashMap<String, List<Integer>> sNewApolloEmoticonMap;
  private static int[] sortedOrderList;
  public int code;
  
  static
  {
    APOLLO_EMOTICON_ORDER = new int[] { 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216 };
    sNewApolloEmoticonMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(214));
    localArrayList.add(Integer.valueOf(215));
    localArrayList.add(Integer.valueOf(216));
    sNewApolloEmoticonMap.put("8.0.0", localArrayList);
    sortedOrderList = null;
  }
  
  public SystemEmoticonInfo() {}
  
  protected SystemEmoticonInfo(Parcel paramParcel)
  {
    super(paramParcel);
    this.code = paramParcel.readInt();
  }
  
  public static List<EmoticonInfo> getEmoticonList(int[] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      SystemEmoticonInfo localSystemEmoticonInfo = new SystemEmoticonInfo();
      localSystemEmoticonInfo.code = paramArrayOfInt[i];
      localSystemEmoticonInfo.type = 1;
      localArrayList.add(localSystemEmoticonInfo);
      i += 1;
    }
    return localArrayList;
  }
  
  private static int[] getSortedOrderList()
  {
    if (sortedOrderList == null)
    {
      int[] arrayOfInt = SYS_EMOTION_ORDER;
      arrayOfInt = Arrays.copyOf(arrayOfInt, arrayOfInt.length);
      Arrays.sort(arrayOfInt);
      sortedOrderList = arrayOfInt;
    }
    return sortedOrderList;
  }
  
  public static int[] getSysEmotionOrder()
  {
    return SYS_EMOTION_ORDER;
  }
  
  public static boolean isCodeCanShow(int paramInt)
  {
    return Arrays.binarySearch(getSortedOrderList(), paramInt) >= 0;
  }
  
  public static boolean parseWhiteList(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    if ((!paramBoolean) && (parsed)) {
      return true;
    }
    paramAppRuntime = ((IEmoticonInfoService)QRoute.api(IEmoticonInfoService.class)).getJSONFromLocal(paramAppRuntime, true);
    if (paramAppRuntime != null) {}
    for (;;)
    {
      int i;
      int k;
      try
      {
        paramAppRuntime = paramAppRuntime.optJSONArray("systemEmojiWhiteList");
        i = 0;
        Object localObject = paramAppRuntime.optJSONObject(0).optJSONArray("androidEmoticonWhiteList");
        paramAppRuntime = new int[((JSONArray)localObject).length()];
        int m = ((JSONArray)localObject).length();
        j = 0;
        if (i < m)
        {
          int n = ((JSONArray)localObject).optInt(i, -1);
          k = j;
          if (n < 0) {
            break label240;
          }
          k = j;
          if (n >= EmotcationConstants.VALID_SYS_EMOTCATION_COUNT) {
            break label240;
          }
          paramAppRuntime[j] = n;
          k = j + 1;
          break label240;
        }
        if (j == 0)
        {
          QLog.e("SystemEmoticonInfo", 1, "parseWhiteList no valid emoticon, use default");
          return true;
        }
        localObject = Arrays.copyOf(paramAppRuntime, j);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("newOrderList: ");
          localStringBuilder.append(Arrays.toString((int[])localObject));
          QLog.d("SystemEmoticonInfo", 2, localStringBuilder.toString());
        }
        paramAppRuntime = Arrays.copyOf(paramAppRuntime, j);
        Arrays.sort(paramAppRuntime);
        SYS_EMOTION_ORDER = (int[])localObject;
        sortedOrderList = paramAppRuntime;
        parsed = true;
      }
      catch (Throwable paramAppRuntime)
      {
        QLog.e("SystemEmoticonInfo", 2, "parseWhiteList error", paramAppRuntime);
      }
      if (QLog.isColorLevel()) {
        QLog.d("SystemEmoticonInfo", 2, "parseWhiteList: local file not exist.");
      }
      return parsed;
      label240:
      i += 1;
      int j = k;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Drawable getBigDrawable(Context paramContext, float paramFloat)
  {
    return QQSysFaceUtil.getFaceGifDrawable(this.code);
  }
  
  public Drawable getDrawable(Context paramContext, float paramFloat)
  {
    return QQSysFaceUtil.getFaceDrawable(this.code);
  }
  
  public void send(AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable)
  {
    if (this.srcType == 1) {
      ReportController.b(null, "CliOper", "", "", "0X8005507", "0X8005507", 0, 0, "", "", "", "");
    } else if (this.srcType == 2) {
      ReportController.b(null, "CliOper", "", "", "0X8005508", "0X8005508", 0, 0, "", "", "", "");
    }
    int i = paramEditText.getSelectionStart();
    int j = paramEditText.getSelectionEnd();
    paramEditText.getEditableText().replace(i, j, QQSysFaceUtil.getFaceString(this.code));
    paramEditText.requestFocus();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.code);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemEmoticonInfo
 * JD-Core Version:    0.7.0.1
 */