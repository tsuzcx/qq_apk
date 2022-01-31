import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.makeup.MakeupMng.2;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tencent.ttpic.util.DecryptListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class lig
  extends lin
{
  private static final DecryptListener a;
  public final ConcurrentHashMap<String, Integer> a;
  public volatile int b;
  public int c;
  private int d;
  public String d;
  
  static
  {
    jdField_a_of_type_ComTencentTtpicUtilDecryptListener = new lih();
  }
  
  public lig(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private static VideoMaterial a(String paramString1, String paramString2)
  {
    return VideoTemplateParser.parseVideoMaterial(paramString1, paramString2, false, jdField_a_of_type_ComTencentTtpicUtilDecryptListener);
  }
  
  private void a(String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      String[] arrayOfString = paramString.split(";");
      int j = arrayOfString.length;
      if (i < j)
      {
        Object localObject = arrayOfString[i];
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
        for (;;)
        {
          i += 1;
          break;
          localObject = ((String)localObject).split(",");
          if (localObject.length == 2)
          {
            CharSequence localCharSequence = localObject[0];
            try
            {
              int k = Integer.parseInt(localObject[1]);
              if (!TextUtils.isEmpty(localCharSequence)) {
                this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localCharSequence, Integer.valueOf(k));
              }
            }
            catch (Throwable localThrowable) {}
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i(this.jdField_a_of_type_JavaLangString, 2, "parseValueMap, map[" + paramString + "]");
  }
  
  public int a()
  {
    return 591;
  }
  
  public int a(String paramString)
  {
    Integer localInteger = null;
    if (!TextUtils.isEmpty(paramString)) {
      localInteger = (Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    if (localInteger == null) {
      return 50;
    }
    return localInteger.intValue();
  }
  
  public VideoMaterial a(String paramString)
  {
    VideoMaterial localVideoMaterial = a(paramString, "params");
    localVideoMaterial.setDataPath(paramString);
    return localVideoMaterial;
  }
  
  public List<PendantItem> a(int paramInt, String paramString)
  {
    Object localObject = super.a(paramInt, paramString);
    ArrayList localArrayList = new ArrayList();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PendantItem localPendantItem = (PendantItem)((Iterator)localObject).next();
        if (localPendantItem != null) {
          localArrayList.add(localPendantItem);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "parse, cid[" + paramInt + "], config[" + paramString + "], size[" + localArrayList.size() + "]");
    }
    return localArrayList;
  }
  
  public lio a(int paramInt1, int paramInt2)
  {
    if (this.b == 0) {
      c();
    }
    if (this.jdField_d_of_type_Int == 3002) {
      a(0L, "getVideoPendant");
    }
    lio locallio = super.a(paramInt1, paramInt2);
    if ((locallio != null) && (locallio.a != null)) {
      locallio.a.extraParam = Integer.valueOf(this.c);
    }
    return locallio;
  }
  
  public void a(int paramInt, String paramString)
  {
    long l = AudioHelper.b();
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 4, "MuteByOthers, fromMuteKey[" + paramInt + "], seq[" + l + "], data[" + paramString + "]");
    }
    if (paramInt == 3004) {}
    do
    {
      return;
      if (paramInt == 3002)
      {
        if (this.jdField_d_of_type_Int == 3003) {
          a(l, this.jdField_d_of_type_JavaLangString);
        }
        this.jdField_d_of_type_Int = 3002;
        return;
      }
    } while ((paramInt != 3003) || (!"creativecop".equals(paramString)));
    this.jdField_d_of_type_Int = 3003;
    a(l, null);
  }
  
  public void a(long paramLong, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 4, "clearMuteFlag, muteFlag[" + this.jdField_d_of_type_Int + "], from[" + paramString + "], cur[" + this.jdField_d_of_type_JavaLangString + "], value[" + this.c + "]");
    }
    if (this.jdField_d_of_type_Int == 3003) {
      a(paramLong, this.jdField_d_of_type_JavaLangString);
    }
    this.jdField_d_of_type_Int = 0;
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (a()) {}
    do
    {
      do
      {
        return;
      } while ((TextUtils.equals(paramString, this.jdField_d_of_type_JavaLangString)) && (paramInt == this.c));
      if ((!paramBoolean) && (!TextUtils.equals(paramString, this.jdField_d_of_type_JavaLangString))) {}
      this.jdField_d_of_type_JavaLangString = paramString;
      this.c = paramInt;
    } while (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(this.jdField_d_of_type_JavaLangString, Integer.valueOf(paramInt));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    super.a(paramString, paramBoolean);
    PendantItem localPendantItem = (PendantItem)a();
    if (localPendantItem == null)
    {
      this.jdField_d_of_type_JavaLangString = null;
      this.c = 50;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "onDestroyUI, peerUin[" + paramString + "], quit[" + paramBoolean + "], item[" + a() + "]");
      }
      return;
      this.jdField_d_of_type_JavaLangString = localPendantItem.getId();
    }
  }
  
  public boolean a()
  {
    return (this.jdField_d_of_type_Int == 3002) || (this.jdField_d_of_type_Int == 3003);
  }
  
  public boolean a(long paramLong, PendantItem paramPendantItem)
  {
    boolean bool = super.a(paramLong, paramPendantItem);
    if ((!a()) && (bool) && (paramPendantItem != null) && (!TextUtils.isEmpty(paramPendantItem.getId())) && (!TextUtils.equals("0", paramPendantItem.getId())))
    {
      lhn locallhn = (lhn)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(12);
      if (locallhn != null) {
        locallhn.a(3004, paramPendantItem.getId());
      }
    }
    return bool;
  }
  
  protected boolean a(PendantItem paramPendantItem)
  {
    boolean bool = super.a(paramPendantItem);
    Object localObject;
    if (bool)
    {
      localObject = new File(c(paramPendantItem), "params.dat");
      long l = ((File)localObject).length();
      if (((!((File)localObject).exists()) || (l >= 1L)) && (((File)localObject).exists())) {
        break label144;
      }
    }
    label144:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = a(paramPendantItem);
        String str = b(paramPendantItem);
        ThreadManager.excute(new MakeupMng.2(this, new File((String)localObject), str), 16, null, false);
        if (QLog.isDevelopLevel()) {
          QLog.i(this.jdField_a_of_type_JavaLangString, 4, "isTemplateUsable, need unzip item[" + paramPendantItem + "]");
        }
      }
      return bool;
    }
  }
  
  public int b()
  {
    return 3004;
  }
  
  public void c()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 4, "initMakeup, flag[" + this.b + "]");
    }
    if (this.b != 0) {}
    do
    {
      return;
      this.b = 1;
      this.b = 2;
    } while (!QLog.isColorLevel());
    QLog.i(this.jdField_a_of_type_JavaLangString, 2, "initMakeup, id[" + this.jdField_d_of_type_JavaLangString + "], value[" + this.c + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lig
 * JD-Core Version:    0.7.0.1
 */