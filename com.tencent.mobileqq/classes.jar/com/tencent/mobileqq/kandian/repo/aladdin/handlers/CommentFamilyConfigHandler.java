package com.tencent.mobileqq.kandian.repo.aladdin.handlers;

import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.AladdinParseUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJCommentFamilyConfigSp;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CommentFamilyConfigHandler
  extends SimpleConfigHandler
{
  public static String a = "CommentFamilyConfigHandler";
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    Object localObject1 = a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[onReceiveConfig] id=");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append(", version=");
    ((StringBuilder)localObject2).append(paramInt2);
    ((StringBuilder)localObject2).append(", content=");
    ((StringBuilder)localObject2).append(paramString);
    QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    paramString = AladdinParseUtils.a(paramString);
    localObject1 = paramString.keySet();
    try
    {
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        String str = (String)paramString.get(localObject2);
        if (TextUtils.equals((CharSequence)localObject2, "rij_comment_family_entrance_switch")) {
          RIJCommentFamilyConfigSp.a(Integer.parseInt(str));
        } else if (TextUtils.equals((CharSequence)localObject2, "rij_small_zhitiao_entrance_switch")) {
          RIJSPUtils.a("readinjjoy_notes_config", Integer.valueOf(Integer.parseInt(str)));
        }
      }
      return true;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    RIJCommentFamilyConfigSp.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.handlers.CommentFamilyConfigHandler
 * JD-Core Version:    0.7.0.1
 */