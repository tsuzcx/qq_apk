package cooperation.qzone.share;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import anvx;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.QzoneTextBuilder;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputViewPanelControl
{
  public static String FormatAtUsers(String paramString, List<Friend> paramList)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    do
    {
      do
      {
        return str;
        str = paramString;
      } while (paramList == null);
      str = paramString;
    } while (paramList.size() == 0);
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      str = paramString;
      if (!localIterator.hasNext()) {
        break;
      }
      Friend localFriend = (Friend)localIterator.next();
      str = localFriend.mName;
      paramList = str;
      if (str == null) {
        paramList = localFriend.mUin + "";
      }
      paramList = paramList.replace("%", "%25").replace(",", "%2C").replace("}", "%7D");
      paramList = "@{uin:" + localFriend.mUin + ",nick:" + paramList + "}";
      str = "@" + localFriend.mName;
      if ((!TextUtils.isEmpty(localFriend.mName)) && (paramString.contains(str))) {
        paramString = replaceFirst(str, paramString, paramList);
      }
    }
  }
  
  public static String ReplaceFormatUser(String paramString, List<Friend> paramList)
  {
    return FormatAtUsers(paramString, paramList);
  }
  
  public static int addAtUser(EditText paramEditText, ArrayList<ResultRecord> paramArrayList, List<Friend> paramList, int paramInt)
  {
    int i;
    if (paramArrayList == null)
    {
      i = paramInt;
      return i;
    }
    paramArrayList = paramArrayList.iterator();
    for (;;)
    {
      label15:
      i = paramInt;
      if (!paramArrayList.hasNext()) {
        break;
      }
      Object localObject = (ResultRecord)paramArrayList.next();
      Friend localFriend = new Friend();
      if (!TextUtils.isEmpty(((ResultRecord)localObject).name)) {}
      for (localFriend.mName = ((ResultRecord)localObject).name;; localFriend.mName = ((ResultRecord)localObject).uin) {
        try
        {
          long l = Long.valueOf(((ResultRecord)localObject).uin).longValue();
          localFriend.mUin = l;
          if ((localFriend.mName == null) || (localFriend.mUin == 0L)) {
            break label15;
          }
          i = paramInt;
          if (paramList == null) {
            break;
          }
          paramList.add(localFriend);
          localObject = "@" + localFriend.mName + " ";
          i = paramInt;
          if (paramInt < ((String)localObject).length()) {
            i = ((String)localObject).length();
          }
          insertStrToEdit((String)localObject, paramEditText.getSelectionStart(), paramEditText);
          paramInt = i;
        }
        catch (NumberFormatException localNumberFormatException) {}
      }
    }
  }
  
  public static String atUsersToString(List<Friend> paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if ((paramList == null) || (paramList.size() == 0)) {
      return localStringBuffer.toString();
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Friend localFriend = (Friend)localIterator.next();
      String str = localFriend.mName;
      paramList = str;
      if (str == null) {
        paramList = localFriend.mUin + "";
      }
      paramList = paramList.replace("%", "%25").replace(",", "%2C").replace("}", "%7D");
      localStringBuffer.append("@{uin:" + localFriend.mUin + ",nick:" + paramList + "}");
    }
    return localStringBuffer.toString();
  }
  
  public static SystemEmoticonPanel createEmoPanel(Context paramContext, EditText paramEditText)
  {
    try
    {
      paramContext = new SystemEmoticonPanel(paramContext, new InputViewPanelControl.1(paramEditText));
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      QLog.e("QZoneShareActivity", 1, paramContext.getStackTrace());
    }
    return null;
  }
  
  public static int findAtSymbol(CharSequence paramCharSequence, int paramInt1, int paramInt2, List<Friend> paramList, int paramInt3, int paramInt4, String paramString)
  {
    if ((paramCharSequence == null) || (paramCharSequence.length() <= 1)) {
      return -1;
    }
    int j;
    int i;
    if (paramCharSequence.length() > paramInt1)
    {
      j = paramInt1 - 1;
      i = 1;
    }
    for (;;)
    {
      if ((j < 0) || (i > paramInt2)) {
        break label112;
      }
      if ((paramCharSequence.charAt(j) == '@') && (isMatchAt(paramCharSequence.toString().substring(j, paramInt1), false, paramList, paramInt3, paramInt4, paramString)))
      {
        return j;
        paramInt1 = paramCharSequence.length();
        break;
      }
      j -= 1;
      i += 1;
    }
    label112:
    return -1;
  }
  
  public static String getEditText(EditText paramEditText, List<Friend> paramList)
  {
    if (paramEditText != null)
    {
      paramEditText = getPalinText(paramEditText);
      if (!TextUtils.isEmpty(paramEditText)) {
        return ReplaceFormatUser(paramEditText, paramList).replaceAll(anvx.a(2131705272), anvx.a(2131705276)).replaceAll(anvx.a(2131705273), "/MM");
      }
    }
    return "";
  }
  
  public static String getPalinText(EditText paramEditText)
  {
    if (paramEditText != null)
    {
      if ((paramEditText.getText() instanceof QQTextBuilder))
      {
        QQTextBuilder localQQTextBuilder = (QQTextBuilder)paramEditText.getText();
        if (localQQTextBuilder != null) {
          return localQQTextBuilder.toPlainText();
        }
      }
      if ((paramEditText != null) && (paramEditText.getEditableText() != null)) {
        return paramEditText.getEditableText().toString();
      }
    }
    return null;
  }
  
  public static Rect getViewRect(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    return new Rect(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getWidth(), arrayOfInt[1] + paramView.getHeight());
  }
  
  public static void insertStrToEdit(String paramString, int paramInt, EditText paramEditText)
  {
    if ((paramEditText == null) || (TextUtils.isEmpty(paramString)) || (paramInt < 0)) {
      return;
    }
    Editable localEditable = QzoneTextBuilder.EMOCTATION_FACORY.newEditable(paramEditText.getText());
    localEditable.insert(paramInt, paramString);
    try
    {
      paramEditText.setText(localEditable);
      paramEditText.setSelection(paramString.length() + paramInt);
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      for (;;)
      {
        localEditable.append(" ");
        paramEditText.setText(localEditable);
      }
    }
  }
  
  public static boolean isDelAt(int paramInt1, int paramInt2, String paramString)
  {
    return (paramInt1 != -1) && (paramInt2 != -1) && (paramString != null) && (paramString.length() > 0);
  }
  
  public static boolean isMatchAt(String paramString1, boolean paramBoolean, List<Friend> paramList, int paramInt1, int paramInt2, String paramString2)
  {
    if (((isDelAt(paramInt1, paramInt2, paramString2)) || (!paramBoolean)) && (paramList != null))
    {
      paramInt2 = paramList.size();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramString2 = (Friend)paramList.get(paramInt1);
        if ((paramString2 != null) && (paramString2.mName != null) && (paramString1 != null) && ((paramString1.equalsIgnoreCase("@" + paramString2.mName)) || (paramString1.equalsIgnoreCase("@" + paramString2.mName + " "))))
        {
          if (paramBoolean) {
            paramList.remove(paramInt1);
          }
          return true;
        }
        paramInt1 += 1;
      }
    }
    return false;
  }
  
  public static boolean isTouchSpecialView(MotionEvent paramMotionEvent, EditText paramEditText, int paramInt1, int paramInt2, View paramView)
  {
    int i;
    if (paramEditText != null)
    {
      i = (int)paramMotionEvent.getX();
      int j = (int)(paramMotionEvent.getY() + paramInt1 + paramInt2);
      paramEditText = getViewRect(paramEditText);
      if ((paramEditText == null) || (!paramEditText.contains(i, j))) {}
    }
    do
    {
      return true;
      if (paramView == null) {
        break;
      }
      i = (int)paramMotionEvent.getX();
      paramInt1 = (int)(paramMotionEvent.getY() + paramInt1 + paramInt2);
      paramMotionEvent = getViewRect(paramView);
    } while ((paramMotionEvent != null) && (paramMotionEvent.contains(i, paramInt1)));
    return false;
  }
  
  public static String replace(String paramString1, String paramString2, String paramString3)
  {
    int i = paramString1.indexOf(paramString2, 0);
    if (i == -1) {
      return paramString1;
    }
    paramString1 = new StringBuilder(paramString1);
    paramString1.replace(i, paramString2.length() + i, paramString3);
    return paramString1.toString();
  }
  
  public static String replaceFirst(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      String str = Pattern.compile(paramString1, 16).matcher(paramString2).replaceFirst(paramString3);
      return str;
    }
    catch (Exception localException) {}
    return replace(paramString2, paramString1, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.share.InputViewPanelControl
 * JD-Core Version:    0.7.0.1
 */