package com.tencent.mobileqq.transfile;

import alud;
import alwx;
import amcp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import awiw;
import awkh;
import awki;
import axtc;
import axwx;
import azdd;
import azen;
import azjh;
import azri;
import bard;
import bare;
import barh;
import bark;
import bass;
import bast;
import basu;
import bawk;
import baxi;
import baxj;
import baxl;
import baxm;
import baxn;
import baxq;
import bayf;
import bayk;
import bbax;
import bbbl;
import bbbm;
import bbcc;
import bbcd;
import bdif;
import bdin;
import com.qq.taf.jce.HexUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.data.MessageForDanceMachine;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.config.HwNetSegConf;
import com.tencent.mobileqq.highway.conn.ConnManager;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.PicInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.ShortVideoReqExtInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.ShortVideoSureReqInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.VideoInfo;
import com.tencent.mobileqq.highway.segment.RequestAck;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.highway.utils.VideoUpConfigInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import tencent.im.msg.hummer.resv.videoFile.ResvAttr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;
import tencent.im.msg.im_msg_body.VideoFile;

public class ShortVideoUploadProcessor
  extends bark
{
  public static boolean a;
  private volatile int A = 0;
  private volatile int B = 0;
  private int C;
  private volatile int D;
  private int E;
  private int F;
  protected int a;
  protected long a;
  alwx jdField_a_of_type_Alwx = new baxq(this);
  protected amcp a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  public QQAppInterface a;
  public Bdh_extinfo.PicInfo a;
  public RequestAck a;
  private ShortVideoUploadProcessor.TimeoutRunnable jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor$TimeoutRunnable;
  Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
  protected String a;
  public AtomicBoolean a;
  protected int b;
  public long b;
  protected RandomAccessFile b;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList<String> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  public HashMap<Integer, barh> b;
  public List<Bdh_extinfo.VideoInfo> b;
  public AtomicBoolean b;
  boolean jdField_b_of_type_Boolean = false;
  public int c;
  public long c;
  public List<Transaction> c;
  public AtomicBoolean c;
  public long d;
  protected byte[] d;
  public long e;
  public barh e;
  private byte[] e;
  private long jdField_f_of_type_Long = 480000L;
  private byte[] jdField_f_of_type_ArrayOfByte;
  public boolean g;
  public boolean q;
  private volatile boolean r;
  private boolean s;
  public int x = -1;
  int y;
  private int z = 1;
  
  public ShortVideoUploadProcessor(bayf parambayf, bayk parambayk)
  {
    super(parambayf, parambayk);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_e_of_type_Barh = new barh();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a);
    jdField_a_of_type_Boolean = VideoUpConfigInfo.sIsPreSendSignal;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG>is preSendAckToBDHServer :" + jdField_a_of_type_Boolean);
    }
    if ((this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo))) {}
    for (this.x = ((MessageForShortVideo)this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType;; this.x = 0)
    {
      if (!this.jdField_a_of_type_Bayk.jdField_i_of_type_Boolean)
      {
        parambayf = this.jdField_a_of_type_Bayk.jdField_i_of_type_JavaLangString;
        parambayk = parambayf.split("QQ_&_MoblieQQ_&_QQ");
        if (4 == parambayk.length) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "path was not set correctlly------path = " + parambayf);
        }
        b(9304, "path =" + parambayf);
        d();
        this.o = true;
      }
      return;
    }
    this.jdField_a_of_type_Bayk.jdField_i_of_type_JavaLangString = parambayk[0];
    this.jdField_a_of_type_JavaLangString = parambayk[1];
    this.jdField_c_of_type_Int = Integer.parseInt(parambayk[2]);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "Init params videoTime : " + this.jdField_c_of_type_Int);
    }
    this.jdField_d_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(parambayk[3]);
  }
  
  private bbbl a()
  {
    int j = 1;
    bbbl localbbbl = new bbbl();
    localbbbl.jdField_c_of_type_Int = ((int)this.jdField_a_of_type_Bayk.jdField_a_of_type_Long);
    localbbbl.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Bayk.jdField_b_of_type_JavaLangString;
    String str;
    int i;
    if ((this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForBlessPTV)))
    {
      Object localObject = (MessageForBlessPTV)this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (((MessageForBlessPTV)localObject).uinList != null)
      {
        str = (String)((MessageForBlessPTV)localObject).uinList.get(0);
        localbbbl.jdField_d_of_type_JavaLangString = str;
        localbbbl.k = 1;
        if (((MessageForBlessPTV)localObject).uinList == null) {
          break label462;
        }
        i = ((MessageForBlessPTV)localObject).uinList.size();
        label123:
        localbbbl.l = i;
        label129:
        localbbbl.f = this.jdField_a_of_type_Bayk.jdField_a_of_type_Int;
        localbbbl.i = 0;
        if ((localbbbl.f != 0) && (1008 != localbbbl.f)) {
          break label547;
        }
        localbbbl.jdField_b_of_type_JavaLangString = null;
        label172:
        if (localbbbl.f != 0) {
          break label562;
        }
        localbbbl.jdField_a_of_type_Int = 0;
        label186:
        localbbbl.jdField_b_of_type_Int = 2;
        localObject = new File(this.jdField_a_of_type_Bayk.jdField_i_of_type_JavaLangString);
        str = ((File)localObject).getName();
        localbbbl.jdField_a_of_type_JavaLangString = str;
        localbbbl.jdField_a_of_type_Long = ((File)localObject).length();
        localbbbl.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
        localbbbl.jdField_b_of_type_ArrayOfByte = this.jdField_d_of_type_ArrayOfByte;
        localbbbl.jdField_e_of_type_Int = this.jdField_a_of_type_Int;
        localbbbl.jdField_d_of_type_Int = this.jdField_b_of_type_Int;
        localbbbl.h = this.jdField_c_of_type_Int;
        localbbbl.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
        localObject = this.jdField_a_of_type_Bass;
        long l = localbbbl.jdField_a_of_type_Long + this.jdField_a_of_type_Long;
        this.jdField_q_of_type_Long = l;
        ((bass)localObject).jdField_a_of_type_Long = l;
        str = str.substring(str.lastIndexOf(".") + 1);
        if (!"avi".equals(str)) {
          break label609;
        }
        i = 2;
      }
    }
    for (;;)
    {
      label344:
      localbbbl.g = i;
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fileFormat", String.valueOf(i));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picResLength", String.valueOf(this.jdField_b_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picResWidth", String.valueOf(this.jdField_a_of_type_Int));
      if ((this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo))) {}
      for (localbbbl.jdField_j_of_type_Int = ((MessageForShortVideo)this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType;; localbbbl.jdField_j_of_type_Int = 0)
      {
        this.x = localbbbl.jdField_j_of_type_Int;
        return localbbbl;
        str = "0";
        break;
        label462:
        i = 1;
        break label123;
        if ((this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (((MessageForShortVideo)this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).CheckIsHotVideo()))
        {
          localbbbl.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString;
          localbbbl.k = 0;
          localbbbl.l = 1;
          break label129;
        }
        localbbbl.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString;
        localbbbl.k = 0;
        localbbbl.l = 1;
        break label129;
        label547:
        localbbbl.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString;
        break label172;
        label562:
        if (1 == localbbbl.f)
        {
          localbbbl.jdField_a_of_type_Int = 1;
          break label186;
        }
        if (3000 == localbbbl.f)
        {
          localbbbl.jdField_a_of_type_Int = 2;
          break label186;
        }
        localbbbl.jdField_a_of_type_Int = 3;
        break label186;
        label609:
        if ("mp4".equals(str))
        {
          i = 3;
          break label344;
        }
        if ("wmv".equals(str))
        {
          i = 4;
          break label344;
        }
        if ("mkv".equals(str))
        {
          i = 5;
          break label344;
        }
        if ("rmvb".equals(str))
        {
          i = 6;
          break label344;
        }
        if ("rm".equals(str))
        {
          i = 7;
          break label344;
        }
        if ("afs".equals(str))
        {
          i = 8;
          break label344;
        }
        if ("mov".equals(str))
        {
          i = 9;
          break label344;
        }
        if ("mod".equals(str))
        {
          i = 10;
          break label344;
        }
        i = j;
        if ("ts".equals(str)) {
          break label344;
        }
        if (!"mts".equals(str)) {
          break label781;
        }
        i = 11;
        break label344;
      }
      label781:
      i = -1;
    }
  }
  
  private im_msg_body.RichText a()
  {
    int i = 1;
    for (;;)
    {
      im_msg_body.VideoFile localVideoFile;
      videoFile.ResvAttr localResvAttr;
      try
      {
        im_msg_body.RichText localRichText = new im_msg_body.RichText();
        localVideoFile = new im_msg_body.VideoFile();
        localVideoFile.setHasFlag(true);
        if (this.jdField_f_of_type_JavaLangString != null) {
          localVideoFile.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.jdField_f_of_type_JavaLangString));
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "mResid uuid=" + this.jdField_f_of_type_JavaLangString);
        }
        if (!(this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo)) {
          break label1095;
        }
        Object localObject1 = (MessageForShortVideo)this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        if (localObject1 != null)
        {
          localVideoFile.bytes_source.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).fileSource));
          localVideoFile.uint32_busi_type.set(((MessageForShortVideo)localObject1).busiType);
          localVideoFile.bool_support_progressive.set(((MessageForShortVideo)localObject1).supportProgressive);
          localVideoFile.uint32_file_width.set(((MessageForShortVideo)localObject1).fileWidth);
          localVideoFile.uint32_file_height.set(((MessageForShortVideo)localObject1).fileHeight);
          localVideoFile.uint32_sub_busi_type.set(((MessageForShortVideo)localObject1).subBusiType);
          localResvAttr = new videoFile.ResvAttr();
          localResvAttr.uint32_msg_tail_type.set(((MessageForShortVideo)localObject1).msgTailType);
          if ((localObject1 == null) || (!((MessageForShortVideo)localObject1).CheckIsHotVideo())) {
            break label995;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoUploadProcessor", 2, "constructRichText MessageForHotVideo ");
          }
          localResvAttr.bytes_hotvideo_icon.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).hotVideoIconUrl));
          localResvAttr.bytes_hotvideo_title.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).hotVideoTitle));
          localResvAttr.bytes_hotvideo_url.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).hotVideoUrl));
          localResvAttr.bytes_hotvideo_icon_sub.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).hotVideoSubIconUrl));
          localResvAttr.uint32_special_video_type.set(((MessageForShortVideo)localObject1).specialVideoType);
          if (this.jdField_l_of_type_JavaLangString != null)
          {
            localVideoFile.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.jdField_l_of_type_JavaLangString));
            if ((this.jdField_c_of_type_JavaLangString == null) || (this.jdField_c_of_type_JavaLangString.length() <= 0)) {
              break label959;
            }
            localVideoFile.bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(this.jdField_c_of_type_JavaLangString)));
            if ((((MessageForShortVideo)localObject1).md5 == null) || (((MessageForShortVideo)localObject1).md5.length() == 0)) {
              ((MessageForShortVideo)localObject1).md5 = this.jdField_c_of_type_JavaLangString;
            }
            if ((this.jdField_a_of_type_Long == 0L) && (((MessageForShortVideo)localObject1).thumbFileSize != 0)) {
              this.jdField_a_of_type_Long = ((MessageForShortVideo)localObject1).thumbFileSize;
            }
            if ((this.jdField_q_of_type_Long == 0L) && (((MessageForShortVideo)localObject1).videoFileSize != 0)) {
              this.jdField_q_of_type_Long = (((MessageForShortVideo)localObject1).videoFileSize + this.jdField_a_of_type_Long);
            }
            if ((this.jdField_a_of_type_Int == 0) && (((MessageForShortVideo)localObject1).thumbWidth != 0)) {
              this.jdField_a_of_type_Int = ((MessageForShortVideo)localObject1).thumbWidth;
            }
            if ((this.jdField_b_of_type_Int == 0) && (((MessageForShortVideo)localObject1).thumbHeight != 0)) {
              this.jdField_b_of_type_Int = ((MessageForShortVideo)localObject1).thumbHeight;
            }
            if ((((MessageForShortVideo)localObject1).videoFileName == null) || (((MessageForShortVideo)localObject1).videoFileName.length() == 0))
            {
              localObject4 = new StringBuilder();
              if (this.jdField_c_of_type_JavaLangString != null) {
                break label987;
              }
              localObject3 = "HotVideo";
              ((MessageForShortVideo)localObject1).videoFileName = ((String)localObject3 + ".mp4");
            }
            localVideoFile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).videoFileName));
            Object localObject4 = localResvAttr.bytes_camera_templateid;
            if (((MessageForShortVideo)localObject1).templateId == null) {
              break label1100;
            }
            localObject3 = ((MessageForShortVideo)localObject1).templateId;
            ((PBBytesField)localObject4).set(ByteStringMicro.copyFromUtf8((String)localObject3));
            localObject4 = localResvAttr.bytes_camera_templateName;
            if (((MessageForShortVideo)localObject1).templateName == null) {
              break label1107;
            }
            localObject3 = ((MessageForShortVideo)localObject1).templateName;
            ((PBBytesField)localObject4).set(ByteStringMicro.copyFromUtf8((String)localObject3));
            localResvAttr.uint32_long_video_kandian_type.set(this.F);
            localObject3 = "unknown";
            if (!this.jdField_q_of_type_Boolean) {
              break label1056;
            }
            i = 7;
            localObject1 = "favorite";
            localResvAttr.uint32_source.set(2);
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoUploadProcessor", 2, new Object[] { "videoSource report: ", Integer.valueOf(i), ", from ", localObject1 });
            }
            localVideoFile.bytes_pb_reserve.set(ByteStringMicro.copyFrom(localResvAttr.toByteArray()));
            localVideoFile.uint32_video_attr.set(this.E);
          }
        }
        else
        {
          localVideoFile.uint32_file_format.set(2);
          localVideoFile.uint32_file_size.set((int)(this.jdField_q_of_type_Long - this.jdField_a_of_type_Long));
          localVideoFile.uint32_file_time.set(this.jdField_c_of_type_Int);
          localVideoFile.uint32_thumb_width.set(this.jdField_a_of_type_Int);
          localVideoFile.uint32_thumb_height.set(this.jdField_b_of_type_Int);
          localVideoFile.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(this.jdField_d_of_type_ArrayOfByte));
          localVideoFile.uint32_thumb_file_size.set((int)this.jdField_a_of_type_Long);
          localVideoFile.uint32_from_chat_type.set(-1);
          localVideoFile.uint32_to_chat_type.set(-1);
          localObject3 = new im_msg_body.Text();
          ((im_msg_body.Text)localObject3).setHasFlag(true);
          ((im_msg_body.Text)localObject3).str.set(ByteStringMicro.copyFromUtf8(alud.a(2131714484)));
          localObject1 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject3);
          localObject3 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject3).video_file.set(localVideoFile);
          localRichText.elems.add((MessageMicro)localObject1);
          localRichText.elems.add((MessageMicro)localObject3);
          return localRichText;
        }
        if (((MessageForShortVideo)localObject1).uuid == null) {
          continue;
        }
        localVideoFile.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).uuid));
        continue;
        if (localException.md5 == null) {
          continue;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoUploadProcessor", 2, "Construct richtext error", localException);
        }
        localException.printStackTrace();
        return null;
      }
      label959:
      localVideoFile.bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(localException.md5)));
      continue;
      label987:
      Object localObject3 = this.jdField_c_of_type_JavaLangString;
      continue;
      label995:
      if (localException.CheckIsDanceVideo()) {
        localResvAttr.uint32_special_video_type.set(localException.specialVideoType);
      }
      localVideoFile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Bayk.jdField_i_of_type_JavaLangString));
      localVideoFile.bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(this.jdField_a_of_type_Bayk.jdField_f_of_type_JavaLangString)));
      continue;
      label1056:
      Object localObject2;
      if (localException.busiType == 0)
      {
        localObject2 = "gallery";
        i = 2;
      }
      else if (((MessageForShortVideo)localObject2).busiType == 1)
      {
        localObject2 = "aio camera";
      }
      else
      {
        i = 6;
        localObject2 = localObject3;
        continue;
        label1095:
        localObject2 = null;
        continue;
        label1100:
        localObject3 = "";
        continue;
        label1107:
        localObject3 = "";
      }
    }
  }
  
  private void a(boolean paramBoolean, long paramLong, String paramString)
  {
    if (!baxl.b(this.jdField_a_of_type_Bayk.jdField_a_of_type_Int, this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString)) {}
    while (!baxl.a()) {
      return;
    }
    for (;;)
    {
      int i;
      synchronized (baxl.jdField_a_of_type_JavaLangObject)
      {
        QLog.d("ShortVideoUploadProcessor", 2, "VideoABTest : uinSeq" + this.jdField_a_of_type_Bayk.jdField_a_of_type_Long + " Switcher:" + this.z + " videoTime:" + this.jdField_c_of_type_Int);
        this.jdField_e_of_type_Long = SystemClock.uptimeMillis();
        baxm localbaxm = baxl.a(this.jdField_a_of_type_Bayk.jdField_a_of_type_Long);
        localbaxm.jdField_e_of_type_Int = this.C;
        localbaxm.jdField_f_of_type_Long = (this.jdField_a_of_type_Barh.jdField_b_of_type_Long - this.jdField_a_of_type_Barh.jdField_a_of_type_Long);
        localbaxm.jdField_d_of_type_Int = this.jdField_c_of_type_Int;
        localbaxm.g = (this.jdField_e_of_type_Long - this.jdField_c_of_type_Long);
        localbaxm.j = (this.jdField_e_of_type_Long - this.jdField_d_of_type_Long);
        localbaxm.jdField_k_of_type_Long = this.jdField_a_of_type_Bayk.jdField_a_of_type_Long;
        if (paramBoolean)
        {
          i = 0;
          localbaxm.jdField_c_of_type_Int = i;
          localbaxm.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
          localbaxm.jdField_a_of_type_Int = this.jdField_a_of_type_Bayk.jdField_a_of_type_Int;
          localbaxm.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString;
          localbaxm.jdField_d_of_type_JavaLangString = paramString;
          localbaxm.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
          localbaxm.jdField_q_of_type_Long = this.jdField_c_of_type_Int;
          localbaxm.m = paramLong;
          localbaxm.o = this.jdField_q_of_type_Long;
          if (this.z != 3)
          {
            localbaxm.jdField_e_of_type_Long = baxl.jdField_a_of_type_Long;
            localbaxm.jdField_c_of_type_Long = baxl.jdField_b_of_type_Long;
            localbaxm.i = baxl.jdField_c_of_type_Long;
            localbaxm.h = baxl.jdField_d_of_type_Long;
          }
          localbaxm.jdField_c_of_type_JavaLangString = (this.jdField_a_of_type_Barh.a(1) + ";" + this.jdField_b_of_type_Barh.a(2) + ";");
          paramString = new StringBuilder();
          i = 0;
          if (i < this.jdField_b_of_type_JavaUtilList.size() + 1)
          {
            localObject1 = (barh)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
            if (localObject1 == null) {
              break label537;
            }
            paramString.append(String.valueOf(((barh)localObject1).a()));
            paramString.append("_");
            break label537;
          }
        }
        else
        {
          i = this.jdField_j_of_type_Int;
          continue;
        }
        Object localObject1 = paramString.toString();
        paramString = (String)localObject1;
        if (((String)localObject1).length() > 0) {
          paramString = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
        }
        localbaxm.jdField_e_of_type_JavaLangString = paramString;
        baxl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bayk.jdField_a_of_type_Int, this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bayk.jdField_a_of_type_Long, this.z);
        return;
      }
      label537:
      i += 1;
    }
  }
  
  private void v()
  {
    this.jdField_a_of_type_Bass.jdField_a_of_type_Bast.a();
    this.jdField_a_of_type_Bass.b.a();
    this.jdField_a_of_type_Bass.jdField_a_of_type_Basu.a();
    this.jdField_a_of_type_Bass.c.a();
    bass localbass = this.jdField_a_of_type_Bass;
    long l = System.nanoTime();
    localbass.g = l;
    this.jdField_k_of_type_Long = l;
    this.jdField_a_of_type_Bass.h = 0L;
  }
  
  private void w()
  {
    if (this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {}
    for (MessageRecord localMessageRecord = this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;; localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bayk.jdField_a_of_type_Int, this.jdField_a_of_type_Bayk.jdField_a_of_type_Long))
    {
      if ((localMessageRecord != null) && ((localMessageRecord instanceof MessageForShortVideo)) && (((MessageForShortVideo)localMessageRecord).redBagType == LocalMediaInfo.REDBAG_TYPE_GET)) {
        azjh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return;
    }
  }
  
  private void x()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
    int i;
    label78:
    Object localObject2;
    long l2;
    if (this.z == 3)
    {
      i = 1;
      ((HashMap)localObject1).put("param_isPreUpload", String.valueOf(i));
      if (this.C != 1) {
        break label514;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_rollback", this.C + "_" + this.y);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_sessionID", String.valueOf(this.jdField_b_of_type_Long));
      if (this.jdField_d_of_type_ArrayOfByte != null) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_thumbMd5", HexUtil.bytes2HexStr(this.jdField_d_of_type_ArrayOfByte));
      }
      localObject1 = baxi.a(this.jdField_a_of_type_Bayk.jdField_a_of_type_Long);
      localObject2 = this.jdField_a_of_type_Barh.a(1) + ";" + this.jdField_e_of_type_Barh.a(2) + ";" + this.jdField_c_of_type_Barh.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_cost_c_trans", localObject2);
      if (this.z != 3) {
        break label535;
      }
      if ((this.jdField_e_of_type_Barh.jdField_b_of_type_Long > 0L) && (((baxj)localObject1).jdField_a_of_type_Long > 0L) && (this.jdField_e_of_type_Barh.jdField_b_of_type_Long / 1000000L - ((baxj)localObject1).jdField_a_of_type_Long > 0L))
      {
        l1 = this.jdField_e_of_type_Barh.jdField_b_of_type_Long / 1000000L;
        l2 = ((baxj)localObject1).jdField_a_of_type_Long;
        this.jdField_a_of_type_JavaUtilHashMap.put("param_cost_c_wait", String.valueOf(l1 - l2 - 400L));
      }
      label296:
      if ((this.z == 3) && (((baxj)localObject1).jdField_b_of_type_Long > 0L)) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_cost_c_comp", String.valueOf(((baxj)localObject1).jdField_b_of_type_Long));
      }
      if ((((baxj)localObject1).jdField_a_of_type_Long <= 0L) || (((baxj)localObject1).jdField_c_of_type_Long <= 0L)) {
        break label665;
      }
    }
    label514:
    label535:
    label665:
    for (long l1 = ((baxj)localObject1).jdField_a_of_type_Long - ((baxj)localObject1).jdField_c_of_type_Long;; l1 = 0L)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put("param_timeBeforeSend", String.valueOf(l1));
      if (((baxj)localObject1).jdField_a_of_type_Int > 0) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_recordTimes", String.valueOf(((baxj)localObject1).jdField_a_of_type_Int));
      }
      baxi.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(this.jdField_a_of_type_Bayk.jdField_a_of_type_Long));
      if (this.z == 3)
      {
        localObject1 = new StringBuilder();
        i = 0;
        for (;;)
        {
          if (i < this.jdField_b_of_type_JavaUtilList.size() + 1)
          {
            localObject2 = (barh)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
            if (localObject2 != null)
            {
              ((StringBuilder)localObject1).append(String.valueOf(((barh)localObject2).a()));
              ((StringBuilder)localObject1).append("_");
            }
            i += 1;
            continue;
            i = 0;
            break;
            this.jdField_a_of_type_JavaUtilHashMap.put("param_rollback", String.valueOf(this.C));
            break label78;
            if ((this.jdField_b_of_type_Barh.jdField_b_of_type_Long <= 0L) || (baxi.jdField_b_of_type_Long <= 0L) || (this.jdField_b_of_type_Barh.jdField_b_of_type_Long / 1000000L - baxi.jdField_b_of_type_Long <= 0L)) {
              break label296;
            }
            l1 = this.jdField_b_of_type_Barh.jdField_b_of_type_Long / 1000000L;
            l2 = baxi.jdField_b_of_type_Long;
            this.jdField_a_of_type_JavaUtilHashMap.put("param_cost_c_wait", String.valueOf(l1 - l2 - 400L));
            break label296;
          }
        }
        localObject2 = ((StringBuilder)localObject1).toString();
        localObject1 = localObject2;
        if (((String)localObject2).length() > 0) {
          localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
        }
        this.jdField_a_of_type_JavaUtilHashMap.put("param_cost_s_segs", localObject1);
      }
      return;
    }
  }
  
  private void y()
  {
    u();
    if (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    do
    {
      return;
      this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      bdif.a(String.valueOf(this.jdField_a_of_type_Bayk.jdField_a_of_type_Long), "rollback", "rollBackToSendFileByBDH RollBack with reason:" + this.C + ",mCancelCode = " + this.y);
      s();
    } while ((this.jdField_a_of_type_Bard == null) || (this.jdField_a_of_type_Bard.a == null));
    this.jdField_a_of_type_Bard.a.post(new ShortVideoUploadProcessor.10(this));
  }
  
  public void a(long paramLong, Bdh_extinfo.PicInfo paramPicInfo, List<Bdh_extinfo.VideoInfo> paramList)
  {
    bdif.a(String.valueOf(this.jdField_a_of_type_Bayk.jdField_a_of_type_Long), "svrcomp_s", "<BDH_LOG><ShortVideoUploadProcessor>sendAckToBDHServer videoInfos.size : " + paramList.size());
    u();
    Bdh_extinfo.ShortVideoReqExtInfo localShortVideoReqExtInfo = new Bdh_extinfo.ShortVideoReqExtInfo();
    localShortVideoReqExtInfo.uint32_cmd.set(3);
    localShortVideoReqExtInfo.uint64_session_id.set(paramLong);
    Bdh_extinfo.ShortVideoSureReqInfo localShortVideoSureReqInfo;
    long l;
    label171:
    int i;
    if (jdField_a_of_type_Boolean)
    {
      localShortVideoReqExtInfo.bool_is_merge_cmd_before_data.set(true);
      localShortVideoSureReqInfo = new Bdh_extinfo.ShortVideoSureReqInfo();
      paramLong = Long.parseLong(this.jdField_a_of_type_Bayk.jdField_b_of_type_JavaLangString);
      l = Long.parseLong(this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString);
      localShortVideoSureReqInfo.uint64_fromuin.set(paramLong);
      localShortVideoSureReqInfo.uint64_touin.set(l);
      if ((this.jdField_a_of_type_Bayk.jdField_a_of_type_Int != 0) && (1008 != this.jdField_a_of_type_Bayk.jdField_a_of_type_Int)) {
        break label390;
      }
      localShortVideoSureReqInfo.uint64_group_code.set(0L);
      if (this.jdField_a_of_type_Bayk.jdField_a_of_type_Int != 0) {
        break label403;
      }
      i = 0;
      label184:
      if ((this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) || (!(this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo))) {
        break label445;
      }
    }
    label390:
    label403:
    label445:
    for (int j = ((MessageForShortVideo)this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType;; j = 0)
    {
      this.x = j;
      localShortVideoSureReqInfo.uint32_chat_type.set(i);
      localShortVideoSureReqInfo.uint32_business_type.set(j);
      localShortVideoSureReqInfo.uint32_client_type.set(2);
      localShortVideoSureReqInfo.msg_thumbinfo.set(paramPicInfo);
      localShortVideoSureReqInfo.rpt_msg_merge_videoinfo.set(paramList);
      localShortVideoReqExtInfo.msg_shortvideo_sure_req.set(localShortVideoSureReqInfo);
      paramPicInfo = new Cryptor().encrypt(localShortVideoReqExtInfo.toByteArray(), this.jdField_e_of_type_ArrayOfByte);
      if (baxl.a()) {
        this.jdField_d_of_type_Long = SystemClock.uptimeMillis();
      }
      paramList = new baxn(this);
      paramPicInfo = new RequestAck(String.valueOf(paramLong), 16, this.jdField_f_of_type_ArrayOfByte, 30000L, paramList, paramPicInfo, this.jdField_d_of_type_ArrayOfByte, this.D);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().SubmitAckRequest(paramPicInfo);
      this.jdField_a_of_type_ComTencentMobileqqHighwaySegmentRequestAck = paramPicInfo;
      return;
      localShortVideoReqExtInfo.bool_is_merge_cmd_before_data.set(false);
      break;
      localShortVideoSureReqInfo.uint64_group_code.set(l);
      break label171;
      if (1 == this.jdField_a_of_type_Bayk.jdField_a_of_type_Int)
      {
        i = 1;
        break label184;
      }
      if (3000 == this.jdField_a_of_type_Bayk.jdField_a_of_type_Int)
      {
        i = 2;
        break label184;
      }
      i = 3;
      break label184;
    }
  }
  
  public void a(bbax parambbax, bbbm parambbbm)
  {
    this.jdField_a_of_type_Bbax = null;
    if (parambbbm != null)
    {
      int i = 0;
      if (i < parambbbm.jdField_a_of_type_JavaUtilList.size())
      {
        parambbax = (bbcc)parambbbm.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", parambbax.toString());
        }
        a(this.jdField_a_of_type_Barh, parambbax);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()------response.result = " + parambbax.jdField_c_of_type_Int);
        }
        this.jdField_f_of_type_JavaLangString = parambbax.jdField_a_of_type_JavaLangString;
        if (parambbax.jdField_c_of_type_Int == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()------response.isExist = " + parambbax.jdField_a_of_type_Boolean);
          }
          this.E = parambbax.jdField_a_of_type_Int;
          this.F = parambbax.jdField_b_of_type_Int;
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()------response.videoAttr = " + parambbax.jdField_a_of_type_Int + ", response.videoKandianType = " + parambbax.jdField_b_of_type_Int);
          }
          if (parambbax.jdField_a_of_type_Boolean)
          {
            this.jdField_b_of_type_Boolean = true;
            d(1007);
            b(true);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          this.jdField_r_of_type_Long = parambbax.jdField_a_of_type_Long;
          d("<BDH_LOG> onBusiProtoResp() send by bdh");
          this.w = 1;
          r();
          continue;
          d();
        }
      }
    }
  }
  
  void a(String paramString, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG>sendVideoSegByBDH  filePath:" + paramString + " index :" + paramInt2 + " md5:" + HexUtil.bytes2HexStr(paramArrayOfByte2) + "fileSize:" + paramInt1);
    }
    Object localObject = new Bdh_extinfo.ShortVideoReqExtInfo();
    ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).uint32_cmd.set(2);
    ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).uint64_session_id.set(this.jdField_b_of_type_Long);
    Bdh_extinfo.VideoInfo localVideoInfo;
    if (jdField_a_of_type_Boolean)
    {
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).bool_is_merge_cmd_before_data.set(true);
      localVideoInfo = new Bdh_extinfo.VideoInfo();
      localVideoInfo.uint32_idx.set(paramInt2);
      localVideoInfo.uint32_size.set(paramInt1);
      localVideoInfo.bytes_bin_md5.set(ByteStringMicro.copyFrom(paramArrayOfByte2));
      localVideoInfo.uint32_format.set(2);
      localVideoInfo.uint32_res_len.set(paramInt3);
      localVideoInfo.uint32_res_width.set(paramInt4);
      localVideoInfo.uint32_time.set(paramInt5);
      if (paramInt2 <= 0) {
        break label292;
      }
      this.jdField_b_of_type_JavaUtilList.add(localVideoInfo);
    }
    for (;;)
    {
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).msg_videoinfo.set(localVideoInfo);
      if (this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$PicInfo != null) {
        ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).msg_thumbinfo.set(this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$PicInfo);
      }
      localObject = new Cryptor().encrypt(((Bdh_extinfo.ShortVideoReqExtInfo)localObject).toByteArray(), this.jdField_e_of_type_ArrayOfByte);
      u();
      a(paramString, this.jdField_f_of_type_ArrayOfByte, paramArrayOfByte1, (byte[])localObject, paramInt2, paramArrayOfByte2);
      return;
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).bool_is_merge_cmd_before_data.set(false);
      break;
      label292:
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoUploadProcessor", 2, "video seg index is out of bounds !  index : " + paramInt2);
      }
    }
  }
  
  void a(String paramString, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG>sendVideoThumbByBDH  filePath:" + paramString + " index :" + 0 + " md5:" + HexUtil.bytes2HexStr(paramArrayOfByte3) + " fileSize:" + paramInt);
    }
    this.jdField_e_of_type_Barh.a();
    Bdh_extinfo.ShortVideoReqExtInfo localShortVideoReqExtInfo = new Bdh_extinfo.ShortVideoReqExtInfo();
    localShortVideoReqExtInfo.uint32_cmd.set(1);
    localShortVideoReqExtInfo.uint64_session_id.set(paramLong);
    if (jdField_a_of_type_Boolean) {
      localShortVideoReqExtInfo.bool_is_merge_cmd_before_data.set(true);
    }
    for (;;)
    {
      Bdh_extinfo.PicInfo localPicInfo = new Bdh_extinfo.PicInfo();
      localPicInfo.uint32_idx.set(0);
      localPicInfo.uint32_size.set(paramInt);
      localPicInfo.uint32_type.set(1);
      localPicInfo.bytes_bin_md5.set(ByteStringMicro.copyFrom(paramArrayOfByte3));
      this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$PicInfo = localPicInfo;
      localShortVideoReqExtInfo.msg_thumbinfo.set(localPicInfo);
      a(paramString, paramArrayOfByte1, paramArrayOfByte3, new Cryptor().encrypt(localShortVideoReqExtInfo.toByteArray(), paramArrayOfByte2), 0, paramArrayOfByte3);
      return;
      localShortVideoReqExtInfo.bool_is_merge_cmd_before_data.set(false);
    }
  }
  
  /* Error */
  void a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt, byte[] paramArrayOfByte4)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 1130	baxr
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 1131	baxr:<init>	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;)V
    //   10: astore 8
    //   12: new 1133	com/tencent/mobileqq/highway/transaction/Transaction
    //   15: dup
    //   16: aload_0
    //   17: getfield 130	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokevirtual 1136	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   23: bipush 16
    //   25: aload_1
    //   26: iconst_0
    //   27: aload_2
    //   28: aload_3
    //   29: aload 8
    //   31: aload 4
    //   33: invokespecial 1139	com/tencent/mobileqq/highway/transaction/Transaction:<init>	(Ljava/lang/String;ILjava/lang/String;I[B[BLcom/tencent/mobileqq/highway/api/ITransactionCallback;[B)V
    //   36: astore_1
    //   37: aload_0
    //   38: getfield 782	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:D	I
    //   41: ifeq +11 -> 52
    //   44: aload_1
    //   45: aload_0
    //   46: getfield 782	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:D	I
    //   49: putfield 1142	com/tencent/mobileqq/highway/transaction/Transaction:cacheIp	I
    //   52: aload 8
    //   54: aload_1
    //   55: putfield 1145	baxr:jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   58: aload 8
    //   60: iload 5
    //   62: putfield 1146	baxr:jdField_a_of_type_Int	I
    //   65: aload_0
    //   66: getfield 130	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   69: invokevirtual 1007	com/tencent/mobileqq/app/QQAppInterface:getHwEngine	()Lcom/tencent/mobileqq/highway/HwEngine;
    //   72: aload_1
    //   73: invokevirtual 1150	com/tencent/mobileqq/highway/HwEngine:submitTransactionTask	(Lcom/tencent/mobileqq/highway/transaction/Transaction;)I
    //   76: istore 7
    //   78: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   81: ifeq +83 -> 164
    //   84: ldc 147
    //   86: iconst_2
    //   87: new 149	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   94: ldc_w 1152
    //   97: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: iload 7
    //   102: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   105: ldc_w 1154
    //   108: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_1
    //   112: invokevirtual 1157	com/tencent/mobileqq/highway/transaction/Transaction:getTransationId	()I
    //   115: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   118: ldc_w 1159
    //   121: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_0
    //   125: getfield 169	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_Bayk	Lbayk;
    //   128: getfield 236	bayk:jdField_a_of_type_Long	J
    //   131: invokevirtual 683	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   134: ldc_w 1161
    //   137: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_1
    //   141: getfield 1164	com/tencent/mobileqq/highway/transaction/Transaction:filePath	Ljava/lang/String;
    //   144: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: ldc_w 1166
    //   150: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: bipush 16
    //   155: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   158: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: aload_0
    //   165: getfield 169	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_Bayk	Lbayk;
    //   168: getfield 236	bayk:jdField_a_of_type_Long	J
    //   171: invokestatic 757	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   174: ldc_w 1168
    //   177: new 149	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   184: ldc_w 1170
    //   187: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: iload 5
    //   192: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   195: ldc_w 1172
    //   198: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload 6
    //   203: invokestatic 845	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   206: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: ldc_w 1174
    //   212: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload_1
    //   216: invokevirtual 1157	com/tencent/mobileqq/highway/transaction/Transaction:getTransationId	()I
    //   219: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   222: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 901	bdif:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   228: new 88	barh
    //   231: dup
    //   232: invokespecial 89	barh:<init>	()V
    //   235: astore_2
    //   236: aload_2
    //   237: invokevirtual 1121	barh:a	()V
    //   240: aload_0
    //   241: getfield 86	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   244: iload 5
    //   246: invokestatic 561	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   249: aload_2
    //   250: invokevirtual 338	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   253: pop
    //   254: iload 7
    //   256: ifeq +37 -> 293
    //   259: aload_0
    //   260: iload 7
    //   262: new 149	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   269: ldc_w 1176
    //   272: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: iload 5
    //   277: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   280: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokevirtual 199	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	(ILjava/lang/String;)V
    //   286: aload_0
    //   287: invokevirtual 201	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	()V
    //   290: aload_0
    //   291: monitorexit
    //   292: return
    //   293: aload_0
    //   294: getfield 81	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   297: aload_1
    //   298: invokeinterface 1100 2 0
    //   303: pop
    //   304: goto -14 -> 290
    //   307: astore_1
    //   308: aload_0
    //   309: monitorexit
    //   310: aload_1
    //   311: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	ShortVideoUploadProcessor
    //   0	312	1	paramString	String
    //   0	312	2	paramArrayOfByte1	byte[]
    //   0	312	3	paramArrayOfByte2	byte[]
    //   0	312	4	paramArrayOfByte3	byte[]
    //   0	312	5	paramInt	int
    //   0	312	6	paramArrayOfByte4	byte[]
    //   76	185	7	i	int
    //   10	49	8	localbaxr	baxr
    // Exception table:
    //   from	to	target	type
    //   2	52	307	finally
    //   52	164	307	finally
    //   164	254	307	finally
    //   259	290	307	finally
    //   293	304	307	finally
  }
  
  public void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (bawk.b(this.jdField_j_of_type_Int))) {}
    long l;
    label252:
    do
    {
      do
      {
        return;
      } while ((this.h) || ((paramBoolean) && ((this.jdField_m_of_type_Int & 0x2) > 0)) || ((!paramBoolean) && ((this.jdField_m_of_type_Int & 0x1) > 0)));
      int j = this.jdField_m_of_type_Int;
      int i;
      Object localObject2;
      if (paramBoolean)
      {
        i = 2;
        this.jdField_m_of_type_Int = (i | j);
        if ((this.jdField_a_of_type_Bayk.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Bayk.jdField_a_of_type_Int == 3000)) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString);
        }
        this.jdField_l_of_type_Long = System.currentTimeMillis();
        l = (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L;
        localObject1 = this.jdField_a_of_type_Barh.a(1) + ";" + this.jdField_b_of_type_Barh.a(2) + ";" + this.jdField_c_of_type_Barh.a(3);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject1);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_busiType", this.x + "");
        localObject2 = this.jdField_a_of_type_JavaUtilHashMap;
        if (this.jdField_f_of_type_JavaLangString != null) {
          break label655;
        }
        localObject1 = this.jdField_l_of_type_JavaLangString;
        ((HashMap)localObject2).put("param_uuid", localObject1);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_toUin", this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_q_of_type_Long));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_thumbSize", String.valueOf(this.jdField_a_of_type_Long));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_isSecondTrans", this.jdField_b_of_type_Boolean + "");
        if (this.jdField_a_of_type_Bayk.jdField_e_of_type_Int == 0) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_BDHExistBeforeVideoUpload", String.valueOf(this.jdField_a_of_type_JavaLangBoolean));
        }
        if (this.z != 3) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_videoDuration", String.valueOf(this.jdField_c_of_type_Int));
        }
        x();
        this.jdField_a_of_type_JavaUtilHashMap.put("param_fileMd5", this.jdField_a_of_type_Bayk.jdField_f_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_BDH_Cache_Diff", String.valueOf(this.jdField_r_of_type_Boolean));
        if (!paramBoolean) {
          break label664;
        }
        b(true, l);
        azri.a(BaseApplication.getContext()).a(null, b(), true, l, this.jdField_q_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
      }
      for (;;)
      {
        l();
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "AutoMonitor_fragment MineFragment onAttach");
        }
        if (((MessageForShortVideo)this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType == 0) {
          ThreadManager.post(new ShortVideoUploadProcessor.5(this, this.jdField_a_of_type_Bayk.jdField_i_of_type_JavaLangString), 5, null, true);
        }
        if (!QLog.isColorLevel()) {
          break label798;
        }
        localObject1 = new StringBuilder();
        localObject2 = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          if (this.jdField_a_of_type_JavaUtilHashMap.get(str) != null)
          {
            ((StringBuilder)localObject1).append("&");
            ((StringBuilder)localObject1).append(str);
            ((StringBuilder)localObject1).append("=");
            ((StringBuilder)localObject1).append((String)this.jdField_a_of_type_JavaUtilHashMap.get(str));
          }
        }
        i = 1;
        break;
        localObject1 = this.jdField_f_of_type_JavaLangString;
        break label252;
        if (this.jdField_j_of_type_Int != -9527) {
          this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
        }
        this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_Bayk.jdField_a_of_type_Int));
        b(false, l);
        azri.a(BaseApplication.getContext()).a(null, b(), false, l, this.jdField_q_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
      }
      bdif.a(String.valueOf(this.jdField_a_of_type_Bayk.jdField_a_of_type_Long), "report", ((StringBuilder)localObject1).toString());
    } while ((this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction == null) || (this.w != 1) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine() == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().getCurrentConfig().segNum <= 32L));
    label655:
    label664:
    label798:
    Object localObject1 = new HashMap();
    ((HashMap)localObject1).put("segNum", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().getCurrentConfig().segNum));
    ((HashMap)localObject1).put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
    azri.a(BaseApplication.getContext()).a(null, "tempVideoUploadBDH", paramBoolean, l, this.jdField_q_of_type_Long, (HashMap)localObject1, "");
  }
  
  /* Error */
  public void aP_()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 204	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:o	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 169	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_Bayk	Lbayk;
    //   12: getfield 174	bayk:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   15: checkcast 176	com/tencent/mobileqq/data/MessageForShortVideo
    //   18: getfield 179	com/tencent/mobileqq/data/MessageForShortVideo:busiType	I
    //   21: ifne +39 -> 60
    //   24: aload_0
    //   25: getfield 169	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_Bayk	Lbayk;
    //   28: getfield 174	bayk:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   31: checkcast 176	com/tencent/mobileqq/data/MessageForShortVideo
    //   34: getfield 1315	com/tencent/mobileqq/data/MessageForShortVideo:isPause	Z
    //   37: ifeq +23 -> 60
    //   40: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq +12 -> 55
    //   46: ldc 147
    //   48: iconst_2
    //   49: ldc_w 1317
    //   52: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: aload_0
    //   56: invokevirtual 1319	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:c	()V
    //   59: return
    //   60: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   63: ifeq +12 -> 75
    //   66: ldc 147
    //   68: iconst_2
    //   69: ldc_w 1321
    //   72: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   75: aload_0
    //   76: invokespecial 1323	bark:aP_	()V
    //   79: aload_0
    //   80: getfield 169	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_Bayk	Lbayk;
    //   83: getfield 174	bayk:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   86: checkcast 176	com/tencent/mobileqq/data/MessageForShortVideo
    //   89: invokevirtual 350	com/tencent/mobileqq/data/MessageForShortVideo:CheckIsHotVideo	()Z
    //   92: ifeq +143 -> 235
    //   95: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   98: ifeq +12 -> 110
    //   101: ldc 147
    //   103: iconst_2
    //   104: ldc_w 1325
    //   107: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: aload_0
    //   111: getfield 169	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_Bayk	Lbayk;
    //   114: getfield 1326	bayk:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   117: ifnull +16 -> 133
    //   120: aload_0
    //   121: getfield 169	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_Bayk	Lbayk;
    //   124: getfield 1326	bayk:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   127: instanceof 1328
    //   130: ifeq +92 -> 222
    //   133: aload_0
    //   134: getfield 169	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_Bayk	Lbayk;
    //   137: getfield 174	bayk:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   140: checkcast 176	com/tencent/mobileqq/data/MessageForShortVideo
    //   143: astore_2
    //   144: aload_2
    //   145: getfield 506	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   148: ifnull +21 -> 169
    //   151: aload_2
    //   152: getfield 506	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   155: invokevirtual 496	java/lang/String:length	()I
    //   158: ifle +11 -> 169
    //   161: aload_0
    //   162: aload_2
    //   163: getfield 506	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   166: putfield 494	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   169: aload_2
    //   170: getfield 644	com/tencent/mobileqq/data/MessageForShortVideo:uuid	Ljava/lang/String;
    //   173: ifnull +21 -> 194
    //   176: aload_2
    //   177: getfield 644	com/tencent/mobileqq/data/MessageForShortVideo:uuid	Ljava/lang/String;
    //   180: invokevirtual 496	java/lang/String:length	()I
    //   183: ifle +11 -> 194
    //   186: aload_0
    //   187: aload_2
    //   188: getfield 644	com/tencent/mobileqq/data/MessageForShortVideo:uuid	Ljava/lang/String;
    //   191: putfield 493	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   194: aload_2
    //   195: getfield 1331	com/tencent/mobileqq/data/MessageForShortVideo:thumbMD5	Ljava/lang/String;
    //   198: ifnull +24 -> 222
    //   201: aload_2
    //   202: getfield 1331	com/tencent/mobileqq/data/MessageForShortVideo:thumbMD5	Ljava/lang/String;
    //   205: invokevirtual 496	java/lang/String:length	()I
    //   208: ifle +14 -> 222
    //   211: aload_0
    //   212: aload_2
    //   213: getfield 1331	com/tencent/mobileqq/data/MessageForShortVideo:thumbMD5	Ljava/lang/String;
    //   216: invokestatic 225	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   219: putfield 227	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   222: aload_0
    //   223: sipush 1001
    //   226: invokevirtual 1052	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	(I)V
    //   229: aload_0
    //   230: iconst_0
    //   231: invokevirtual 1054	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	(Z)V
    //   234: return
    //   235: aload_0
    //   236: getfield 169	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_Bayk	Lbayk;
    //   239: getfield 1326	bayk:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   242: ifnull +33 -> 275
    //   245: aload_0
    //   246: getfield 169	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_Bayk	Lbayk;
    //   249: getfield 1326	bayk:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   252: instanceof 1333
    //   255: ifeq +20 -> 275
    //   258: aload_0
    //   259: aload_0
    //   260: getfield 169	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_Bayk	Lbayk;
    //   263: getfield 1326	bayk:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   266: checkcast 1333	azen
    //   269: getfield 1334	azen:jdField_i_of_type_Boolean	Z
    //   272: putfield 549	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_q_of_type_Boolean	Z
    //   275: aload_0
    //   276: sipush 1001
    //   279: invokevirtual 1052	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	(I)V
    //   282: aload_0
    //   283: getfield 306	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_Bass	Lbass;
    //   286: invokevirtual 1335	bass:a	()V
    //   289: invokestatic 675	baxl:a	()Z
    //   292: ifeq +10 -> 302
    //   295: aload_0
    //   296: invokestatic 692	android/os/SystemClock:uptimeMillis	()J
    //   299: putfield 710	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_c_of_type_Long	J
    //   302: aload_0
    //   303: getfield 169	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_Bayk	Lbayk;
    //   306: getfield 182	bayk:jdField_i_of_type_Boolean	Z
    //   309: ifeq +144 -> 453
    //   312: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   315: ifeq +12 -> 327
    //   318: ldc 147
    //   320: iconst_2
    //   321: ldc_w 1337
    //   324: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   327: aload_0
    //   328: iconst_3
    //   329: putfield 132	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:z	I
    //   332: aload_0
    //   333: aload_0
    //   334: getfield 169	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_Bayk	Lbayk;
    //   337: getfield 1338	bayk:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   340: putfield 206	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   343: aload_0
    //   344: aload_0
    //   345: getfield 169	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_Bayk	Lbayk;
    //   348: getfield 1340	bayk:k	Ljava/lang/String;
    //   351: invokestatic 225	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   354: putfield 227	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   357: aload_0
    //   358: invokevirtual 1342	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:f	()V
    //   361: aload_0
    //   362: getfield 227	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   365: ifnonnull +345 -> 710
    //   368: new 1344	java/io/FileInputStream
    //   371: dup
    //   372: aload_0
    //   373: getfield 206	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   376: invokespecial 1345	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   379: astore_3
    //   380: aload_3
    //   381: astore_2
    //   382: aload_0
    //   383: aload_3
    //   384: lconst_0
    //   385: invokestatic 1351	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   388: putfield 227	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   391: aload_3
    //   392: astore_2
    //   393: aload_0
    //   394: getfield 227	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   397: ifnonnull +305 -> 702
    //   400: aload_3
    //   401: astore_2
    //   402: aload_0
    //   403: sipush 9041
    //   406: new 149	java/lang/StringBuilder
    //   409: dup
    //   410: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   413: ldc_w 1353
    //   416: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: aload_0
    //   420: getfield 206	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   423: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   429: invokevirtual 199	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	(ILjava/lang/String;)V
    //   432: aload_3
    //   433: astore_2
    //   434: aload_0
    //   435: invokevirtual 201	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	()V
    //   438: aload_3
    //   439: ifnull -432 -> 7
    //   442: aload_3
    //   443: invokevirtual 1356	java/io/FileInputStream:close	()V
    //   446: return
    //   447: astore_2
    //   448: aload_2
    //   449: invokevirtual 1357	java/io/IOException:printStackTrace	()V
    //   452: return
    //   453: aload_0
    //   454: getfield 169	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_Bayk	Lbayk;
    //   457: getfield 656	bayk:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   460: invokestatic 1363	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   463: ifne +40 -> 503
    //   466: aload_0
    //   467: aload_0
    //   468: getfield 169	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_Bayk	Lbayk;
    //   471: getfield 656	bayk:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   474: invokestatic 225	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   477: putfield 288	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   480: aload_0
    //   481: getfield 306	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_Bass	Lbass;
    //   484: astore_2
    //   485: aload_0
    //   486: getfield 169	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_Bayk	Lbayk;
    //   489: getfield 656	bayk:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   492: astore_3
    //   493: aload_2
    //   494: aload_3
    //   495: putfield 1364	bass:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   498: aload_0
    //   499: aload_3
    //   500: putfield 494	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   503: aload_0
    //   504: getfield 288	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   507: ifnonnull +15 -> 522
    //   510: aload_0
    //   511: invokevirtual 1366	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:h	()Z
    //   514: ifne +8 -> 522
    //   517: aload_0
    //   518: invokevirtual 201	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	()V
    //   521: return
    //   522: aload_0
    //   523: getfield 169	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_Bayk	Lbayk;
    //   526: getfield 184	bayk:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   529: invokestatic 1371	bdhb:b	(Ljava/lang/String;)Z
    //   532: ifne +18 -> 550
    //   535: aload_0
    //   536: sipush 9042
    //   539: ldc_w 1373
    //   542: invokevirtual 199	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	(ILjava/lang/String;)V
    //   545: aload_0
    //   546: invokevirtual 201	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	()V
    //   549: return
    //   550: aload_0
    //   551: getfield 1375	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   554: ifnonnull +59 -> 613
    //   557: aload_0
    //   558: new 1377	java/io/RandomAccessFile
    //   561: dup
    //   562: aload_0
    //   563: getfield 169	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_Bayk	Lbayk;
    //   566: getfield 184	bayk:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   569: ldc_w 1378
    //   572: invokespecial 1380	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   575: putfield 1375	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   578: aload_0
    //   579: getfield 1375	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   582: ifnonnull +31 -> 613
    //   585: aload_0
    //   586: sipush 9303
    //   589: ldc_w 1382
    //   592: invokevirtual 199	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	(ILjava/lang/String;)V
    //   595: aload_0
    //   596: invokevirtual 201	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	()V
    //   599: return
    //   600: astore_2
    //   601: aload_2
    //   602: invokevirtual 1383	java/io/FileNotFoundException:printStackTrace	()V
    //   605: aload_0
    //   606: aconst_null
    //   607: putfield 1375	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   610: goto -32 -> 578
    //   613: aload_0
    //   614: getfield 169	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_Bayk	Lbayk;
    //   617: getfield 174	bayk:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   620: checkcast 176	com/tencent/mobileqq/data/MessageForShortVideo
    //   623: getfield 179	com/tencent/mobileqq/data/MessageForShortVideo:busiType	I
    //   626: iconst_1
    //   627: if_icmpne +43 -> 670
    //   630: getstatic 1386	com/tencent/mobileqq/highway/utils/VideoUpConfigInfo:sSwitch	I
    //   633: iconst_2
    //   634: if_icmpne +8 -> 642
    //   637: aload_0
    //   638: iconst_2
    //   639: putfield 132	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:z	I
    //   642: getstatic 1387	baxi:jdField_a_of_type_Long	J
    //   645: lconst_0
    //   646: lcmp
    //   647: ifle -286 -> 361
    //   650: aload_0
    //   651: getfield 330	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   654: ldc_w 866
    //   657: getstatic 1387	baxi:jdField_a_of_type_Long	J
    //   660: invokestatic 757	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   663: invokevirtual 338	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   666: pop
    //   667: goto -306 -> 361
    //   670: aload_0
    //   671: getfield 169	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_Bayk	Lbayk;
    //   674: getfield 174	bayk:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   677: checkcast 176	com/tencent/mobileqq/data/MessageForShortVideo
    //   680: getfield 179	com/tencent/mobileqq/data/MessageForShortVideo:busiType	I
    //   683: iconst_2
    //   684: if_icmpne -42 -> 642
    //   687: getstatic 1390	com/tencent/mobileqq/highway/utils/PTVUpConfigInfo:sSwitch	I
    //   690: iconst_2
    //   691: if_icmpne -49 -> 642
    //   694: aload_0
    //   695: iconst_2
    //   696: putfield 132	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:z	I
    //   699: goto -57 -> 642
    //   702: aload_3
    //   703: ifnull +7 -> 710
    //   706: aload_3
    //   707: invokevirtual 1356	java/io/FileInputStream:close	()V
    //   710: aload_0
    //   711: getfield 1392	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   714: ifnonnull +125 -> 839
    //   717: aload_0
    //   718: new 1377	java/io/RandomAccessFile
    //   721: dup
    //   722: aload_0
    //   723: getfield 206	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   726: ldc_w 1378
    //   729: invokespecial 1380	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   732: putfield 1392	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   735: aload_0
    //   736: getfield 1392	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   739: ifnonnull +100 -> 839
    //   742: aload_0
    //   743: sipush 9303
    //   746: ldc_w 1394
    //   749: invokevirtual 199	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	(ILjava/lang/String;)V
    //   752: aload_0
    //   753: invokevirtual 201	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	()V
    //   756: return
    //   757: astore_2
    //   758: aload_2
    //   759: invokevirtual 1357	java/io/IOException:printStackTrace	()V
    //   762: goto -52 -> 710
    //   765: astore 4
    //   767: aconst_null
    //   768: astore_3
    //   769: aload_3
    //   770: astore_2
    //   771: aload_0
    //   772: aconst_null
    //   773: putfield 227	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   776: aload_3
    //   777: astore_2
    //   778: aload_0
    //   779: aload 4
    //   781: invokevirtual 1397	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(Ljava/io/IOException;)V
    //   784: aload_3
    //   785: astore_2
    //   786: aload_0
    //   787: invokevirtual 201	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	()V
    //   790: aload_3
    //   791: ifnull -784 -> 7
    //   794: aload_3
    //   795: invokevirtual 1356	java/io/FileInputStream:close	()V
    //   798: return
    //   799: astore_2
    //   800: aload_2
    //   801: invokevirtual 1357	java/io/IOException:printStackTrace	()V
    //   804: return
    //   805: astore_3
    //   806: aconst_null
    //   807: astore_2
    //   808: aload_2
    //   809: ifnull +7 -> 816
    //   812: aload_2
    //   813: invokevirtual 1356	java/io/FileInputStream:close	()V
    //   816: aload_3
    //   817: athrow
    //   818: astore_2
    //   819: aload_2
    //   820: invokevirtual 1357	java/io/IOException:printStackTrace	()V
    //   823: goto -7 -> 816
    //   826: astore_2
    //   827: aload_2
    //   828: invokevirtual 1383	java/io/FileNotFoundException:printStackTrace	()V
    //   831: aload_0
    //   832: aconst_null
    //   833: putfield 1392	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   836: goto -101 -> 735
    //   839: aload_0
    //   840: new 274	java/io/File
    //   843: dup
    //   844: aload_0
    //   845: getfield 206	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   848: invokespecial 277	java/io/File:<init>	(Ljava/lang/String;)V
    //   851: invokevirtual 285	java/io/File:length	()J
    //   854: putfield 301	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_Long	J
    //   857: aload_0
    //   858: aload_0
    //   859: getfield 206	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   862: invokevirtual 1399	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	(Ljava/lang/String;)V
    //   865: ldc_w 1401
    //   868: monitorenter
    //   869: aload_0
    //   870: getfield 169	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_Bayk	Lbayk;
    //   873: getfield 239	bayk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   876: invokestatic 1405	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   879: invokevirtual 1408	com/tencent/mobileqq/highway/openup/SessionInfo:getHttpconn_sig_session	()[B
    //   882: ifnull +48 -> 930
    //   885: aload_0
    //   886: getfield 169	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_Bayk	Lbayk;
    //   889: getfield 239	bayk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   892: invokestatic 1405	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   895: invokevirtual 1408	com/tencent/mobileqq/highway/openup/SessionInfo:getHttpconn_sig_session	()[B
    //   898: arraylength
    //   899: istore_1
    //   900: aload_0
    //   901: iload_1
    //   902: newarray byte
    //   904: putfield 777	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_f_of_type_ArrayOfByte	[B
    //   907: aload_0
    //   908: getfield 169	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_Bayk	Lbayk;
    //   911: getfield 239	bayk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   914: invokestatic 1405	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   917: invokevirtual 1408	com/tencent/mobileqq/highway/openup/SessionInfo:getHttpconn_sig_session	()[B
    //   920: iconst_0
    //   921: aload_0
    //   922: getfield 777	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_f_of_type_ArrayOfByte	[B
    //   925: iconst_0
    //   926: iload_1
    //   927: invokestatic 1412	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   930: aload_0
    //   931: getfield 169	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_Bayk	Lbayk;
    //   934: getfield 239	bayk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   937: invokestatic 1405	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   940: invokevirtual 1415	com/tencent/mobileqq/highway/openup/SessionInfo:getSessionKey	()[B
    //   943: ifnull +48 -> 991
    //   946: aload_0
    //   947: getfield 169	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_Bayk	Lbayk;
    //   950: getfield 239	bayk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   953: invokestatic 1405	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   956: invokevirtual 1415	com/tencent/mobileqq/highway/openup/SessionInfo:getSessionKey	()[B
    //   959: arraylength
    //   960: istore_1
    //   961: aload_0
    //   962: iload_1
    //   963: newarray byte
    //   965: putfield 780	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_e_of_type_ArrayOfByte	[B
    //   968: aload_0
    //   969: getfield 169	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_Bayk	Lbayk;
    //   972: getfield 239	bayk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   975: invokestatic 1405	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   978: invokevirtual 1415	com/tencent/mobileqq/highway/openup/SessionInfo:getSessionKey	()[B
    //   981: iconst_0
    //   982: aload_0
    //   983: getfield 780	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_e_of_type_ArrayOfByte	[B
    //   986: iconst_0
    //   987: iload_1
    //   988: invokestatic 1412	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   991: ldc_w 1401
    //   994: monitorexit
    //   995: aload_0
    //   996: getfield 777	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_f_of_type_ArrayOfByte	[B
    //   999: ifnull +26 -> 1025
    //   1002: aload_0
    //   1003: getfield 777	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_f_of_type_ArrayOfByte	[B
    //   1006: arraylength
    //   1007: ifeq +18 -> 1025
    //   1010: aload_0
    //   1011: getfield 780	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_e_of_type_ArrayOfByte	[B
    //   1014: ifnull +11 -> 1025
    //   1017: aload_0
    //   1018: getfield 780	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_e_of_type_ArrayOfByte	[B
    //   1021: arraylength
    //   1022: ifne +67 -> 1089
    //   1025: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1028: ifeq +12 -> 1040
    //   1031: ldc 147
    //   1033: iconst_2
    //   1034: ldc_w 1417
    //   1037: invokestatic 1115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1040: aload_0
    //   1041: getfield 130	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1044: aload_0
    //   1045: getfield 169	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_Bayk	Lbayk;
    //   1048: getfield 239	bayk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1051: invokestatic 1423	com/tencent/mobileqq/highway/config/HwServlet:getConfig	(Lmqq/app/AppRuntime;Ljava/lang/String;)V
    //   1054: aload_0
    //   1055: getfield 132	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:z	I
    //   1058: iconst_3
    //   1059: if_icmpne +30 -> 1089
    //   1062: aload_0
    //   1063: monitorenter
    //   1064: aload_0
    //   1065: iconst_1
    //   1066: putfield 72	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:B	I
    //   1069: aload_0
    //   1070: iconst_3
    //   1071: putfield 699	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:C	I
    //   1074: aload_0
    //   1075: monitorexit
    //   1076: return
    //   1077: astore_2
    //   1078: aload_0
    //   1079: monitorexit
    //   1080: aload_2
    //   1081: athrow
    //   1082: astore_2
    //   1083: ldc_w 1401
    //   1086: monitorexit
    //   1087: aload_2
    //   1088: athrow
    //   1089: ldc 147
    //   1091: iconst_1
    //   1092: new 149	java/lang/StringBuilder
    //   1095: dup
    //   1096: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   1099: ldc_w 1425
    //   1102: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1105: aload_0
    //   1106: getfield 132	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:z	I
    //   1109: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1112: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1115: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1118: aload_0
    //   1119: getfield 132	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:z	I
    //   1122: tableswitch	default:+22 -> 1144, 2:+27->1149, 3:+37->1159
    //   1145: invokevirtual 1427	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:g	()V
    //   1148: return
    //   1149: aload_0
    //   1150: iconst_1
    //   1151: putfield 1063	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:w	I
    //   1154: aload_0
    //   1155: invokevirtual 1065	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:r	()V
    //   1158: return
    //   1159: aload_0
    //   1160: aload_0
    //   1161: getfield 169	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_Bayk	Lbayk;
    //   1164: getfield 236	bayk:jdField_a_of_type_Long	J
    //   1167: putfield 839	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_Long	J
    //   1170: aload_0
    //   1171: aload_0
    //   1172: getfield 206	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1175: aload_0
    //   1176: getfield 301	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_Long	J
    //   1179: l2i
    //   1180: aload_0
    //   1181: getfield 777	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_f_of_type_ArrayOfByte	[B
    //   1184: aload_0
    //   1185: getfield 780	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_e_of_type_ArrayOfByte	[B
    //   1188: aload_0
    //   1189: getfield 227	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   1192: aload_0
    //   1193: getfield 839	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_Long	J
    //   1196: invokevirtual 1429	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(Ljava/lang/String;I[B[B[BJ)V
    //   1199: aload_0
    //   1200: iconst_1
    //   1201: putfield 1063	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:w	I
    //   1204: return
    //   1205: astore_3
    //   1206: goto -398 -> 808
    //   1209: astore 4
    //   1211: goto -442 -> 769
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1214	0	this	ShortVideoUploadProcessor
    //   899	89	1	i	int
    //   143	291	2	localObject1	Object
    //   447	2	2	localIOException1	java.io.IOException
    //   484	10	2	localbass	bass
    //   600	2	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   757	2	2	localIOException2	java.io.IOException
    //   770	16	2	localObject2	Object
    //   799	2	2	localIOException3	java.io.IOException
    //   807	6	2	localObject3	Object
    //   818	2	2	localIOException4	java.io.IOException
    //   826	2	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   1077	4	2	localObject4	Object
    //   1082	6	2	localObject5	Object
    //   379	416	3	localObject6	Object
    //   805	12	3	localObject7	Object
    //   1205	1	3	localObject8	Object
    //   765	15	4	localIOException5	java.io.IOException
    //   1209	1	4	localIOException6	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   442	446	447	java/io/IOException
    //   557	578	600	java/io/FileNotFoundException
    //   706	710	757	java/io/IOException
    //   368	380	765	java/io/IOException
    //   794	798	799	java/io/IOException
    //   368	380	805	finally
    //   812	816	818	java/io/IOException
    //   717	735	826	java/io/FileNotFoundException
    //   1064	1076	1077	finally
    //   1078	1080	1077	finally
    //   869	930	1082	finally
    //   930	991	1082	finally
    //   991	995	1082	finally
    //   1083	1087	1082	finally
    //   382	391	1205	finally
    //   393	400	1205	finally
    //   402	432	1205	finally
    //   434	438	1205	finally
    //   771	776	1205	finally
    //   778	784	1205	finally
    //   786	790	1205	finally
    //   382	391	1209	java/io/IOException
    //   393	400	1209	java/io/IOException
    //   402	432	1209	java/io/IOException
    //   434	438	1209	java/io/IOException
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "resume()  + mIsPause : " + this.jdField_k_of_type_Boolean);
    }
    if (this.jdField_k_of_type_Boolean)
    {
      this.jdField_k_of_type_Boolean = false;
      this.o = false;
      d(1002);
      this.t = 0;
      this.jdField_s_of_type_Int = 0;
      this.jdField_r_of_type_Int = 0;
      this.jdField_j_of_type_Int = 0;
      this.jdField_j_of_type_JavaLangString = "";
      v();
      d(1001);
      this.jdField_a_of_type_Bard.a.post(new ShortVideoUploadProcessor.1(this));
    }
    return 0;
  }
  
  public String b()
  {
    if ((this.jdField_a_of_type_Bayk.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Bayk.jdField_a_of_type_Int == 3000))
    {
      if (this.w == 1) {
        return "actShortVideoDiscussgroupUploadBDH";
      }
      return "actShortVideoDiscussgroupUpload";
    }
    if (this.w == 1) {
      return "actShortVideoUploadBDH";
    }
    return "actShortVideoUpload";
  }
  
  protected void b(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    this.jdField_a_of_type_Int = localOptions.outWidth;
    this.jdField_b_of_type_Int = localOptions.outHeight;
  }
  
  public void b(boolean paramBoolean)
  {
    int j = 2002;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "sendMsg() start.");
    }
    if (!f())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "do not send message, due to mIsCancel=true || mIsPause=true.");
      }
      return;
    }
    Object localObject2;
    if ((this.jdField_a_of_type_Bayk.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_Bayk.jdField_a_of_type_JavaLangObject instanceof azen)))
    {
      localObject2 = (azen)this.jdField_a_of_type_Bayk.jdField_a_of_type_JavaLangObject;
      this.jdField_s_of_type_Boolean = ((azen)localObject2).jdField_g_of_type_Boolean;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "sendMsg() start, mNeedSyncStory = " + this.jdField_s_of_type_Boolean);
      }
    }
    for (;;)
    {
      if (localObject2 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "sendMsg() start, isHotVideo = " + ((azen)localObject2).jdField_e_of_type_Boolean);
        }
        if (((azen)localObject2).jdField_e_of_type_Boolean)
        {
          this.jdField_l_of_type_JavaLangString = ((azen)localObject2).jdField_a_of_type_JavaLangString;
          this.jdField_c_of_type_JavaLangString = ((azen)localObject2).jdField_e_of_type_JavaLangString;
          this.jdField_a_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(((azen)localObject2).jdField_e_of_type_JavaLangString);
          this.jdField_q_of_type_Long = (((azen)localObject2).jdField_e_of_type_Int + ((azen)localObject2).jdField_b_of_type_Long);
          this.jdField_c_of_type_Int = ((azen)localObject2).f;
          this.jdField_a_of_type_Long = ((azen)localObject2).jdField_b_of_type_Long;
          this.jdField_d_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(((azen)localObject2).jdField_g_of_type_JavaLangString);
          this.jdField_b_of_type_Int = ((azen)localObject2).jdField_d_of_type_Int;
          this.jdField_a_of_type_Int = ((azen)localObject2).jdField_c_of_type_Int;
        }
      }
      if (!this.jdField_c_of_type_Boolean) {
        break;
      }
      bdif.a(String.valueOf(this.jdField_a_of_type_Bayk.jdField_a_of_type_Long), "message", "sendMsg() start.");
      this.jdField_c_of_type_Barh.a();
      Object localObject3 = a();
      if (localObject3 == null)
      {
        a(9368, "constructpberror", null, this.jdField_c_of_type_Barh);
        d();
        return;
      }
      if (this.jdField_a_of_type_Bayk.jdField_a_of_type_Awkh != null)
      {
        localObject1 = this.jdField_a_of_type_Bayk.jdField_a_of_type_Awkh.a((im_msg_body.RichText)localObject3);
        if ((localObject1 != null) && ((localObject1 instanceof MessageForShortVideo))) {
          break label508;
        }
        localObject2 = new StringBuilder().append("Mr_");
        if (localObject1 != null) {
          break label479;
        }
      }
      label479:
      for (Object localObject1 = "null";; localObject1 = "" + ((MessageRecord)localObject1).msgtype)
      {
        a(9368, "msgtypeError", (String)localObject1, this.jdField_c_of_type_Barh);
        d();
        return;
        if (this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
        {
          localObject1 = this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          break;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bayk.jdField_a_of_type_Int, this.jdField_a_of_type_Bayk.jdField_a_of_type_Long);
        break;
      }
      label508:
      ((MessageForShortVideo)localObject1).richText = ((im_msg_body.RichText)localObject3);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "sendMsg() start, subBusiType = " + ((MessageForShortVideo)localObject1).subBusiType);
      }
      if ((this.jdField_a_of_type_Bayk.jdField_e_of_type_Int == 1010) && (this.jdField_a_of_type_Bayk.jdField_a_of_type_Awkh != null))
      {
        e();
        return;
      }
      if ((localObject1 instanceof MessageForBlessPTV))
      {
        ((MessageForBlessPTV)localObject1).uuid = this.jdField_f_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().notifyUI(999, true, ((MessageRecord)localObject1).frienduin);
        awiw.a("ShortVideoUploadProcessor", "updataMessageDataBaseContent", "notifyUI bless ptv data send finished");
        return;
      }
      if ((localObject1 instanceof MessageForDanceMachine))
      {
        ((MessageForDanceMachine)localObject1).uuid = this.jdField_f_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().notifyUI(8034, true, localObject1);
        awiw.a("ShortVideoUploadProcessor", "updataMessageDataBaseContent", "notifyUI dance machine data send finished");
        return;
      }
      if (!e())
      {
        a(9366, "illegal app", null, this.jdField_c_of_type_Barh);
        d();
        return;
      }
      bdif.a(String.valueOf(this.jdField_a_of_type_Bayk.jdField_a_of_type_Long), "message", "sendMsg() []. mr = " + ((MessageRecord)localObject1).toString());
      ((axwx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a((MessageRecord)localObject1, this.jdField_a_of_type_Alwx);
      if (localObject2 == null) {
        break;
      }
      localObject3 = new axtc(BaseApplication.getContext());
      int i = j;
      switch (((MessageForShortVideo)localObject1).busiType)
      {
      default: 
        i = j;
      }
      for (;;)
      {
        if ((((azen)localObject2).jdField_i_of_type_JavaLangString == null) || (((azen)localObject2).jdField_i_of_type_JavaLangString.length() <= 0)) {
          ((azen)localObject2).jdField_i_of_type_JavaLangString = ((azen)localObject2).h;
        }
        ((axtc)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((azen)localObject2).jdField_i_of_type_JavaLangString, i, ((MessageRecord)localObject1).istroop, ((MessageRecord)localObject1).frienduin, false, paramBoolean, -1, null, ((azen)localObject2).f, ((azen)localObject2).jdField_e_of_type_JavaLangString);
        return;
        i = 2001;
        continue;
        i = 2003;
      }
      localObject2 = null;
    }
  }
  
  public int c()
  {
    if ((this.jdField_a_of_type_Bayk != null) && (this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (((MessageForShortVideo)this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType == 0)) {
      this.jdField_m_of_type_Boolean = true;
    }
    return 0;
  }
  
  public void c()
  {
    if (!this.jdField_k_of_type_Boolean)
    {
      this.jdField_k_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        b("pause", "");
      }
      d(1004);
      if ((this.jdField_a_of_type_Bayk.jdField_e_of_type_Int == 1010) && (this.jdField_a_of_type_Bayk.jdField_a_of_type_Awkh != null))
      {
        awki localawki = new awki();
        localawki.jdField_a_of_type_Int = -1;
        localawki.jdField_b_of_type_Int = 9037;
        localawki.jdField_a_of_type_JavaLangString = "cancel";
        this.jdField_a_of_type_Bayk.jdField_a_of_type_Awkh.b(localawki);
      }
      if (this.jdField_a_of_type_Bbax != null)
      {
        bbcd.b(this.jdField_a_of_type_Bbax);
        this.jdField_a_of_type_Bbax = null;
      }
    }
    switch (this.w)
    {
    default: 
      return;
    case 0: 
      d("<BDH_LOG> pause() BUT current status is INIT");
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null)
    {
      d("<BDH_LOG> pause() pause BDH channel, transation id=" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().stopTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      return;
    }
    d("<BDH_LOG> pause() pause BDH channel, but trans == null");
  }
  
  public void d()
  {
    try
    {
      if ((this.jdField_c_of_type_JavaUtilList != null) && (this.jdField_c_of_type_JavaUtilList.size() != 0))
      {
        Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((Transaction)localIterator.next()).cancelTransaction();
        }
        this.jdField_c_of_type_JavaUtilList.clear();
      }
    }
    finally {}
    if (this.jdField_a_of_type_ComTencentMobileqqHighwaySegmentRequestAck != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().cancelAckRequest(this.jdField_a_of_type_ComTencentMobileqqHighwaySegmentRequestAck);
      this.jdField_a_of_type_ComTencentMobileqqHighwaySegmentRequestAck = null;
    }
    super.d();
    if ((this.z == 3) && (this.jdField_c_of_type_JavaLangString != null) && (this.jdField_c_of_type_JavaLangString.length() > 0)) {
      if (this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) {
        break label417;
      }
    }
    label417:
    for (Object localObject2 = this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;; localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bayk.jdField_a_of_type_Int, this.jdField_a_of_type_Bayk.jdField_a_of_type_Long))
    {
      if ((localObject2 != null) && ((localObject2 instanceof MessageForShortVideo))) {
        ((MessageForShortVideo)localObject2).md5 = this.jdField_c_of_type_JavaLangString;
      }
      d(1005);
      if (QLog.isColorLevel())
      {
        QLog.d("ShortVideoUploadProcessor", 2, "onError()---- errCode:" + this.jdField_j_of_type_Int);
        QLog.d("ShortVideoUploadProcessor", 2, "onError()---- errDesc:" + this.jdField_j_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_Bayk.jdField_a_of_type_Awkh != null)
      {
        localObject2 = new awki();
        ((awki)localObject2).jdField_a_of_type_Int = -1;
        ((awki)localObject2).jdField_b_of_type_Int = this.jdField_j_of_type_Int;
        ((awki)localObject2).jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
        this.jdField_a_of_type_Bayk.jdField_a_of_type_Awkh.b((awki)localObject2);
      }
      if ((this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForBlessPTV)))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().notifyUI(999, false, this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin);
        awiw.a("ShortVideoUploadProcessor", "onError", "notifyUI bless ptv send error");
      }
      if ((this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForDanceMachine)))
      {
        ((MessageForDanceMachine)this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).errorCode = 1;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().notifyUI(8034, false, this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
        awiw.a("ShortVideoUploadProcessor", "onError", "notifyUI dance machine send error");
      }
      return;
    }
  }
  
  public void d(int paramInt)
  {
    super.d(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "sendMessageToUpdate------state = " + paramInt + ", str= " + ShortVideoUtils.b(paramInt));
    }
    if ((this.jdField_k_of_type_Boolean) && (1004 != paramInt)) {
      return;
    }
    azdd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bass, this.jdField_a_of_type_Bayk);
  }
  
  public void d(boolean paramBoolean)
  {
    MessageRecord localMessageRecord;
    if (this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
    {
      localMessageRecord = this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (localMessageRecord != null) {
        break label78;
      }
      b("updateDb", "msg null");
    }
    label78:
    while (!(localMessageRecord instanceof MessageForShortVideo))
    {
      return;
      localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bayk.jdField_a_of_type_Int, this.jdField_a_of_type_Bayk.jdField_a_of_type_Long);
      b("updateDb", "findmsgbyMsgId,need fix");
      break;
    }
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)localMessageRecord;
    localMessageForShortVideo.videoFileSize = ((int)(this.jdField_q_of_type_Long - this.jdField_a_of_type_Long));
    if (this.jdField_f_of_type_JavaLangString == null) {}
    for (String str = this.jdField_l_of_type_JavaLangString;; str = this.jdField_f_of_type_JavaLangString)
    {
      localMessageForShortVideo.uuid = str;
      localMessageForShortVideo.md5 = this.jdField_c_of_type_JavaLangString;
      localMessageForShortVideo.videoAttr = this.E;
      localMessageForShortVideo.videoKandianType = this.F;
      localMessageForShortVideo.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bayk.jdField_a_of_type_Int, localMessageRecord.uniseq, localMessageForShortVideo.msgData);
      return;
    }
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_Amcp != null) {
      this.jdField_a_of_type_Amcp.a(this.jdField_a_of_type_Bayk.jdField_f_of_type_JavaLangString + this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString + this.jdField_a_of_type_Bayk.jdField_a_of_type_Long);
    }
    String str;
    if (this.jdField_a_of_type_Bayk.jdField_a_of_type_Awkh != null)
    {
      awki localawki = new awki();
      localawki.jdField_a_of_type_Int = 0;
      localawki.jdField_a_of_type_Long = (this.jdField_q_of_type_Long - this.jdField_a_of_type_Long);
      localawki.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      if (this.jdField_f_of_type_JavaLangString == null)
      {
        str = this.jdField_l_of_type_JavaLangString;
        localawki.jdField_c_of_type_JavaLangString = str;
        localawki.jdField_c_of_type_Long = this.jdField_a_of_type_Long;
        localawki.jdField_c_of_type_Int = this.E;
        localawki.jdField_d_of_type_Int = this.F;
        this.jdField_a_of_type_Bayk.jdField_a_of_type_Awkh.b(localawki);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "onSuccess uuid = " + localawki.jdField_c_of_type_JavaLangString);
        }
      }
    }
    for (;;)
    {
      d(1003);
      if (this.jdField_a_of_type_Bayk.jdField_e_of_type_Int == 2) {
        w();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "onSuccess().");
      }
      return;
      str = this.jdField_f_of_type_JavaLangString;
      break;
      d(true);
    }
  }
  
  void f()
  {
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.PreUploadVideoConfig.name(), "0|0|1.0|5|480000|0");
    if ((localObject != null) && (((String)localObject).length() > 0))
    {
      localObject = ((String)localObject).split("\\|");
      if ((localObject == null) || (localObject.length < 5)) {}
    }
    for (;;)
    {
      try
      {
        l = Long.valueOf(localObject[4]).longValue();
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> dpcTimeout : " + l);
        }
        if (l > 0L) {
          this.jdField_f_of_type_Long = l;
        }
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoUploadProcessor", 2, "<BDH_LOG>get DpcConfig Erro", localNumberFormatException);
        }
      }
      long l = 0L;
    }
  }
  
  public void f(int paramInt)
  {
    try
    {
      this.B = 1;
      this.C = paramInt;
      if (this.A == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> handleBDHActError mVideoPreUpStatus = " + this.B + " mVideoRecordStatus = " + this.A);
        }
        bdif.a(String.valueOf(this.jdField_a_of_type_Bayk.jdField_a_of_type_Long), "handleBDHActError", "mVideoPreUpStatus = " + this.B + " mVideoRecordStatus = " + this.A);
        y();
      }
      return;
    }
    finally {}
  }
  
  void g()
  {
    this.jdField_a_of_type_Barh.a();
    bbax localbbax = new bbax();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "sendGetUrlReq()----busiReq.seq : " + this.jdField_a_of_type_Bayk.jdField_a_of_type_Long);
    }
    bbbl localbbbl = a();
    localbbax.jdField_a_of_type_Bbce = this;
    localbbax.jdField_a_of_type_JavaLangString = "short_video_up";
    localbbax.jdField_a_of_type_JavaUtilList.add(localbbbl);
    localbbax.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Barh);
      d();
    }
    do
    {
      return;
      if (localbbbl.jdField_a_of_type_Long == 0L)
      {
        b(9303, "video filesize is 0");
        d();
        return;
      }
      if (this.jdField_a_of_type_Long == 0L)
      {
        b(9303, "thumbfile filesize is 0");
        d();
        return;
      }
      if ((localbbbl.jdField_j_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().mConnManager.getCurrentConnNum() > 0)) {
        this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
      }
      b("requestStart", localbbax.toString());
    } while (!f());
    this.jdField_a_of_type_Bbax = localbbax;
    bbcd.a(localbbax);
  }
  
  void h()
  {
    if (this.o) {
      return;
    }
    if ((this.w == 1) && (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null))
    {
      if (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.isSuccess.get())
      {
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoUploadProcessor", 2, "inter_retry resume sendMsg!");
        }
        b(false);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().resumeTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      return;
    }
    if ((this.jdField_f_of_type_JavaLangString != null) && (this.jdField_s_of_type_Long >= this.jdField_q_of_type_Long))
    {
      b(false);
      return;
    }
    aP_();
  }
  
  /* Error */
  public void r()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +29 -> 35
    //   9: ldc 147
    //   11: iconst_2
    //   12: new 149	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 1799
    //   22: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: invokevirtual 1802	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: aload_0
    //   36: getfield 745	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_Barh	Lbarh;
    //   39: invokevirtual 1121	barh:a	()V
    //   42: aload_0
    //   43: getfield 1293	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   46: ifnull +4 -> 50
    //   49: return
    //   50: invokestatic 692	android/os/SystemClock:uptimeMillis	()J
    //   53: lstore_3
    //   54: aload_0
    //   55: getfield 227	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   58: arraylength
    //   59: aload_0
    //   60: getfield 288	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   63: arraylength
    //   64: iadd
    //   65: newarray byte
    //   67: astore 10
    //   69: aload_0
    //   70: getfield 227	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   73: iconst_0
    //   74: aload 10
    //   76: iconst_0
    //   77: aload_0
    //   78: getfield 227	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   81: arraylength
    //   82: invokestatic 1412	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   85: aload_0
    //   86: getfield 288	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   89: iconst_0
    //   90: aload 10
    //   92: aload_0
    //   93: getfield 227	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   96: arraylength
    //   97: aload_0
    //   98: getfield 288	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   101: arraylength
    //   102: invokestatic 1412	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   105: new 149	java/lang/StringBuilder
    //   108: dup
    //   109: invokestatic 1804	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	()Ljava/lang/String;
    //   112: invokespecial 1805	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   115: aload 10
    //   117: invokestatic 845	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   120: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: ldc_w 1807
    //   126: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: astore 15
    //   134: invokestatic 692	android/os/SystemClock:uptimeMillis	()J
    //   137: lstore 5
    //   139: new 274	java/io/File
    //   142: dup
    //   143: aload 15
    //   145: invokespecial 277	java/io/File:<init>	(Ljava/lang/String;)V
    //   148: invokevirtual 1810	java/io/File:delete	()Z
    //   151: pop
    //   152: new 274	java/io/File
    //   155: dup
    //   156: aload 15
    //   158: invokespecial 277	java/io/File:<init>	(Ljava/lang/String;)V
    //   161: astore 10
    //   163: aload 10
    //   165: invokevirtual 1813	java/io/File:exists	()Z
    //   168: istore 9
    //   170: iload 9
    //   172: ifne +9 -> 181
    //   175: aload 10
    //   177: invokevirtual 1816	java/io/File:createNewFile	()Z
    //   180: pop
    //   181: new 1818	java/io/FileOutputStream
    //   184: dup
    //   185: aload 10
    //   187: invokespecial 1821	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   190: astore 10
    //   192: new 1823	java/io/BufferedOutputStream
    //   195: dup
    //   196: aload 10
    //   198: invokespecial 1826	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   201: astore 12
    //   203: aload 10
    //   205: astore 13
    //   207: aload 12
    //   209: astore 11
    //   211: aload_0
    //   212: getfield 1392	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   215: invokevirtual 1827	java/io/RandomAccessFile:length	()J
    //   218: l2i
    //   219: newarray byte
    //   221: astore 14
    //   223: aload 10
    //   225: astore 13
    //   227: aload 12
    //   229: astore 11
    //   231: aload_0
    //   232: getfield 1392	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   235: aload 14
    //   237: invokevirtual 1831	java/io/RandomAccessFile:read	([B)I
    //   240: pop
    //   241: aload 10
    //   243: astore 13
    //   245: aload 12
    //   247: astore 11
    //   249: aload 12
    //   251: aload 14
    //   253: invokevirtual 1835	java/io/BufferedOutputStream:write	([B)V
    //   256: aload 10
    //   258: astore 13
    //   260: aload 12
    //   262: astore 11
    //   264: ldc_w 1836
    //   267: newarray byte
    //   269: astore 14
    //   271: aload 10
    //   273: astore 13
    //   275: aload 12
    //   277: astore 11
    //   279: aload_0
    //   280: getfield 1375	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   283: aload 14
    //   285: invokevirtual 1831	java/io/RandomAccessFile:read	([B)I
    //   288: istore_1
    //   289: iload_1
    //   290: iconst_m1
    //   291: if_icmpeq +607 -> 898
    //   294: aload 10
    //   296: astore 13
    //   298: aload 12
    //   300: astore 11
    //   302: aload 12
    //   304: aload 14
    //   306: iconst_0
    //   307: iload_1
    //   308: invokevirtual 1839	java/io/BufferedOutputStream:write	([BII)V
    //   311: goto -40 -> 271
    //   314: astore 13
    //   316: aload 12
    //   318: astore 11
    //   320: aload 13
    //   322: astore 12
    //   324: aload 12
    //   326: invokevirtual 1383	java/io/FileNotFoundException:printStackTrace	()V
    //   329: aload 11
    //   331: ifnull +8 -> 339
    //   334: aload 11
    //   336: invokevirtual 1840	java/io/BufferedOutputStream:close	()V
    //   339: aload 10
    //   341: ifnull +8 -> 349
    //   344: aload 10
    //   346: invokevirtual 1841	java/io/FileOutputStream:close	()V
    //   349: aload_0
    //   350: invokespecial 1750	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	()Lbbbl;
    //   353: astore 10
    //   355: new 1843	pttcenterservice/PttShortVideo$PttShortVideoUploadReq
    //   358: dup
    //   359: invokespecial 1844	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:<init>	()V
    //   362: astore 11
    //   364: aload 11
    //   366: iconst_1
    //   367: invokevirtual 1845	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:setHasFlag	(Z)V
    //   370: aload 11
    //   372: getfield 1846	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint64_fromuin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   375: aload 10
    //   377: getfield 241	bbbl:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   380: invokestatic 950	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   383: invokevirtual 940	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   386: aload 11
    //   388: getfield 1847	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint64_touin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   391: aload 10
    //   393: getfield 252	bbbl:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   396: invokestatic 950	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   399: invokevirtual 940	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   402: aload 11
    //   404: getfield 1848	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_chat_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   407: aload 10
    //   409: getfield 270	bbbl:jdField_a_of_type_Int	I
    //   412: invokevirtual 421	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   415: aload 11
    //   417: getfield 1849	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_client_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   420: aload 10
    //   422: getfield 272	bbbl:jdField_b_of_type_Int	I
    //   425: invokevirtual 421	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   428: aload 10
    //   430: getfield 269	bbbl:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   433: ifnull +747 -> 1180
    //   436: aload 11
    //   438: getfield 1850	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   441: aload 10
    //   443: getfield 269	bbbl:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   446: invokestatic 950	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   449: invokevirtual 940	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   452: aload 11
    //   454: getfield 1853	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_agent_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   457: aload 10
    //   459: getfield 268	bbbl:i	I
    //   462: invokevirtual 421	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   465: aload 11
    //   467: getfield 1854	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_business_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   470: aload 10
    //   472: getfield 345	bbbl:jdField_j_of_type_Int	I
    //   475: invokevirtual 421	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   478: aload 11
    //   480: getfield 1857	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_flag_support_large_size	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   483: iconst_1
    //   484: invokevirtual 421	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   487: new 1859	pttcenterservice/PttShortVideo$PttShortVideoFileInfo
    //   490: dup
    //   491: invokespecial 1860	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:<init>	()V
    //   494: astore 12
    //   496: aload 12
    //   498: getfield 1864	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:str_file_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   501: aload 10
    //   503: getfield 281	bbbl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   506: invokevirtual 1868	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   509: aload 12
    //   511: getfield 1869	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:bytes_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   514: aload 10
    //   516: getfield 289	bbbl:jdField_a_of_type_ArrayOfByte	[B
    //   519: invokestatic 503	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   522: invokevirtual 404	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   525: aload 12
    //   527: getfield 1870	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:bytes_thumb_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   530: aload 10
    //   532: getfield 291	bbbl:jdField_b_of_type_ArrayOfByte	[B
    //   535: invokestatic 503	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   538: invokevirtual 404	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   541: aload 12
    //   543: getfield 1873	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint64_file_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   546: aload 10
    //   548: getfield 286	bbbl:jdField_a_of_type_Long	J
    //   551: invokevirtual 940	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   554: aload 12
    //   556: getfield 1876	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint32_file_res_length	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   559: aload 10
    //   561: getfield 297	bbbl:jdField_d_of_type_Int	I
    //   564: invokevirtual 421	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   567: aload 12
    //   569: getfield 1879	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint32_file_res_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   572: aload 10
    //   574: getfield 294	bbbl:jdField_e_of_type_Int	I
    //   577: invokevirtual 421	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   580: aload 12
    //   582: getfield 1880	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint32_file_format	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   585: aload 10
    //   587: getfield 328	bbbl:g	I
    //   590: invokevirtual 421	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   593: aload 12
    //   595: getfield 1881	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint32_file_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   598: aload 10
    //   600: getfield 300	bbbl:h	I
    //   603: invokevirtual 421	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   606: aload 12
    //   608: getfield 1884	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint64_thumb_file_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   611: aload 10
    //   613: getfield 303	bbbl:jdField_b_of_type_Long	J
    //   616: invokevirtual 940	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   619: aload 11
    //   621: getfield 1888	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:msg_PttShortVideoFileInfo	Lpttcenterservice/PttShortVideo$PttShortVideoFileInfo;
    //   624: aload 12
    //   626: invokevirtual 1889	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   629: aload 11
    //   631: invokevirtual 1890	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:toByteArray	()[B
    //   634: astore 11
    //   636: new 1892	baxo
    //   639: dup
    //   640: aload_0
    //   641: lload_3
    //   642: aload 15
    //   644: invokespecial 1895	baxo:<init>	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;JLjava/lang/String;)V
    //   647: astore 12
    //   649: bipush 12
    //   651: istore_1
    //   652: aload 10
    //   654: getfield 345	bbbl:jdField_j_of_type_Int	I
    //   657: ifne +6 -> 663
    //   660: bipush 25
    //   662: istore_1
    //   663: aload_0
    //   664: new 1133	com/tencent/mobileqq/highway/transaction/Transaction
    //   667: dup
    //   668: aload_0
    //   669: getfield 130	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   672: invokevirtual 1136	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   675: iload_1
    //   676: aload 15
    //   678: aload_0
    //   679: getfield 1057	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_r_of_type_Long	J
    //   682: l2i
    //   683: aload_0
    //   684: getfield 288	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   687: aload 12
    //   689: aload 11
    //   691: iconst_1
    //   692: invokespecial 1898	com/tencent/mobileqq/highway/transaction/Transaction:<init>	(Ljava/lang/String;ILjava/lang/String;I[BLcom/tencent/mobileqq/highway/api/ITransactionCallback;[BZ)V
    //   695: putfield 1293	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   698: new 1900	baxp
    //   701: dup
    //   702: aload_0
    //   703: invokespecial 1901	baxp:<init>	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;)V
    //   706: astore 10
    //   708: aload_0
    //   709: getfield 1293	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   712: aload 10
    //   714: putfield 1905	com/tencent/mobileqq/highway/transaction/Transaction:cbForReport	Lcom/tencent/mobileqq/highway/api/ITransCallbackForReport;
    //   717: aload_0
    //   718: getfield 130	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   721: invokevirtual 1007	com/tencent/mobileqq/app/QQAppInterface:getHwEngine	()Lcom/tencent/mobileqq/highway/HwEngine;
    //   724: aload_0
    //   725: getfield 1293	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   728: invokevirtual 1150	com/tencent/mobileqq/highway/HwEngine:submitTransactionTask	(Lcom/tencent/mobileqq/highway/transaction/Transaction;)I
    //   731: istore_2
    //   732: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   735: ifeq +113 -> 848
    //   738: ldc 147
    //   740: iconst_2
    //   741: new 149	java/lang/StringBuilder
    //   744: dup
    //   745: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   748: ldc_w 1907
    //   751: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: iload_2
    //   755: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   758: ldc_w 1154
    //   761: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: aload_0
    //   765: getfield 1293	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   768: invokevirtual 1157	com/tencent/mobileqq/highway/transaction/Transaction:getTransationId	()I
    //   771: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   774: ldc_w 1159
    //   777: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   780: aload_0
    //   781: getfield 169	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_Bayk	Lbayk;
    //   784: getfield 236	bayk:jdField_a_of_type_Long	J
    //   787: invokevirtual 683	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   790: ldc_w 1909
    //   793: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: aload_0
    //   797: getfield 494	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   800: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: ldc_w 1911
    //   806: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: aload_0
    //   810: getfield 493	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   813: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: ldc_w 1161
    //   819: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   822: aload_0
    //   823: getfield 1293	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   826: getfield 1164	com/tencent/mobileqq/highway/transaction/Transaction:filePath	Ljava/lang/String;
    //   829: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   832: ldc_w 1913
    //   835: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: iload_1
    //   839: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   842: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   845: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   848: iload_2
    //   849: ifeq -800 -> 49
    //   852: aload_0
    //   853: iload_2
    //   854: ldc_w 1915
    //   857: ldc_w 662
    //   860: aload_0
    //   861: getfield 745	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_Barh	Lbarh;
    //   864: invokevirtual 1505	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(ILjava/lang/String;Ljava/lang/String;Lbarh;)V
    //   867: aload_0
    //   868: invokevirtual 201	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	()V
    //   871: return
    //   872: astore 12
    //   874: aload 12
    //   876: invokevirtual 1357	java/io/IOException:printStackTrace	()V
    //   879: goto -698 -> 181
    //   882: astore 12
    //   884: aconst_null
    //   885: astore 13
    //   887: aload 11
    //   889: astore 10
    //   891: aload 13
    //   893: astore 11
    //   895: goto -571 -> 324
    //   898: aload 10
    //   900: astore 13
    //   902: aload 12
    //   904: astore 11
    //   906: invokestatic 692	android/os/SystemClock:uptimeMillis	()J
    //   909: lstore 7
    //   911: aload 10
    //   913: astore 13
    //   915: aload 12
    //   917: astore 11
    //   919: aload_0
    //   920: getfield 330	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   923: ldc_w 1917
    //   926: lload 7
    //   928: lload 5
    //   930: lsub
    //   931: invokestatic 757	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   934: invokevirtual 338	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   937: pop
    //   938: aload 12
    //   940: ifnull +8 -> 948
    //   943: aload 12
    //   945: invokevirtual 1840	java/io/BufferedOutputStream:close	()V
    //   948: aload 10
    //   950: ifnull -601 -> 349
    //   953: aload 10
    //   955: invokevirtual 1841	java/io/FileOutputStream:close	()V
    //   958: goto -609 -> 349
    //   961: astore 10
    //   963: aload 10
    //   965: invokevirtual 1357	java/io/IOException:printStackTrace	()V
    //   968: goto -619 -> 349
    //   971: astore 11
    //   973: aload 11
    //   975: invokevirtual 1357	java/io/IOException:printStackTrace	()V
    //   978: goto -30 -> 948
    //   981: astore 11
    //   983: aload 11
    //   985: invokevirtual 1357	java/io/IOException:printStackTrace	()V
    //   988: goto -649 -> 339
    //   991: astore 10
    //   993: aload 10
    //   995: invokevirtual 1357	java/io/IOException:printStackTrace	()V
    //   998: goto -649 -> 349
    //   1001: astore 14
    //   1003: aconst_null
    //   1004: astore 10
    //   1006: aconst_null
    //   1007: astore 12
    //   1009: aload 10
    //   1011: astore 13
    //   1013: aload 12
    //   1015: astore 11
    //   1017: aload 14
    //   1019: invokevirtual 1357	java/io/IOException:printStackTrace	()V
    //   1022: aload 12
    //   1024: ifnull +8 -> 1032
    //   1027: aload 12
    //   1029: invokevirtual 1840	java/io/BufferedOutputStream:close	()V
    //   1032: aload 10
    //   1034: ifnull -685 -> 349
    //   1037: aload 10
    //   1039: invokevirtual 1841	java/io/FileOutputStream:close	()V
    //   1042: goto -693 -> 349
    //   1045: astore 10
    //   1047: aload 10
    //   1049: invokevirtual 1357	java/io/IOException:printStackTrace	()V
    //   1052: goto -703 -> 349
    //   1055: astore 11
    //   1057: aload 11
    //   1059: invokevirtual 1357	java/io/IOException:printStackTrace	()V
    //   1062: goto -30 -> 1032
    //   1065: astore 14
    //   1067: aconst_null
    //   1068: astore 10
    //   1070: aconst_null
    //   1071: astore 12
    //   1073: aload 10
    //   1075: astore 13
    //   1077: aload 12
    //   1079: astore 11
    //   1081: aload 14
    //   1083: invokevirtual 1918	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1086: aload 12
    //   1088: ifnull +8 -> 1096
    //   1091: aload 12
    //   1093: invokevirtual 1840	java/io/BufferedOutputStream:close	()V
    //   1096: aload 10
    //   1098: ifnull -749 -> 349
    //   1101: aload 10
    //   1103: invokevirtual 1841	java/io/FileOutputStream:close	()V
    //   1106: goto -757 -> 349
    //   1109: astore 10
    //   1111: aload 10
    //   1113: invokevirtual 1357	java/io/IOException:printStackTrace	()V
    //   1116: goto -767 -> 349
    //   1119: astore 11
    //   1121: aload 11
    //   1123: invokevirtual 1357	java/io/IOException:printStackTrace	()V
    //   1126: goto -30 -> 1096
    //   1129: astore 12
    //   1131: aconst_null
    //   1132: astore 10
    //   1134: aconst_null
    //   1135: astore 11
    //   1137: aload 11
    //   1139: ifnull +8 -> 1147
    //   1142: aload 11
    //   1144: invokevirtual 1840	java/io/BufferedOutputStream:close	()V
    //   1147: aload 10
    //   1149: ifnull +8 -> 1157
    //   1152: aload 10
    //   1154: invokevirtual 1841	java/io/FileOutputStream:close	()V
    //   1157: aload 12
    //   1159: athrow
    //   1160: astore 11
    //   1162: aload 11
    //   1164: invokevirtual 1357	java/io/IOException:printStackTrace	()V
    //   1167: goto -20 -> 1147
    //   1170: astore 10
    //   1172: aload 10
    //   1174: invokevirtual 1357	java/io/IOException:printStackTrace	()V
    //   1177: goto -20 -> 1157
    //   1180: aload 11
    //   1182: getfield 1850	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1185: lconst_0
    //   1186: invokevirtual 940	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   1189: goto -737 -> 452
    //   1192: astore 12
    //   1194: aconst_null
    //   1195: astore 11
    //   1197: goto -60 -> 1137
    //   1200: astore 12
    //   1202: aload 13
    //   1204: astore 10
    //   1206: goto -69 -> 1137
    //   1209: astore 12
    //   1211: goto -74 -> 1137
    //   1214: astore 14
    //   1216: aconst_null
    //   1217: astore 12
    //   1219: goto -146 -> 1073
    //   1222: astore 14
    //   1224: goto -151 -> 1073
    //   1227: astore 14
    //   1229: aconst_null
    //   1230: astore 12
    //   1232: goto -223 -> 1009
    //   1235: astore 14
    //   1237: goto -228 -> 1009
    //   1240: astore 12
    //   1242: aconst_null
    //   1243: astore 11
    //   1245: goto -921 -> 324
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1248	0	this	ShortVideoUploadProcessor
    //   288	551	1	i	int
    //   731	123	2	j	int
    //   53	589	3	l1	long
    //   137	792	5	l2	long
    //   909	18	7	l3	long
    //   168	3	9	bool	boolean
    //   67	887	10	localObject1	Object
    //   961	3	10	localIOException1	java.io.IOException
    //   991	3	10	localIOException2	java.io.IOException
    //   1004	34	10	localObject2	Object
    //   1045	3	10	localIOException3	java.io.IOException
    //   1068	34	10	localObject3	Object
    //   1109	3	10	localIOException4	java.io.IOException
    //   1132	21	10	localObject4	Object
    //   1170	3	10	localIOException5	java.io.IOException
    //   1204	1	10	localObject5	Object
    //   1	917	11	localObject6	Object
    //   971	3	11	localIOException6	java.io.IOException
    //   981	3	11	localIOException7	java.io.IOException
    //   1015	1	11	localObject7	Object
    //   1055	3	11	localIOException8	java.io.IOException
    //   1079	1	11	localObject8	Object
    //   1119	3	11	localIOException9	java.io.IOException
    //   1135	8	11	localObject9	Object
    //   1160	21	11	localIOException10	java.io.IOException
    //   1195	49	11	localObject10	Object
    //   201	487	12	localObject11	Object
    //   872	3	12	localIOException11	java.io.IOException
    //   882	62	12	localFileNotFoundException1	java.io.FileNotFoundException
    //   1007	85	12	localObject12	Object
    //   1129	29	12	localObject13	Object
    //   1192	1	12	localObject14	Object
    //   1200	1	12	localObject15	Object
    //   1209	1	12	localObject16	Object
    //   1217	14	12	localObject17	Object
    //   1240	1	12	localFileNotFoundException2	java.io.FileNotFoundException
    //   205	92	13	localObject18	Object
    //   314	7	13	localFileNotFoundException3	java.io.FileNotFoundException
    //   885	318	13	localObject19	Object
    //   221	84	14	arrayOfByte	byte[]
    //   1001	17	14	localIOException12	java.io.IOException
    //   1065	17	14	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   1214	1	14	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1222	1	14	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   1227	1	14	localIOException13	java.io.IOException
    //   1235	1	14	localIOException14	java.io.IOException
    //   132	545	15	str	String
    // Exception table:
    //   from	to	target	type
    //   211	223	314	java/io/FileNotFoundException
    //   231	241	314	java/io/FileNotFoundException
    //   249	256	314	java/io/FileNotFoundException
    //   264	271	314	java/io/FileNotFoundException
    //   279	289	314	java/io/FileNotFoundException
    //   302	311	314	java/io/FileNotFoundException
    //   906	911	314	java/io/FileNotFoundException
    //   919	938	314	java/io/FileNotFoundException
    //   175	181	872	java/io/IOException
    //   134	170	882	java/io/FileNotFoundException
    //   175	181	882	java/io/FileNotFoundException
    //   181	192	882	java/io/FileNotFoundException
    //   874	879	882	java/io/FileNotFoundException
    //   953	958	961	java/io/IOException
    //   943	948	971	java/io/IOException
    //   334	339	981	java/io/IOException
    //   344	349	991	java/io/IOException
    //   134	170	1001	java/io/IOException
    //   181	192	1001	java/io/IOException
    //   874	879	1001	java/io/IOException
    //   1037	1042	1045	java/io/IOException
    //   1027	1032	1055	java/io/IOException
    //   134	170	1065	java/lang/OutOfMemoryError
    //   175	181	1065	java/lang/OutOfMemoryError
    //   181	192	1065	java/lang/OutOfMemoryError
    //   874	879	1065	java/lang/OutOfMemoryError
    //   1101	1106	1109	java/io/IOException
    //   1091	1096	1119	java/io/IOException
    //   134	170	1129	finally
    //   175	181	1129	finally
    //   181	192	1129	finally
    //   874	879	1129	finally
    //   1142	1147	1160	java/io/IOException
    //   1152	1157	1170	java/io/IOException
    //   192	203	1192	finally
    //   211	223	1200	finally
    //   231	241	1200	finally
    //   249	256	1200	finally
    //   264	271	1200	finally
    //   279	289	1200	finally
    //   302	311	1200	finally
    //   906	911	1200	finally
    //   919	938	1200	finally
    //   1017	1022	1200	finally
    //   1081	1086	1200	finally
    //   324	329	1209	finally
    //   192	203	1214	java/lang/OutOfMemoryError
    //   211	223	1222	java/lang/OutOfMemoryError
    //   231	241	1222	java/lang/OutOfMemoryError
    //   249	256	1222	java/lang/OutOfMemoryError
    //   264	271	1222	java/lang/OutOfMemoryError
    //   279	289	1222	java/lang/OutOfMemoryError
    //   302	311	1222	java/lang/OutOfMemoryError
    //   906	911	1222	java/lang/OutOfMemoryError
    //   919	938	1222	java/lang/OutOfMemoryError
    //   192	203	1227	java/io/IOException
    //   211	223	1235	java/io/IOException
    //   231	241	1235	java/io/IOException
    //   249	256	1235	java/io/IOException
    //   264	271	1235	java/io/IOException
    //   279	289	1235	java/io/IOException
    //   302	311	1235	java/io/IOException
    //   906	911	1235	java/io/IOException
    //   919	938	1235	java/io/IOException
    //   192	203	1240	java/io/FileNotFoundException
  }
  
  void s()
  {
    if (bdin.h(BaseApplication.getContext())) {
      return;
    }
    Object localObject = BaseApplication.getContext();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4;; i = 0)
    {
      localObject = ((BaseApplication)localObject).getSharedPreferences("presend_config_sp", i);
      i = ((SharedPreferences)localObject).getInt("key_video_rollback_counts", 0);
      long l1 = ((SharedPreferences)localObject).getLong("key_video_rollback_time", 0L);
      long l2 = NetConnInfoCenter.getServerTime();
      if ((i == 0) || (l1 == 0L)) {
        ((SharedPreferences)localObject).edit().putLong("key_video_rollback_time", l2).commit();
      }
      if (l2 - l1 < 0L) {
        ((SharedPreferences)localObject).edit().putLong("key_video_rollback_time", l2).commit();
      }
      ((SharedPreferences)localObject).edit().putInt("key_video_rollback_counts", i + 1).commit();
      bdif.a(String.valueOf(this.jdField_a_of_type_Bayk.jdField_a_of_type_Long), "rollback", "recordRollbackCounts ：" + String.valueOf(i + 1));
      return;
    }
  }
  
  public void t()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> startTimerForPreUpload");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor$TimeoutRunnable == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor$TimeoutRunnable = new ShortVideoUploadProcessor.TimeoutRunnable(this);
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor$TimeoutRunnable, this.jdField_f_of_type_Long);
  }
  
  public void u()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> stopTimerForPreUpload");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor$TimeoutRunnable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor$TimeoutRunnable.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor$TimeoutRunnable);
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor$TimeoutRunnable = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoUploadProcessor
 * JD-Core Version:    0.7.0.1
 */