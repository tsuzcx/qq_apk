import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.newshare.util.StoryBasicShareUtils.2;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import java.net.URLEncoder;
import java.util.ArrayList;

public class tff
{
  private static void a(Context paramContext, tes paramtes, tcp paramtcp)
  {
    try
    {
      mpb.a(paramContext, paramtes.jdField_a_of_type_JavaLangString);
      if (paramtcp != null) {
        paramtcp.a(paramtes);
      }
      return;
    }
    catch (Throwable paramContext)
    {
      while (paramtcp == null) {}
      paramtcp.b(paramtes);
    }
  }
  
  public static void a(Context paramContext, tet paramtet, tcp paramtcp)
  {
    urk.b("StoryBasicShareUtils", "share() data = %s", paramtet.toString());
    if ((paramtet instanceof teu))
    {
      a(paramContext, (teu)paramtet, paramtcp);
      return;
    }
    if ((paramtet instanceof tes))
    {
      a(paramContext, (tes)paramtet, paramtcp);
      return;
    }
    if ((paramtet instanceof tev))
    {
      a(paramContext, (tev)paramtet, paramtcp);
      return;
    }
    if ((paramtet instanceof tex))
    {
      paramContext = (tex)paramtet;
      a(paramContext, paramContext.jdField_a_of_type_Boolean, paramtcp);
      return;
    }
    if ((paramtet instanceof tew))
    {
      a(paramContext, (tew)paramtet, paramtcp);
      return;
    }
    paramtcp.a(paramtet);
  }
  
  private static void a(Context paramContext, teu paramteu, tcp paramtcp)
  {
    switch (paramteu.b)
    {
    default: 
      return;
    case 0: 
      paramtcp = new MessageForQQStory();
      paramtcp.authorName = paramteu.i;
      paramtcp.brief = paramteu.jdField_d_of_type_JavaLangString;
      paramtcp.briefBgColor = paramteu.jdField_c_of_type_Int;
      paramtcp.coverImgUrl = paramteu.jdField_a_of_type_JavaLangString;
      paramtcp.logoImgUrl = paramteu.jdField_c_of_type_JavaLangString;
      paramtcp.msgAction = paramteu.h;
      paramtcp.srcAction = paramteu.g;
      paramtcp.srcName = paramteu.f;
      paramtcp.type = paramteu.jdField_e_of_type_Int;
      paramtcp.mVid = paramteu.jdField_e_of_type_JavaLangString;
      paramtcp.storyTitle = paramteu.o;
      paramtcp.storyBrief = paramteu.p;
      azsq.a((Activity)paramContext, paramtcp, 29782);
      return;
    case 1: 
      if (baic.a(paramContext, 29, paramteu.jdField_d_of_type_Int, "web_share", paramteu.n, paramteu.jdField_a_of_type_JavaLangString, paramteu.k, paramteu.l, paramteu.jdField_d_of_type_JavaLangString, paramteu.jdField_a_of_type_JavaLangString, "plugin", null, paramteu.h, paramteu.h, "plugin", null, paramteu.g, paramteu.g, null, paramteu.f, null, paramteu.m, true))
      {
        paramtcp.a(paramteu);
        return;
      }
      paramtcp.b(paramteu);
      return;
    }
    baic.a(paramContext, 1001, 1, "web_share", "", paramteu.jdField_a_of_type_JavaLangString, paramteu.k, paramteu.l, paramteu.jdField_d_of_type_JavaLangString, paramteu.h, "web", null, null, null, "plugin", paramteu.g, null, null, null, paramteu.f, null, null, 29782, null, -1L);
  }
  
  private static void a(Context paramContext, tev paramtev, tcp paramtcp)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Bundle localBundle = new Bundle();
    Object localObject;
    if (TextUtils.isEmpty(paramtev.jdField_c_of_type_JavaLangString))
    {
      localObject = paramtev.jdField_e_of_type_JavaLangString;
      localBundle.putString("title", (String)localObject);
      if (!TextUtils.isEmpty(paramtev.jdField_d_of_type_JavaLangString)) {
        break label151;
      }
      localObject = paramtev.jdField_e_of_type_JavaLangString;
      label58:
      localBundle.putString("desc", (String)localObject);
      localBundle.putString("detail_url", paramtev.jdField_e_of_type_JavaLangString);
      localObject = new ArrayList(1);
      ((ArrayList)localObject).add(paramtev.jdField_a_of_type_JavaLangString);
      localBundle.putStringArrayList("image_url", (ArrayList)localObject);
      localBundle.putLong("req_share_id", 0L);
      localBundle.putInt("iUrlInfoFrm", 0);
      if (!bfqn.a(localQQAppInterface, paramContext, localBundle, null)) {
        break label159;
      }
      if (paramtcp != null) {
        paramtcp.a(paramtev);
      }
    }
    label151:
    label159:
    while (paramtcp == null)
    {
      return;
      localObject = paramtev.jdField_c_of_type_JavaLangString;
      break;
      localObject = paramtev.jdField_d_of_type_JavaLangString;
      break label58;
    }
    paramtcp.b(paramtev);
  }
  
  private static void a(Context paramContext, tew paramtew, tcp paramtcp)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      ThreadManager.executeOnSubThread(new StoryBasicShareUtils.2(localPackageManager.getApplicationInfo("com.sina.weibo", 8192), paramtew, paramContext, paramtcp));
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      do
      {
        try
        {
          do
          {
            Object localObject1 = URLEncoder.encode(paramtew.jdField_a_of_type_JavaLangString, "UTF-8");
            localObject1 = "http://v.t.sina.com.cn/share/share.php?" + "mTitle=" + (String)localObject1;
            Object localObject2 = URLEncoder.encode(paramtew.jdField_c_of_type_JavaLangString, "UTF-8");
            localObject2 = (String)localObject1 + "&url=" + (String)localObject2;
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(paramtew.jdField_e_of_type_JavaLangString))
            {
              localObject1 = URLEncoder.encode(paramtew.jdField_e_of_type_JavaLangString, "UTF-8");
              localObject1 = (String)localObject2 + "&pic=" + (String)localObject1;
            }
            localObject1 = (String)localObject1 + "&_wv=3";
            localObject2 = new Intent(paramContext, QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("url", (String)localObject1);
            paramContext.startActivity((Intent)localObject2);
          } while (paramtcp == null);
          paramtcp.a(paramtew);
          return;
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
        }
      } while (paramtcp == null);
      paramtcp.b(paramtew);
    }
  }
  
  private static void a(tex paramtex, boolean paramBoolean, tcp paramtcp)
  {
    String str1 = String.valueOf(System.currentTimeMillis());
    paramtcp = new tfg(str1, paramtcp, paramtex);
    WXShareHelper.a().a(paramtcp);
    paramtcp = WXShareHelper.a();
    String str2 = paramtex.jdField_a_of_type_JavaLangString;
    Bitmap localBitmap = paramtex.jdField_a_of_type_AndroidGraphicsBitmap;
    String str3 = paramtex.jdField_c_of_type_JavaLangString;
    paramtex = paramtex.jdField_d_of_type_JavaLangString;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramtcp.b(str1, str2, localBitmap, str3, paramtex, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tff
 * JD-Core Version:    0.7.0.1
 */