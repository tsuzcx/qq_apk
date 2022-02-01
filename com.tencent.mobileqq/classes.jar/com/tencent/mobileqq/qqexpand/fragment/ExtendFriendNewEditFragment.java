package com.tencent.mobileqq.qqexpand.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.AgeSelectionActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtReq;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqexpand.bean.profile.ExtendFriendInfo;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils;
import com.tencent.mobileqq.qqexpand.network.IExpandCmdHandler;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qqexpand.widget.ActionSheetCustom;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendHonorOfKingRecordView;
import com.tencent.mobileqq.qqexpand.widget.PhotoWallListView;
import com.tencent.mobileqq.qqexpand.widget.PhotoWallListView.PhotoPath;
import com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoiceView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qqexpand.userInfo.userInfo.UserInfo.BaseInfo;
import com.tencent.trpcprotocol.qqexpand.userInfo.userInfo.UserInfo.Birthday;
import com.tencent.trpcprotocol.qqexpand.userInfo.userInfo.UserInfo.ExpandInfo;
import com.tencent.trpcprotocol.qqexpand.userInfo.userInfo.UserInfo.LocationInfo;
import com.tencent.trpcprotocol.qqexpand.userInfo.userInfo.UserInfo.MiniInfo;
import com.tencent.trpcprotocol.qqexpand.userInfo.userInfo.UserInfo.PicturesWall;
import com.tencent.trpcprotocol.qqexpand.userInfo.userInfo.UserInfo.SetMiniUserInfoReq;
import com.tencent.upload.network.NetworkState;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ExtendFriendNewEditFragment
  extends QPublicBaseFragment
  implements View.OnClickListener
{
  private String A = "";
  private int B = 0;
  private int C = 0;
  private int D = 0;
  private int E = 0;
  private int F = 0;
  private String G = "";
  private String H = "";
  private String I = "";
  private String J;
  private EditText K;
  private TextView L;
  private TextView M;
  private int N;
  private int O;
  private int P;
  private int Q;
  private int R;
  private int S;
  private View T;
  private View U;
  private View V;
  private TextView W;
  private QQToast X;
  private View Y;
  private ExtendFriendHonorOfKingRecordView Z;
  ExtendFriendNewEditFragment.MaxNicknameTextWatcher a;
  private String aa = "";
  private long ab = 0L;
  private long ac = 3000L;
  private ConditionSearchManager.IConfigListener ad = new ExtendFriendNewEditFragment.1(this);
  private final TransProcessorHandler ae = new ExtendFriendNewEditFragment.2(this);
  private Runnable af = new ExtendFriendNewEditFragment.3(this);
  private IphonePickerView.PickerViewAdapter ag = new ExtendFriendNewEditFragment.4(this);
  private IphonePickerView.PickerViewAdapter ah = new ExtendFriendNewEditFragment.5(this);
  private QBaseActivity b;
  private View c;
  private QQAppInterface d;
  private QQProgressDialog e;
  private ConditionSearchManager f;
  private TextView g;
  private PhotoWallListView h;
  private ArrayList<PhotoWallListView.PhotoPath> i = new ArrayList();
  private int j;
  private DynamicAvatarView k;
  private PhotoWallListView.PhotoPath l;
  private ImageView m;
  private TextView n;
  private ImageView o;
  private ImageView p;
  private TextView q;
  private ExpandVoiceView r;
  private RelativeLayout s;
  private boolean t = false;
  private boolean u = false;
  private boolean v = false;
  private boolean w = false;
  private String x = "";
  private String y = "";
  private int z = 0;
  
  private String A()
  {
    Object localObject = (String[])this.W.getTag();
    localObject = this.f.d((String[])localObject);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!"不限".equals(localObject))) {
      return localObject;
    }
    return this.I;
  }
  
  private UserInfo.BaseInfo B()
  {
    UserInfo.BaseInfo localBaseInfo = new UserInfo.BaseInfo();
    localBaseInfo.nick.set(v());
    localBaseInfo.age.set(x());
    localBaseInfo.constellation.set(w());
    localBaseInfo.gender.set(y());
    localBaseInfo.birthday.set(u());
    localBaseInfo.self_birthday.set(u());
    localBaseInfo.age_group.set(t());
    localBaseInfo.city.set(A());
    localBaseInfo.location.set(z());
    return localBaseInfo;
  }
  
  private UserInfo.PicturesWall C()
  {
    UserInfo.PicturesWall localPicturesWall = new UserInfo.PicturesWall();
    int i1 = 0;
    while (i1 < this.i.size())
    {
      localPicturesWall.pictures_wall_pic.add(((PhotoWallListView.PhotoPath)this.i.get(i1)).a);
      i1 += 1;
    }
    return localPicturesWall;
  }
  
  private String D()
  {
    PhotoWallListView.PhotoPath localPhotoPath = this.l;
    if (localPhotoPath != null) {
      return localPhotoPath.a;
    }
    return "";
  }
  
  private UserInfo.ExpandInfo E()
  {
    UserInfo.ExpandInfo localExpandInfo = new UserInfo.ExpandInfo();
    localExpandInfo.declarationa.set(this.x);
    localExpandInfo.voice_url.set(this.y);
    localExpandInfo.voice_duration.set(this.z);
    return localExpandInfo;
  }
  
  private UserInfo.MiniInfo F()
  {
    UserInfo.MiniInfo localMiniInfo = new UserInfo.MiniInfo();
    localMiniInfo.base_info.set(B());
    localMiniInfo.avatar.set(D());
    localMiniInfo.expand_info.set(E());
    localMiniInfo.pictures_wall_urls.set(C());
    return localMiniInfo;
  }
  
  private UserInfo.SetMiniUserInfoReq G()
  {
    UserInfo.SetMiniUserInfoReq localSetMiniUserInfoReq = new UserInfo.SetMiniUserInfoReq();
    if (this.t) {
      localSetMiniUserInfoReq.mini_info_ids.add(Integer.valueOf(1));
    }
    if (this.u) {
      localSetMiniUserInfoReq.mini_info_ids.add(Integer.valueOf(2));
    }
    if (this.v) {
      localSetMiniUserInfoReq.mini_info_ids.add(Integer.valueOf(3));
    }
    if (this.w) {
      localSetMiniUserInfoReq.mini_info_ids.add(Integer.valueOf(12));
    }
    localSetMiniUserInfoReq.infos.set(F());
    return localSetMiniUserInfoReq;
  }
  
  private void H()
  {
    if (a(this.A, v()))
    {
      this.t = true;
      return;
    }
    if (this.B != y())
    {
      this.t = true;
      return;
    }
    Object[] arrayOfObject = (Object[])this.M.getTag();
    if ((arrayOfObject != null) && (arrayOfObject.length > 0))
    {
      int i2 = 0;
      int i1 = ((Integer)arrayOfObject[0]).intValue();
      int i3;
      if (i1 != 0)
      {
        i2 = i1 >>> 16;
        i3 = (0xFF00 & i1) >>> 8;
        i1 &= 0xFF;
      }
      else
      {
        i1 = 0;
        i3 = 0;
      }
      if ((this.D != i2) || (this.E != i3) || (this.F != i1)) {
        this.t = true;
      }
    }
    else
    {
      if ((this.D != 0) || (this.E != 0) || (this.F != 0)) {
        break label183;
      }
    }
    if (a(this.I, A())) {
      this.t = true;
    }
    return;
    label183:
    this.t = true;
  }
  
  private JSONObject I()
  {
    Object localObject = (String[])this.W.getTag();
    int i2;
    int i3;
    int i4;
    int i1;
    if ((localObject != null) && (localObject.length >= 4))
    {
      i2 = Integer.parseInt(localObject[0]);
      i3 = Integer.parseInt(localObject[1]);
      i4 = Integer.parseInt(localObject[2]);
      i1 = Integer.parseInt(localObject[3]);
    }
    else
    {
      i1 = 0;
      i2 = 0;
      i3 = 0;
      i4 = 0;
    }
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).putOpt("country", Integer.valueOf(i2));
      ((JSONObject)localObject).putOpt("province", Integer.valueOf(i3));
      ((JSONObject)localObject).putOpt("city", Integer.valueOf(i4));
      ((JSONObject)localObject).putOpt("district", Integer.valueOf(i1));
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("ExtendFriendNewEditFragment", 1, localJSONException, new Object[0]);
    }
    return localObject;
  }
  
  private JSONObject J()
  {
    JSONObject localJSONObject = new JSONObject();
    Object[] arrayOfObject = (Object[])this.M.getTag();
    if ((arrayOfObject != null) && (arrayOfObject.length > 0))
    {
      i1 = ((Integer)arrayOfObject[0]).intValue();
      if (i1 != 0)
      {
        i2 = i1 >>> 16;
        i3 = (0xFF00 & i1) >>> 8;
        i1 &= 0xFF;
        break label79;
      }
    }
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    try
    {
      label79:
      localJSONObject.putOpt("year", Integer.valueOf(i2));
      localJSONObject.putOpt("month", Integer.valueOf(i3));
      localJSONObject.putOpt("day", Integer.valueOf(i1));
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("ExtendFriendNewEditFragment", 1, localJSONException, new Object[0]);
    }
    return localJSONObject;
  }
  
  private JSONObject K()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.putOpt("nick", v());
      localJSONObject.putOpt("age", Integer.valueOf(x()));
      localJSONObject.putOpt("constellation", w());
      localJSONObject.putOpt("gender", Integer.valueOf(y()));
      localJSONObject.putOpt("birthday", J());
      localJSONObject.putOpt("self_birthday", J());
      localJSONObject.putOpt("age_group", t());
      localJSONObject.putOpt("city", A());
      localJSONObject.putOpt("location", I());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("ExtendFriendNewEditFragment", 1, localJSONException, new Object[0]);
    }
    return localJSONObject;
  }
  
  private JSONObject L()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.putOpt("declarationa", this.x);
      localJSONObject.putOpt("voice_url", this.y);
      localJSONObject.putOpt("voice_duration", Integer.valueOf(this.z));
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("ExtendFriendNewEditFragment", 1, localJSONException, new Object[0]);
    }
    return localJSONObject;
  }
  
  private JSONObject M()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      JSONArray localJSONArray = new JSONArray();
      int i1 = 0;
      while (i1 < this.i.size())
      {
        localJSONArray.put(i1, ((PhotoWallListView.PhotoPath)this.i.get(i1)).a);
        i1 += 1;
      }
      localJSONObject.putOpt("pictures_wall_pic", localJSONArray);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("ExtendFriendNewEditFragment", 1, localJSONException, new Object[0]);
    }
    return localJSONObject;
  }
  
  private JSONObject N()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.putOpt("base_info", K());
      localJSONObject.putOpt("avatar", D());
      localJSONObject.putOpt("expand_info", L());
      localJSONObject.putOpt("pictures_wall_urls", M());
      localJSONObject.putOpt("wangzhe_record", new JSONObject(this.J));
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("ExtendFriendNewEditFragment", 1, localJSONException, new Object[0]);
    }
    return localJSONObject;
  }
  
  private JSONObject O()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.putOpt("infos", N());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("ExtendFriendNewEditFragment", 1, localJSONException, new Object[0]);
    }
    return localJSONObject;
  }
  
  private boolean P()
  {
    if (!TextUtils.isEmpty(this.J)) {
      try
      {
        JSONObject localJSONObject = new JSONObject(this.J).optJSONObject("record");
        if (localJSONObject == null) {
          return false;
        }
        int i1 = localJSONObject.optInt("grade");
        return i1 > 0;
      }
      catch (JSONException localJSONException)
      {
        QLog.d("ExtendFriendNewEditFragment", 1, localJSONException.toString());
      }
    }
    return false;
  }
  
  private String a(int paramInt)
  {
    int i1 = 0;
    if (paramInt >= 1960) {
      i1 = (paramInt - 1960) / 10 + 1;
    }
    this.G = new String[] { "", "60后", "70后", "80后", "90后", "00后", "10后", "10后" }[i1];
    return this.G;
  }
  
  private String a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    String str = a(paramInt1);
    StringBuilder localStringBuilder = new StringBuilder();
    if (TextUtils.isEmpty(str))
    {
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("-");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("-");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString);
    }
    else
    {
      localStringBuilder.append(str);
      localStringBuilder.append("-");
      localStringBuilder.append(paramString);
    }
    return localStringBuilder.toString();
  }
  
  /* Error */
  private String a(String paramString)
  {
    // Byte code:
    //   0: new 520	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 521	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 6
    //   10: aconst_null
    //   11: astore 4
    //   13: aconst_null
    //   14: astore_2
    //   15: new 523	java/io/FileInputStream
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 524	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   23: astore_3
    //   24: aload_3
    //   25: astore_1
    //   26: aload_3
    //   27: aload 6
    //   29: invokevirtual 528	java/io/File:length	()J
    //   32: invokestatic 534	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   35: astore 5
    //   37: aload 5
    //   39: astore_1
    //   40: aload_1
    //   41: astore_2
    //   42: goto +48 -> 90
    //   45: astore_1
    //   46: aload_3
    //   47: astore_2
    //   48: aload_1
    //   49: astore_3
    //   50: goto +76 -> 126
    //   53: aload_3
    //   54: astore_1
    //   55: aload 6
    //   57: invokevirtual 537	java/io/File:exists	()Z
    //   60: ifeq +30 -> 90
    //   63: aload_3
    //   64: astore_1
    //   65: aload 6
    //   67: invokestatic 542	com/tencent/qqprotect/singleupdate/MD5FileUtil:a	(Ljava/io/File;)Ljava/lang/String;
    //   70: astore_2
    //   71: aload_2
    //   72: ifnull +143 -> 215
    //   75: goto +3 -> 78
    //   78: aload_3
    //   79: astore_1
    //   80: aload_2
    //   81: invokestatic 548	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   84: astore_2
    //   85: aload_2
    //   86: astore_1
    //   87: goto -47 -> 40
    //   90: aload_3
    //   91: invokevirtual 551	java/io/FileInputStream:close	()V
    //   94: aload_2
    //   95: astore_1
    //   96: goto +77 -> 173
    //   99: astore_1
    //   100: ldc_w 397
    //   103: iconst_1
    //   104: aload_1
    //   105: iconst_0
    //   106: anewarray 399	java/lang/Object
    //   109: invokestatic 404	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   112: aload_2
    //   113: astore_1
    //   114: goto +59 -> 173
    //   117: astore_2
    //   118: aconst_null
    //   119: astore_1
    //   120: goto +59 -> 179
    //   123: astore_3
    //   124: aconst_null
    //   125: astore_2
    //   126: aload_2
    //   127: astore_1
    //   128: ldc_w 397
    //   131: iconst_1
    //   132: aload_3
    //   133: iconst_0
    //   134: anewarray 399	java/lang/Object
    //   137: invokestatic 404	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   140: aload 4
    //   142: astore_1
    //   143: aload_2
    //   144: ifnull +29 -> 173
    //   147: aload_2
    //   148: invokevirtual 551	java/io/FileInputStream:close	()V
    //   151: aload 4
    //   153: astore_1
    //   154: goto +19 -> 173
    //   157: astore_1
    //   158: ldc_w 397
    //   161: iconst_1
    //   162: aload_1
    //   163: iconst_0
    //   164: anewarray 399	java/lang/Object
    //   167: invokestatic 404	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   170: aload 4
    //   172: astore_1
    //   173: aload_1
    //   174: invokestatic 555	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   177: areturn
    //   178: astore_2
    //   179: aload_1
    //   180: ifnull +23 -> 203
    //   183: aload_1
    //   184: invokevirtual 551	java/io/FileInputStream:close	()V
    //   187: goto +16 -> 203
    //   190: astore_1
    //   191: ldc_w 397
    //   194: iconst_1
    //   195: aload_1
    //   196: iconst_0
    //   197: anewarray 399	java/lang/Object
    //   200: invokestatic 404	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   203: goto +5 -> 208
    //   206: aload_2
    //   207: athrow
    //   208: goto -2 -> 206
    //   211: astore_1
    //   212: goto -159 -> 53
    //   215: ldc 108
    //   217: astore_2
    //   218: goto -140 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	ExtendFriendNewEditFragment
    //   0	221	1	paramString	String
    //   14	99	2	localObject1	Object
    //   117	1	2	localObject2	Object
    //   125	23	2	localObject3	Object
    //   178	29	2	localObject4	Object
    //   217	1	2	str	String
    //   23	68	3	localObject5	Object
    //   123	10	3	localIOException	java.io.IOException
    //   11	160	4	localObject6	Object
    //   35	3	5	arrayOfByte	byte[]
    //   8	58	6	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   26	37	45	java/io/IOException
    //   55	63	45	java/io/IOException
    //   65	71	45	java/io/IOException
    //   80	85	45	java/io/IOException
    //   90	94	99	java/io/IOException
    //   15	24	117	finally
    //   15	24	123	java/io/IOException
    //   147	151	157	java/io/IOException
    //   26	37	178	finally
    //   55	63	178	finally
    //   65	71	178	finally
    //   80	85	178	finally
    //   128	140	178	finally
    //   183	187	190	java/io/IOException
    //   26	37	211	java/lang/UnsatisfiedLinkError
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = this.N;
    int i2 = paramInt1 + 1896;
    i1 -= i2;
    Object localObject = Calendar.getInstance();
    int i3 = paramInt2 + 1;
    paramInt3 += 1;
    ((Calendar)localObject).set(1, i3, paramInt3);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, this.O, this.P);
    paramInt1 = i1;
    if (((Calendar)localObject).after(localCalendar)) {
      paramInt1 = i1 - 1;
    }
    paramInt2 = paramInt1;
    if (paramInt1 < 0) {
      paramInt2 = 0;
    }
    this.H = Utils.b(i3, paramInt3);
    paramInt1 = AgeSelectionActivity.a(this.H);
    localObject = a(i2, i3, paramInt3, this.H);
    a(this.M, (String)localObject);
    this.M.setTag(new Object[] { Integer.valueOf(i2 << 16 | i3 << 8 | paramInt3), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
  }
  
  private void a(TextView paramTextView, String paramString)
  {
    if (paramTextView == null) {
      return;
    }
    paramTextView.setText(paramString);
  }
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    if (a(this.x, paramString1))
    {
      this.v = true;
      return;
    }
    if (a(this.y, paramString2))
    {
      this.v = true;
      return;
    }
    if (this.z != paramInt) {
      this.v = true;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.aa = O().toString();
      Intent localIntent = this.b.getIntent();
      if (localIntent != null)
      {
        String str = this.aa;
        if (str != null)
        {
          localIntent.putExtra("key_extend_friend_info_json", str);
          this.b.setResult(-1, localIntent);
        }
      }
    }
    else
    {
      this.b.setResult(0);
    }
    this.b.finish();
  }
  
  private void a(String[] paramArrayOfString)
  {
    Object localObject1;
    try
    {
      String str = this.f.d(paramArrayOfString);
    }
    catch (Exception localException)
    {
      QLog.e("ExtendFriendNewEditFragment", 1, localException, new Object[0]);
      localObject1 = null;
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (!localObject1.equals("不限")) {}
    }
    else
    {
      localObject2 = "";
    }
    if ((this.W != null) && (!TextUtils.isEmpty((CharSequence)localObject2)))
    {
      a(this.W, (String)localObject2);
      this.W.setTag(paramArrayOfString);
    }
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return true;
      }
      return paramString1.equals(paramString2) ^ true;
    }
    return true;
  }
  
  private void b(String paramString)
  {
    this.b.runOnUiThread(new ExtendFriendNewEditFragment.10(this, paramString));
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(0, "该头像为QQ头像，请前往QQ资料卡进行修改", false);
      return;
    }
    a(0, "该昵称为QQ昵称，请前往QQ资料卡进行修改", false);
  }
  
  private int d()
  {
    return new Random().nextInt(90000000) + 10000000;
  }
  
  private void e()
  {
    if (g() >= 0)
    {
      this.d.execute(this.af);
      return;
    }
    f();
  }
  
  private void f()
  {
    Object localObject1 = this.l;
    if ((localObject1 != null) && (TextUtils.isEmpty(((PhotoWallListView.PhotoPath)localObject1).a)) && (!TextUtils.isEmpty(this.l.b)))
    {
      localObject1 = new TransferRequest();
      ((TransferRequest)localObject1).mIsUp = true;
      ((TransferRequest)localObject1).mSelfUin = this.d.getCurrentUin();
      ((TransferRequest)localObject1).mLocalPath = this.l.b;
      ((TransferRequest)localObject1).mUniseq = System.currentTimeMillis();
      ((TransferRequest)localObject1).mFileType = 68;
      Bdh_extinfo.CommFileExtReq localCommFileExtReq = new Bdh_extinfo.CommFileExtReq();
      localCommFileExtReq.uint32_action_type.set(0);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(d());
      ((StringBuilder)localObject2).append("-");
      ((StringBuilder)localObject2).append(a(this.l.b));
      ((StringBuilder)localObject2).append(".jpg");
      localObject2 = ((StringBuilder)localObject2).toString();
      localCommFileExtReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      ((TransferRequest)localObject1).mExtentionInfo = localCommFileExtReq.toByteArray();
      ((ITransFileController)this.d.getRuntimeService(ITransFileController.class)).transferAsync((TransferRequest)localObject1);
      return;
    }
    QLog.d("ExtendFriendNewEditFragment", 1, "uploadAvatar mAvatarPath is null or already upload");
    c();
  }
  
  private int g()
  {
    this.j = -1;
    int i1 = 0;
    while (i1 < this.i.size())
    {
      if (((PhotoWallListView.PhotoPath)this.i.get(i1)).b())
      {
        this.j = i1;
        break;
      }
      i1 += 1;
    }
    return this.j;
  }
  
  private void h()
  {
    ActionSheetCustom localActionSheetCustom = ActionSheetCustom.a(this.b);
    Object localObject = (DispatchActionMoveScrollView)localActionSheetCustom.findViewById(2131427560);
    ((DispatchActionMoveScrollView)localObject).a = true;
    ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
    localObject = (IphonePickerView)LayoutInflater.from(this.b).inflate(2131627482, null);
    ((IphonePickerView)localObject).a(this.ag);
    if (this.L.getTag() != null)
    {
      int i2 = ((Integer)this.L.getTag()).intValue();
      int i1;
      if (i2 >= 0)
      {
        i1 = i2;
        if (i2 <= 1) {}
      }
      else
      {
        i1 = 0;
      }
      ((IphonePickerView)localObject).setSelection(0, i1);
      ((IphonePickerView)localObject).setPickListener(new ExtendFriendNewEditFragment.7(this, (IphonePickerView)localObject, localActionSheetCustom));
      localActionSheetCustom.a(new ExtendFriendNewEditFragment.8(this));
      localActionSheetCustom.setOnDismissListener(new ExtendFriendNewEditFragment.9(this));
      this.T.setClickable(false);
      localActionSheetCustom.setActionContentView((View)localObject, null);
      localActionSheetCustom.show();
    }
  }
  
  private void i()
  {
    this.b.runOnUiThread(new ExtendFriendNewEditFragment.11(this));
  }
  
  private void j()
  {
    Intent localIntent = new Intent();
    ExtendFriendInfo localExtendFriendInfo = new ExtendFriendInfo();
    localExtendFriendInfo.a = this.x;
    localExtendFriendInfo.d = this.y;
    localExtendFriendInfo.e = this.z;
    localIntent.putExtra("key_extend_friend_info", localExtendFriendInfo);
    QPublicFragmentActivity.startForResult(this.b, localIntent, ExpandEditFragment.class, 5003);
  }
  
  private void k()
  {
    ActionSheetCustom localActionSheetCustom = ActionSheetCustom.a(this.b);
    Calendar localCalendar = Calendar.getInstance();
    this.N = localCalendar.get(1);
    Object localObject = (DispatchActionMoveScrollView)localActionSheetCustom.findViewById(2131427560);
    ((DispatchActionMoveScrollView)localObject).a = true;
    ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
    localObject = (IphonePickerView)LayoutInflater.from(this.b).inflate(2131627482, null);
    ((IphonePickerView)localObject).a(this.ah);
    if (this.M.getTag() != null)
    {
      int i1 = ((Integer)((Object[])(Object[])this.M.getTag())[0]).intValue();
      if (i1 == 0)
      {
        this.Q = 94;
        this.R = 0;
        this.S = 0;
      }
      else
      {
        this.Q = ((i1 >>> 16) - 1896);
        this.R = (((0xFF00 & i1) >>> 8) - 1);
        this.S = ((i1 & 0xFF) - 1);
      }
      localCalendar.setTimeInMillis(System.currentTimeMillis());
      this.N = localCalendar.get(1);
      this.O = (localCalendar.get(2) + 1);
      this.P = localCalendar.get(5);
      ((IphonePickerView)localObject).setPickListener(new ExtendFriendNewEditFragment.12(this, (IphonePickerView)localObject, localActionSheetCustom));
      localActionSheetCustom.a(new ExtendFriendNewEditFragment.13(this, (IphonePickerView)localObject));
      localActionSheetCustom.setOnDismissListener(new ExtendFriendNewEditFragment.14(this, (IphonePickerView)localObject));
      this.U.setClickable(false);
      ((IphonePickerView)localObject).setSelection(0, this.Q);
      ((IphonePickerView)localObject).setSelection(1, this.R);
      ((IphonePickerView)localObject).setSelection(2, this.S);
      localActionSheetCustom.setActionContentView((View)localObject, null);
      localActionSheetCustom.show();
    }
  }
  
  private String l()
  {
    Object[] arrayOfObject = (Object[])this.M.getTag();
    if ((arrayOfObject != null) && (arrayOfObject.length >= 3))
    {
      int i1 = ((Integer)arrayOfObject[0]).intValue();
      if (i1 == 0) {
        return "";
      }
      return a(i1 >>> 16, (0xFF00 & i1) >>> 8, i1 & 0xFF, this.H);
    }
    return "";
  }
  
  private void m()
  {
    o();
    q();
    p();
    n();
    a(this.K, this.A);
    a(this.L, this.ag.getText(0, this.B - 1));
    a(this.M, l());
    a(this.W, this.I);
  }
  
  private void n()
  {
    if (P()) {
      try
      {
        JSONObject localJSONObject = new JSONObject(this.J);
        this.Z.setData(localJSONObject);
        this.Y.setVisibility(0);
        return;
      }
      catch (JSONException localJSONException)
      {
        QLog.d("ExtendFriendNewEditFragment", 1, localJSONException.toString());
      }
    }
    this.Y.setVisibility(8);
  }
  
  private void o()
  {
    this.h.a();
    String str = String.format("(%d/4)", new Object[] { Integer.valueOf(this.i.size()) });
    this.g.setText(str);
  }
  
  private void p()
  {
    Object localObject1 = this.l;
    if (localObject1 != null)
    {
      if (!TextUtils.isEmpty(((PhotoWallListView.PhotoPath)localObject1).b))
      {
        ThreadManager.getFileThreadHandler().post(new ExtendFriendNewEditFragment.15(this));
        return;
      }
      if (!TextUtils.isEmpty(this.l.a))
      {
        localObject1 = this.d;
        localObject1 = FaceDrawable.getFaceDrawable((AppInterface)localObject1, 1, ((QQAppInterface)localObject1).getCurrentUin());
        Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.k.getWidth();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.k.getHeight();
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
        localObject1 = URLDrawable.getDrawable(this.l.a, (URLDrawable.URLDrawableOptions)localObject2);
        ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.b);
        ((URLDrawable)localObject1).setTag(new int[] { 640, 640 });
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendNewEditFragment", 2, "onGetHDHeadUrl: newDisplayHDHead");
        }
        localObject2 = this.k;
        QQAppInterface localQQAppInterface = this.d;
        ((DynamicAvatarView)localObject2).setFaceDrawable(localQQAppInterface, (Drawable)localObject1, 1, 200, localQQAppInterface.getCurrentUin(), 640, true, null, false, true, false, true, 7);
      }
    }
  }
  
  private void q()
  {
    if (TextUtils.isEmpty(this.x)) {
      this.q.setText("介绍一下自己的特长、兴趣爱好、交友目的");
    } else {
      this.q.setText(this.x);
    }
    String str = this.y;
    if ((str != null) && (this.z > 0))
    {
      this.r.setVoiceUrl(str);
      this.r.setVoiceDuration(this.z);
      this.r.setVisibility(0);
      this.s.setVisibility(8);
      return;
    }
    this.r.setVisibility(8);
    this.s.setVisibility(0);
  }
  
  private void r()
  {
    DialogUtil.a(this.b, 0, null, "返回会丢失当前编辑内容，是否返回？", "取消", "确定", new ExtendFriendNewEditFragment.16(this), new ExtendFriendNewEditFragment.17(this)).show();
  }
  
  private void s()
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("parseExtendFriendInfo:");
      ((StringBuilder)localObject1).append(this.aa);
      QLog.d("ExtendFriendNewEditFragment", 1, ((StringBuilder)localObject1).toString());
      localObject1 = new JSONObject(this.aa).getJSONObject("infos");
      this.l = new PhotoWallListView.PhotoPath(((JSONObject)localObject1).optString("avatar"), null);
      Object localObject2 = ((JSONObject)localObject1).optJSONObject("wangzhe_record");
      if (localObject2 != null) {
        this.J = ((JSONObject)localObject2).toString();
      }
      localObject2 = ((JSONObject)localObject1).optJSONObject("expand_info");
      if (localObject2 != null)
      {
        this.x = ((JSONObject)localObject2).optString("declarationa");
        this.y = ((JSONObject)localObject2).optString("voice_url");
        this.z = ((JSONObject)localObject2).optInt("voice_duration");
      }
      localObject2 = ((JSONObject)localObject1).optJSONObject("pictures_wall_urls");
      if (localObject2 != null)
      {
        localObject2 = ((JSONObject)localObject2).optJSONArray("pictures_wall_pic");
        if (localObject2 != null)
        {
          ArrayList localArrayList = new ArrayList();
          i1 = 0;
          while (i1 < ((JSONArray)localObject2).length())
          {
            localArrayList.add(((JSONArray)localObject2).getString(i1));
            i1 += 1;
          }
          this.h.a(localArrayList);
        }
        else
        {
          this.h.a(null);
        }
      }
      localObject1 = ((JSONObject)localObject1).getJSONObject("base_info");
      this.A = ((JSONObject)localObject1).optString("nick");
      this.B = ((JSONObject)localObject1).optInt("gender");
      this.L.setTag(Integer.valueOf(this.B - 1));
      this.C = ((JSONObject)localObject1).optInt("age");
      this.G = ((JSONObject)localObject1).optString("age_group");
      this.H = ((JSONObject)localObject1).optString("constellation");
      int i1 = AgeSelectionActivity.a(this.H);
      localObject2 = ((JSONObject)localObject1).getJSONObject("self_birthday");
      this.D = ((JSONObject)localObject2).optInt("year");
      this.E = ((JSONObject)localObject2).optInt("month");
      this.F = ((JSONObject)localObject2).optInt("day");
      int i2 = this.D;
      int i3 = this.E;
      int i4 = this.F;
      this.M.setTag(new Object[] { Integer.valueOf(i2 << 16 | i3 << 8 | i4), Integer.valueOf(this.C), Integer.valueOf(i1) });
      this.I = ((JSONObject)localObject1).optString("city");
      localObject1 = ((JSONObject)localObject1).optJSONObject("location");
      if (localObject1 != null)
      {
        i1 = ((JSONObject)localObject1).optInt("country");
        i2 = ((JSONObject)localObject1).optInt("province");
        i3 = ((JSONObject)localObject1).optInt("city");
        i4 = ((JSONObject)localObject1).optInt("district");
        this.W.setTag(new String[] { String.valueOf(i1), String.valueOf(i2), String.valueOf(i3), String.valueOf(i4) });
      }
      else
      {
        this.W.setTag(new String[] { "0", "0", "0", "0" });
      }
    }
    catch (JSONException localJSONException)
    {
      a(1, "数据获取发生异常", true);
      QLog.e("ExtendFriendNewEditFragment", 1, "parseExtendFriendInfo exception", localJSONException);
    }
    this.b.runOnUiThread(new ExtendFriendNewEditFragment.19(this));
  }
  
  private String t()
  {
    return this.G;
  }
  
  private UserInfo.Birthday u()
  {
    UserInfo.Birthday localBirthday = new UserInfo.Birthday();
    Object[] arrayOfObject = (Object[])this.M.getTag();
    if ((arrayOfObject != null) && (arrayOfObject.length > 0))
    {
      int i2 = 0;
      int i1 = ((Integer)arrayOfObject[0]).intValue();
      int i3;
      if (i1 != 0)
      {
        i2 = i1 >>> 16;
        i3 = (0xFF00 & i1) >>> 8;
        i1 &= 0xFF;
      }
      else
      {
        i1 = 0;
        i3 = 0;
      }
      localBirthday.year.set(i2);
      localBirthday.month.set(i3);
      localBirthday.day.set(i1);
    }
    return localBirthday;
  }
  
  private String v()
  {
    return this.K.getText().toString();
  }
  
  private String w()
  {
    Object[] arrayOfObject = (Object[])this.M.getTag();
    if ((arrayOfObject != null) && (arrayOfObject.length >= 3)) {
      return Utils.c(((Integer)arrayOfObject[2]).intValue());
    }
    return "";
  }
  
  private int x()
  {
    Object[] arrayOfObject = (Object[])this.M.getTag();
    if ((arrayOfObject != null) && (arrayOfObject.length >= 2)) {
      return ((Integer)arrayOfObject[1]).intValue();
    }
    return 0;
  }
  
  private int y()
  {
    int i1 = ((Integer)this.L.getTag()).intValue();
    if ((i1 >= 0) && (i1 <= 1)) {
      return i1 + 1;
    }
    return 0;
  }
  
  private UserInfo.LocationInfo z()
  {
    UserInfo.LocationInfo localLocationInfo = new UserInfo.LocationInfo();
    String[] arrayOfString = (String[])this.W.getTag();
    if ((arrayOfString != null) && (arrayOfString.length >= 4))
    {
      localLocationInfo.country.set(Integer.parseInt(arrayOfString[0]));
      localLocationInfo.province.set(Integer.parseInt(arrayOfString[1]));
      localLocationInfo.city.set(Integer.parseInt(arrayOfString[2]));
      localLocationInfo.district.set(Integer.parseInt(arrayOfString[3]));
      return localLocationInfo;
    }
    localLocationInfo.country.set(0);
    localLocationInfo.province.set(0);
    localLocationInfo.city.set(0);
    localLocationInfo.district.set(0);
    return localLocationInfo;
  }
  
  public void a()
  {
    Intent localIntent = new Intent(this.b, LocationSelectActivity.class);
    localIntent.putExtra("param_req_type", 2);
    localIntent.putExtra("param_title", "城市");
    int i1 = this.f.d();
    if (i1 != 0)
    {
      i1 = this.f.a(i1, true);
      if (i1 == 2)
      {
        a(1, "当前网络不可用，请检查网络设置。", false);
        return;
      }
      if (i1 == 0)
      {
        b(this.b.getResources().getString(2131888006));
        this.f.c(this.ad);
      }
      return;
    }
    String[] arrayOfString2 = (String[])this.W.getTag();
    String[] arrayOfString1;
    if (arrayOfString2 != null)
    {
      arrayOfString1 = arrayOfString2;
      if (arrayOfString2.length == 4) {}
    }
    else
    {
      arrayOfString1 = new String[4];
      arrayOfString1[0] = "0";
      arrayOfString1[1] = "0";
      arrayOfString1[2] = "0";
      arrayOfString1[3] = "0";
    }
    localIntent.putExtra("param_location", arrayOfString1);
    localIntent.putExtra("param_is_popup", false);
    localIntent.putExtra("param_location_param", this.f.d(arrayOfString1));
    this.b.startActivityForResult(localIntent, 5002);
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    this.b.runOnUiThread(new ExtendFriendNewEditFragment.6(this, paramBoolean, paramInt, paramString));
  }
  
  public void b()
  {
    ILimitChatUtils localILimitChatUtils = (ILimitChatUtils)QRoute.api(ILimitChatUtils.class);
    QQAppInterface localQQAppInterface = this.d;
    localILimitChatUtils.preLoadDataForArkMiniProfileCard(localQQAppInterface, Long.valueOf(Long.parseLong(localQQAppInterface.getCurrentUin())), new ExtendFriendNewEditFragment.18(this));
  }
  
  public void c()
  {
    UserInfo.SetMiniUserInfoReq localSetMiniUserInfoReq = G();
    ((IExpandCmdHandler)QRoute.api(IExpandCmdHandler.class)).sendSSORequest(this.d, "QQExpand.UserInfo.SetMiniUserInfo", localSetMiniUserInfoReq.toByteArray(), new ExtendFriendNewEditFragment.20(this));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Bundle localBundle;
    if (paramIntent != null) {
      localBundle = paramIntent.getExtras();
    } else {
      localBundle = null;
    }
    if (localBundle == null)
    {
      QLog.e("ExtendFriendNewEditFragment", 1, "onActivityResult bundle is null");
      return;
    }
    if (paramInt1 != 10020)
    {
      if (paramInt1 != 10021)
      {
        switch (paramInt1)
        {
        default: 
          return;
        case 5003: 
          paramIntent = (ExtendFriendInfo)localBundle.getParcelable("key_extend_friend_info");
          if (paramIntent == null) {
            break;
          }
          a(paramIntent.a, paramIntent.d, paramIntent.e);
          this.x = paramIntent.a;
          this.y = paramIntent.d;
          this.z = paramIntent.e;
          q();
          return;
        case 5002: 
          a(paramIntent.getStringArrayExtra("param_location"));
          return;
        case 5001: 
          paramIntent = localBundle.getStringArrayList("extend_friend_delete_path_list");
          if ((paramIntent != null) && (paramIntent.size() > 0)) {
            this.w = true;
          }
          this.h.c(paramIntent);
          o();
          return;
        }
      }
      else
      {
        paramIntent = localBundle.getString("PhotoConst.SINGLE_PHOTO_PATH");
        if (!TextUtils.isEmpty(paramIntent))
        {
          this.u = true;
          this.l = new PhotoWallListView.PhotoPath(null, paramIntent);
          p();
        }
      }
    }
    else
    {
      paramIntent = localBundle.getStringArrayList("PhotoConst.SELECTED_PATHS");
      if ((paramIntent != null) && (paramIntent.size() > 0)) {
        this.w = true;
      }
      this.h.b(paramIntent);
      o();
    }
  }
  
  public boolean onBackEvent()
  {
    H();
    if ((!this.t) && (!this.u) && (!this.v) && (!this.w)) {
      a(false);
    } else {
      r();
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131449972: 
      if (this.r.a())
      {
        this.r.c();
        return;
      }
      this.r.b();
      return;
    case 1912930421: 
      ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#edit_data_page#save_btn", true, -1L, -1L, null, true, true);
      if (!NetworkState.isNetworkConnected(this.b))
      {
        a(1, "当前网络不可用，请检查网络设置。", false);
        return;
      }
      if (TextUtils.isEmpty(v()))
      {
        a(1, "昵称不能为空", false);
        return;
      }
      H();
      b("正在保存");
      e();
      return;
    case 1912930386: 
      ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#edit_data_page#name_btn", true, -1L, -1L, null, true, true);
      b(false);
      return;
    case 1912930352: 
      ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#edit_data_page#sex_btn", true, -1L, -1L, null, true, true);
      h();
      return;
    case 1912930331: 
      ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#edit_data_page#voiceprint_btn", true, -1L, -1L, null, true, true);
      j();
      return;
    case 1912930330: 
      ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#edit_data_page#dating_profile_btn", true, -1L, -1L, null, true, true);
      j();
      return;
    case 1912930320: 
      ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#edit_data_page#city_btn", true, -1L, -1L, null, true, true);
      a();
      return;
    case 1912930313: 
      onBackEvent();
      return;
    case 1912930310: 
      ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#edit_data_page#profile_photo_btn", true, -1L, -1L, null, true, true);
      b(true);
      return;
    }
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#edit_data_page#birthday_btn", true, -1L, -1L, null, true, true);
    k();
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = getQBaseActivity();
    this.d = ((QQAppInterface)getQBaseActivity().getAppRuntime());
    this.f = ((ConditionSearchManager)this.d.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER));
    this.f.a(this);
    this.ae.addFilter(new Class[] { NearbyPeoplePhotoUploadProcessor.class });
    ((ITransFileController)this.d.getRuntimeService(ITransFileController.class)).addHandle(this.ae);
    paramBundle = this.b.getIntent();
    if (paramBundle != null) {
      this.aa = paramBundle.getStringExtra("key_extend_friend_info_json");
    }
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("expose#edit_data_page#view", true, -1L, -1L, null, true, true);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramBundle = Integer.valueOf(0);
    this.c = paramLayoutInflater.inflate(1912995846, paramViewGroup, false);
    this.g = ((TextView)this.c.findViewById(1912930393));
    this.h = ((PhotoWallListView)this.c.findViewById(1912930392));
    this.h.setActivity(this.b);
    this.h.setPhotoPathList(this.i);
    this.m = ((ImageView)this.c.findViewById(1912930313));
    this.n = ((TextView)this.c.findViewById(1912930421));
    this.o = ((ImageView)this.c.findViewById(1912930330));
    this.p = ((ImageView)this.c.findViewById(1912930331));
    this.q = ((TextView)this.c.findViewById(1912930332));
    this.r = ((ExpandVoiceView)this.c.findViewById(1912930461));
    this.r.setOnClickListener(this);
    this.r.setActivity(this.b);
    this.r.setDeleteIconEnable(false, null);
    this.s = ((RelativeLayout)this.c.findViewById(1912930370));
    this.k = ((DynamicAvatarView)this.c.findViewById(1912930310));
    this.K = ((EditText)this.c.findViewById(1912930386));
    this.a = new ExtendFriendNewEditFragment.MaxNicknameTextWatcher(this, 36, this.K);
    this.K.addTextChangedListener(this.a);
    this.L = ((TextView)this.c.findViewById(1912930350));
    this.M = ((TextView)this.c.findViewById(1912930305));
    this.W = ((TextView)this.c.findViewById(1912930319));
    this.Y = this.c.findViewById(1912930464);
    this.Z = ((ExtendFriendHonorOfKingRecordView)this.c.findViewById(1912930347));
    this.T = this.c.findViewById(1912930352);
    this.U = this.c.findViewById(1912930306);
    this.V = this.c.findViewById(1912930320);
    this.m.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.K.setOnClickListener(this);
    this.T.setOnClickListener(this);
    this.U.setOnClickListener(this);
    this.V.setOnClickListener(this);
    this.L.setTag(paramBundle);
    this.M.setTag(new Object[] { paramBundle, paramBundle, paramBundle });
    this.W.setTag(new String[] { "0", "0", "0", "0" });
    if (TextUtils.isEmpty(this.aa))
    {
      b();
      b("正在获取数据");
    }
    else
    {
      s();
    }
    return this.c;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ConditionSearchManager localConditionSearchManager = this.f;
    if (localConditionSearchManager != null)
    {
      localConditionSearchManager.d(this.ad);
      this.f.b(this);
    }
    ((ITransFileController)this.d.getRuntimeService(ITransFileController.class)).removeHandle(this.ae);
  }
  
  public void onPause()
  {
    super.onPause();
    ExpandVoiceView localExpandVoiceView = this.r;
    if ((localExpandVoiceView != null) && (localExpandVoiceView.a())) {
      this.r.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendNewEditFragment
 * JD-Core Version:    0.7.0.1
 */