import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;

public class eo
{
  static String jdField_a_of_type_JavaLangString = "DirectForwarder";
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public eo(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private int a(String paramString, int paramInt, boolean paramBoolean, er paramer)
  {
    axrm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "dl_forwardin_image");
    if ((paramString == null) || (paramString.equals("")))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "forwardPhoto. path=null");
      return 4;
    }
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = paramString.split(";");
    int j = 0;
    int i = 0;
    if (j < arrayOfString.length)
    {
      if (apvd.b(arrayOfString[j]))
      {
        paramString = arrayOfString[j];
        label94:
        if (TextUtils.isEmpty(paramString)) {
          break label257;
        }
        if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://"))) {
          break label247;
        }
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800492E", "0X800492E", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.e("qqdataline", 2, "shareFromMigSdk|report send link:0X800492E.");
        }
        if (d(paramString, paramInt, paramBoolean, paramer) == 0) {
          i = 1;
        }
      }
      for (;;)
      {
        for (;;)
        {
          j += 1;
          break;
          try
          {
            paramString = URLDecoder.decode(arrayOfString[j], "UTF-8");
          }
          catch (UnsupportedEncodingException paramString)
          {
            if (QLog.isColorLevel()) {
              QLog.e("qqdataline", 2, "forwardImage. decode exp. imageUrls[i]=" + arrayOfString[j]);
            }
          }
          catch (IllegalArgumentException paramString)
          {
            paramString = arrayOfString[j];
          }
        }
        break label94;
        label247:
        localArrayList.add(paramString);
        continue;
        label257:
        if (QLog.isColorLevel()) {
          QLog.e("qqdataline", 2, "forwardImage|file path invalid. path=" + paramString);
        }
      }
    }
    if (!localArrayList.isEmpty())
    {
      if (paramBoolean)
      {
        if (localArrayList.size() <= 1) {
          break label374;
        }
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004930", "0X8004930", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.e("qqdataline", 2, "forwardImage shareFromMigSdk|report send multi pic:0X8004930.");
        }
      }
      while ((a(localArrayList, 1, paramInt, paramBoolean, paramer) == 0) || (i != 0))
      {
        return 0;
        label374:
        if (localArrayList.size() == 1)
        {
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800492F", "0X800492F", 0, 0, "", "", "", "");
          if (QLog.isColorLevel()) {
            QLog.e("qqdataline", 2, "forwardImage shareFromMigSdk|report single pics:0X800492F.");
          }
        }
      }
      return 8;
    }
    if (i != 0) {
      return 0;
    }
    return 4;
  }
  
  private int a(ArrayList<String> paramArrayList, int paramInt1, int paramInt2, boolean paramBoolean, er paramer)
  {
    if (paramArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "sendMultipleFile paths is null !!!!!!");
      }
      if (paramer != null) {
        paramer.b();
      }
      return 268;
    }
    if (paramBoolean)
    {
      int i = 0;
      localObject = "";
      while (i < paramArrayList.size())
      {
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800492D", "0X800492D", 0, 0, "", "", "", "");
        localObject = (String)localObject + "sendMultipleFile shareFromMigSdk|report send one from sdk:0X800492D.";
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.e("qqdataline", 2, (String)localObject);
      }
    }
    Object localObject = new ep(this, paramArrayList, paramInt2);
    long l = a(paramArrayList);
    if (l == 0L)
    {
      if (paramer != null) {
        paramer.a();
      }
      return 128;
    }
    if ((bbfj.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) && (!bbfj.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) && (l > 3145728L))
    {
      if (paramer != null) {
        paramer.a((AsyncTask)localObject, paramInt1);
      }
      return 512;
    }
    ((AsyncTask)localObject).execute(new Integer[] { Integer.valueOf(paramInt1) });
    return 0;
  }
  
  private long a(ArrayList<String> paramArrayList)
  {
    if (paramArrayList == null) {
      return 0L;
    }
    paramArrayList = paramArrayList.iterator();
    long l = 0L;
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (str != null) {
        l = new VFSFile(str).length() + l;
      }
    }
    return l;
  }
  
  private DataLineMsgRecord a(ForwardFileInfo paramForwardFileInfo, boolean paramBoolean, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramForwardFileInfo.b());
    if (localFileManagerEntity == null) {}
    int k;
    do
    {
      return null;
      k = ajum.a(localFileManagerEntity);
    } while (!ajum.c(k));
    int j = ajum.a(paramForwardFileInfo.d(), paramBoolean);
    int i = j;
    if (!paramBoolean)
    {
      i = j;
      if (j == 1) {
        i = 0;
      }
    }
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.msgtype = ajum.a(i);
    localDataLineMsgRecord.sessionid = ((ajum)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a(0, paramInt).longValue();
    localDataLineMsgRecord.filename = paramForwardFileInfo.d();
    localDataLineMsgRecord.filesize = paramForwardFileInfo.d();
    localDataLineMsgRecord.fileUuid = paramForwardFileInfo.b();
    localDataLineMsgRecord.fileFrom = k;
    localDataLineMsgRecord.thumbPath = paramForwardFileInfo.f();
    if (!TextUtils.isEmpty(localFileManagerEntity.strFileMd5)) {
      localDataLineMsgRecord.md5 = bbea.a(localFileManagerEntity.strFileMd5);
    }
    if (!TextUtils.isEmpty(localFileManagerEntity.peerUin)) {
      localDataLineMsgRecord.uOwnerUin = Long.parseLong(localFileManagerEntity.peerUin.replace("+", ""));
    }
    if (TextUtils.isEmpty(paramForwardFileInfo.a())) {}
    for (localDataLineMsgRecord.path = paramForwardFileInfo.d();; localDataLineMsgRecord.path = paramForwardFileInfo.a()) {
      return localDataLineMsgRecord;
    }
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    String str = BaseApplicationImpl.getApplication().getBaseContext().getResources().getString(paramInt1);
    if ((str != null) && (str.length() > 0)) {
      a(str, paramInt2);
    }
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    bcql localbcql = new bcql(paramContext);
    localbcql.a(2130839277);
    localbcql.d(2000);
    localbcql.c(paramInt);
    localbcql.b(paramContext.getResources().getDimensionPixelSize(2131298865) - (int)bbdv.a(paramContext, 5.0F));
  }
  
  public static void a(Context paramContext, AsyncTask<Integer, Integer, String> paramAsyncTask, int paramInt, aptw paramaptw)
  {
    aptt.a(paramContext, 2131692673, 2131692678, new eq(paramAsyncTask, paramInt, paramaptw));
  }
  
  public static void a(String paramString, int paramInt)
  {
    Context localContext = BaseApplicationImpl.getApplication().getBaseContext();
    bcql.a(localContext, paramInt, paramString, 1).b(localContext.getResources().getDimensionPixelSize(2131298865) - (int)bbdv.a(localContext, 5.0F));
  }
  
  private boolean a(ForwardFileInfo paramForwardFileInfo, int paramInt1, int paramInt2)
  {
    if (paramForwardFileInfo == null) {}
    boolean bool;
    do
    {
      FileManagerEntity localFileManagerEntity;
      do
      {
        return false;
        localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramForwardFileInfo.b());
      } while (localFileManagerEntity == null);
      QLog.i(jdField_a_of_type_JavaLangString, 1, "ForwardOfflineFile forwardFileType: " + paramInt1 + " devType:" + paramInt2);
      int i = ajum.a(localFileManagerEntity);
      switch (i)
      {
      default: 
        QLog.w(jdField_a_of_type_JavaLangString, 1, "ForwardOfflineFile fileFrom " + i + " is not handled");
        return false;
      case 3: 
        if (paramInt1 != 101) {
          break label177;
        }
        bool = true;
        paramForwardFileInfo = a(paramForwardFileInfo, bool, paramInt2);
      }
    } while (paramForwardFileInfo == null);
    ((ajum)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a(paramForwardFileInfo, false);
    for (;;)
    {
      return true;
      label177:
      bool = false;
      break;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(3, paramForwardFileInfo.b(), paramInt2);
      continue;
      paramInt1 = 7;
      if (paramInt2 == 1) {
        paramInt1 = 6003;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramForwardFileInfo.b(), paramForwardFileInfo.e(), paramForwardFileInfo.a(), Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), paramInt1, paramForwardFileInfo.a());
    }
  }
  
  private int b(String paramString, int paramInt, boolean paramBoolean, er paramer)
  {
    axrm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "dl_forwardin_file");
    if ((paramString == null) || (paramString.equals("")))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "forwardFile. path=null");
      return 4;
    }
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = paramString.split(";");
    int j = 0;
    int i = 0;
    if (j < arrayOfString.length)
    {
      if (apvd.b(arrayOfString[j]))
      {
        paramString = arrayOfString[j];
        label96:
        if (TextUtils.isEmpty(paramString)) {
          break label219;
        }
        if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://"))) {
          break label209;
        }
        if (d(paramString, paramInt, paramBoolean, paramer) == 0) {
          i = 1;
        }
      }
      for (;;)
      {
        for (;;)
        {
          j += 1;
          break;
          try
          {
            paramString = URLDecoder.decode(arrayOfString[j], "UTF-8");
          }
          catch (UnsupportedEncodingException paramString)
          {
            if (QLog.isColorLevel()) {
              QLog.e("qqdataline", 2, "forwardFile|decode exp. imageUrls[i]=" + arrayOfString[j]);
            }
          }
          catch (IllegalArgumentException paramString)
          {
            paramString = arrayOfString[j];
          }
        }
        break label96;
        label209:
        localArrayList.add(paramString);
        continue;
        label219:
        if (QLog.isColorLevel()) {
          QLog.e("qqdataline", 2, "forwardFile|file path invalid. path=" + paramString);
        }
      }
    }
    if (!localArrayList.isEmpty())
    {
      if (paramBoolean)
      {
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004932", "0X8004932", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.e("qqdataline", 2, "forwardFile shareFromMigSdk|report send file:0X8004932.");
        }
      }
      if ((a(localArrayList, 0, paramInt, paramBoolean, paramer) == 0) || (i != 0)) {
        return 0;
      }
      return 8;
    }
    if (i != 0) {
      return 0;
    }
    return 4;
  }
  
  public static void b(Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return;
    case 2: 
    case 4: 
      a(paramContext, 2131693950);
      return;
    case 8: 
      a(ajya.a(2131703336), 1);
      return;
    case 0: 
      a(2131692756, 2);
      return;
    }
    a(2131694673, 0);
  }
  
  private int c(String paramString, int paramInt, boolean paramBoolean, er paramer)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      if (bbft.d.matcher(paramString).find()) {
        axrm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "dl_forwardin_link");
      }
      for (;;)
      {
        return d(paramString, paramInt, paramBoolean, paramer);
        axrm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "dl_forwardin_text");
      }
    }
    return 4;
  }
  
  private int d(String paramString, int paramInt, boolean paramBoolean, er paramer)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (paramer != null) {
        paramer.d();
      }
      return 32;
    }
    if (paramString.length() > 3478)
    {
      if (paramer != null) {
        paramer.c();
      }
      return 64;
    }
    if (paramBoolean)
    {
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800492D", "0X800492D", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.e("qqdataline", 2, "sendTextMessage shareFromMigSdk|report send one from sdk:0X800492D.");
      }
    }
    ((ajum)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a(paramString, paramInt);
    return 0;
  }
  
  public int a(String paramString, Bundle paramBundle, er paramer)
  {
    int j = 0;
    if (!bbfj.d(BaseApplication.getContext()))
    {
      j = 9;
      return j;
    }
    int m = paramBundle.getInt("dataline_forward_type", -1);
    Object localObject = paramBundle.getStringArrayList("dataline_forward_pathlist");
    ArrayList localArrayList = paramBundle.getParcelableArrayList("fileinfo_array");
    boolean bool = paramBundle.getBoolean("isMigSdkShare", false);
    paramBundle = (ajum)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
    if (ajsd.z.equalsIgnoreCase(paramString)) {
      paramBundle.jdField_a_of_type_JavaLangString = ajsd.z;
    }
    int k;
    for (paramBundle.jdField_a_of_type_Int = 0;; paramBundle.jdField_a_of_type_Int = 1)
    {
      k = paramBundle.jdField_a_of_type_Int;
      if (m != -1) {
        break label134;
      }
      return 2;
      if (!ajsd.A.equalsIgnoreCase(paramString)) {
        break;
      }
      paramBundle.jdField_a_of_type_JavaLangString = ajsd.A;
    }
    return 8;
    label134:
    if (m == 100) {}
    for (int i = 0;; i = 1)
    {
      if (localObject == null)
      {
        paramString = null;
        if (localArrayList != null) {}
        try
        {
          paramString = (ArrayList)localArrayList;
          if (paramString == null) {
            return 4;
          }
        }
        catch (ClassCastException paramString)
        {
          for (;;)
          {
            paramString = null;
          }
          paramer = new ArrayList();
          paramString = paramString.iterator();
          i = 0;
          while (paramString.hasNext())
          {
            localObject = (ForwardFileInfo)paramString.next();
            if (a((ForwardFileInfo)localObject, m, k))
            {
              i = 1;
            }
            else
            {
              localObject = a((ForwardFileInfo)localObject, false, k);
              if (localObject != null) {
                if (DataLineMsgSet.isSingle((DataLineMsgRecord)localObject))
                {
                  localArrayList = new ArrayList();
                  localArrayList.add(localObject);
                  paramBundle.a(localArrayList, false);
                  i = 1;
                }
              }
              for (;;)
              {
                break;
                paramer.add(localObject);
              }
            }
          }
          if (paramer.size() > 0)
          {
            paramBundle.a(paramer, false);
            return 0;
          }
        }
        if (i != 0) {
          break;
        }
        return 4;
      }
      paramString = ((ArrayList)localObject).iterator();
      while (paramString.hasNext())
      {
        paramBundle = (String)paramString.next();
        if ((paramBundle == null) || (paramBundle.equals("/"))) {
          paramString.remove();
        }
      }
      if (!((ArrayList)localObject).isEmpty())
      {
        if (a((ArrayList)localObject, i, k, bool, paramer) != 0) {
          break;
        }
        return 0;
      }
      return 4;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public boolean a(DataLineMsgRecord paramDataLineMsgRecord, int paramInt1, int paramInt2)
  {
    boolean bool2;
    if (paramDataLineMsgRecord == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "reForwardOfflineFile msg=null ");
      bool2 = false;
      return bool2;
    }
    boolean bool1 = false;
    if (paramDataLineMsgRecord.nOpType == 31)
    {
      TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDataLineMsgRecord.uOwnerUin).a(paramInt2, paramDataLineMsgRecord.uOwnerUin, paramDataLineMsgRecord.busId, Long.valueOf(paramDataLineMsgRecord.selfuin).longValue(), paramDataLineMsgRecord.istroop, paramDataLineMsgRecord.filename, paramDataLineMsgRecord.thumbPath, paramDataLineMsgRecord.filesize, paramDataLineMsgRecord.fileUuid, true, paramDataLineMsgRecord.sessionid, apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1));
      paramDataLineMsgRecord.fileMsgStatus = 0L;
      paramDataLineMsgRecord.issuc = true;
      bool1 = true;
    }
    for (;;)
    {
      bool2 = bool1;
      if (3 != paramDataLineMsgRecord.fileFrom) {
        break;
      }
      bool2 = bool1;
      if (TextUtils.isEmpty(paramDataLineMsgRecord.fileUuid)) {
        break;
      }
      ((ajum)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a(paramDataLineMsgRecord, true);
      return true;
      if (paramDataLineMsgRecord.nOpType == 29)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(3, paramDataLineMsgRecord.trans2Entity(), paramInt1))
        {
          paramDataLineMsgRecord.fileMsgStatus = 0L;
          paramDataLineMsgRecord.issuc = true;
        }
        bool1 = true;
      }
    }
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 0);
    localBundle.putBoolean("not_forward", true);
    localBundle.putInt("dataline_forward_type", 100);
    localBundle.putString("dataline_forward_path", paramFileManagerEntity.getFilePath());
    localBundle.putParcelable("fileinfo", aqcg.a(paramFileManagerEntity));
    return b(ajsd.z, localBundle, null) == 0;
  }
  
  public int b(String paramString, Bundle paramBundle, er paramer)
  {
    if (!bbfj.d(BaseApplication.getContext())) {
      return 9;
    }
    int i = paramBundle.getInt("dataline_forward_type", -1);
    String str1 = paramBundle.getString("dataline_forward_path");
    String str2 = paramBundle.getString("dataline_forward_text");
    boolean bool = paramBundle.getBoolean("isMigSdkShare", false);
    paramBundle = (ForwardFileInfo)paramBundle.getParcelable("fileinfo");
    ajum localajum = (ajum)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
    if (ajsd.z.equalsIgnoreCase(paramString)) {
      localajum.jdField_a_of_type_JavaLangString = ajsd.z;
    }
    int j;
    for (localajum.jdField_a_of_type_Int = 0;; localajum.jdField_a_of_type_Int = 1)
    {
      j = localajum.jdField_a_of_type_Int;
      if (i != -1) {
        break label144;
      }
      return 2;
      if (!ajsd.A.equalsIgnoreCase(paramString)) {
        break;
      }
      localajum.jdField_a_of_type_JavaLangString = ajsd.A;
    }
    return 8;
    label144:
    if (a(paramBundle, i, j)) {
      return 0;
    }
    switch (i)
    {
    default: 
      axrm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "dl_forwardin_other");
      return 4;
    case 101: 
      return a(str1, j, bool, paramer);
    case 100: 
      return b(str1, j, bool, paramer);
    }
    return c(str2, j, bool, paramer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     eo
 * JD-Core Version:    0.7.0.1
 */