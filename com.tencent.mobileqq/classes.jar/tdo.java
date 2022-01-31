import android.app.Activity;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.newshare.mode.base.ShareModeBase.23;
import com.tencent.biz.qqstory.newshare.mode.base.ShareModeBase.24;
import com.tencent.biz.qqstory.newshare.mode.base.ShareModeBase.25;
import com.tencent.biz.qqstory.newshare.mode.base.ShareModeBase.26;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public abstract class tdo
{
  public static Map<String, String> a;
  private int a;
  public WeakReference<Activity> a;
  public tcm a;
  public tep a;
  public Map<String, String> b = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  }
  
  public tdo()
  {
    this.jdField_a_of_type_Tep = new tep();
  }
  
  public static String a(String paramString, Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    if (!paramString.contains("?")) {}
    label37:
    label192:
    for (String str1 = "?";; str1 = "")
    {
      try
      {
        Iterator localIterator = paramMap.keySet().iterator();
        int i = 1;
        if (localIterator.hasNext())
        {
          String str4 = (String)localIterator.next();
          String str3 = (String)paramMap.get(str4);
          String str2 = str3;
          if (str3 == null) {
            str2 = "";
          }
          if (i != 0) {
            localStringBuilder.append(str1);
          }
          for (;;)
          {
            localStringBuilder.append(str4 + "=" + URLEncoder.encode(str2, "utf-8"));
            i = 0;
            break label37;
            if ((paramString.endsWith("?")) || (paramString.endsWith("&"))) {
              break label192;
            }
            str1 = "&";
            break;
            localStringBuilder.append("&");
          }
        }
        paramMap = localStringBuilder.toString();
      }
      catch (UnsupportedEncodingException paramMap)
      {
        urk.e("Q.qqstory.share.ShareModeBase", paramMap.getMessage());
        return paramString;
      }
      return paramMap;
    }
  }
  
  private void b(int paramInt)
  {
    urk.b("Q.qqstory.share.ShareModeBase", "handlePrepareShareData() action=%d", Integer.valueOf(paramInt));
    switch (paramInt)
    {
    default: 
      return;
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
      localObject = new tet();
      ((tet)localObject).jdField_a_of_type_Int = paramInt;
      new ter(this, (tet)localObject).a();
      return;
    case 1: 
      localObject = new teu();
      ((teu)localObject).jdField_a_of_type_Int = paramInt;
      a_((tet)localObject);
      a((teu)localObject);
      b((tet)localObject);
      b((teu)localObject);
      return;
    case 2: 
      localObject = new tev();
      ((tev)localObject).jdField_a_of_type_Int = paramInt;
      a_((tet)localObject);
      a((tev)localObject);
      b((tet)localObject);
      b((tev)localObject);
      return;
    case 3: 
      localObject = new tex();
      ((tex)localObject).jdField_a_of_type_Int = paramInt;
      a_((tet)localObject);
      a((tex)localObject);
      b((tet)localObject);
      c((tex)localObject);
      return;
    case 4: 
      localObject = new tex();
      ((tex)localObject).jdField_a_of_type_Int = paramInt;
      ((tex)localObject).jdField_a_of_type_Boolean = true;
      a_((tet)localObject);
      b((tex)localObject);
      b((tet)localObject);
      c((tex)localObject);
      return;
    case 5: 
      localObject = new tew();
      ((tew)localObject).jdField_a_of_type_Int = paramInt;
      a_((tet)localObject);
      a((tew)localObject);
      b((tet)localObject);
      b((tew)localObject);
      return;
    }
    Object localObject = new tes();
    ((tes)localObject).jdField_a_of_type_Int = paramInt;
    a_((tet)localObject);
    a((tes)localObject);
    b((tet)localObject);
    b((tes)localObject);
  }
  
  protected abstract String a(int paramInt);
  
  protected String a(String paramString, tet paramtet)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(jdField_a_of_type_JavaUtilMap);
    if (paramtet != null) {
      localHashMap.putAll(paramtet.jdField_a_of_type_JavaUtilMap);
    }
    localHashMap.putAll(this.b);
    return a(paramString, localHashMap);
  }
  
  protected void a()
  {
    a(true);
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    a();
  }
  
  public void a(@NonNull Activity paramActivity)
  {
    vkw.a(paramActivity);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
  }
  
  public void a(tes paramtes) {}
  
  public void a(teu paramteu) {}
  
  public void a(tev paramtev) {}
  
  public void a(tew paramtew) {}
  
  public void a(tex paramtex)
  {
    paramtex.jdField_a_of_type_Boolean = false;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Tep.a(new ShareModeBase.23(this));
      return;
    }
    tet localtet = new tet();
    localtet.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    d(localtet);
  }
  
  protected void a_(tet paramtet) {}
  
  protected String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "qq";
    case 2: 
      return "qzone";
    case 3: 
      return "wechat";
    case 4: 
      return "wechat";
    case 5: 
      return "weibo";
    }
    return "copy_link";
  }
  
  protected void b(tes paramtes)
  {
    String str = paramtes.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Tep.a(new tdv(this, str, null, false, paramtes)).a(new tdu(this, paramtes)).a(new ter(this, paramtes));
  }
  
  protected final void b(tet paramtet)
  {
    urk.a("Q.qqstory.share.ShareModeBase", "prepareCommonShareData %s", paramtet);
    if ((paramtet instanceof tex)) {
      ((tex)paramtet).d = a(((tex)paramtet).d, paramtet);
    }
    do
    {
      return;
      if ((paramtet instanceof tes))
      {
        ((tes)paramtet).jdField_a_of_type_JavaLangString = a(((tes)paramtet).jdField_a_of_type_JavaLangString, paramtet);
        return;
      }
      if ((paramtet instanceof tew))
      {
        ((tew)paramtet).c = a(((tew)paramtet).c, paramtet);
        return;
      }
      if ((paramtet instanceof tev))
      {
        ((tev)paramtet).e = a(((tev)paramtet).e, paramtet);
        return;
      }
    } while (!(paramtet instanceof teu));
    ((teu)paramtet).h = a(((teu)paramtet).h, paramtet);
  }
  
  protected void b(teu paramteu)
  {
    if ((paramteu.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramteu.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_Tep.a(new tdp(this, paramteu.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramteu));
    }
    for (;;)
    {
      String str = paramteu.h;
      this.jdField_a_of_type_Tep.a(new tee(this, str, null, true, paramteu)).a(new ter(this, paramteu));
      return;
      if ((paramteu.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramteu.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_Tep.a(new tea(this, paramteu.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramteu));
      }
    }
  }
  
  protected void b(tev paramtev)
  {
    String str = paramtev.e;
    this.jdField_a_of_type_Tep.a(new tek(this, str, null, false, paramtev));
    if ((paramtev.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramtev.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_Tep.a(new tdr(this, paramtev.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem)).a(new tdq(this, paramtev));
    }
    for (;;)
    {
      this.jdField_a_of_type_Tep.a(new ter(this, paramtev));
      return;
      if ((paramtev.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramtev.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_Tep.a(new tdt(this, paramtev.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem)).a(new tds(this, paramtev));
      }
    }
  }
  
  protected void b(tew paramtew)
  {
    String str = paramtew.c;
    this.jdField_a_of_type_Tep.a(new tdw(this, str, null, false, paramtew));
    if ((paramtew.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramtew.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_Tep.a(new tdz(this, paramtew.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramtew)).a(new tdy(this, paramtew)).a(new tdx(this, paramtew));
    }
    for (;;)
    {
      this.jdField_a_of_type_Tep.a(new ter(this, paramtew));
      return;
      if ((paramtew.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramtew.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_Tep.a(new ted(this, paramtew.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramtew)).a(new tec(this, paramtew)).a(new teb(this, paramtew));
      } else {
        this.jdField_a_of_type_Tep.a(new tcu(paramtew.e, paramtew.d, paramtew.jdField_a_of_type_Boolean));
      }
    }
  }
  
  public void b(tex paramtex)
  {
    paramtex.jdField_a_of_type_Boolean = true;
  }
  
  public void c(tet paramtet)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.share.ShareModeBase", 2, "notifyResult");
    }
    tet localtet;
    if (this.jdField_a_of_type_Tcm != null)
    {
      localtet = paramtet;
      if (paramtet == null)
      {
        localtet = new tet();
        localtet.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      }
      if (Looper.myLooper() == Looper.getMainLooper()) {
        this.jdField_a_of_type_Tcm.a(localtet);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new ShareModeBase.24(this, localtet));
  }
  
  protected void c(tex paramtex)
  {
    String str = paramtex.d;
    urk.b("Q.qqstory.share.ShareModeBase", "handleShareToWeChatJob url: %s", str);
    this.jdField_a_of_type_Tep.a(new tef(this, str, null, false, paramtex));
    if ((paramtex.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramtex.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_Tep.a(new teg(this, paramtex.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramtex));
    }
    for (;;)
    {
      this.jdField_a_of_type_Tep.a(new tej(this, paramtex.e)).a(new tei(this, paramtex.b, paramtex.c, paramtex)).a(new ter(this, paramtex));
      return;
      if ((paramtex.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramtex.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_Tep.a(new teh(this, paramtex.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramtex));
      }
    }
  }
  
  public void d(tet paramtet)
  {
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.share.ShareModeBase", 2, "notifyError");
    }
    tet localtet;
    if (this.jdField_a_of_type_Tcm != null)
    {
      localtet = paramtet;
      if (paramtet == null)
      {
        localtet = new tet();
        localtet.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      }
      if (Looper.myLooper() == Looper.getMainLooper()) {
        this.jdField_a_of_type_Tcm.b(localtet);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new ShareModeBase.25(this, localtet));
  }
  
  public void e(tet paramtet)
  {
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.share.ShareModeBase", 2, "notifyCancel");
    }
    tet localtet;
    if (this.jdField_a_of_type_Tcm != null)
    {
      localtet = paramtet;
      if (paramtet == null)
      {
        localtet = new tet();
        localtet.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      }
      if (Looper.myLooper() == Looper.getMainLooper()) {
        this.jdField_a_of_type_Tcm.c(localtet);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new ShareModeBase.26(this, localtet));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tdo
 * JD-Core Version:    0.7.0.1
 */