import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class onk
  implements aqwv<String>
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 3000L;
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString = "";
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString = "";
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString = "";
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private String jdField_f_of_type_JavaLangString = "";
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o = true;
  private boolean p;
  private boolean q;
  
  public static onk a()
  {
    onk localonk = new onk();
    localonk.jdField_a_of_type_JavaLangString = usu.jdField_d_of_type_JavaLangString;
    localonk.jdField_b_of_type_JavaLangString = usu.jdField_e_of_type_JavaLangString;
    localonk.jdField_b_of_type_Boolean = usu.jdField_a_of_type_Boolean;
    localonk.jdField_c_of_type_Boolean = usu.p;
    localonk.jdField_a_of_type_Boolean = usu.jdField_b_of_type_Boolean;
    localonk.jdField_d_of_type_Boolean = usu.jdField_e_of_type_Boolean;
    localonk.jdField_e_of_type_Boolean = usu.jdField_f_of_type_Boolean;
    localonk.jdField_f_of_type_Boolean = usu.jdField_g_of_type_Boolean;
    localonk.jdField_g_of_type_Boolean = usu.jdField_h_of_type_Boolean;
    localonk.jdField_h_of_type_Boolean = usu.jdField_i_of_type_Boolean;
    localonk.jdField_i_of_type_Boolean = usu.l;
    localonk.j = usu.j;
    localonk.jdField_c_of_type_JavaLangString = usu.jdField_f_of_type_JavaLangString;
    localonk.jdField_a_of_type_Long = usu.jdField_a_of_type_Long;
    localonk.k = usu.m;
    localonk.jdField_a_of_type_Int = usu.jdField_b_of_type_Int;
    localonk.jdField_d_of_type_JavaLangString = usu.jdField_i_of_type_JavaLangString;
    localonk.l = usu.n;
    localonk.m = usu.jdField_c_of_type_Boolean;
    localonk.n = usu.o;
    localonk.jdField_a_of_type_JavaUtilArrayList = usu.jdField_a_of_type_JavaUtilArrayList;
    localonk.jdField_b_of_type_Int = usu.jdField_c_of_type_Int;
    localonk.jdField_c_of_type_Int = usu.jdField_d_of_type_Int;
    localonk.jdField_d_of_type_Int = usu.jdField_e_of_type_Int;
    localonk.o = usu.k;
    Object localObject = usu.jdField_g_of_type_JavaLangString;
    localonk.jdField_e_of_type_JavaLangString = ((String)localObject);
    localonk.jdField_f_of_type_JavaLangString = usu.jdField_h_of_type_JavaLangString;
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new JSONObject((String)localObject);
        if (((JSONObject)localObject).has("useNewLogic")) {
          b(localonk, (JSONObject)localObject);
        }
        if (((JSONObject)localObject).has("releaseServiceMinMem")) {
          a(localonk, (JSONObject)localObject);
        }
      }
      return localonk;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localonk;
  }
  
  private onk a(onk paramonk, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return this;
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("service_folder_name")) {
          this.jdField_a_of_type_JavaLangString = paramonk.jdField_a_of_type_JavaLangString;
        }
        if (paramString.has("service_folder_icon")) {
          this.jdField_b_of_type_JavaLangString = paramonk.jdField_b_of_type_JavaLangString;
        }
        if (paramString.has("service_folder_redspots")) {
          this.jdField_a_of_type_Boolean = paramonk.jdField_a_of_type_Boolean;
        }
        if (paramString.has("service_folder_delete")) {
          this.jdField_b_of_type_Boolean = paramonk.jdField_b_of_type_Boolean;
        }
        if (paramString.has("ServiceFolder_RedClean_After_Enter")) {
          this.jdField_c_of_type_Boolean = paramonk.jdField_c_of_type_Boolean;
        }
        if (paramString.has("readInJoy_feeds_preload")) {
          this.jdField_d_of_type_Boolean = paramonk.jdField_d_of_type_Boolean;
        }
        if (paramString.has("readInJoy_feeds_preload_wifi")) {
          this.jdField_e_of_type_Boolean = paramonk.jdField_e_of_type_Boolean;
        }
        if (paramString.has("readInJoy_feeds_preload_4G")) {
          this.jdField_f_of_type_Boolean = paramonk.jdField_f_of_type_Boolean;
        }
        if (paramString.has("readInJoy_feeds_preload_3G")) {
          this.jdField_g_of_type_Boolean = paramonk.jdField_g_of_type_Boolean;
        }
        if (paramString.has("readInJoy_feeds_preload_2G")) {
          this.jdField_h_of_type_Boolean = paramonk.jdField_h_of_type_Boolean;
        }
        if (paramString.has("pub_account_bottom_bar")) {
          this.jdField_i_of_type_Boolean = paramonk.jdField_i_of_type_Boolean;
        }
        if (paramString.has("readInJoy_feeds_image_preload")) {
          this.j = paramonk.j;
        }
        if (paramString.has("kandian_feeds_fling_LToR_host")) {
          this.jdField_c_of_type_JavaLangString = paramonk.jdField_c_of_type_JavaLangString;
        }
        if (paramString.has("kandian_ad_background_showtime")) {
          this.jdField_a_of_type_Long = paramonk.jdField_a_of_type_Long;
        }
        if (paramString.has("readInJoy_ip_connect")) {
          this.k = paramonk.k;
        }
        if ((paramString.has("readInJoy_ip_connect_full_report")) && (paramString.has("readInJoy_ip_connect_report_tail")))
        {
          this.jdField_a_of_type_Int = paramonk.jdField_a_of_type_Int;
          this.jdField_d_of_type_JavaLangString = paramonk.jdField_d_of_type_JavaLangString;
        }
        if (paramString.has("readInJoy_load_img")) {
          this.l = paramonk.l;
        }
        if (paramString.has("service_account_folder_redspots_delete")) {
          this.m = paramonk.m;
        }
        int i1 = 0;
        if (paramString.has("disable_big_data_channel"))
        {
          this.n = paramonk.n;
          i1 = 1;
        }
        if ((i1 != 0) && (paramString.has("host_white_list"))) {
          this.jdField_a_of_type_JavaUtilArrayList = paramonk.jdField_a_of_type_JavaUtilArrayList;
        }
        if (paramString.has("album_predown_enable")) {
          this.jdField_b_of_type_Int = paramonk.jdField_b_of_type_Int;
        }
        if (paramString.has("album_predown_photo_rule")) {
          this.jdField_c_of_type_Int = paramonk.jdField_c_of_type_Int;
        }
        if (paramString.has("album_predown_slide_photocounts")) {
          this.jdField_d_of_type_Int = paramonk.jdField_d_of_type_Int;
        }
        if (paramString.has("preload_tool_process")) {
          this.o = paramonk.o;
        }
        if (paramString.has("useNewLogic"))
        {
          this.jdField_e_of_type_JavaLangString = paramonk.jdField_e_of_type_JavaLangString;
          this.p = paramonk.p;
          this.jdField_e_of_type_Int = paramonk.jdField_e_of_type_Int;
          this.jdField_f_of_type_Int = paramonk.jdField_f_of_type_Int;
          this.jdField_g_of_type_Int = paramonk.jdField_g_of_type_Int;
          this.jdField_h_of_type_Int = paramonk.jdField_h_of_type_Int;
        }
        if (paramString.has("releaseServiceMinMem"))
        {
          this.jdField_f_of_type_JavaLangString = paramonk.jdField_f_of_type_JavaLangString;
          this.jdField_i_of_type_Int = paramonk.jdField_i_of_type_Int;
          return this;
        }
      }
      catch (JSONException paramonk)
      {
        paramonk.printStackTrace();
      }
    }
    return this;
  }
  
  public static onk a(aqxa[] paramArrayOfaqxa)
  {
    Object localObject1 = new onk();
    Object localObject2 = localObject1;
    label94:
    Object localObject3;
    if (paramArrayOfaqxa != null)
    {
      localObject2 = localObject1;
      if (paramArrayOfaqxa.length > 0)
      {
        int i1 = 0;
        String str;
        for (;;)
        {
          if (i1 >= paramArrayOfaqxa.length) {
            break label94;
          }
          str = paramArrayOfaqxa[i1].jdField_a_of_type_JavaLangString;
          try
          {
            localObject2 = ((onk)localObject1).a((onk)aqxo.a(str, onk.class), str);
            localObject1 = localObject2;
          }
          catch (QStorageInstantiateException localQStorageInstantiateException)
          {
            for (;;)
            {
              QLog.i("ServiceAccountFolderConfProcessor", 1, "loadConfig l :" + str, localQStorageInstantiateException);
            }
          }
          i1 += 1;
        }
        localObject3 = localObject1;
      }
    }
    return localObject3;
  }
  
  private static void a(onk paramonk, JSONObject paramJSONObject)
  {
    paramonk.jdField_i_of_type_Int = paramJSONObject.optInt("releaseServiceMinMem", 80);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = ((QQAppInterface)localObject).getHandler(Conversation.class);
        if (localObject != null) {
          ((MqqHandler)localObject).sendEmptyMessage(1009);
        }
      }
    }
  }
  
  private static void b(onk paramonk, JSONObject paramJSONObject)
  {
    paramonk.p = paramJSONObject.optBoolean("useNewLogic", false);
    paramonk.jdField_e_of_type_Int = paramJSONObject.optInt("minTotalMem", 1024);
    paramonk.jdField_f_of_type_Int = paramJSONObject.optInt("minAvailableMem", 100);
    paramonk.jdField_g_of_type_Int = paramJSONObject.optInt("minCpuNum", 2);
    paramonk.jdField_h_of_type_Int = paramJSONObject.optInt("minCpuFreq", 1000);
  }
  
  public void a()
  {
    a(this.q);
  }
  
  public void a(String paramString)
  {
    Object localObject;
    String str;
    label48:
    label123:
    boolean bool;
    label182:
    int i3;
    label237:
    label890:
    int i18;
    label296:
    label355:
    int i19;
    label414:
    label473:
    label1394:
    int i24;
    label532:
    label591:
    label983:
    label1512:
    int i1;
    label650:
    label709:
    label1101:
    label1627:
    int i2;
    label770:
    label831:
    int i5;
    label1042:
    label1210:
    int i6;
    label1160:
    label1335:
    int i7;
    label1453:
    int i8;
    label1568:
    int i9;
    int i10;
    int i11;
    int i14;
    int i15;
    int i16;
    int i17;
    int i20;
    int i21;
    int i22;
    int i12;
    int i23;
    int i13;
    int i4;
    try
    {
      localJSONObject = new JSONObject(paramString);
      if (!localJSONObject.has("service_folder_name")) {
        break label2022;
      }
      localObject = localJSONObject.getString("service_folder_name");
      if (!localJSONObject.has("service_folder_icon")) {
        break label2029;
      }
      str = localJSONObject.getString("service_folder_icon");
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(str))) {
        break label1908;
      }
      this.jdField_a_of_type_JavaLangString = ((String)localObject);
      this.jdField_b_of_type_JavaLangString = str;
      if (!QLog.isColorLevel()) {
        break label1913;
      }
      QLog.d("ServiceAccountFolderConfProcessor", 2, "SERVICE_ACCOUNT_FOLDER_CONFIG_CMD checkPublicAccountCenterUrlConfigData SERVICE_ACCOUNT_FOLDER_NAME:" + (String)localObject + " SERVICE_ACCOUNT_FOLDER_ICON:" + str);
    }
    catch (JSONException paramString)
    {
      JSONObject localJSONObject;
      QLog.e("ServiceAccountFolderConfProcessor", 1, "handleFlashChatConfig failed", paramString);
      return;
    }
    if (localJSONObject.has("service_folder_redspots"))
    {
      this.jdField_a_of_type_Boolean = localJSONObject.getBoolean("service_folder_redspots");
      if (!QLog.isColorLevel()) {
        break label1918;
      }
      QLog.d("ServiceAccountFolderConfProcessor", 2, "SERVICE_ACCOUNT_FOLDER_CONFIG_CMD checkPublicAccountCenterUrlConfigData service_folder_redspots:" + this.jdField_a_of_type_Boolean);
      break label1918;
      if (localJSONObject.has("service_folder_delete"))
      {
        bool = localJSONObject.getBoolean("service_folder_delete");
        this.jdField_b_of_type_Boolean = bool;
        QLog.d("ServiceAccountFolderConfProcessor", 1, "SERVICE_ACCOUNT_FOLDER_CONFIG_CMD checkPublicAccountCenterUrlConfigData service_folder_delete:" + bool);
        i3 = 1;
        if (localJSONObject.has("ServiceFolder_RedClean_After_Enter"))
        {
          this.jdField_c_of_type_Boolean = localJSONObject.getBoolean("ServiceFolder_RedClean_After_Enter");
          if (!QLog.isColorLevel()) {
            break label1923;
          }
          QLog.d("ServiceAccountFolderConfProcessor", 2, "ServiceFolder_RedClean_After_Enter = " + this.jdField_c_of_type_Boolean);
          break label1923;
          if (localJSONObject.has("readInJoy_feeds_preload"))
          {
            this.jdField_d_of_type_Boolean = localJSONObject.getBoolean("readInJoy_feeds_preload");
            if (!QLog.isColorLevel()) {
              break label1929;
            }
            QLog.d("ServiceAccountFolderConfProcessor", 2, "readInJoy feeds preload:" + this.jdField_d_of_type_Boolean);
            break label1929;
            if (localJSONObject.has("readInJoy_feeds_preload_wifi"))
            {
              this.jdField_e_of_type_Boolean = localJSONObject.getBoolean("readInJoy_feeds_preload_wifi");
              if (!QLog.isColorLevel()) {
                break label1935;
              }
              QLog.d("ServiceAccountFolderConfProcessor", 2, "readInJoy feeds preload wifi:" + this.jdField_e_of_type_Boolean);
              break label1935;
              if (localJSONObject.has("readInJoy_feeds_preload_4G"))
              {
                this.jdField_f_of_type_Boolean = localJSONObject.getBoolean("readInJoy_feeds_preload_4G");
                if (!QLog.isColorLevel()) {
                  break label1941;
                }
                QLog.d("ServiceAccountFolderConfProcessor", 2, "readInJoy feeds preload 4G:" + this.jdField_f_of_type_Boolean);
                break label1941;
                if (localJSONObject.has("readInJoy_feeds_preload_3G"))
                {
                  this.jdField_g_of_type_Boolean = localJSONObject.getBoolean("readInJoy_feeds_preload_3G");
                  if (!QLog.isColorLevel()) {
                    break label1947;
                  }
                  QLog.d("ServiceAccountFolderConfProcessor", 2, "readInJoy feeds preload 3G:" + this.jdField_g_of_type_Boolean);
                  break label1947;
                  if (localJSONObject.has("readInJoy_feeds_preload_2G"))
                  {
                    this.jdField_h_of_type_Boolean = localJSONObject.getBoolean("readInJoy_feeds_preload_2G");
                    if (!QLog.isColorLevel()) {
                      break label1953;
                    }
                    QLog.d("ServiceAccountFolderConfProcessor", 2, "readInJoy feeds preload 2G:" + this.jdField_h_of_type_Boolean);
                    break label1953;
                    if (localJSONObject.has("pub_account_bottom_bar"))
                    {
                      this.jdField_i_of_type_Boolean = localJSONObject.getBoolean("pub_account_bottom_bar");
                      if (!QLog.isColorLevel()) {
                        break label1959;
                      }
                      QLog.d("ServiceAccountFolderConfProcessor", 2, "needPABottomBar: " + this.jdField_i_of_type_Boolean);
                      break label1959;
                      if (localJSONObject.has("readInJoy_feeds_image_preload"))
                      {
                        this.j = localJSONObject.getBoolean("readInJoy_feeds_image_preload");
                        if (!QLog.isColorLevel()) {
                          break label1965;
                        }
                        QLog.d("ServiceAccountFolderConfProcessor", 2, "readInJoy feeds image preload" + this.j);
                        break label1965;
                        if (localJSONObject.has("kandian_feeds_fling_LToR_host"))
                        {
                          this.jdField_c_of_type_JavaLangString = localJSONObject.optJSONArray("kandian_feeds_fling_LToR_host").toString();
                          if (!QLog.isColorLevel()) {
                            break label1971;
                          }
                          QLog.d("ServiceAccountFolderConfProcessor", 2, "kandian_feeds_fling_LToR_host" + this.jdField_c_of_type_JavaLangString);
                          break label1971;
                          if (localJSONObject.has("kandian_ad_background_showtime"))
                          {
                            this.jdField_a_of_type_Long = localJSONObject.optLong("kandian_ad_background_showtime", 3000L);
                            if (!QLog.isColorLevel()) {
                              break label1977;
                            }
                            QLog.d("ServiceAccountFolderConfProcessor", 2, "kandian_ad_background_showtime" + this.jdField_a_of_type_Long);
                            break label1977;
                            if (localJSONObject.has("readInJoy_ip_connect"))
                            {
                              this.k = localJSONObject.getBoolean("readInJoy_ip_connect");
                              if (!QLog.isColorLevel()) {
                                break label1983;
                              }
                              QLog.d("ServiceAccountFolderConfProcessor", 2, "readInJoy_ip_connect:" + this.k);
                              break label1983;
                              if ((localJSONObject.has("readInJoy_ip_connect_full_report")) && (localJSONObject.has("readInJoy_ip_connect_report_tail")))
                              {
                                this.jdField_a_of_type_Int = localJSONObject.getInt("readInJoy_ip_connect_full_report");
                                this.jdField_d_of_type_JavaLangString = localJSONObject.getString("readInJoy_ip_connect_report_tail");
                                if (!QLog.isColorLevel()) {
                                  break label1989;
                                }
                                QLog.d("ServiceAccountFolderConfProcessor", 2, "readInJoy_ip_connect_full_report:" + this.jdField_a_of_type_Int + ", readInJoy_ip_connect_report_tail:" + this.jdField_d_of_type_JavaLangString);
                                break label1989;
                                if (localJSONObject.has("readInJoy_load_img"))
                                {
                                  this.l = localJSONObject.getBoolean("readInJoy_load_img");
                                  if (!QLog.isColorLevel()) {
                                    break label1995;
                                  }
                                  QLog.d("ServiceAccountFolderConfProcessor", 2, "readInJoyLoadImg:" + this.l);
                                  break label1995;
                                  if (localJSONObject.has("service_account_folder_redspots_delete"))
                                  {
                                    this.m = localJSONObject.getBoolean("service_account_folder_redspots_delete");
                                    if (!QLog.isColorLevel()) {
                                      break label2001;
                                    }
                                    QLog.d("ServiceAccountFolderConfProcessor", 2, "service_account_folder_redspots_delete:" + this.m);
                                    break label2001;
                                    if (localJSONObject.has("disable_big_data_channel"))
                                    {
                                      this.n = localJSONObject.getBoolean("disable_big_data_channel");
                                      if (!QLog.isColorLevel()) {
                                        break label2007;
                                      }
                                      QLog.d("ServiceAccountFolderConfProcessor", 2, "disable big data channel is " + this.n);
                                      break label2007;
                                      if ((i18 != 0) && (localJSONObject.has("host_white_list")))
                                      {
                                        localObject = localJSONObject.optJSONArray("host_white_list");
                                        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
                                        this.jdField_a_of_type_JavaUtilArrayList.clear();
                                        if (localObject != null)
                                        {
                                          i19 = 0;
                                          if (i19 < ((JSONArray)localObject).length())
                                          {
                                            this.jdField_a_of_type_JavaUtilArrayList.add(((JSONArray)localObject).getString(i19));
                                            if (!QLog.isColorLevel()) {
                                              break label2013;
                                            }
                                            QLog.d("ServiceAccountFolderConfProcessor", 2, " big data channel white host is " + ((JSONArray)localObject).getString(i19));
                                            break label2013;
                                          }
                                        }
                                      }
                                      if (localJSONObject.has("album_predown_enable"))
                                      {
                                        this.jdField_b_of_type_Int = localJSONObject.getInt("album_predown_enable");
                                        if (!QLog.isColorLevel()) {
                                          break label2036;
                                        }
                                        QLog.d("ServiceAccountFolderConfProcessor", 2, "imageCollectionPreloadEnable is " + this.jdField_b_of_type_Int);
                                        break label2036;
                                        if (localJSONObject.has("album_predown_photo_rule"))
                                        {
                                          this.jdField_c_of_type_Int = localJSONObject.getInt("album_predown_photo_rule");
                                          if (!QLog.isColorLevel()) {
                                            break label2042;
                                          }
                                          QLog.d("ServiceAccountFolderConfProcessor", 2, "imageCollectionPreloadCoverEnable is " + this.jdField_c_of_type_Int);
                                          break label2042;
                                          if (localJSONObject.has("album_predown_slide_photocounts"))
                                          {
                                            this.jdField_d_of_type_Int = localJSONObject.getInt("album_predown_slide_photocounts");
                                            if (!QLog.isColorLevel()) {
                                              break label2048;
                                            }
                                            QLog.d("ServiceAccountFolderConfProcessor", 2, "imageCollectionPreloadImageEnable is " + this.jdField_d_of_type_Int);
                                            break label2048;
                                            if (localJSONObject.has("preload_tool_process"))
                                            {
                                              this.o = localJSONObject.getBoolean("preload_tool_process");
                                              if (!QLog.isColorLevel()) {
                                                break label2054;
                                              }
                                              QLog.d("ServiceAccountFolderConfProcessor", 2, "preload tool progress is " + this.o);
                                              break label2054;
                                              if (localJSONObject.has("useNewLogic"))
                                              {
                                                this.jdField_e_of_type_JavaLangString = paramString;
                                                b(this, localJSONObject);
                                                if (!QLog.isColorLevel()) {
                                                  break label2060;
                                                }
                                                QLog.d("ServiceAccountFolderConfProcessor", 2, "read in joy preload tool progress config is " + paramString);
                                                break label2060;
                                                i24 = 0;
                                                if (localJSONObject.has("releaseServiceMinMem"))
                                                {
                                                  this.jdField_f_of_type_JavaLangString = paramString;
                                                  a(this, localJSONObject);
                                                  if (!QLog.isColorLevel()) {
                                                    break label2066;
                                                  }
                                                  QLog.d("ServiceAccountFolderConfProcessor", 2, "release web service config is " + paramString);
                                                  break label2066;
                                                }
                                                b();
                                                if ((i1 != 0) || (i2 != 0) || (i3 != 0) || (i5 != 0) || (i6 != 0) || (i7 != 0) || (i8 != 0) || (i9 != 0) || (i10 != 0) || (i11 != 0) || (i14 != 0) || (i15 != 0) || (i16 != 0) || (i17 != 0) || (i18 != 0) || (i19 != 0) || (i20 != 0) || (i21 != 0) || (i22 != 0) || (i12 != 0) || (i23 != 0) || (i13 != 0) || (i24 != 0)) {
                                                  break label2072;
                                                }
                                                if (i4 != 0) {
                                                  break label2072;
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      this.q = bool;
      return;
      bool = false;
      continue;
      i23 = 0;
      break label1568;
      i22 = 0;
      break label1512;
      i21 = 0;
      break label1453;
      i20 = 0;
      break label1394;
      i19 = 0;
      break label1335;
      i18 = 0;
      break label1160;
      i17 = 0;
      break label1101;
      i16 = 0;
      break label1042;
      i15 = 0;
      break label983;
      i14 = 0;
      break label890;
      i13 = 0;
      break label831;
      i12 = 0;
      break label770;
      i11 = 0;
      break label709;
      i10 = 0;
      break label650;
      i9 = 0;
      break label591;
      i8 = 0;
      break label532;
      i7 = 0;
      break label473;
      i6 = 0;
      break label414;
      i5 = 0;
      break label355;
      i4 = 0;
      break label296;
      i3 = 0;
      break label237;
      i2 = 0;
      break label182;
      label1908:
      i1 = 0;
      break label123;
      label1913:
      i1 = 1;
      break label123;
      label1918:
      i2 = 1;
      break label182;
      label1923:
      i4 = 1;
      break label296;
      label1929:
      i5 = 1;
      break label355;
      label1935:
      i6 = 1;
      break label414;
      label1941:
      i7 = 1;
      break label473;
      label1947:
      i8 = 1;
      break label532;
      label1953:
      i9 = 1;
      break label591;
      label1959:
      i10 = 1;
      break label650;
      label1965:
      i11 = 1;
      break label709;
      label1971:
      i12 = 1;
      break label770;
      label1977:
      i13 = 1;
      break label831;
      label1983:
      i14 = 1;
      break label890;
      label1989:
      i15 = 1;
      break label983;
      label1995:
      i16 = 1;
      break label1042;
      label2001:
      i17 = 1;
      break label1101;
      label2007:
      i18 = 1;
      break label1160;
      label2013:
      i19 += 1;
      break label1210;
      label2022:
      localObject = "";
      break;
      label2029:
      str = "";
      break label48;
      label2036:
      i19 = 1;
      break label1335;
      label2042:
      i20 = 1;
      break label1394;
      label2048:
      i21 = 1;
      break label1453;
      label2054:
      i22 = 1;
      break label1512;
      label2060:
      i23 = 1;
      break label1568;
      label2066:
      i24 = 1;
      break label1627;
      label2072:
      bool = true;
    }
  }
  
  public void b()
  {
    usu.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    usu.jdField_e_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    usu.jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
    usu.p = this.jdField_c_of_type_Boolean;
    usu.jdField_b_of_type_Boolean = this.jdField_a_of_type_Boolean;
    usu.jdField_e_of_type_Boolean = this.jdField_d_of_type_Boolean;
    usu.jdField_f_of_type_Boolean = this.jdField_e_of_type_Boolean;
    usu.jdField_g_of_type_Boolean = this.jdField_f_of_type_Boolean;
    usu.jdField_h_of_type_Boolean = this.jdField_g_of_type_Boolean;
    usu.jdField_i_of_type_Boolean = this.jdField_h_of_type_Boolean;
    usu.l = this.jdField_i_of_type_Boolean;
    usu.j = this.j;
    usu.jdField_f_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    usu.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    usu.m = this.k;
    usu.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    usu.jdField_i_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    usu.n = this.l;
    usu.jdField_c_of_type_Boolean = this.m;
    usu.o = this.n;
    usu.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    usu.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
    usu.jdField_d_of_type_Int = this.jdField_c_of_type_Int;
    usu.jdField_e_of_type_Int = this.jdField_d_of_type_Int;
    usu.k = this.o;
    usu.jdField_g_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
    usu.jdField_h_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
  }
  
  public void c()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      usu.b((QQAppInterface)localAppRuntime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     onk
 * JD-Core Version:    0.7.0.1
 */