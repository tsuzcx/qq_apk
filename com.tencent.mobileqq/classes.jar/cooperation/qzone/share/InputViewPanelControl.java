package cooperation.qzone.share;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.QzoneTextBuilder;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcooperation.qzone.share.Friend;>;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputViewPanelControl
{
  public static String FormatAtUsers(String paramString, List<Friend> paramList)
  {
    if (paramString == null) {
      return null;
    }
    Object localObject = paramString;
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return paramString;
      }
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        localObject = paramString;
        if (!localIterator.hasNext()) {
          break;
        }
        Friend localFriend = (Friend)localIterator.next();
        localObject = localFriend.mName;
        paramList = (List<Friend>)localObject;
        if (localObject == null)
        {
          paramList = new StringBuilder();
          paramList.append(localFriend.mUin);
          paramList.append("");
          paramList = paramList.toString();
        }
        paramList = paramList.replace("%", "%25").replace(",", "%2C").replace("}", "%7D");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("@{uin:");
        ((StringBuilder)localObject).append(localFriend.mUin);
        ((StringBuilder)localObject).append(",nick:");
        ((StringBuilder)localObject).append(paramList);
        ((StringBuilder)localObject).append("}");
        paramList = ((StringBuilder)localObject).toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("@");
        ((StringBuilder)localObject).append(localFriend.mName);
        localObject = ((StringBuilder)localObject).toString();
        if ((!TextUtils.isEmpty(localFriend.mName)) && (paramString.contains((CharSequence)localObject))) {
          paramString = replaceFirst((String)localObject, paramString, paramList);
        }
      }
    }
    return localObject;
  }
  
  public static String ReplaceFormatUser(String paramString, List<Friend> paramList)
  {
    return FormatAtUsers(paramString, paramList);
  }
  
  public static int addAtUser(EditText paramEditText, ArrayList<ResultRecord> paramArrayList, List<Friend> paramList, int paramInt)
  {
    if (paramArrayList == null) {
      return paramInt;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Object localObject2 = (ResultRecord)paramArrayList.next();
      Object localObject1 = new Friend();
      if (!TextUtils.isEmpty(((ResultRecord)localObject2).name)) {
        ((Friend)localObject1).mName = ((ResultRecord)localObject2).name;
      } else {
        ((Friend)localObject1).mName = ((ResultRecord)localObject2).uin;
      }
      try
      {
        long l = Long.valueOf(((ResultRecord)localObject2).uin).longValue();
        ((Friend)localObject1).mUin = l;
        if ((((Friend)localObject1).mName != null) && (((Friend)localObject1).mUin != 0L))
        {
          if (paramList == null) {
            return paramInt;
          }
          paramList.add(localObject1);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("@");
          ((StringBuilder)localObject2).append(((Friend)localObject1).mName);
          ((StringBuilder)localObject2).append(" ");
          localObject1 = ((StringBuilder)localObject2).toString();
          int i = paramInt;
          if (paramInt < ((String)localObject1).length()) {
            i = ((String)localObject1).length();
          }
          insertStrToEdit((String)localObject1, paramEditText.getSelectionStart(), paramEditText);
          paramInt = i;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        label205:
        break label205;
      }
    }
    return paramInt;
  }
  
  public static String atUsersToString(List<Friend> paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if ((paramList != null) && (paramList.size() != 0))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Friend localFriend = (Friend)localIterator.next();
        Object localObject = localFriend.mName;
        paramList = (List<Friend>)localObject;
        if (localObject == null)
        {
          paramList = new StringBuilder();
          paramList.append(localFriend.mUin);
          paramList.append("");
          paramList = paramList.toString();
        }
        paramList = paramList.replace("%", "%25").replace(",", "%2C").replace("}", "%7D");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("@{uin:");
        ((StringBuilder)localObject).append(localFriend.mUin);
        ((StringBuilder)localObject).append(",nick:");
        ((StringBuilder)localObject).append(paramList);
        ((StringBuilder)localObject).append("}");
        localStringBuffer.append(((StringBuilder)localObject).toString());
      }
      return localStringBuffer.toString();
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
    if (paramCharSequence != null)
    {
      int j = paramCharSequence.length();
      int i = 1;
      if (j <= 1) {
        return -1;
      }
      if (paramCharSequence.length() <= paramInt1) {
        paramInt1 = paramCharSequence.length();
      }
      j = paramInt1 - 1;
      while ((j >= 0) && (i <= paramInt2))
      {
        if ((paramCharSequence.charAt(j) == '@') && (isMatchAt(paramCharSequence.toString().substring(j, paramInt1), false, paramList, paramInt3, paramInt4, paramString))) {
          return j;
        }
        j -= 1;
        i += 1;
      }
    }
    return -1;
  }
  
  public static String getEditText(EditText paramEditText, List<Friend> paramList)
  {
    if (paramEditText != null)
    {
      paramEditText = getPalinText(paramEditText);
      if (!TextUtils.isEmpty(paramEditText)) {
        return ReplaceFormatUser(paramEditText, paramList).replaceAll(HardCodeUtil.a(2131903747), HardCodeUtil.a(2131903751)).replaceAll(HardCodeUtil.a(2131903748), "/MM");
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
    Editable localEditable;
    if ((paramEditText != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (paramInt < 0) {
        return;
      }
      localEditable = QzoneTextBuilder.a.newEditable(paramEditText.getText());
      localEditable.insert(paramInt, paramString);
    }
    try
    {
      paramEditText.setText(localEditable);
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      label44:
      break label44;
    }
    localEditable.append(" ");
    paramEditText.setText(localEditable);
    paramEditText.setSelection(paramInt + paramString.length());
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
        if ((paramString2 != null) && (paramString2.mName != null) && (paramString1 != null))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("@");
          localStringBuilder.append(paramString2.mName);
          if (!paramString1.equalsIgnoreCase(localStringBuilder.toString()))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("@");
            localStringBuilder.append(paramString2.mName);
            localStringBuilder.append(" ");
            if (!paramString1.equalsIgnoreCase(localStringBuilder.toString())) {}
          }
          else
          {
            if (paramBoolean) {
              paramList.remove(paramInt1);
            }
            return true;
          }
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
      if ((paramEditText != null) && (paramEditText.contains(i, j))) {
        return true;
      }
    }
    if (paramView != null)
    {
      i = (int)paramMotionEvent.getX();
      paramInt1 = (int)(paramMotionEvent.getY() + paramInt1 + paramInt2);
      paramMotionEvent = getViewRect(paramView);
      if ((paramMotionEvent != null) && (paramMotionEvent.contains(i, paramInt1))) {
        return true;
      }
    }
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
    catch (Exception localException)
    {
      label17:
      break label17;
    }
    return replace(paramString2, paramString1, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.share.InputViewPanelControl
 * JD-Core Version:    0.7.0.1
 */