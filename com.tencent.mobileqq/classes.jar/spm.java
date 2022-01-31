import android.os.Message;
import com.tencent.mobileqq.activity.FriendProfileImageAvatar;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.os.MqqHandler;

public class spm
  implements Runnable
{
  public spm(FriendProfileImageAvatar paramFriendProfileImageAvatar, String paramString1, byte paramByte, String paramString2) {}
  
  public void run()
  {
    Object localObject2 = ProfileCardUtil.a(String.valueOf(this.jdField_a_of_type_JavaLangString));
    if (FileUtil.a((String)localObject2)) {
      if (NearbyUtils.a()) {
        NearbyUtils.a("Q.profilecard.Avatar", "downloadHDAvatar hd avatar file exist 2", new Object[0]);
      }
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.b)
      {
        if (!NearbyUtils.a()) {
          continue;
        }
        NearbyUtils.a("Q.profilecard.Avatar", "downloadHDAvatar is downloading and return 2", new Object[0]);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.b = true;
      int i;
      label86:
      Object localObject1;
      if ((this.jdField_a_of_type_Byte & 0x20) != 0)
      {
        i = 0;
        localObject1 = this.b + i;
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.jdField_a_of_type_JavaNetURL = new URL((String)localObject1);
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.Avatar", 2, "downloadHDAvatar()  uin=" + this.jdField_a_of_type_JavaLangString + ", mgSize=" + i + ", url = " + (String)localObject1);
        }
        localObject2 = new File((String)localObject2);
        File localFile = new File(((File)localObject2).getPath() + Long.toString(System.currentTimeMillis()));
        if (HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new DownloadInfo(MsfSdkUtils.insertMtype("friendlist", (String)localObject1), localFile, 0), this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar) == 0)
        {
          bool1 = true;
          boolean bool2 = bool1;
          if (bool1) {
            bool2 = localFile.renameTo((File)localObject2);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.jdField_a_of_type_MqqOsMqqHandler != null)
          {
            localObject1 = Message.obtain();
            ((Message)localObject1).what = 3;
            if (!bool2) {
              break label429;
            }
            i = 1;
            ((Message)localObject1).arg1 = i;
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject1);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.b = false;
          if (!NearbyUtils.a()) {
            continue;
          }
          NearbyUtils.a("Q.profilecard.Avatar", "downloadHDAvatar end of downloading", new Object[0]);
          return;
          if ((this.jdField_a_of_type_Byte & 0x10) != 0)
          {
            i = 640;
            break label86;
          }
          if ((this.jdField_a_of_type_Byte & 0x8) != 0)
          {
            i = 140;
            break label86;
          }
          if ((this.jdField_a_of_type_Byte & 0x4) != 0)
          {
            i = 100;
            break label86;
          }
          i = 40;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          boolean bool1;
          if (QLog.isColorLevel())
          {
            QLog.e("Q.profilecard.Avatar", 2, localMalformedURLException.toString());
            continue;
            bool1 = false;
            continue;
            label429:
            i = 0;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     spm
 * JD-Core Version:    0.7.0.1
 */