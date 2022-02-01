import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.EffectPendantTools.1;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.QQTemplateParser;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.FabbyMvPart;
import com.tencent.ttpic.openapi.filter.FabbyParts;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class lhp
  extends lhk
{
  public String d;
  
  public lhp(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  public static int a(PendantItem paramPendantItem, boolean paramBoolean)
  {
    if ((paramPendantItem != null) || (paramBoolean)) {}
    switch (AEFilterSupport.a())
    {
    case 5: 
    case 6: 
    default: 
      return 0;
    case 3: 
      return 3;
    case 4: 
      return 4;
    }
    return 5;
  }
  
  public static boolean a(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial != null)
    {
      if (paramVideoMaterial.getFabbyParts() != null)
      {
        paramVideoMaterial = paramVideoMaterial.getFabbyParts().getParts().iterator();
        FabbyMvPart localFabbyMvPart;
        do
        {
          if (!paramVideoMaterial.hasNext()) {
            break;
          }
          localFabbyMvPart = (FabbyMvPart)paramVideoMaterial.next();
        } while ((localFabbyMvPart.bgItem == null) || (localFabbyMvPart.bgItem.name == null) || (!localFabbyMvPart.bgItem.name.endsWith("_360")));
        return true;
      }
    }
    else {
      return false;
    }
    return false;
  }
  
  public int a()
  {
    return 106;
  }
  
  public VideoMaterial a(String paramString)
  {
    VideoMaterial localVideoMaterial = QQTemplateParser.parseVideoMaterial(paramString, "params");
    localVideoMaterial.setDataPath(paramString);
    return localVideoMaterial;
  }
  
  public lhm a(int paramInt1, int paramInt2)
  {
    lhm locallhm = super.a(paramInt1, paramInt2);
    if ((this.jdField_a_of_type_Lho != null) && (locallhm != null) && (locallhm.a != null))
    {
      boolean bool = lhi.a().b();
      if ((!a(locallhm.a)) || (bool)) {
        this.jdField_a_of_type_Lho.c(0);
      }
    }
    return locallhm;
  }
  
  public void a(int paramInt, String paramString)
  {
    long l = AudioHelper.b();
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 4, "MuteByOthers, seq[" + l + "], fromMuteKey[" + paramInt + "], data[" + paramString + "]");
    }
    if (paramInt == b()) {}
    do
    {
      do
      {
        return;
        if (paramInt != 3003) {
          break;
        }
      } while (!"creativecop".equals(paramString));
      a(l, "0");
      return;
    } while ((paramInt != 3001) && (paramInt != 3004) && (paramInt != 3005));
    a(l, "0");
  }
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      paramString1 = (PendantItem)a();
    } while ((paramString1 == null) || (TextUtils.isEmpty(paramString1.getId())));
    a(paramLong, null);
  }
  
  public boolean a(long paramLong, PendantItem paramPendantItem)
  {
    boolean bool = super.a(paramLong, paramPendantItem);
    if ((bool) && (paramPendantItem != null) && (!TextUtils.equals("0", paramPendantItem.getId())))
    {
      localObject = (lgl)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(12);
      if (localObject != null) {
        ((lgl)localObject).a(3002, paramPendantItem.getId());
      }
    }
    String str = this.jdField_a_of_type_JavaLangString;
    if (paramPendantItem == null) {}
    for (Object localObject = null;; localObject = paramPendantItem.getId())
    {
      lhq.a(str, (String)localObject);
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "setCurrentItem, item[" + paramPendantItem + "]");
      }
      return bool;
    }
  }
  
  protected boolean a(PendantItem paramPendantItem)
  {
    int j = 1;
    if ((a() <= 0) || (paramPendantItem == null) || (TextUtils.isEmpty(paramPendantItem.getId())))
    {
      lbc.e(this.jdField_a_of_type_JavaLangString, "isTemplateUsable:" + a() + "|");
      return false;
    }
    if (TextUtils.isEmpty(paramPendantItem.getResurl())) {
      return true;
    }
    File localFile = new File(a(paramPendantItem));
    boolean bool = localFile.exists();
    Object localObject1;
    long l1;
    Object localObject2;
    if (!bool)
    {
      localObject1 = lbf.b() + paramPendantItem.getName();
      localFile = new File((String)localObject1);
      if (localFile.exists())
      {
        l1 = System.currentTimeMillis();
        localObject1 = SecUtil.getFileMd5((String)localObject1);
        long l2 = System.currentTimeMillis();
        localObject2 = paramPendantItem.getMd5();
        lbc.c(this.jdField_a_of_type_JavaLangString, "isTemplateUsable :" + (String)localObject1 + "|" + (String)localObject2 + "|" + (l2 - l1));
        bool = ((String)localObject2).equalsIgnoreCase((String)localObject1);
      }
    }
    for (;;)
    {
      int i;
      if (bool)
      {
        localObject1 = c(paramPendantItem);
        localObject2 = new File((String)localObject1, "params.json");
        l1 = ((File)localObject2).length();
        if (((((File)localObject2).exists()) && (l1 < 1L)) || (!((File)localObject2).exists()))
        {
          i = 1;
          if (i == 0) {
            break label370;
          }
          localObject1 = new File((String)localObject1, "params.dat");
          l1 = ((File)localObject1).length();
          if (((File)localObject1).exists())
          {
            i = j;
            if (l1 < 1L) {}
          }
          else
          {
            if (((File)localObject1).exists()) {
              break label362;
            }
            i = j;
          }
        }
      }
      label362:
      label370:
      for (;;)
      {
        if (i != 0)
        {
          ThreadManager.post(new EffectPendantTools.1(this, localFile, paramPendantItem), 5, null, false);
          return false;
          i = 0;
          break;
          i = 0;
          continue;
        }
        return bool;
      }
    }
  }
  
  public int b()
  {
    return 3002;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lhp
 * JD-Core Version:    0.7.0.1
 */