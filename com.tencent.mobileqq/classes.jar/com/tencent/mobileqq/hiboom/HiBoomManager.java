package com.tencent.mobileqq.hiboom;

import adfd;
import adfe;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONObject;

public class HiBoomManager
  implements Manager
{
  public static HiBoomFont.HiBoomFontDownloader a;
  private static final String a;
  public static HiBoomFont.HiBoomFontDownloader b;
  public int a;
  public Handler a;
  public QQAppInterface a;
  public final Object a;
  public Vector a;
  public AtomicBoolean a;
  public Vector b;
  
  static
  {
    jdField_a_of_type_JavaLangString = HiBoomFont.jdField_a_of_type_JavaLangString + "mine_list.json";
    jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader = new adfd();
    jdField_b_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader = new adfe();
  }
  
  public HiBoomManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    this.jdField_b_of_type_JavaUtilVector = new Vector();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramQQAppInterface.getPreferences().getInt("hiboom_select_id", 0);
  }
  
  public static String a(String paramString)
  {
    Object localObject2;
    if (android.text.TextUtils.isEmpty(paramString))
    {
      localObject2 = null;
      return localObject2;
    }
    Object localObject1 = "";
    int i = 0;
    for (;;)
    {
      localObject2 = localObject1;
      if (i >= paramString.length()) {
        break;
      }
      localObject2 = localObject1;
      if (paramString.charAt(i) != ' ')
      {
        localObject2 = localObject1;
        if (paramString.charAt(i) != '\n')
        {
          localObject2 = localObject1;
          if (paramString.charAt(i) != '\r') {
            localObject2 = (String)localObject1 + paramString.charAt(i);
          }
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont.HiBoomManager", 2, "getRecommendListFromJSON");
    }
    ??? = FileUtils.a(VasQuickUpdateManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1000L, "xydata.qim.hifont.recommend.json", null, paramBoolean, null), -1);
    if (??? != null) {
      for (;;)
      {
        int i;
        try
        {
          ??? = new JSONArray((String)???);
          this.jdField_b_of_type_JavaUtilVector.clear();
          i = 0;
          if (i < ((JSONArray)???).length())
          {
            HiBoomItem localHiBoomItem = new HiBoomItem();
            localHiBoomItem.c = 1;
            Object localObject3 = ((JSONArray)???).getJSONObject(i);
            Object localObject4 = ((JSONObject)localObject3).optString("id");
            if (android.text.TextUtils.isDigitsOnly((CharSequence)localObject4)) {
              localHiBoomItem.jdField_a_of_type_Int = Integer.parseInt((String)localObject4);
            }
            localHiBoomItem.g = ((JSONObject)localObject3).optString("imgUrl");
            if (!android.text.TextUtils.isEmpty(localHiBoomItem.g))
            {
              localObject4 = URLDrawable.getDrawable(localHiBoomItem.g, URLDrawable.URLDrawableOptions.obtain());
              ((URLDrawable)localObject4).startDownload();
              localHiBoomItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject4);
            }
            localHiBoomItem.h = ((JSONObject)localObject3).optString("tagUrl");
            if (android.text.TextUtils.isEmpty(localHiBoomItem.h)) {
              break label333;
            }
            localObject3 = URLDrawable.getDrawable(localHiBoomItem.h, URLDrawable.URLDrawableOptions.obtain());
            ((URLDrawable)localObject3).startDownload();
            localHiBoomItem.b = ((Drawable)localObject3);
            break label333;
            if (j < this.jdField_a_of_type_JavaUtilVector.size())
            {
              if (((HiBoomItem)this.jdField_a_of_type_JavaUtilVector.get(j)).jdField_a_of_type_Int != localHiBoomItem.jdField_a_of_type_Int) {
                break label345;
              }
              j = 1;
              if (j != 0) {
                break label338;
              }
              this.jdField_b_of_type_JavaUtilVector.add(localHiBoomItem);
              break label338;
            }
          }
          else
          {
            synchronized (this.jdField_a_of_type_JavaLangObject)
            {
              if (this.jdField_a_of_type_AndroidOsHandler != null) {
                this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
              }
              return;
            }
          }
          j = 0;
        }
        catch (Exception localException)
        {
          QLog.e("HiBoomFont.HiBoomManager", 1, "getRecommendListFromJSON error: ", localException);
          return;
        }
        continue;
        label333:
        int j = 0;
        continue;
        label338:
        i += 1;
        continue;
        label345:
        j += 1;
      }
    }
  }
  
  public boolean a()
  {
    Object localObject = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(216)).b();
    if (!android.text.TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split(":");
      if (localObject.length == 2)
      {
        int i = Integer.valueOf(localObject[0]).intValue();
        int j = Integer.valueOf(localObject[1]).intValue();
        if (i == 1)
        {
          localObject = this.jdField_b_of_type_JavaUtilVector.iterator();
          while (((Iterator)localObject).hasNext()) {
            if (((HiBoomItem)((Iterator)localObject).next()).jdField_a_of_type_Int == j) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }
  
  public boolean a(BaseChatPie paramBaseChatPie, String paramString, int paramInt)
  {
    int i;
    if ((paramBaseChatPie.b() != 1008) && (paramBaseChatPie.b() != 7200) && (!AnonymousChatHelper.a().a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      i = 1;
      if (i != 0)
      {
        paramString = a(paramString);
        if (!android.text.TextUtils.isEmpty(paramString)) {
          break label64;
        }
      }
    }
    label64:
    do
    {
      return false;
      i = 0;
      break;
      if (paramString.length() > 20) {
        break label180;
      }
      if (!com.tencent.mobileqq.text.TextUtils.a(paramString)) {
        break label142;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("HiBoom_CHN_Tips", false));
    QQToast.a(paramBaseChatPie.jdField_a_of_type_AndroidContentContext, "嗨爆字体暂不支持带表情的文字输入", 0).a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putBoolean("HiBoom_CHN_Tips", true).apply();
    return false;
    label142:
    HiBoomMessage localHiBoomMessage = new HiBoomMessage();
    localHiBoomMessage.id = paramInt;
    localHiBoomMessage.text = paramString;
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localHiBoomMessage, null);
    return true;
    label180:
    QQToast.a(paramBaseChatPie.jdField_a_of_type_AndroidContentContext, "嗨爆字体不能超过20字", 0).a();
    return false;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomManager
 * JD-Core Version:    0.7.0.1
 */