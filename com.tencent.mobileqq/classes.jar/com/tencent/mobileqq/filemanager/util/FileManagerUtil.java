package com.tencent.mobileqq.filemanager.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutInfo.Builder;
import android.content.pm.ShortcutManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore.Images.Media;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.dataline.mpfile.MpfileTaskInfo;
import com.dataline.util.file.MediaStoreUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.config.business.qvip.KingCardConfig;
import com.tencent.mobileqq.config.business.qvip.KingCardConfig.Item;
import com.tencent.mobileqq.config.business.qvip.KingCardProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoProcessor;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PrinterItemMsgRecord;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.data.FMConstants;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.recreate.FileModel;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.haoliyou.JumpShareUtils;
import com.tencent.mobileqq.haoliyou.orion.ZhuoXusManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.transfile.TimeoutParam;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.mobileqq.vip.TMSManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.securitysdk.utils.MD5;
import com.tencent.smtt.sdk.QbSdk;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qqdataline.ipc.DatalineRemoteManager;
import cooperation.qqfav.QfavHelper;
import cooperation.weiyun.ResponseHandler;
import cooperation.weiyun.WeiyunSaveTipsFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.apache.http.util.ByteArrayBuffer;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class FileManagerUtil
{
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private static final String jdField_a_of_type_JavaLangString;
  private static ArrayList<Long> jdField_a_of_type_JavaUtilArrayList = null;
  private static HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private static final char[] jdField_a_of_type_ArrayOfChar = { '…' };
  private static ArrayList<Long> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private static HashMap<String, Integer> jdField_b_of_type_JavaUtilHashMap;
  private static HashMap<Integer, String> c = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = new String(jdField_a_of_type_ArrayOfChar);
    jdField_a_of_type_JavaUtilHashMap = null;
    jdField_b_of_type_JavaUtilHashMap = null;
  }
  
  public static int a()
  {
    return QFileUtils.a();
  }
  
  public static int a(int paramInt)
  {
    return a(paramInt, 2);
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 11: 
    case 13: 
    default: 
      return 2130844531;
    case 2: 
      return 2130844532;
    case 0: 
      return 2130844458;
    case 1: 
      return 2130844473;
    case 3: 
      return 2130844435;
    case 4: 
      return 2130844543;
    case 6: 
      return 2130844542;
    case 5: 
      return 2130844419;
    case 7: 
      return 2130844487;
    case 8: 
      return 2130844439;
    case 9: 
      return 2130844485;
    case 10: 
      return 2130844520;
    case 12: 
      return 2130844494;
    case 14: 
      return 2130844417;
    case 15: 
      return 2130844438;
    case 16: 
      return 2130844449;
    case 17: 
      return 2130844459;
    case 18: 
      return 2130844482;
    case 19: 
      return 2130844483;
    case 20: 
      return 2130844484;
    }
    return 2130844504;
  }
  
  public static int a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isMultiMsg)
    {
      paramChatMessage = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileName");
      if (!TextUtils.isEmpty(paramChatMessage))
      {
        int i = a(paramChatMessage);
        if ((i == 2) || (i == 0)) {
          return i;
        }
      }
    }
    return -1;
  }
  
  public static int a(FileManagerEntity paramFileManagerEntity)
  {
    int k = 0;
    if ((-1 == paramFileManagerEntity.status) || (1 == paramFileManagerEntity.status)) {}
    int j;
    for (int i = 1;; i = 0)
    {
      j = k;
      if (paramFileManagerEntity.bSend)
      {
        j = k;
        if (8 != paramFileManagerEntity.nOpType)
        {
          j = k;
          if (5 != paramFileManagerEntity.nOpType)
          {
            j = k;
            if (1 != paramFileManagerEntity.nOpType) {
              j = 1;
            }
          }
        }
      }
      if (3 != paramFileManagerEntity.getCloudType()) {
        break label135;
      }
      if ((j != 0) && ((j == 0) || (i == 0))) {
        break label133;
      }
      if ((TextUtils.isEmpty(paramFileManagerEntity.Uuid)) || (paramFileManagerEntity.peerType == 6000)) {
        break;
      }
      return 1;
    }
    if (!TextUtils.isEmpty(paramFileManagerEntity.WeiYunFileId)) {
      return 2;
    }
    if (!TextUtils.isEmpty(paramFileManagerEntity.strTroopFilePath)) {
      return 4;
    }
    label133:
    return 3;
    label135:
    if (((2 == paramFileManagerEntity.getCloudType()) || (1 == paramFileManagerEntity.getCloudType()) || ((4 == paramFileManagerEntity.getCloudType()) && (paramFileManagerEntity.nOpType != 24))) && (j != 0) && (i == 0) && (!TextUtils.isEmpty(paramFileManagerEntity.getFilePath()))) {
      return 3;
    }
    return paramFileManagerEntity.getCloudType();
  }
  
  /* Error */
  public static int a(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 135	com/tencent/mobileqq/filemanager/util/FileUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   7: astore_2
    //   8: aload_2
    //   9: ifnull +12 -> 21
    //   12: aload_2
    //   13: invokevirtual 138	java/lang/String:length	()I
    //   16: istore_1
    //   17: iload_1
    //   18: ifne +10 -> 28
    //   21: iconst_m1
    //   22: istore_1
    //   23: ldc 2
    //   25: monitorexit
    //   26: iload_1
    //   27: ireturn
    //   28: aload_2
    //   29: invokevirtual 141	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   32: astore_2
    //   33: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   36: ifnonnull +1199 -> 1235
    //   39: new 42	java/util/HashMap
    //   42: dup
    //   43: invokespecial 43	java/util/HashMap:<init>	()V
    //   46: putstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   49: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   52: ldc 143
    //   54: iconst_1
    //   55: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   58: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   61: pop
    //   62: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   65: ldc 155
    //   67: iconst_1
    //   68: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   71: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   74: pop
    //   75: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   78: ldc 157
    //   80: iconst_1
    //   81: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   84: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   87: pop
    //   88: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   91: ldc 159
    //   93: iconst_1
    //   94: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   97: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   100: pop
    //   101: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   104: ldc 161
    //   106: iconst_1
    //   107: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   110: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   113: pop
    //   114: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   117: ldc 163
    //   119: iconst_1
    //   120: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   123: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   126: pop
    //   127: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   130: ldc 165
    //   132: invokevirtual 169	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   135: pop
    //   136: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   139: ldc 171
    //   141: invokevirtual 169	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   144: pop
    //   145: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   148: ldc 173
    //   150: invokevirtual 169	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   153: pop
    //   154: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   157: ldc 175
    //   159: invokevirtual 169	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   162: pop
    //   163: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   166: ldc 177
    //   168: iconst_0
    //   169: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   172: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   175: pop
    //   176: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   179: ldc 179
    //   181: iconst_0
    //   182: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   185: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   188: pop
    //   189: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   192: ldc 181
    //   194: iconst_0
    //   195: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   198: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   201: pop
    //   202: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   205: ldc 183
    //   207: iconst_0
    //   208: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   211: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   214: pop
    //   215: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   218: ldc 185
    //   220: iconst_0
    //   221: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   224: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   227: pop
    //   228: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   231: ldc 173
    //   233: iconst_0
    //   234: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   237: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   240: pop
    //   241: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   244: ldc 187
    //   246: bipush 12
    //   248: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   251: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   254: pop
    //   255: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   258: ldc 189
    //   260: iconst_2
    //   261: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   264: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   267: pop
    //   268: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   271: ldc 191
    //   273: iconst_2
    //   274: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   277: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   280: pop
    //   281: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   284: ldc 193
    //   286: iconst_2
    //   287: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   290: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   293: pop
    //   294: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   297: ldc 195
    //   299: iconst_2
    //   300: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   303: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   306: pop
    //   307: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   310: ldc 197
    //   312: iconst_2
    //   313: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   316: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   319: pop
    //   320: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   323: ldc 199
    //   325: iconst_2
    //   326: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   329: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   332: pop
    //   333: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   336: ldc 201
    //   338: iconst_2
    //   339: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   342: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   345: pop
    //   346: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   349: ldc 203
    //   351: iconst_2
    //   352: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   355: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   358: pop
    //   359: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   362: ldc 205
    //   364: iconst_2
    //   365: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   368: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   371: pop
    //   372: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   375: ldc 207
    //   377: iconst_2
    //   378: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   381: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   384: pop
    //   385: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   388: ldc 209
    //   390: iconst_2
    //   391: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   394: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   397: pop
    //   398: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   401: ldc 211
    //   403: iconst_2
    //   404: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   407: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   410: pop
    //   411: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   414: ldc 165
    //   416: iconst_2
    //   417: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   420: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   423: pop
    //   424: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   427: ldc 213
    //   429: iconst_2
    //   430: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   433: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   436: pop
    //   437: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   440: ldc 215
    //   442: iconst_2
    //   443: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   446: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   449: pop
    //   450: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   453: ldc 217
    //   455: iconst_2
    //   456: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   459: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   462: pop
    //   463: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   466: ldc 219
    //   468: iconst_2
    //   469: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   472: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   475: pop
    //   476: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   479: ldc 221
    //   481: iconst_2
    //   482: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   485: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   488: pop
    //   489: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   492: ldc 223
    //   494: iconst_2
    //   495: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   498: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   501: pop
    //   502: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   505: ldc 225
    //   507: iconst_2
    //   508: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   511: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   514: pop
    //   515: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   518: ldc 227
    //   520: iconst_2
    //   521: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   524: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   527: pop
    //   528: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   531: ldc 229
    //   533: iconst_2
    //   534: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   537: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   540: pop
    //   541: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   544: ldc 231
    //   546: iconst_3
    //   547: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   550: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   553: pop
    //   554: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   557: ldc 233
    //   559: iconst_3
    //   560: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   563: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   566: pop
    //   567: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   570: ldc 235
    //   572: iconst_3
    //   573: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   576: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   579: pop
    //   580: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   583: ldc 237
    //   585: iconst_3
    //   586: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   589: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   592: pop
    //   593: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   596: ldc 239
    //   598: iconst_4
    //   599: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   602: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   605: pop
    //   606: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   609: ldc 241
    //   611: iconst_4
    //   612: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   615: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   618: pop
    //   619: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   622: ldc 243
    //   624: iconst_4
    //   625: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   628: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   631: pop
    //   632: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   635: ldc 245
    //   637: iconst_4
    //   638: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   641: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   644: pop
    //   645: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   648: ldc 247
    //   650: iconst_4
    //   651: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   654: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   657: pop
    //   658: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   661: ldc 249
    //   663: iconst_4
    //   664: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   667: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   670: pop
    //   671: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   674: ldc 251
    //   676: iconst_5
    //   677: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   680: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   683: pop
    //   684: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   687: ldc 253
    //   689: iconst_5
    //   690: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   693: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   696: pop
    //   697: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   700: ldc 255
    //   702: bipush 6
    //   704: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   707: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   710: pop
    //   711: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   714: ldc_w 257
    //   717: bipush 6
    //   719: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   722: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   725: pop
    //   726: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   729: ldc_w 259
    //   732: bipush 6
    //   734: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   737: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   740: pop
    //   741: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   744: ldc_w 261
    //   747: bipush 6
    //   749: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   752: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   755: pop
    //   756: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   759: ldc_w 263
    //   762: bipush 6
    //   764: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   767: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   770: pop
    //   771: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   774: ldc_w 265
    //   777: bipush 7
    //   779: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   782: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   785: pop
    //   786: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   789: ldc_w 267
    //   792: bipush 7
    //   794: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   797: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   800: pop
    //   801: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   804: ldc_w 269
    //   807: bipush 7
    //   809: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   812: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   815: pop
    //   816: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   819: ldc_w 271
    //   822: bipush 7
    //   824: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   827: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   830: pop
    //   831: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   834: ldc_w 273
    //   837: bipush 7
    //   839: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   842: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   845: pop
    //   846: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   849: ldc_w 275
    //   852: bipush 8
    //   854: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   857: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   860: pop
    //   861: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   864: ldc_w 277
    //   867: bipush 8
    //   869: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   872: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   875: pop
    //   876: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   879: ldc_w 279
    //   882: bipush 8
    //   884: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   887: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   890: pop
    //   891: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   894: ldc_w 281
    //   897: bipush 9
    //   899: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   902: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   905: pop
    //   906: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   909: ldc_w 283
    //   912: bipush 10
    //   914: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   917: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   920: pop
    //   921: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   924: ldc_w 285
    //   927: bipush 10
    //   929: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   932: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   935: pop
    //   936: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   939: ldc_w 287
    //   942: bipush 10
    //   944: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   947: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   950: pop
    //   951: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   954: ldc_w 289
    //   957: bipush 10
    //   959: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   962: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   965: pop
    //   966: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   969: ldc_w 291
    //   972: bipush 10
    //   974: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   977: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   980: pop
    //   981: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   984: ldc_w 293
    //   987: bipush 10
    //   989: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   992: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   995: pop
    //   996: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   999: ldc_w 295
    //   1002: bipush 10
    //   1004: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1007: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1010: pop
    //   1011: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1014: ldc_w 297
    //   1017: bipush 10
    //   1019: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1022: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1025: pop
    //   1026: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1029: ldc_w 299
    //   1032: bipush 10
    //   1034: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1037: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1040: pop
    //   1041: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1044: ldc_w 301
    //   1047: bipush 10
    //   1049: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1052: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1055: pop
    //   1056: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1059: ldc_w 303
    //   1062: bipush 10
    //   1064: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1067: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1070: pop
    //   1071: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1074: ldc_w 305
    //   1077: bipush 10
    //   1079: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1082: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1085: pop
    //   1086: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1089: ldc_w 259
    //   1092: bipush 10
    //   1094: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1097: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1100: pop
    //   1101: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1104: ldc_w 307
    //   1107: bipush 10
    //   1109: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1112: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1115: pop
    //   1116: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1119: ldc_w 309
    //   1122: bipush 14
    //   1124: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1127: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1130: pop
    //   1131: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1134: ldc_w 311
    //   1137: bipush 15
    //   1139: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1142: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1145: pop
    //   1146: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1149: ldc_w 313
    //   1152: bipush 16
    //   1154: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1157: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1160: pop
    //   1161: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1164: ldc_w 315
    //   1167: bipush 17
    //   1169: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1172: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1175: pop
    //   1176: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1179: ldc_w 317
    //   1182: bipush 18
    //   1184: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1187: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1190: pop
    //   1191: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1194: ldc_w 261
    //   1197: bipush 19
    //   1199: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1202: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1205: pop
    //   1206: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1209: ldc 237
    //   1211: bipush 20
    //   1213: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1216: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1219: pop
    //   1220: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1223: ldc_w 319
    //   1226: bipush 21
    //   1228: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1231: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1234: pop
    //   1235: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1238: aload_2
    //   1239: invokevirtual 141	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1242: invokevirtual 323	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1245: ifeq +23 -> 1268
    //   1248: getstatic 32	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1251: aload_2
    //   1252: invokevirtual 141	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1255: invokevirtual 326	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1258: checkcast 145	java/lang/Integer
    //   1261: invokevirtual 329	java/lang/Integer:intValue	()I
    //   1264: istore_1
    //   1265: goto -1242 -> 23
    //   1268: invokestatic 335	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1271: ifeq +36 -> 1307
    //   1274: ldc_w 337
    //   1277: iconst_2
    //   1278: new 339	java/lang/StringBuilder
    //   1281: dup
    //   1282: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   1285: ldc_w 342
    //   1288: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1291: aload_0
    //   1292: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1295: ldc_w 348
    //   1298: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1301: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1304: invokestatic 355	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1307: bipush 11
    //   1309: istore_1
    //   1310: goto -1287 -> 23
    //   1313: astore_0
    //   1314: ldc 2
    //   1316: monitorexit
    //   1317: aload_0
    //   1318: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1319	0	paramString	String
    //   16	1294	1	i	int
    //   7	1245	2	str	String
    // Exception table:
    //   from	to	target	type
    //   3	8	1313	finally
    //   12	17	1313	finally
    //   28	1235	1313	finally
    //   1235	1265	1313	finally
    //   1268	1307	1313	finally
  }
  
  public static int a(List<FileInfo> paramList, long paramLong)
  {
    int i = 0;
    int j = paramList.size() - 1;
    int k = i;
    if (i <= j)
    {
      k = i + j >>> 1;
      FileInfo localFileInfo = (FileInfo)paramList.get(k);
      if (localFileInfo.b() > paramLong)
      {
        k += 1;
        i = j;
        j = k;
      }
      for (;;)
      {
        k = j;
        j = i;
        i = k;
        break;
        if (localFileInfo.b() >= paramLong) {
          break label103;
        }
        k -= 1;
        j = i;
        i = k;
      }
    }
    label103:
    return k;
  }
  
  public static long a()
  {
    int i = MobileQQService.seq;
    MobileQQService.seq = i + 1;
    return i;
  }
  
  public static long a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1L;
    case 1004: 
      return 105L;
    case 1000: 
      return 104L;
    case 1001: 
      return 100L;
    case 10002: 
      return 127L;
    case 1006: 
      return 102L;
    case 1010: 
      return 109L;
    }
    return 124L;
  }
  
  public static long a(long paramLong)
  {
    return 2863315899L << 31 | paramLong;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          return 0L;
        }
        paramQQAppInterface = g(paramString);
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          break label163;
        }
        l = 20971520L;
        if ("txt".equals(paramQQAppInterface.toLowerCase())) {
          l = 102400L;
        }
        paramString = TencentDocImportFileInfoProcessor.a().b();
        if (TextUtils.isEmpty(paramString)) {
          return l;
        }
        paramString = paramString.split("#");
        if (paramString.length != 0) {
          break label165;
        }
        return l;
      }
      catch (Exception paramQQAppInterface)
      {
        long l;
        String[] arrayOfString;
        QLog.e("FileManagerUtil<FileAssistant>", 1, " get docs import file max size exception =" + paramQQAppInterface.toString());
      }
      if (i < paramString.length)
      {
        arrayOfString = paramString[i].split("_");
        if ((arrayOfString[0].contains(paramQQAppInterface)) || (arrayOfString[0].contains(paramQQAppInterface.toLowerCase())))
        {
          l = Long.parseLong(arrayOfString[1]);
          return l;
        }
        i += 1;
      }
      else
      {
        label163:
        return 0L;
        label165:
        i = 0;
      }
    }
  }
  
  public static long a(String paramString)
  {
    if (paramString == null)
    {
      QLog.e("FileManagerUtil<FileAssistant>", 1, "getFileSizes: filePath is null");
      return 0L;
    }
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      QLog.w("FileManagerUtil<FileAssistant>", 1, "file " + paramString + " is not exists");
      return 0L;
    }
    long l = localFile.length();
    if (0L == l) {
      QLog.w("FileManagerUtil<FileAssistant>", 1, "file " + paramString + " len is 0");
    }
    return l;
  }
  
  public static Context a()
  {
    return BaseApplicationImpl.getContext();
  }
  
  public static Context a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getBaseContext();
  }
  
  public static Intent a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    Object localObject;
    if (paramMessageRecord == null) {
      localObject = null;
    }
    Intent localIntent;
    Bundle localBundle;
    do
    {
      do
      {
        do
        {
          return localObject;
          localIntent = new Intent();
          localBundle = new Bundle();
          localBundle.putInt("forward_type", 0);
          localBundle.putBoolean("not_forward", true);
          if ((paramMessageRecord instanceof MessageForFile))
          {
            paramMessageRecord = (MessageForFile)paramMessageRecord;
            localBundle.putParcelable("fileinfo", a(a(paramQQAppInterface, paramMessageRecord), paramMessageRecord));
            localIntent.putExtras(localBundle);
            return localIntent;
          }
          if ((paramMessageRecord instanceof MessageForTroopFile))
          {
            paramMessageRecord = (MessageForTroopFile)paramMessageRecord;
            paramQQAppInterface = TroopFileUtils.a(paramQQAppInterface, paramMessageRecord);
            localObject = a(paramQQAppInterface);
            ((FileManagerEntity)localObject).status = 2;
            ((FileManagerEntity)localObject).nOpType = 24;
            ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
            localForwardFileInfo.b(((FileManagerEntity)localObject).nSessionId);
            localForwardFileInfo.b(10006);
            if (!TextUtils.isEmpty(((FileManagerEntity)localObject).getFilePath())) {
              localForwardFileInfo.a(paramQQAppInterface.jdField_a_of_type_JavaLangString);
            }
            localForwardFileInfo.d(paramQQAppInterface.g);
            localForwardFileInfo.d(paramQQAppInterface.jdField_c_of_type_Long);
            localForwardFileInfo.a(Long.parseLong(paramMessageRecord.frienduin));
            if (paramQQAppInterface.jdField_a_of_type_JavaUtilUUID != null) {
              localForwardFileInfo.e(paramQQAppInterface.jdField_a_of_type_JavaUtilUUID.toString());
            }
            localForwardFileInfo.d(1);
            localForwardFileInfo.a(1);
            localBundle.putParcelable("fileinfo", localForwardFileInfo);
            localIntent.putExtras(localBundle);
            localIntent.putExtra("forward_from_troop_file", true);
            return localIntent;
          }
          localObject = localIntent;
        } while (!(paramMessageRecord instanceof MessageForDLFile));
        paramMessageRecord = (MessageForDLFile)paramMessageRecord;
        int i = paramMessageRecord.deviceType;
        long l = paramMessageRecord.associatedId;
        paramQQAppInterface = paramQQAppInterface.getMessageFacade().a(i).a(l);
        localObject = localIntent;
      } while (paramQQAppInterface == null);
      localObject = localIntent;
    } while (!com.tencent.mobileqq.utils.FileUtils.b(paramQQAppInterface.path));
    try
    {
      localObject = a(new FileInfo(paramQQAppInterface.path));
      ((FileManagerEntity)localObject).uniseq = paramMessageRecord.uniseq;
      ((FileManagerEntity)localObject).strMiddleThumPath = paramQQAppInterface.thumbPath;
      ((FileManagerEntity)localObject).strLargeThumPath = paramQQAppInterface.thumbPath;
      paramQQAppInterface = new ForwardFileInfo();
      paramQQAppInterface.b(10000);
      paramQQAppInterface.d(((FileManagerEntity)localObject).getCloudType());
      paramQQAppInterface.b(((FileManagerEntity)localObject).nSessionId);
      paramQQAppInterface.d(((FileManagerEntity)localObject).fileName);
      paramQQAppInterface.c(((FileManagerEntity)localObject).uniseq);
      paramQQAppInterface.d(((FileManagerEntity)localObject).fileSize);
      paramQQAppInterface.a(((FileManagerEntity)localObject).getFilePath());
      paramQQAppInterface.f(((FileManagerEntity)localObject).strLargeThumPath);
      localBundle.putParcelable("fileinfo", paramQQAppInterface);
      localIntent.putExtras(localBundle);
      return localIntent;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
    return localIntent;
  }
  
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, int paramInt)
  {
    if (paramBitmap == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        float f = paramContext.getResources().getDisplayMetrics().density;
        int i2 = AIOUtils.a(paramInt, paramContext.getResources());
        j = (int)(paramBitmap.getWidth() * f);
        k = (int)(f * paramBitmap.getHeight());
        paramInt = paramBitmap.getWidth();
        i = paramBitmap.getHeight();
        if (paramInt > i)
        {
          j = (paramInt - i) / 2;
          m = k;
          paramInt = i;
          i1 = 0;
          n = k;
          k = j;
          j = i1;
          paramContext = Bitmap.createBitmap(n, m, Bitmap.Config.ARGB_8888);
          Canvas localCanvas = new Canvas(paramContext);
          Paint localPaint = new Paint();
          Rect localRect1 = new Rect(k, j, i + k, paramInt + j);
          Rect localRect2 = new Rect(0, 0, n, m);
          RectF localRectF = new RectF(localRect2);
          localPaint.setAntiAlias(true);
          localPaint.setDither(true);
          localPaint.setFilterBitmap(true);
          localCanvas.drawARGB(0, 0, 0, 0);
          localPaint.setColor(-12434878);
          localCanvas.drawRoundRect(localRectF, i2, i2, localPaint);
          localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
          localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
          return paramContext;
        }
        if (i > paramInt)
        {
          k = (i - paramInt) / 2;
          m = j;
          n = j;
          i1 = 0;
          i = paramInt;
          j = k;
          k = i1;
          continue;
        }
        int m = k;
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        return null;
      }
      int n = j;
      int i1 = 0;
      int k = 0;
      int j = paramInt;
      paramInt = i;
      int i = j;
      j = i1;
    }
  }
  
  public static SpannableString a(String paramString1, String paramString2, FileManagerUtil.TipsClickedInterface paramTipsClickedInterface)
  {
    int i = paramString1.indexOf(paramString2);
    int j = paramString2.length() + i;
    paramString1 = new SpannableString(paramString1);
    paramString2 = new FileManagerUtil.10(paramTipsClickedInterface);
    try
    {
      paramString1.setSpan(new ForegroundColorSpan(-12541697), i, j, 33);
      paramString1.setSpan(paramString2, i, j, 33);
      return paramString1;
    }
    catch (Exception paramString2) {}
    return paramString1;
  }
  
  public static QQAppInterface a()
  {
    return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  }
  
  public static ChatMessage a(ChatMessage paramChatMessage)
  {
    Object localObject2 = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileType");
    Object localObject1 = a();
    if ((a(paramChatMessage)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
    {
      int j = Integer.parseInt((String)localObject2);
      if (j == 3)
      {
        localObject1 = (ChatMessage)MessageRecordFactory.a(-2017);
        ((ChatMessage)localObject1).isMultiMsg = paramChatMessage.isMultiMsg;
        ((ChatMessage)localObject1).isReplySource = paramChatMessage.isReplySource;
        ((ChatMessage)localObject1).selfuin = paramChatMessage.selfuin;
        ((ChatMessage)localObject1).shmsgseq = paramChatMessage.shmsgseq;
        ((ChatMessage)localObject1).frienduin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardReceiverUin");
        ((ChatMessage)localObject1).senderuin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSenderUin");
        a(paramChatMessage, (MessageForTroopFile)localObject1);
        ((MessageForTroopFile)localObject1).istroop = 1;
      }
      for (;;)
      {
        paramChatMessage = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileStatus");
        if (!TextUtils.isEmpty(paramChatMessage)) {
          ((ChatMessage)localObject1).saveExtInfoToExtStr("_m_ForwardFileStatus", paramChatMessage);
        }
        return localObject1;
        if ((j == 1) || (j == 2))
        {
          if (j == 1) {}
          for (int i = -2005;; i = -2014)
          {
            localObject2 = (ChatMessage)MessageRecordFactory.a(i);
            ((ChatMessage)localObject2).isMultiMsg = paramChatMessage.isMultiMsg;
            ((ChatMessage)localObject2).isReplySource = paramChatMessage.isReplySource;
            ((ChatMessage)localObject2).selfuin = paramChatMessage.selfuin;
            ((ChatMessage)localObject2).shmsgseq = paramChatMessage.shmsgseq;
            ((ChatMessage)localObject2).frienduin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardReceiverUin");
            ((ChatMessage)localObject2).senderuin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSenderUin");
            a(paramChatMessage, (MessageForFile)localObject2);
            if (localObject1 == null) {
              break label265;
            }
            a((QQAppInterface)localObject1, (ChatMessage)localObject2, paramChatMessage);
            localObject1 = localObject2;
            break;
          }
          label265:
          if (j == 1)
          {
            ((ChatMessage)localObject2).istroop = 0;
            ((ChatMessage)localObject2).frienduin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSenderUin");
            localObject1 = localObject2;
          }
          else
          {
            localObject1 = localObject2;
            if (j == 2)
            {
              ((ChatMessage)localObject2).istroop = 3000;
              localObject1 = localObject2;
            }
          }
        }
        else
        {
          localObject1 = paramChatMessage;
        }
      }
    }
    return paramChatMessage;
  }
  
  public static FileManagerEngine a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getFileManagerEngine();
  }
  
  public static FileManagerEntity a()
  {
    Object localObject3 = FMDataCache.b();
    Object localObject2 = FMDataCache.a();
    Object localObject1 = FMDataCache.d();
    if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
    {
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject3).next();
        if (localFileManagerEntity.nFileType == 0) {
          return localFileManagerEntity;
        }
      }
    }
    if ((localObject2 != null) && (((Set)localObject2).size() > 0))
    {
      localObject2 = ((Set)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (FileInfo)((Iterator)localObject2).next();
        if (((FileInfo)localObject3).a() == 0) {
          return a((FileInfo)localObject3);
        }
      }
    }
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WeiYunFileInfo)((Iterator)localObject1).next();
        if (a(((WeiYunFileInfo)localObject2).jdField_c_of_type_JavaLangString) == 0) {
          return a((WeiYunFileInfo)localObject2);
        }
      }
    }
    return null;
  }
  
  public static FileManagerEntity a(Bundle paramBundle)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.setCloudType(2);
    localFileManagerEntity.nOpType = 50;
    localFileManagerEntity.bSend = false;
    localFileManagerEntity.WeiYunFileId = ((String)paramBundle.get("file_id"));
    localFileManagerEntity.fileName = ((String)paramBundle.get("filename"));
    localFileManagerEntity.WeiYunDirKey = ((String)paramBundle.get("pdir_key"));
    return localFileManagerEntity;
  }
  
  public static FileManagerEntity a(MpfileTaskInfo paramMpfileTaskInfo, long paramLong)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.setCloudType(7);
    localFileManagerEntity.bSend = false;
    Object localObject;
    if (paramMpfileTaskInfo.g == MpfileTaskInfo.jdField_a_of_type_Int)
    {
      localFileManagerEntity.status = -1;
      localFileManagerEntity.fileName = paramMpfileTaskInfo.jdField_d_of_type_JavaLangString;
      localFileManagerEntity.setFilePath(paramMpfileTaskInfo.jdField_e_of_type_JavaLangString);
      localFileManagerEntity.fileSize = paramMpfileTaskInfo.jdField_b_of_type_Long;
      localFileManagerEntity.nFileType = a(paramMpfileTaskInfo.jdField_d_of_type_JavaLangString);
      if (localFileManagerEntity.nFileType == 0)
      {
        localObject = (DataLineHandler)a().getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        if (((DataLineHandler)localObject).a().a() != null) {
          break label343;
        }
        if (QLog.isColorLevel()) {
          QLog.e("##########", 2, "插件的service没有启动");
        }
      }
    }
    for (;;)
    {
      localFileManagerEntity.fProgress = ((float)paramMpfileTaskInfo.jdField_c_of_type_Long / (float)paramMpfileTaskInfo.jdField_b_of_type_Long);
      localFileManagerEntity.uniseq = paramMpfileTaskInfo.jdField_d_of_type_Long;
      localFileManagerEntity.strDataLineMPFileID = paramMpfileTaskInfo.jdField_c_of_type_JavaLangString;
      localFileManagerEntity.peerDin = paramLong;
      localObject = a();
      QLog.i("FileManagerUtil<FileAssistant>", 1, "=_= create new Entity[" + localFileManagerEntity.nSessionId + "] fileName[" + paramMpfileTaskInfo.jdField_d_of_type_JavaLangString + "] by mpfile size(" + localFileManagerEntity.imgHeight + ":" + localFileManagerEntity.imgWidth + ")");
      ((QQAppInterface)localObject).getFileManagerDataCenter().d(localFileManagerEntity);
      return localFileManagerEntity;
      if (paramMpfileTaskInfo.g == MpfileTaskInfo.jdField_c_of_type_Int)
      {
        localFileManagerEntity.status = 1;
        localFileManagerEntity.fProgress = 1.0F;
        break;
      }
      if ((paramMpfileTaskInfo.g == MpfileTaskInfo.jdField_d_of_type_Int) || (paramMpfileTaskInfo.g == MpfileTaskInfo.jdField_e_of_type_Int))
      {
        localFileManagerEntity.status = 3;
        localFileManagerEntity.fProgress = ((float)paramMpfileTaskInfo.jdField_c_of_type_Long / (float)paramMpfileTaskInfo.jdField_b_of_type_Long);
        break;
      }
      localFileManagerEntity.status = 2;
      localFileManagerEntity.fProgress = ((float)paramMpfileTaskInfo.jdField_c_of_type_Long / (float)paramMpfileTaskInfo.jdField_b_of_type_Long);
      break;
      label343:
      localFileManagerEntity.strLargeThumPath = String.format("%s/%s", new Object[] { ((DataLineHandler)localObject).a().a(), paramMpfileTaskInfo.jdField_d_of_type_JavaLangString });
    }
  }
  
  public static FileManagerEntity a(QQAppInterface paramQQAppInterface, long paramLong, String paramString, int paramInt, ChatMessage paramChatMessage)
  {
    FileManagerEntity localFileManagerEntity = paramQQAppInterface.getFileManagerDataCenter().a(paramLong, paramString, paramInt);
    if (localFileManagerEntity == null) {}
    paramString = localFileManagerEntity;
    if (localFileManagerEntity == null) {
      paramString = a(paramQQAppInterface, paramChatMessage);
    }
    return paramString;
  }
  
  public static FileManagerEntity a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    boolean bool = false;
    if ((paramChatMessage == null) || (!a(paramChatMessage))) {
      return null;
    }
    Object localObject = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileType");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    for (int i = Integer.parseInt((String)localObject);; i = -1)
    {
      if ((i != 1) && (i != 2)) {
        return null;
      }
      localObject = new FileManagerEntity();
      ((FileManagerEntity)localObject).nSessionId = a().longValue();
      ((FileManagerEntity)localObject).uniseq = paramChatMessage.uniseq;
      ((FileManagerEntity)localObject).selfUin = paramQQAppInterface.getAccount();
      ((FileManagerEntity)localObject).isReaded = false;
      ((FileManagerEntity)localObject).peerUin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardReceiverUin");
      a(paramQQAppInterface, (FileManagerEntity)localObject, paramChatMessage);
      ((FileManagerEntity)localObject).peerNick = a(paramQQAppInterface, ((FileManagerEntity)localObject).peerUin, null, ((FileManagerEntity)localObject).peerType);
      ((FileManagerEntity)localObject).Uuid = paramChatMessage.getExtInfoFromExtStr("_m_ForwardUuid");
      ((FileManagerEntity)localObject).fileIdCrc = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileIdCrc");
      ((FileManagerEntity)localObject).fileName = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileName");
      String str = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSize");
      if (!TextUtils.isEmpty(str)) {
        ((FileManagerEntity)localObject).fileSize = Long.parseLong(str);
      }
      str = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSenderUin");
      if (!TextUtils.isEmpty(((FileManagerEntity)localObject).selfUin))
      {
        if (!((FileManagerEntity)localObject).selfUin.equals(str)) {
          break label404;
        }
        ((FileManagerEntity)localObject).nOpType = 0;
      }
      for (;;)
      {
        ((FileManagerEntity)localObject).status = -1;
        str = paramChatMessage.getExtInfoFromExtStr("_m_ForwardReceiverUin");
        if (!TextUtils.isEmpty(((FileManagerEntity)localObject).selfUin))
        {
          if (!((FileManagerEntity)localObject).selfUin.equals(str)) {
            bool = true;
          }
          ((FileManagerEntity)localObject).bSend = bool;
        }
        str = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFilePath");
        if (com.tencent.mobileqq.utils.FileUtils.b(str))
        {
          ((FileManagerEntity)localObject).setFilePath(str);
          ((FileManagerEntity)localObject).setCloudType(3);
          ((FileManagerEntity)localObject).strFileMd5 = paramChatMessage.getExtInfoFromExtStr("_m_ForwardMd5");
          ((FileManagerEntity)localObject).strFileSHA = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSha");
          str = paramChatMessage.getExtInfoFromExtStr("_m_ForwardImgWidth");
        }
        try
        {
          ((FileManagerEntity)localObject).imgWidth = Integer.parseInt(str);
          label354:
          str = paramChatMessage.getExtInfoFromExtStr("_m_ForwardImgHeight");
          try
          {
            ((FileManagerEntity)localObject).imgHeight = Integer.parseInt(str);
            label373:
            a(paramQQAppInterface, (FileManagerEntity)localObject);
            b(paramQQAppInterface, (FileManagerEntity)localObject);
            if (b(paramChatMessage)) {
              paramQQAppInterface.getFileManagerDataCenter().a((FileManagerEntity)localObject);
            }
            return localObject;
            label404:
            ((FileManagerEntity)localObject).nOpType = 1;
            continue;
            ((FileManagerEntity)localObject).setCloudType(1);
          }
          catch (NumberFormatException localNumberFormatException1)
          {
            break label373;
          }
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          break label354;
        }
      }
    }
  }
  
  public static FileManagerEntity a(QQAppInterface paramQQAppInterface, MessageForFile paramMessageForFile)
  {
    FileManagerEntity localFileManagerEntity = paramQQAppInterface.getFileManagerDataCenter().a(paramMessageForFile.uniseq, paramMessageForFile.frienduin, paramMessageForFile.istroop);
    Object localObject = localFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      localFileManagerEntity = paramQQAppInterface.getFileManagerDataCenter().b(paramMessageForFile.uniseq, paramMessageForFile.frienduin, paramMessageForFile.istroop);
      if (QLog.isColorLevel()) {
        QLog.d("FileManager", 2, "QueryFileEntityByUniseq return null, create new! sessionId[" + localFileManagerEntity.nSessionId + "], messageId[" + localFileManagerEntity.uniseq + "], peerUin[" + e(localFileManagerEntity.peerUin) + "], peerType[" + localFileManagerEntity.peerType + "]");
      }
      localObject = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      TransFileInfo localTransFileInfo = (TransFileInfo)((EntityManager)localObject).find(TransFileInfo.class, new String[] { String.valueOf(paramMessageForFile.time), String.valueOf(paramMessageForFile.msgseq), paramQQAppInterface.getCurrentAccountUin(), paramMessageForFile.frienduin });
      ((EntityManager)localObject).close();
      localFileManagerEntity.status = b(paramMessageForFile.status);
      if (!paramMessageForFile.isSend()) {
        break label433;
      }
      localFileManagerEntity.setCloudType(3);
      if (!TextUtils.isEmpty(paramMessageForFile.url)) {
        break label421;
      }
      localFileManagerEntity.status = 16;
      if (localTransFileInfo != null)
      {
        if (localTransFileInfo.uuid == null) {
          break label483;
        }
        localObject = new String(localTransFileInfo.uuid);
        label268:
        localFileManagerEntity.Uuid = ((String)localObject);
      }
      localFileManagerEntity.fileName = paramMessageForFile.fileName;
      localFileManagerEntity.fileSize = paramMessageForFile.fileSize;
      if (!paramMessageForFile.isSend()) {
        break label490;
      }
    }
    label421:
    label433:
    label483:
    label490:
    for (int i = 0;; i = 1)
    {
      localFileManagerEntity.nOpType = i;
      localFileManagerEntity.peerUin = paramMessageForFile.frienduin;
      localFileManagerEntity.peerType = paramMessageForFile.istroop;
      localFileManagerEntity.peerNick = a(paramQQAppInterface, String.valueOf(paramMessageForFile.frienduin), null, paramMessageForFile.istroop);
      localFileManagerEntity.srvTime = (paramMessageForFile.time * 1000L);
      localFileManagerEntity.strServerPath = paramMessageForFile.urlAtServer;
      localFileManagerEntity.fProgress = ((float)paramQQAppInterface.getFileManagerRSCenter().a(paramMessageForFile.frienduin, paramMessageForFile.fileSize, paramMessageForFile.uniseq, paramMessageForFile.istroop) / 100.0F);
      paramQQAppInterface.getFileManagerDataCenter().d(localFileManagerEntity);
      localFileManagerEntity.bDelInFM = true;
      localObject = localFileManagerEntity;
      return localObject;
      localFileManagerEntity.setFilePath(paramMessageForFile.url);
      break;
      localFileManagerEntity.setCloudType(1);
      localFileManagerEntity.lastTime = (paramMessageForFile.time * 1000L + 604800000L);
      if (localFileManagerEntity.status != 1) {
        break;
      }
      localFileManagerEntity.setCloudType(3);
      localFileManagerEntity.setFilePath(paramMessageForFile.url);
      break;
      localObject = "";
      break label268;
    }
  }
  
  public static FileManagerEntity a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    FileManagerEntity localFileManagerEntity1 = null;
    QQAppInterface localQQAppInterface = a();
    if (paramDataLineMsgRecord.entityID != 0L) {
      localFileManagerEntity1 = localQQAppInterface.getFileManagerDataCenter().a(paramDataLineMsgRecord.entityID);
    }
    FileManagerEntity localFileManagerEntity2 = localFileManagerEntity1;
    if (localFileManagerEntity1 == null)
    {
      localFileManagerEntity1 = new FileManagerEntity();
      localFileManagerEntity1.nSessionId = a().longValue();
      paramDataLineMsgRecord.entityID = localFileManagerEntity1.nSessionId;
      localFileManagerEntity1.datalineEntitySessionId = paramDataLineMsgRecord.sessionid;
      localFileManagerEntity2 = localFileManagerEntity1;
      if (paramDataLineMsgRecord.nOpType == 31)
      {
        localFileManagerEntity1.strTroopFilePath = paramDataLineMsgRecord.fileUuid;
        localFileManagerEntity2 = localFileManagerEntity1;
      }
    }
    if (localFileManagerEntity2.datalineEntitySessionId == 0L) {
      localFileManagerEntity2.datalineEntitySessionId = paramDataLineMsgRecord.sessionid;
    }
    localFileManagerEntity2.setCloudType(6);
    localFileManagerEntity2.bSend = paramDataLineMsgRecord.isSendFromLocal();
    localFileManagerEntity2.status = -1;
    if (paramDataLineMsgRecord.fileMsgStatus == 0L)
    {
      localFileManagerEntity2.status = 1;
      if (!paramDataLineMsgRecord.issuc)
      {
        localFileManagerEntity2.status = 0;
        if (paramDataLineMsgRecord.nOpType == 1) {
          localFileManagerEntity2.bSend = false;
        }
        localFileManagerEntity2.fileName = paramDataLineMsgRecord.filename;
        if (!TextUtils.isEmpty(paramDataLineMsgRecord.path)) {
          localFileManagerEntity2.setFilePath(paramDataLineMsgRecord.path);
        }
        localFileManagerEntity2.Uuid = paramDataLineMsgRecord.serverPath;
        if ((localFileManagerEntity2.Uuid == null) && ((paramDataLineMsgRecord.nOpType == 31) || (paramDataLineMsgRecord.nOpType == 29))) {
          localFileManagerEntity2.Uuid = paramDataLineMsgRecord.fileUuid;
        }
        localFileManagerEntity2.peerType = 6000;
        localFileManagerEntity2.peerUin = AppConstants.DATALINE_PC_UIN;
        if (1 == DataLineMsgRecord.getDevTypeBySeId(paramDataLineMsgRecord.sessionid))
        {
          localFileManagerEntity2.peerType = 6003;
          localFileManagerEntity2.peerUin = AppConstants.DATALINE_IPAD_UIN;
        }
        localFileManagerEntity2.fileSize = paramDataLineMsgRecord.filesize;
        localFileManagerEntity2.strFileMd5 = com.tencent.mobileqq.utils.HexUtil.bytes2HexStr(paramDataLineMsgRecord.md5);
        localFileManagerEntity2.nFileType = a(paramDataLineMsgRecord.filename);
        if (localFileManagerEntity2.nFileType != 0) {
          break label581;
        }
        localFileManagerEntity2.strThumbPath = paramDataLineMsgRecord.thumbPath;
        localFileManagerEntity2.strLargeThumPath = paramDataLineMsgRecord.thumbPath;
      }
    }
    for (;;)
    {
      if (paramDataLineMsgRecord.strMoloKey != null)
      {
        localFileManagerEntity2.nFileType = a(paramDataLineMsgRecord.path);
        localFileManagerEntity2.isFromrMolo = true;
      }
      localFileManagerEntity2.fProgress = paramDataLineMsgRecord.progress;
      if ((localFileManagerEntity2.fProgress == 1.0D) && ((localFileManagerEntity2.status == 3) || (localFileManagerEntity2.status == -1))) {
        localFileManagerEntity2.fProgress = 0.0F;
      }
      if ((paramDataLineMsgRecord.nOpType == 1) && (Float.compare(paramDataLineMsgRecord.progress, 1.0F) == 0) && (!FilePathUtil.a(paramDataLineMsgRecord.path))) {
        localFileManagerEntity2.fProgress = 0.0F;
      }
      localFileManagerEntity2.uniseq = paramDataLineMsgRecord.sessionid;
      localFileManagerEntity2.nOpType = paramDataLineMsgRecord.nOpType;
      localFileManagerEntity2.srvTime = (paramDataLineMsgRecord.time * 1000L);
      QLog.i("FileManagerUtil<FileAssistant>", 1, "=_= create new Entity[" + localFileManagerEntity2.nSessionId + "] fileName[" + paramDataLineMsgRecord.filename + "] by dataline size(" + localFileManagerEntity2.imgHeight + ":" + localFileManagerEntity2.imgWidth + ")");
      localQQAppInterface.getFileManagerDataCenter().d(localFileManagerEntity2);
      return localFileManagerEntity2;
      if (paramDataLineMsgRecord.progress == 1.0F) {
        break;
      }
      localFileManagerEntity2.status = 2;
      break;
      if (paramDataLineMsgRecord.fileMsgStatus != 2L) {
        break;
      }
      localFileManagerEntity2.status = 3;
      if (paramDataLineMsgRecord.progress != 0.0F) {
        break;
      }
      localFileManagerEntity2.status = 0;
      break;
      label581:
      if ((localFileManagerEntity2.nFileType == -1) && (paramDataLineMsgRecord.msgtype == -2000)) {
        localFileManagerEntity2.nFileType = 0;
      }
    }
  }
  
  public static FileManagerEntity a(MessageForDeviceFile paramMessageForDeviceFile)
  {
    FileManagerEntity localFileManagerEntity1 = null;
    QQAppInterface localQQAppInterface = a();
    if (paramMessageForDeviceFile.entityID != 0L) {
      localFileManagerEntity1 = localQQAppInterface.getFileManagerProxy().a(paramMessageForDeviceFile.entityID);
    }
    FileManagerEntity localFileManagerEntity2 = localFileManagerEntity1;
    if (localFileManagerEntity1 == null)
    {
      localFileManagerEntity2 = new FileManagerEntity();
      localFileManagerEntity2.nSessionId = a().longValue();
      paramMessageForDeviceFile.entityID = localFileManagerEntity2.nSessionId;
    }
    localFileManagerEntity2.setCloudType(8);
    localFileManagerEntity2.bSend = paramMessageForDeviceFile.isSendFromLocal();
    localFileManagerEntity2.nOpType = 1;
    if (localFileManagerEntity2.bSend) {
      localFileManagerEntity2.nOpType = 0;
    }
    if ((paramMessageForDeviceFile.nFileStatus == 3) || (paramMessageForDeviceFile.nFileStatus == 1) || (paramMessageForDeviceFile.nFileStatus == 2)) {
      localFileManagerEntity2.status = 2;
    }
    for (;;)
    {
      localFileManagerEntity2.fileName = a(paramMessageForDeviceFile.filePath);
      if (!TextUtils.isEmpty(paramMessageForDeviceFile.filePath)) {
        localFileManagerEntity2.setFilePath(paramMessageForDeviceFile.filePath);
      }
      localFileManagerEntity2.fileSize = paramMessageForDeviceFile.fileSize;
      localFileManagerEntity2.nFileType = a(paramMessageForDeviceFile.filePath);
      if ((localFileManagerEntity2.nFileType == -1) && (paramMessageForDeviceFile.strServiceName.equals(DeviceMsgHandle.jdField_d_of_type_JavaLangString))) {
        localFileManagerEntity2.nFileType = 0;
      }
      localFileManagerEntity2.fProgress = paramMessageForDeviceFile.progress;
      localFileManagerEntity2.uniseq = paramMessageForDeviceFile.uSessionID;
      localFileManagerEntity2.peerUin = paramMessageForDeviceFile.frienduin;
      localFileManagerEntity2.peerType = paramMessageForDeviceFile.istroop;
      localFileManagerEntity2.msgSeq = paramMessageForDeviceFile.uniseq;
      QLog.i("FileManagerUtil<FileAssistant>", 1, "=_= create new Entity[" + localFileManagerEntity2.nSessionId + "] fileName[" + paramMessageForDeviceFile.srcFileName + "] by devices size(" + localFileManagerEntity2.imgHeight + ":" + localFileManagerEntity2.imgWidth + ")");
      localQQAppInterface.getFileManagerDataCenter().d(localFileManagerEntity2);
      return localFileManagerEntity2;
      if (paramMessageForDeviceFile.nFileStatus == 4) {
        localFileManagerEntity2.status = 3;
      } else if (paramMessageForDeviceFile.nFileStatus == 5) {
        localFileManagerEntity2.status = 1;
      } else if (paramMessageForDeviceFile.nFileStatus == 6) {
        localFileManagerEntity2.status = 0;
      } else if (paramMessageForDeviceFile.nFileStatus == -1) {
        localFileManagerEntity2.status = -1;
      }
    }
  }
  
  public static FileManagerEntity a(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct)
  {
    FileManagerEntity localFileManagerEntity1 = null;
    QQAppInterface localQQAppInterface = a();
    if (paramMessageForDeviceSingleStruct.entityID != 0L) {
      localFileManagerEntity1 = localQQAppInterface.getFileManagerProxy().a(paramMessageForDeviceSingleStruct.entityID);
    }
    FileManagerEntity localFileManagerEntity2 = localFileManagerEntity1;
    if (localFileManagerEntity1 == null)
    {
      localFileManagerEntity2 = new FileManagerEntity();
      localFileManagerEntity2.nSessionId = a().longValue();
      paramMessageForDeviceSingleStruct.entityID = localFileManagerEntity2.nSessionId;
    }
    localFileManagerEntity2.setCloudType(8);
    localFileManagerEntity2.bSend = paramMessageForDeviceSingleStruct.isSendFromLocal();
    localFileManagerEntity2.nOpType = 0;
    if ((paramMessageForDeviceSingleStruct.nMediaFileStatus == 3) || (paramMessageForDeviceSingleStruct.nMediaFileStatus == 1) || (paramMessageForDeviceSingleStruct.nMediaFileStatus == 2)) {
      localFileManagerEntity2.status = 2;
    }
    for (;;)
    {
      localFileManagerEntity2.uniseq = paramMessageForDeviceSingleStruct.uniseq;
      localFileManagerEntity2.fileName = paramMessageForDeviceSingleStruct.strMediaFileName;
      localFileManagerEntity2.strThumbPath = paramMessageForDeviceSingleStruct.strCoverPath;
      localFileManagerEntity2.strLargeThumPath = paramMessageForDeviceSingleStruct.strCoverPath;
      if (!TextUtils.isEmpty(paramMessageForDeviceSingleStruct.strMediaPath)) {
        localFileManagerEntity2.setFilePath(paramMessageForDeviceSingleStruct.strMediaPath);
      }
      localFileManagerEntity2.fileSize = paramMessageForDeviceSingleStruct.nMediaFileSize;
      localFileManagerEntity2.nFileType = a(paramMessageForDeviceSingleStruct.strMediaFileName);
      localFileManagerEntity2.fProgress = paramMessageForDeviceSingleStruct.nMediaProgress;
      localFileManagerEntity2.uniseq = paramMessageForDeviceSingleStruct.nMediaSessionID;
      localFileManagerEntity2.peerUin = paramMessageForDeviceSingleStruct.frienduin;
      localFileManagerEntity2.peerType = paramMessageForDeviceSingleStruct.istroop;
      localFileManagerEntity2.msgSeq = paramMessageForDeviceSingleStruct.uniseq;
      localQQAppInterface.getFileManagerDataCenter().d(localFileManagerEntity2);
      return localFileManagerEntity2;
      if (paramMessageForDeviceSingleStruct.nMediaFileStatus == 5) {
        localFileManagerEntity2.status = 1;
      } else if (paramMessageForDeviceSingleStruct.nMediaFileStatus == 6) {
        localFileManagerEntity2.status = 0;
      }
    }
  }
  
  public static FileManagerEntity a(PrinterItemMsgRecord paramPrinterItemMsgRecord)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.setCloudType(6);
    localFileManagerEntity.bSend = paramPrinterItemMsgRecord.isSendFromLocal();
    localFileManagerEntity.status = 1;
    localFileManagerEntity.fileName = paramPrinterItemMsgRecord.filename;
    localFileManagerEntity.setFilePath(paramPrinterItemMsgRecord.filename);
    localFileManagerEntity.nOpType = 0;
    if (localFileManagerEntity.bSend) {
      localFileManagerEntity.nOpType = 0;
    }
    int i = paramPrinterItemMsgRecord.filename.lastIndexOf("/");
    if (i >= 0) {}
    for (localFileManagerEntity.fileName = paramPrinterItemMsgRecord.filename.substring(i + 1);; localFileManagerEntity.fileName = paramPrinterItemMsgRecord.filename)
    {
      VFSFile localVFSFile = new VFSFile(localFileManagerEntity.getFilePath());
      if (localVFSFile.exists()) {
        localFileManagerEntity.fileSize = localVFSFile.length();
      }
      localFileManagerEntity.nFileType = a(paramPrinterItemMsgRecord.filename);
      localFileManagerEntity.fProgress = 1.0F;
      localFileManagerEntity.uniseq = paramPrinterItemMsgRecord.uSessionID;
      QLog.i("FileManagerUtil<FileAssistant>", 1, "=_= create new Entity[" + localFileManagerEntity.nSessionId + "] fileName[" + paramPrinterItemMsgRecord.filename + "] by print size(" + localFileManagerEntity.imgHeight + ":" + localFileManagerEntity.imgWidth + ")");
      a().getFileManagerDataCenter().d(localFileManagerEntity);
      return localFileManagerEntity;
    }
  }
  
  public static FileManagerEntity a(FileInfo paramFileInfo)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.setCloudType(3);
    localFileManagerEntity.fileName = paramFileInfo.d();
    localFileManagerEntity.setFilePath(paramFileInfo.c());
    localFileManagerEntity.fileSize = paramFileInfo.a();
    if (paramFileInfo.a() == 5)
    {
      localFileManagerEntity.nFileType = 5;
      FileCategoryUtil.a(paramFileInfo.c(), new FileManagerUtil.2(localFileManagerEntity));
    }
    for (;;)
    {
      localFileManagerEntity.status = -1;
      QQAppInterface localQQAppInterface = a();
      QLog.i("FileManagerUtil<FileAssistant>", 1, "=_= create new Entity[" + localFileManagerEntity.nSessionId + "] fileName[" + paramFileInfo.d() + "]by local size(" + localFileManagerEntity.imgHeight + ":" + localFileManagerEntity.imgWidth + ")");
      localQQAppInterface.getFileManagerDataCenter().d(localFileManagerEntity);
      return localFileManagerEntity;
      localFileManagerEntity.nFileType = a(paramFileInfo.d());
    }
  }
  
  public static FileManagerEntity a(OfflineFileInfo paramOfflineFileInfo, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    QQAppInterface localQQAppInterface = a();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.Uuid = paramOfflineFileInfo.jdField_a_of_type_JavaLangString;
    localFileManagerEntity.fileIdCrc = paramOfflineFileInfo.jdField_b_of_type_JavaLangString;
    localFileManagerEntity.setCloudType(1);
    localFileManagerEntity.strThumbPath = paramOfflineFileInfo.jdField_e_of_type_JavaLangString;
    localFileManagerEntity.peerUin = String.valueOf(paramOfflineFileInfo.jdField_a_of_type_Long);
    localFileManagerEntity.peerNick = a(localQQAppInterface, localFileManagerEntity.peerUin, null, paramInt);
    localFileManagerEntity.peerType = paramInt;
    localFileManagerEntity.fileName = paramOfflineFileInfo.jdField_c_of_type_JavaLangString;
    localFileManagerEntity.fileSize = paramOfflineFileInfo.jdField_b_of_type_Long;
    localFileManagerEntity.nFileType = a(paramOfflineFileInfo.jdField_c_of_type_JavaLangString);
    localFileManagerEntity.lastTime = paramOfflineFileInfo.jdField_c_of_type_Long;
    localFileManagerEntity.status = -1;
    localFileManagerEntity.srvTime = paramOfflineFileInfo.jdField_d_of_type_Long;
    localFileManagerEntity.bSend = paramOfflineFileInfo.jdField_a_of_type_Boolean;
    if ((localFileManagerEntity.Uuid == null) || (localFileManagerEntity.Uuid.length() == 0)) {
      localFileManagerEntity.nWeiYunSrcType = -1;
    }
    QLog.i("FileManagerUtil<FileAssistant>", 1, "=_= create new Entity[" + localFileManagerEntity.nSessionId + "] fileName[" + paramOfflineFileInfo.jdField_c_of_type_JavaLangString + "] by offlinefile size(" + localFileManagerEntity.imgHeight + ":" + localFileManagerEntity.imgWidth + ")");
    localQQAppInterface.getFileManagerDataCenter().d(localFileManagerEntity);
    return localFileManagerEntity;
  }
  
  public static FileManagerEntity a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    FileManagerEntity localFileManagerEntity1 = new FileManagerEntity();
    localFileManagerEntity1.nSessionId = a().longValue();
    localFileManagerEntity1.WeiYunFileId = paramWeiYunFileInfo.jdField_a_of_type_JavaLangString;
    localFileManagerEntity1.fileName = paramWeiYunFileInfo.jdField_c_of_type_JavaLangString;
    localFileManagerEntity1.fileSize = paramWeiYunFileInfo.jdField_a_of_type_Long;
    localFileManagerEntity1.nFileType = a(paramWeiYunFileInfo.jdField_c_of_type_JavaLangString);
    localFileManagerEntity1.strThumbPath = paramWeiYunFileInfo.h;
    localFileManagerEntity1.setCloudType(2);
    localFileManagerEntity1.nWeiYunSrcType = paramWeiYunFileInfo.jdField_a_of_type_Int;
    if (localFileManagerEntity1.nWeiYunSrcType == 2) {
      localFileManagerEntity1.strLargeThumPath = paramWeiYunFileInfo.jdField_e_of_type_JavaLangString;
    }
    localFileManagerEntity1.lastTime = paramWeiYunFileInfo.jdField_b_of_type_Long;
    localFileManagerEntity1.bSend = false;
    localFileManagerEntity1.status = -1;
    localFileManagerEntity1.srvTime = (MessageCache.a() * 1000L);
    localFileManagerEntity1.strFileMd5 = paramWeiYunFileInfo.i;
    localFileManagerEntity1.WeiYunDirKey = paramWeiYunFileInfo.jdField_b_of_type_JavaLangString;
    localFileManagerEntity1.strFileSHA = paramWeiYunFileInfo.j;
    QQAppInterface localQQAppInterface = a();
    FileManagerEntity localFileManagerEntity2 = localQQAppInterface.getFileManagerDataCenter().d(paramWeiYunFileInfo.jdField_a_of_type_JavaLangString);
    if (localFileManagerEntity2 != null)
    {
      localFileManagerEntity1.imgWidth = localFileManagerEntity2.imgWidth;
      localFileManagerEntity1.imgHeight = localFileManagerEntity2.imgHeight;
    }
    QLog.i("FileManagerUtil<FileAssistant>", 1, "=_= create new Entity[" + localFileManagerEntity1.nSessionId + "] fileName[" + paramWeiYunFileInfo.jdField_c_of_type_JavaLangString + "] by WeiYun size(" + localFileManagerEntity1.imgHeight + ":" + localFileManagerEntity1.imgWidth + ")");
    localQQAppInterface.getFileManagerDataCenter().d(localFileManagerEntity1);
    return localFileManagerEntity1;
  }
  
  public static FileManagerEntity a(TroopFileStatusInfo paramTroopFileStatusInfo)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.setCloudType(4);
    localFileManagerEntity.fileName = paramTroopFileStatusInfo.g;
    if (FileUtil.a(paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString)) {
      localFileManagerEntity.setFilePath(paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString);
    }
    if (FileUtil.a(paramTroopFileStatusInfo.jdField_c_of_type_JavaLangString)) {
      localFileManagerEntity.strLargeThumPath = paramTroopFileStatusInfo.jdField_c_of_type_JavaLangString;
    }
    if (FileUtil.a(paramTroopFileStatusInfo.jdField_b_of_type_JavaLangString))
    {
      localFileManagerEntity.strThumbPath = paramTroopFileStatusInfo.jdField_b_of_type_JavaLangString;
      localFileManagerEntity.fileSize = paramTroopFileStatusInfo.jdField_c_of_type_Long;
      localFileManagerEntity.fProgress = ((float)paramTroopFileStatusInfo.jdField_d_of_type_Long / (float)paramTroopFileStatusInfo.jdField_c_of_type_Long);
      localFileManagerEntity.nFileType = a(paramTroopFileStatusInfo.g);
      if ((6 <= paramTroopFileStatusInfo.jdField_b_of_type_Int) && (13 != paramTroopFileStatusInfo.jdField_b_of_type_Int)) {
        break label372;
      }
      localFileManagerEntity.status = 2;
    }
    for (;;)
    {
      if (paramTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID != null) {
        localFileManagerEntity.strTroopFileID = paramTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID.toString();
      }
      localFileManagerEntity.strTroopFilePath = paramTroopFileStatusInfo.jdField_e_of_type_JavaLangString;
      localFileManagerEntity.strTroopFileSha1 = paramTroopFileStatusInfo.f;
      localFileManagerEntity.busId = paramTroopFileStatusInfo.h;
      localFileManagerEntity.TroopUin = paramTroopFileStatusInfo.jdField_b_of_type_Long;
      localFileManagerEntity.peerType = 1;
      localFileManagerEntity.peerUin = String.valueOf(paramTroopFileStatusInfo.jdField_b_of_type_Long);
      localFileManagerEntity.uniseq = paramTroopFileStatusInfo.jdField_a_of_type_Long;
      localFileManagerEntity.yybApkPackageName = paramTroopFileStatusInfo.k;
      localFileManagerEntity.yybApkName = paramTroopFileStatusInfo.l;
      localFileManagerEntity.yybApkIconUrl = paramTroopFileStatusInfo.m;
      localFileManagerEntity.apkSafeLevel = paramTroopFileStatusInfo.i;
      localFileManagerEntity.apkSafeMsg = paramTroopFileStatusInfo.n;
      localFileManagerEntity.apkSafeDetailUrl = paramTroopFileStatusInfo.o;
      QLog.i("FileManagerUtil<FileAssistant>", 1, "=_= create new Entity[" + localFileManagerEntity.nSessionId + "] fileName[" + paramTroopFileStatusInfo.g + "] by troop size(" + localFileManagerEntity.imgHeight + ":" + localFileManagerEntity.imgWidth + ")");
      a().getFileManagerDataCenter().d(localFileManagerEntity);
      return localFileManagerEntity;
      if (!FileUtil.a(paramTroopFileStatusInfo.jdField_d_of_type_JavaLangString)) {
        break;
      }
      localFileManagerEntity.strMiddleThumPath = paramTroopFileStatusInfo.jdField_d_of_type_JavaLangString;
      break;
      label372:
      if (12 == paramTroopFileStatusInfo.jdField_b_of_type_Int) {
        localFileManagerEntity.status = 0;
      } else {
        localFileManagerEntity.status = 1;
      }
    }
  }
  
  public static FileManagerEntity a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, String paramString6, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.strFavFileId = paramString2;
    localFileManagerEntity.strFavId = paramString1;
    localFileManagerEntity.fileName = paramString4;
    localFileManagerEntity.fileSize = paramLong;
    localFileManagerEntity.nFileType = a(paramString4);
    localFileManagerEntity.setCloudType(10);
    localFileManagerEntity.setFilePath(paramString3);
    localFileManagerEntity.bSend = false;
    localFileManagerEntity.status = -1;
    localFileManagerEntity.srvTime = (MessageCache.a() * 1000L);
    localFileManagerEntity.strFileMd5 = paramString5;
    localFileManagerEntity.peerType = paramInt;
    localFileManagerEntity.peerUin = paramString6;
    if (paramInt == 1) {
      localFileManagerEntity.nOpType = 36;
    }
    for (;;)
    {
      a().getFileManagerDataCenter().d(localFileManagerEntity);
      return localFileManagerEntity;
      if (paramInt == 0) {
        localFileManagerEntity.nOpType = 37;
      } else if (paramInt == 7) {
        localFileManagerEntity.nOpType = 38;
      }
    }
  }
  
  public static ForwardFileInfo a(FileManagerEntity paramFileManagerEntity)
  {
    return ForwardFileOption.a(paramFileManagerEntity);
  }
  
  public static ForwardFileInfo a(FileManagerEntity paramFileManagerEntity, MessageForFile paramMessageForFile)
  {
    return ForwardFileOption.a(paramFileManagerEntity, paramMessageForFile);
  }
  
  /* Error */
  public static FileManagerUtil.VideoThumbInfo a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokestatic 1487	com/tencent/mobileqq/filemanager/util/FileManagerUtil:f	(Ljava/lang/String;)Ljava/lang/String;
    //   6: astore 4
    //   8: new 1489	com/tencent/mobileqq/filemanager/util/FileManagerUtil$VideoThumbInfo
    //   11: dup
    //   12: invokespecial 1490	com/tencent/mobileqq/filemanager/util/FileManagerUtil$VideoThumbInfo:<init>	()V
    //   15: astore 5
    //   17: aload 5
    //   19: iconst_0
    //   20: putfield 1491	com/tencent/mobileqq/filemanager/util/FileManagerUtil$VideoThumbInfo:jdField_a_of_type_Int	I
    //   23: aload 4
    //   25: invokestatic 1492	com/tencent/mobileqq/filemanager/util/FileUtil:b	(Ljava/lang/String;)Z
    //   28: ifeq +51 -> 79
    //   31: new 1494	android/graphics/BitmapFactory$Options
    //   34: dup
    //   35: invokespecial 1495	android/graphics/BitmapFactory$Options:<init>	()V
    //   38: astore_0
    //   39: aload_0
    //   40: iconst_1
    //   41: putfield 1498	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   44: aload 4
    //   46: aload_0
    //   47: invokestatic 1503	com/tencent/mobileqq/filemanager/util/FilePicURLDrawlableHelper:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   50: pop
    //   51: aload 5
    //   53: aload_0
    //   54: getfield 1506	android/graphics/BitmapFactory$Options:outWidth	I
    //   57: putfield 1507	com/tencent/mobileqq/filemanager/util/FileManagerUtil$VideoThumbInfo:jdField_b_of_type_Int	I
    //   60: aload 5
    //   62: aload_0
    //   63: getfield 1510	android/graphics/BitmapFactory$Options:outHeight	I
    //   66: putfield 1511	com/tencent/mobileqq/filemanager/util/FileManagerUtil$VideoThumbInfo:jdField_c_of_type_Int	I
    //   69: aload 5
    //   71: aload 4
    //   73: putfield 1512	com/tencent/mobileqq/filemanager/util/FileManagerUtil$VideoThumbInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   76: aload 5
    //   78: areturn
    //   79: aload_0
    //   80: iconst_1
    //   81: invokestatic 1518	android/media/ThumbnailUtils:createVideoThumbnail	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   84: astore_0
    //   85: aload_0
    //   86: astore_2
    //   87: aload_0
    //   88: ifnonnull +21 -> 109
    //   91: aload 5
    //   93: iconst_m1
    //   94: putfield 1491	com/tencent/mobileqq/filemanager/util/FileManagerUtil$VideoThumbInfo:jdField_a_of_type_Int	I
    //   97: aload 5
    //   99: areturn
    //   100: astore_1
    //   101: aconst_null
    //   102: astore_0
    //   103: aload_1
    //   104: invokevirtual 640	java/lang/Exception:printStackTrace	()V
    //   107: aload_0
    //   108: astore_2
    //   109: new 339	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   116: invokestatic 1523	com/tencent/mobileqq/filemanager/settings/FMSettings:a	()Lcom/tencent/mobileqq/filemanager/settings/FMSettings;
    //   119: invokevirtual 1524	com/tencent/mobileqq/filemanager/settings/FMSettings:d	()Ljava/lang/String;
    //   122: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokestatic 1529	java/lang/System:currentTimeMillis	()J
    //   128: invokevirtual 954	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   131: ldc 179
    //   133: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: astore 6
    //   141: new 339	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   148: invokestatic 1523	com/tencent/mobileqq/filemanager/settings/FMSettings:a	()Lcom/tencent/mobileqq/filemanager/settings/FMSettings;
    //   151: invokevirtual 1524	com/tencent/mobileqq/filemanager/settings/FMSettings:d	()Ljava/lang/String;
    //   154: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: ldc_w 1531
    //   160: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 1533	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;)V
    //   169: new 1337	com/tencent/mm/vfs/VFSFile
    //   172: dup
    //   173: aload 6
    //   175: invokespecial 1338	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   178: astore 7
    //   180: aload 7
    //   182: invokevirtual 1536	com/tencent/mm/vfs/VFSFile:getParent	()Ljava/lang/String;
    //   185: astore_0
    //   186: aload_0
    //   187: ifnonnull +6 -> 193
    //   190: aload 5
    //   192: areturn
    //   193: new 1337	com/tencent/mm/vfs/VFSFile
    //   196: dup
    //   197: aload_0
    //   198: invokespecial 1338	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   201: astore_0
    //   202: aload_0
    //   203: invokevirtual 1339	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   206: ifeq +10 -> 216
    //   209: aload_0
    //   210: invokevirtual 1539	com/tencent/mm/vfs/VFSFile:isDirectory	()Z
    //   213: ifne +8 -> 221
    //   216: aload_0
    //   217: invokevirtual 1542	com/tencent/mm/vfs/VFSFile:mkdirs	()Z
    //   220: pop
    //   221: aload 7
    //   223: invokevirtual 1339	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   226: ifeq +11 -> 237
    //   229: aload 7
    //   231: invokevirtual 1545	com/tencent/mm/vfs/VFSFile:isFile	()Z
    //   234: ifne +9 -> 243
    //   237: aload 7
    //   239: invokevirtual 1548	com/tencent/mm/vfs/VFSFile:createNewFile	()Z
    //   242: pop
    //   243: new 1550	java/io/BufferedOutputStream
    //   246: dup
    //   247: new 1552	com/tencent/mm/vfs/VFSFileOutputStream
    //   250: dup
    //   251: aload 7
    //   253: invokespecial 1555	com/tencent/mm/vfs/VFSFileOutputStream:<init>	(Lcom/tencent/mm/vfs/VFSFile;)V
    //   256: invokespecial 1558	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   259: astore_0
    //   260: aload_2
    //   261: ifnull +92 -> 353
    //   264: aload_0
    //   265: astore_1
    //   266: aload_2
    //   267: getstatic 1564	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   270: bipush 80
    //   272: aload_0
    //   273: invokevirtual 1568	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   276: pop
    //   277: aload_0
    //   278: astore_1
    //   279: aload_0
    //   280: invokevirtual 1571	java/io/BufferedOutputStream:flush	()V
    //   283: aload_0
    //   284: ifnull +7 -> 291
    //   287: aload_0
    //   288: invokevirtual 1572	java/io/BufferedOutputStream:close	()V
    //   291: aload 7
    //   293: invokevirtual 1339	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   296: ifeq +229 -> 525
    //   299: aload 6
    //   301: aload 4
    //   303: invokestatic 1575	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   306: pop
    //   307: aload 6
    //   309: invokestatic 1577	com/tencent/mobileqq/filemanager/util/FileUtil:c	(Ljava/lang/String;)Z
    //   312: pop
    //   313: aload 5
    //   315: aload 4
    //   317: putfield 1512	com/tencent/mobileqq/filemanager/util/FileManagerUtil$VideoThumbInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   320: aload_2
    //   321: ifnull +21 -> 342
    //   324: aload 5
    //   326: aload_2
    //   327: invokevirtual 671	android/graphics/Bitmap:getWidth	()I
    //   330: putfield 1507	com/tencent/mobileqq/filemanager/util/FileManagerUtil$VideoThumbInfo:jdField_b_of_type_Int	I
    //   333: aload 5
    //   335: aload_2
    //   336: invokevirtual 674	android/graphics/Bitmap:getHeight	()I
    //   339: putfield 1511	com/tencent/mobileqq/filemanager/util/FileManagerUtil$VideoThumbInfo:jdField_c_of_type_Int	I
    //   342: aload 5
    //   344: areturn
    //   345: astore_0
    //   346: aload_0
    //   347: invokevirtual 1578	java/io/IOException:printStackTrace	()V
    //   350: goto -107 -> 243
    //   353: aload_0
    //   354: astore_1
    //   355: aload 5
    //   357: iconst_m1
    //   358: putfield 1491	com/tencent/mobileqq/filemanager/util/FileManagerUtil$VideoThumbInfo:jdField_a_of_type_Int	I
    //   361: goto -78 -> 283
    //   364: astore_1
    //   365: aload 5
    //   367: bipush 254
    //   369: putfield 1491	com/tencent/mobileqq/filemanager/util/FileManagerUtil$VideoThumbInfo:jdField_a_of_type_Int	I
    //   372: invokestatic 335	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   375: ifeq +44 -> 419
    //   378: ldc_w 337
    //   381: iconst_2
    //   382: new 339	java/lang/StringBuilder
    //   385: dup
    //   386: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   389: ldc_w 1580
    //   392: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: aload 6
    //   397: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: ldc_w 1582
    //   403: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: aload_1
    //   407: invokevirtual 1585	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   410: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   416: invokestatic 443	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   419: aload_0
    //   420: ifnull -129 -> 291
    //   423: aload_0
    //   424: invokevirtual 1572	java/io/BufferedOutputStream:close	()V
    //   427: goto -136 -> 291
    //   430: astore_0
    //   431: goto -140 -> 291
    //   434: astore_3
    //   435: aconst_null
    //   436: astore_0
    //   437: aload_0
    //   438: astore_1
    //   439: aload 5
    //   441: bipush 254
    //   443: putfield 1491	com/tencent/mobileqq/filemanager/util/FileManagerUtil$VideoThumbInfo:jdField_a_of_type_Int	I
    //   446: aload_0
    //   447: astore_1
    //   448: invokestatic 335	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   451: ifeq +46 -> 497
    //   454: aload_0
    //   455: astore_1
    //   456: ldc_w 337
    //   459: iconst_2
    //   460: new 339	java/lang/StringBuilder
    //   463: dup
    //   464: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   467: ldc_w 1580
    //   470: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: aload 6
    //   475: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: ldc_w 1587
    //   481: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: aload_3
    //   485: invokevirtual 1588	java/io/IOException:getMessage	()Ljava/lang/String;
    //   488: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokestatic 443	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   497: aload_0
    //   498: ifnull -207 -> 291
    //   501: aload_0
    //   502: invokevirtual 1572	java/io/BufferedOutputStream:close	()V
    //   505: goto -214 -> 291
    //   508: astore_0
    //   509: goto -218 -> 291
    //   512: astore_0
    //   513: aconst_null
    //   514: astore_1
    //   515: aload_1
    //   516: ifnull +7 -> 523
    //   519: aload_1
    //   520: invokevirtual 1572	java/io/BufferedOutputStream:close	()V
    //   523: aload_0
    //   524: athrow
    //   525: aload 5
    //   527: iconst_m1
    //   528: putfield 1491	com/tencent/mobileqq/filemanager/util/FileManagerUtil$VideoThumbInfo:jdField_a_of_type_Int	I
    //   531: invokestatic 335	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   534: ifeq -192 -> 342
    //   537: ldc_w 337
    //   540: iconst_2
    //   541: ldc_w 1590
    //   544: invokestatic 443	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   547: goto -205 -> 342
    //   550: astore_0
    //   551: goto -260 -> 291
    //   554: astore_1
    //   555: goto -32 -> 523
    //   558: astore_0
    //   559: goto -44 -> 515
    //   562: astore_2
    //   563: aload_0
    //   564: astore_1
    //   565: aload_2
    //   566: astore_0
    //   567: goto -52 -> 515
    //   570: astore_3
    //   571: goto -134 -> 437
    //   574: astore_1
    //   575: aload_3
    //   576: astore_0
    //   577: goto -212 -> 365
    //   580: astore_1
    //   581: goto -478 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	584	0	paramString	String
    //   100	4	1	localException1	Exception
    //   265	90	1	str1	String
    //   364	43	1	localFileNotFoundException1	FileNotFoundException
    //   438	82	1	str2	String
    //   554	1	1	localIOException1	IOException
    //   564	1	1	str3	String
    //   574	1	1	localFileNotFoundException2	FileNotFoundException
    //   580	1	1	localException2	Exception
    //   86	250	2	str4	String
    //   562	4	2	localObject1	Object
    //   1	1	3	localObject2	Object
    //   434	51	3	localIOException2	IOException
    //   570	6	3	localIOException3	IOException
    //   6	310	4	str5	String
    //   15	511	5	localVideoThumbInfo	FileManagerUtil.VideoThumbInfo
    //   139	335	6	str6	String
    //   178	114	7	localVFSFile	VFSFile
    // Exception table:
    //   from	to	target	type
    //   79	85	100	java/lang/Exception
    //   237	243	345	java/io/IOException
    //   266	277	364	java/io/FileNotFoundException
    //   279	283	364	java/io/FileNotFoundException
    //   355	361	364	java/io/FileNotFoundException
    //   423	427	430	java/io/IOException
    //   243	260	434	java/io/IOException
    //   501	505	508	java/io/IOException
    //   243	260	512	finally
    //   287	291	550	java/io/IOException
    //   519	523	554	java/io/IOException
    //   266	277	558	finally
    //   279	283	558	finally
    //   355	361	558	finally
    //   439	446	558	finally
    //   448	454	558	finally
    //   456	497	558	finally
    //   365	419	562	finally
    //   266	277	570	java/io/IOException
    //   279	283	570	java/io/IOException
    //   355	361	570	java/io/IOException
    //   243	260	574	java/io/FileNotFoundException
    //   91	97	580	java/lang/Exception
  }
  
  public static IForwardCallBack a(QQAppInterface paramQQAppInterface)
  {
    return new C2CProcessCallBack(paramQQAppInterface);
  }
  
  public static IForwardCallBack a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    return new FileManagerUtil.14(paramQQAppInterface, paramInt);
  }
  
  public static TimeoutParam a()
  {
    boolean bool = false;
    Object localObject = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
    int i = -1;
    int k;
    int j;
    if (localObject != null)
    {
      k = ((NetworkInfo)localObject).getType();
      if (k == 1)
      {
        i = 1;
        j = i;
        i = k;
      }
    }
    for (;;)
    {
      int m = BaseApplicationImpl.sApplication.getMsfConnectedNetType();
      if (m == 2) {}
      for (k = 1;; k = 0)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("getNetworkInfo,systemType:").append(i).append(" msfType:").append(m).append(" isSameNet:");
          if (j == k) {
            bool = true;
          }
          QLog.i("FileManagerUtil<FileAssistant>.NetDebug", 1, bool);
        }
        if (j == k) {
          break label199;
        }
        localObject = new TimeoutParam();
        ((TimeoutParam)localObject).readTimeoutFor2G = 20000;
        ((TimeoutParam)localObject).readTimeoutFor3G = 15000;
        ((TimeoutParam)localObject).readTimeoutForWifi = 10000;
        ((TimeoutParam)localObject).connectTimeoutFor2G = 10000;
        ((TimeoutParam)localObject).connectTimeoutFor3G = 5000;
        ((TimeoutParam)localObject).connectTimeoutForWifi = 5000;
        return localObject;
        i = 0;
        break;
      }
      label199:
      return null;
      j = 0;
    }
  }
  
  public static IUniformDownloadMgr a()
  {
    return (IUniformDownloadMgr)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IUniformDownloadMgr.class, "all");
  }
  
  public static Long a()
  {
    return Long.valueOf((int)(System.currentTimeMillis() / 1000L) << 32 | Math.abs(new Random().nextInt()));
  }
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 1166
    //   6: astore_2
    //   7: aload_2
    //   8: astore_3
    //   9: invokestatic 1692	java/lang/Thread:getAllStackTraces	()Ljava/util/Map;
    //   12: invokestatic 1696	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   15: invokeinterface 1699 2 0
    //   20: checkcast 1701	[Ljava/lang/StackTraceElement;
    //   23: astore 4
    //   25: aload_2
    //   26: astore_3
    //   27: aload 4
    //   29: arraylength
    //   30: istore_1
    //   31: iconst_0
    //   32: istore_0
    //   33: iload_0
    //   34: iload_1
    //   35: if_icmpge +69 -> 104
    //   38: aload 4
    //   40: iload_0
    //   41: aaload
    //   42: astore 5
    //   44: aload_2
    //   45: astore_3
    //   46: invokestatic 335	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   49: ifeq +17 -> 66
    //   52: aload_2
    //   53: astore_3
    //   54: ldc_w 1703
    //   57: iconst_1
    //   58: aload 5
    //   60: invokevirtual 1706	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   63: invokestatic 443	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: aload_2
    //   67: astore_3
    //   68: new 339	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   75: aload_2
    //   76: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload 5
    //   81: invokevirtual 1706	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   84: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: ldc_w 1708
    //   90: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: astore_2
    //   97: iload_0
    //   98: iconst_1
    //   99: iadd
    //   100: istore_0
    //   101: goto -68 -> 33
    //   104: ldc 2
    //   106: monitorexit
    //   107: aload_2
    //   108: areturn
    //   109: astore_2
    //   110: ldc 2
    //   112: monitorexit
    //   113: aload_2
    //   114: athrow
    //   115: astore_2
    //   116: aload_3
    //   117: astore_2
    //   118: goto -14 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   32	69	0	i	int
    //   30	6	1	j	int
    //   6	102	2	str1	String
    //   109	5	2	localObject1	Object
    //   115	1	2	localException	Exception
    //   117	1	2	localObject2	Object
    //   8	109	3	str2	String
    //   23	16	4	arrayOfStackTraceElement	java.lang.StackTraceElement[]
    //   42	38	5	localStackTraceElement	java.lang.StackTraceElement
    // Exception table:
    //   from	to	target	type
    //   9	25	109	finally
    //   27	31	109	finally
    //   46	52	109	finally
    //   54	66	109	finally
    //   68	97	109	finally
    //   9	25	115	java/lang/Exception
    //   27	31	115	java/lang/Exception
    //   46	52	115	java/lang/Exception
    //   54	66	115	java/lang/Exception
    //   68	97	115	java/lang/Exception
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 8: 
    default: 
      return d(2131704555);
    case 1: 
      return d(2131704549);
    case 0: 
      return d(2131704565);
    case 2: 
      return d(2131704571);
    case 3: 
    case 6: 
    case 7: 
    case 9: 
      return d(2131704558);
    }
    return d(2131704578);
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return String.valueOf(0);
    case 3: 
      return String.valueOf(1);
    case 1: 
      if (paramInt2 == 0) {
        return String.valueOf(2);
      }
      return String.valueOf(4);
    case 0: 
      return String.valueOf(7);
    }
    return String.valueOf(3);
  }
  
  public static String a(long paramLong, int paramInt)
  {
    long l2 = 604800000L;
    long l1 = l2;
    switch (paramInt)
    {
    }
    for (l1 = l2;; l1 = 2592000000L)
    {
      Date localDate1 = new Date(l1 + paramLong);
      Date localDate2 = new Date(MessageCache.a() * 1000L);
      paramInt = (int)((localDate1.getTime() - localDate2.getTime()) / 86400000L);
      if (paramInt >= 0) {
        break;
      }
      return d(2131704551);
    }
    if (paramInt == 0) {
      return d(2131704557);
    }
    return paramInt + d(2131704554);
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    return ((IFMConfig)QRoute.api(IFMConfig.class)).getPreviewConfig(paramContext, paramString1, paramString2);
  }
  
  public static String a(TextView paramTextView, int paramInt, String paramString1, String paramString2)
  {
    int j = paramTextView.getWidth();
    TextPaint localTextPaint = paramTextView.getPaint();
    float f = localTextPaint.measureText(paramString1);
    if (f < j) {}
    while (f <= paramInt * j - 50) {
      return paramString2;
    }
    int i = 0;
    for (;;)
    {
      int k = paramString2.length() - i - 1;
      if (k < 1) {}
      for (;;)
      {
        return paramString1;
        paramTextView = paramString2.substring(0, k) + jdField_a_of_type_JavaLangString;
        paramString1 = paramString1.replace(paramString2, paramTextView);
        if (localTextPaint.measureText(paramString1) >= paramInt * j - 50) {
          break;
        }
        paramString1 = paramTextView;
      }
      i += 1;
      paramString2 = paramTextView;
    }
  }
  
  public static String a(TextView paramTextView, String paramString)
  {
    int m = paramTextView.getWidth();
    StringBuilder localStringBuilder = new StringBuilder();
    paramTextView = paramTextView.getPaint();
    if (paramTextView.measureText(paramString) < m) {
      return paramString;
    }
    int j = 0;
    int i = 1;
    while (i < paramString.length())
    {
      int k = i + 1;
      i = k;
      if (paramTextView.measureText(paramString, j, k) >= m - 30)
      {
        localStringBuilder.append(paramString, j, k);
        localStringBuilder.append('\n');
        j = k;
        i = k;
      }
    }
    localStringBuilder.append(paramString, j, i);
    return localStringBuilder.toString();
  }
  
  public static String a(QQAppInterface paramQQAppInterface, Message paramMessage)
  {
    paramQQAppInterface = paramQQAppInterface.getFileManagerDataCenter().a(paramMessage.uniseq, paramMessage.frienduin, paramMessage.istroop);
    if (paramQQAppInterface == null) {
      return null;
    }
    if (paramQQAppInterface.nFileType == -1) {
      paramQQAppInterface.nFileType = a(paramQQAppInterface.getFilePath());
    }
    paramMessage = a(paramQQAppInterface.nFileType);
    return "[" + paramMessage + "]" + paramQQAppInterface.fileName;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, DataLineMsgRecord paramDataLineMsgRecord)
  {
    if (paramDataLineMsgRecord == null) {
      return null;
    }
    paramQQAppInterface = a(a(paramDataLineMsgRecord.path));
    return "[" + paramQQAppInterface + "]" + paramDataLineMsgRecord.filename;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    paramQQAppInterface = paramQQAppInterface.getFileManagerDataCenter().a(paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop);
    if (paramQQAppInterface == null) {
      return null;
    }
    if (paramQQAppInterface.nFileType == -1) {
      paramQQAppInterface.nFileType = a(paramQQAppInterface.getFilePath());
    }
    paramMessageRecord = a(paramQQAppInterface.nFileType);
    return "[" + paramMessageRecord + "]" + paramQQAppInterface.fileName;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (AppConstants.DATALINE_PC_UIN.equalsIgnoreCase(paramString1)) {
      return HardCodeUtil.a(2131694415);
    }
    if (AppConstants.DATALINE_IPAD_UIN.equalsIgnoreCase(paramString1)) {
      return "我的iPad";
    }
    if (AppConstants.FM_EXTERNAL_SAVEFILE_UIN.equalsIgnoreCase(paramString1)) {
      return "";
    }
    return ContactUtils.b(paramQQAppInterface, paramString1, paramInt);
  }
  
  public static String a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!paramChatMessage.isMultiMsg)) {
      paramChatMessage = "";
    }
    String str1;
    String str2;
    do
    {
      return paramChatMessage;
      str1 = paramChatMessage.getExtInfoFromExtStr("_f_thumb_path_750_");
      str2 = paramChatMessage.getExtInfoFromExtStr("_f_thumb_path_384_");
      if (TextUtils.isEmpty(str1)) {
        break;
      }
      paramChatMessage = str1;
    } while (com.tencent.mobileqq.utils.FileUtils.b(str1));
    if ((!TextUtils.isEmpty(str1)) && (com.tencent.mobileqq.utils.FileUtils.b(str2))) {
      return str2;
    }
    return "";
  }
  
  public static String a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      paramFileManagerEntity = "";
    }
    for (;;)
    {
      return paramFileManagerEntity;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("FileManagerEntity info, ");
        localStringBuilder.append("], nSessionId[");
        localStringBuilder.append(paramFileManagerEntity.nSessionId);
        localStringBuilder.append("], fileName[");
        localStringBuilder.append(paramFileManagerEntity.fileName);
        localStringBuilder.append("], cloudType[");
        localStringBuilder.append(paramFileManagerEntity.getCloudType());
        localStringBuilder.append("], uniseq[");
        localStringBuilder.append(paramFileManagerEntity.uniseq);
        localStringBuilder.append("], nRelatedSessionId[");
        localStringBuilder.append(paramFileManagerEntity.nRelatedSessionId);
        localStringBuilder.append("], bDelInAio[");
        localStringBuilder.append(paramFileManagerEntity.bDelInAio);
        localStringBuilder.append("], bDelInFM[");
        localStringBuilder.append(paramFileManagerEntity.bDelInFM);
        localStringBuilder.append("], fileSize[");
        localStringBuilder.append(paramFileManagerEntity.fileSize);
        localStringBuilder.append("], fProgress[");
        localStringBuilder.append(paramFileManagerEntity.fProgress);
        localStringBuilder.append("], lastTime[");
        localStringBuilder.append(paramFileManagerEntity.lastTime);
        localStringBuilder.append("], msgSeq[");
        localStringBuilder.append(paramFileManagerEntity.msgSeq);
        localStringBuilder.append("], msgUid[");
        localStringBuilder.append(paramFileManagerEntity.msgUid);
        localStringBuilder.append("], msgTime[");
        localStringBuilder.append(paramFileManagerEntity.msgTime);
        localStringBuilder.append("], nFileType[");
        localStringBuilder.append(paramFileManagerEntity.nFileType);
        localStringBuilder.append("], nOpType[");
        localStringBuilder.append(paramFileManagerEntity.nOpType);
        localStringBuilder.append("], nWeiYunSrcType[");
        localStringBuilder.append(paramFileManagerEntity.nWeiYunSrcType);
        localStringBuilder.append("], peerNick[");
        localStringBuilder.append(paramFileManagerEntity.peerNick);
        localStringBuilder.append("], peerType[");
        localStringBuilder.append(paramFileManagerEntity.peerType);
        localStringBuilder.append("], peerUin[");
        localStringBuilder.append(e(paramFileManagerEntity.peerUin));
        localStringBuilder.append("], selfUin[");
        localStringBuilder.append(e(paramFileManagerEntity.selfUin));
        localStringBuilder.append("], srvTime[");
        localStringBuilder.append(paramFileManagerEntity.srvTime);
        localStringBuilder.append("], status[");
        localStringBuilder.append(paramFileManagerEntity.status);
        localStringBuilder.append("], strFilePath[");
        localStringBuilder.append(paramFileManagerEntity.getFilePath());
        localStringBuilder.append("], strServerPath[");
        localStringBuilder.append(paramFileManagerEntity.strServerPath);
        localStringBuilder.append("], strThumbPath[");
        localStringBuilder.append(paramFileManagerEntity.strThumbPath);
        localStringBuilder.append("], Uuid[");
        localStringBuilder.append(paramFileManagerEntity.Uuid);
        localStringBuilder.append("], WeiYunFileId[");
        localStringBuilder.append(paramFileManagerEntity.WeiYunFileId);
        localStringBuilder.append("], nOLfileSessionId[");
        localStringBuilder.append(paramFileManagerEntity.nOLfileSessionId);
        localStringBuilder.append("], strFileMd5[");
        localStringBuilder.append(paramFileManagerEntity.strFileMd5);
        localStringBuilder.append("], strFileSHA[");
        localStringBuilder.append(paramFileManagerEntity.strFileSHA);
        localStringBuilder.append("], nOLfileSessionId[");
        localStringBuilder.append(paramFileManagerEntity.nOLfileSessionId);
        localStringBuilder.append("], WeiYunDirKey[");
        localStringBuilder.append(paramFileManagerEntity.WeiYunDirKey);
        localStringBuilder.append("], _status[");
        localStringBuilder.append(paramFileManagerEntity.getStatus());
        localStringBuilder.append("], bOnceSuccess[");
        localStringBuilder.append(paramFileManagerEntity.bOnceSuccess);
        localStringBuilder.append("], imgHeight[");
        localStringBuilder.append(paramFileManagerEntity.imgHeight);
        localStringBuilder.append("], imgWidth[");
        localStringBuilder.append(paramFileManagerEntity.imgWidth);
        localStringBuilder.append("]");
        paramFileManagerEntity = localStringBuilder.toString();
      }
      finally {}
    }
  }
  
  private static String a(FileManagerEntity paramFileManagerEntity, Context paramContext, String paramString)
  {
    switch (paramFileManagerEntity.nOpType)
    {
    }
    do
    {
      return paramString;
      if ((paramFileManagerEntity.nFileType == 13) && (paramFileManagerEntity.selfUin.equals(paramFileManagerEntity.peerUin))) {
        return paramContext.getString(2131692340);
      }
      return paramContext.getString(2131692413);
      paramString = paramContext.getString(2131692379);
    } while (!paramFileManagerEntity.bSend);
    return paramContext.getString(2131692413);
  }
  
  @NotNull
  private static String a(FileManagerEntity paramFileManagerEntity, Context paramContext, String paramString, QQAppInterface paramQQAppInterface)
  {
    paramString = ((DiscussionManager)a(paramQQAppInterface, QQManagerFactory.DISCUSSION_MANAGER)).a(String.valueOf(paramFileManagerEntity.peerUin));
    if ((paramString == null) || (paramString.discussionName == null)) {
      paramString = "";
    }
    for (;;)
    {
      paramQQAppInterface = paramContext.getString(2131692341) + paramString;
      paramString = paramQQAppInterface;
      if (paramFileManagerEntity.bSend) {
        paramString = paramContext.getString(2131692343) + paramQQAppInterface;
      }
      return paramString;
      if ((paramString != null) && (paramString.discussionName != null) && (paramString.discussionName.length() > 14)) {
        paramString = paramString.discussionName;
      } else {
        paramString = paramString.discussionName;
      }
    }
  }
  
  private static String a(FileManagerEntity paramFileManagerEntity, Context paramContext, String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString1 != null)
    {
      str = paramString2;
      if (!paramString1.equals(paramContext.getString(2131692386)))
      {
        str = paramString2;
        if (!paramString1.equals(paramContext.getString(2131692380))) {
          str = paramFileManagerEntity.peerNick;
        }
      }
    }
    return str;
  }
  
  public static String a(ByteStringMicro paramByteStringMicro)
  {
    try
    {
      paramByteStringMicro = paramByteStringMicro.toByteArray();
      if (paramByteStringMicro == null) {
        return "";
      }
    }
    catch (Exception paramByteStringMicro)
    {
      paramByteStringMicro.printStackTrace();
      return "";
    }
    char[] arrayOfChar = "0123456789ABCDEF".toCharArray();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramByteStringMicro.length)
    {
      int j = paramByteStringMicro[i];
      localStringBuffer.append(arrayOfChar[(j >>> 4 & 0xF)]);
      localStringBuffer.append(arrayOfChar[(j & 0xF)]);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String a(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FMERROR", 1, "getFileName but strFilePath is null");
      }
      a();
      localObject = "";
      return localObject;
    }
    int k = paramString.length();
    int i = paramString.lastIndexOf('/');
    int j = paramString.lastIndexOf('\\');
    if (j > i) {
      i = j;
    }
    for (;;)
    {
      if (i < 0)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FileManagerUtil<FileAssistant>", 2, "filepath without / ?");
        }
        i = 0;
      }
      String str2;
      String str1;
      for (;;)
      {
        str2 = paramString.substring(i, k);
        if ((QLog.isColorLevel()) && (str2 != null) && (str2.startsWith("."))) {
          QLog.e("FileManagerUtil<FileAssistant>", 2, "InvaildName ,filePath[" + paramString + "], subName[" + str2 + "]");
        }
        for (str1 = str2; (str1 != null) && (str1.startsWith(".")); str1 = str1.replaceFirst(".", "")) {}
        i += 1;
      }
      localObject = str1;
      if (!TextUtils.isEmpty(str1)) {
        break;
      }
      localObject = "InvaildName";
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("FileManagerUtil<FileAssistant>", 2, "InvaildName ,filePath[" + paramString + "], subName[" + str2 + "]");
      return "InvaildName";
    }
  }
  
  public static String a(String paramString, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.getBytes().length < paramInt)) {
      return "";
    }
    int j = paramInt / 2;
    int i = paramInt / 4;
    char[] arrayOfChar = paramString.toCharArray();
    StringBuilder localStringBuilder1 = new StringBuilder();
    paramInt = 0;
    if (paramInt < arrayOfChar.length)
    {
      localStringBuilder1.append(arrayOfChar[paramInt]);
      if (localStringBuilder1.toString().getBytes().length <= j) {}
    }
    else
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      j = arrayOfChar.length;
      paramInt = arrayOfChar.length - 1;
      label94:
      if (paramInt <= 0) {
        break label168;
      }
      localStringBuilder2.append(arrayOfChar[paramInt]);
      if (localStringBuilder2.toString().getBytes().length <= i) {
        break label161;
      }
    }
    for (;;)
    {
      return localStringBuilder1.toString() + jdField_a_of_type_JavaLangString + paramString.substring(paramInt);
      paramInt += 1;
      break;
      label161:
      paramInt -= 1;
      break label94;
      label168:
      paramInt = j - 1;
    }
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2, FileManagerUtil.IThumbResult paramIThumbResult)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (paramIThumbResult != null) {
        paramIThumbResult.a(null);
      }
      paramString = null;
    }
    Object localObject1;
    int i;
    for (;;)
    {
      return paramString;
      localObject1 = new VFSFile(FMSettings.a().d());
      if (!((VFSFile)localObject1).exists()) {
        ((VFSFile)localObject1).mkdirs();
      }
      localObject1 = FMSettings.a().d() + a(paramString) + ".JPG";
      if (FileUtil.b((String)localObject1))
      {
        paramString = (String)localObject1;
        if (paramIThumbResult != null)
        {
          paramIThumbResult.a((String)localObject1);
          return localObject1;
        }
      }
      else
      {
        i = a(paramString);
        if (i != 0) {
          break label372;
        }
        Object localObject2 = Looper.getMainLooper();
        if (Thread.currentThread() != ((Looper)localObject2).getThread())
        {
          localObject2 = MediaStoreUtil.a(paramString, paramInt1, paramInt2);
          if (localObject2 == null)
          {
            if (paramIThumbResult != null) {
              paramIThumbResult.a(null);
            }
            return null;
          }
          try
          {
            FileUtil.a((Bitmap)localObject2, (String)localObject1);
            ((Bitmap)localObject2).recycle();
            MediaStoreUtil.a((String)localObject1, MediaStoreUtil.a(paramString));
            paramString = (String)localObject1;
            if (paramIThumbResult != null)
            {
              paramIThumbResult.a((String)localObject1);
              return localObject1;
            }
          }
          catch (FileNotFoundException paramString)
          {
            paramString.printStackTrace();
            QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail FileNotFoundException:" + paramString.getMessage());
            if (paramIThumbResult != null) {
              paramIThumbResult.a(null);
            }
            return null;
          }
          catch (IOException paramString)
          {
            paramString.printStackTrace();
            QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail IOException:" + paramString.getMessage());
            if (paramIThumbResult != null) {
              paramIThumbResult.a(null);
            }
            return null;
          }
          catch (OutOfMemoryError paramString)
          {
            paramString.printStackTrace();
            QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail OutOfMemoryError:" + paramString.getMessage());
            if (paramIThumbResult != null) {
              paramIThumbResult.a(null);
            }
            return null;
          }
        }
      }
    }
    FileManagerUtil.FileExecutor.a().execute(new FileManagerUtil.11((String)localObject1, paramIThumbResult, paramString, paramInt1, paramInt2));
    return localObject1;
    label372:
    if (i == 2)
    {
      a(paramString, true, paramInt1, paramInt2, 3, new FileManagerUtil.12(paramIThumbResult, (String)localObject1, paramString));
      return localObject1;
    }
    if (paramIThumbResult != null) {
      paramIThumbResult.a(null);
    }
    return null;
  }
  
  private static String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return "";
    }
    return paramString1 + paramString2;
  }
  
  public static String a(String paramString, boolean paramBoolean, int paramInt1, TextPaint paramTextPaint, int paramInt2)
  {
    Object localObject;
    if ((TextUtils.isEmpty(paramString)) || (paramTextPaint == null) || (paramInt1 <= 0))
    {
      localObject = "";
      return localObject;
    }
    int j;
    char[] arrayOfChar;
    int k;
    label54:
    int n;
    int m;
    if (paramInt2 > 1)
    {
      j = paramInt2;
      arrayOfChar = paramString.toCharArray();
      localObject = new StringBuilder();
      i = 0;
      k = 0;
      if (i >= arrayOfChar.length) {
        break label395;
      }
      ((StringBuilder)localObject).append(arrayOfChar[i]);
      n = i;
      m = k;
      if (paramTextPaint.measureText(((StringBuilder)localObject).toString()) <= paramInt1) {
        break label273;
      }
      n = i - 1;
      i = k + 1;
      ((StringBuilder)localObject).delete(0, ((StringBuilder)localObject).length());
      m = i;
      if (i < j) {
        break label273;
      }
    }
    label389:
    label395:
    for (int i = 1;; i = 0)
    {
      localObject = paramString;
      if (i == 0) {
        break;
      }
      if (paramBoolean)
      {
        j = 6;
        label150:
        if (paramString.length() >= j) {
          break label293;
        }
        localObject = paramString;
        label162:
        StringBuilder localStringBuilder = new StringBuilder((String)localObject);
        m = 0;
        k = 0;
        i = 0;
        label182:
        if (m >= arrayOfChar.length - j) {
          break label389;
        }
        localStringBuilder.append(arrayOfChar[m]);
        if (paramTextPaint.measureText(localStringBuilder.toString()) <= paramInt1 * paramInt2) {
          break label309;
        }
      }
      for (paramInt1 = m - 2;; paramInt1 = i)
      {
        if (paramInt1 > 0) {}
        for (;;)
        {
          if (k != 0) {
            break label364;
          }
          return paramString.substring(0, paramInt1) + jdField_a_of_type_JavaLangString + (String)localObject;
          j = 1;
          break;
          label273:
          i = n + 1;
          k = m;
          break label54;
          j = 15;
          break label150;
          label293:
          localObject = paramString.substring(paramString.length() - j);
          break label162;
          label309:
          if (paramString.substring(m, m + 1).equals(jdField_a_of_type_JavaLangString)) {
            k = 1;
          }
          if (m == arrayOfChar.length - j - 1) {
            i = m - 2;
          }
          m += 1;
          break label182;
          paramInt1 = 0;
        }
        label364:
        return paramString.substring(0, paramInt1) + (String)localObject;
      }
    }
  }
  
  public static String a(Map paramMap)
  {
    try
    {
      paramMap = new JSONObject(paramMap).toString();
      return paramMap;
    }
    catch (Exception paramMap) {}
    return null;
  }
  
  public static ArrayList<FileInfo> a(boolean paramBoolean, int paramInt)
  {
    int i = 0;
    Object localObject2 = new VFSFile(b()).listFiles();
    if (localObject2 == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject3;
    Object localObject1;
    if (i < localObject2.length)
    {
      FileInfo localFileInfo = localObject2[i];
      localObject3 = localFileInfo.getPath();
      if ((!paramBoolean) && (localFileInfo.getName().startsWith("."))) {}
      for (;;)
      {
        i += 1;
        break;
        try
        {
          localFileInfo = new FileInfo((String)localObject3);
          if (localFileInfo != null) {
            localArrayList.add(localFileInfo);
          }
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          for (;;)
          {
            localFileNotFoundException.printStackTrace();
            localObject1 = null;
          }
        }
      }
    }
    try
    {
      localObject1 = BaseApplication.getContext().getSharedPreferences("ExternalFileOfFM", 0).getAll();
      if ((localObject1 != null) && (((Map)localObject1).size() > 0))
      {
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Map.Entry)((Iterator)localObject1).next()).getKey();
          if (FileUtil.a((String)localObject2))
          {
            localObject2 = new VFSFile((String)localObject2);
            localObject3 = new FileInfo();
            ((FileInfo)localObject3).d(((VFSFile)localObject2).getName());
            ((FileInfo)localObject3).b(((VFSFile)localObject2).isDirectory());
            ((FileInfo)localObject3).e(((VFSFile)localObject2).getPath());
            ((FileInfo)localObject3).a(((VFSFile)localObject2).length());
            ((FileInfo)localObject3).b(((VFSFile)localObject2).lastModified());
            localArrayList.add(localObject3);
          }
        }
      }
      if (paramInt != 0) {
        break label291;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    Collections.sort(localArrayList, new FileUtil.MyFileCompare());
    for (;;)
    {
      return localArrayList;
      label291:
      Collections.sort(localArrayList, new FileCompare());
    }
  }
  
  public static HashMap<String, String> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    paramString = paramString.split("&");
    if ((paramString != null) && (paramString.length > 0))
    {
      int i = 0;
      while (i < paramString.length)
      {
        String[] arrayOfString = paramString[i].split("_");
        if ((arrayOfString != null) && (arrayOfString.length == 2) && (!TextUtils.isEmpty(arrayOfString[0])) && (!TextUtils.isEmpty(arrayOfString[1]))) {
          localHashMap.put(arrayOfString[0], arrayOfString[1]);
        }
        i += 1;
      }
    }
    return localHashMap;
  }
  
  public static LinkedHashMap a(String paramString)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil<FileAssistant>", 1, "jsonToMap but jsonString is null!");
      }
      return localLinkedHashMap;
    }
    Object localObject = paramString.replace("\"", "");
    paramString = (String)localObject;
    if (((String)localObject).startsWith("{")) {
      paramString = ((String)localObject).substring(1);
    }
    localObject = paramString;
    if (paramString.endsWith("}")) {
      localObject = paramString.substring(0, paramString.length() - 1);
    }
    paramString = ((String)localObject).split(",");
    int i = 0;
    if (i < paramString.length)
    {
      localObject = paramString[i].split(":");
      if (localObject.length == 1) {
        localLinkedHashMap.put(localObject[0].toLowerCase(), "");
      }
      for (;;)
      {
        i += 1;
        break;
        localLinkedHashMap.put(localObject[0].toLowerCase(), localObject[1]);
      }
    }
    return localLinkedHashMap;
  }
  
  public static List<MessageRecord> a(List<MessageRecord> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return paramList;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if (a(localMessageRecord)) {
        localArrayList.add(a((ChatMessage)localMessageRecord));
      } else {
        localArrayList.add(localMessageRecord);
      }
    }
    return localArrayList;
  }
  
  /* Error */
  @TargetApi(9)
  public static Map<String, File> a(Context paramContext)
  {
    // Byte code:
    //   0: new 42	java/util/HashMap
    //   3: dup
    //   4: bipush 10
    //   6: invokespecial 2170	java/util/HashMap:<init>	(I)V
    //   9: astore 4
    //   11: aload 4
    //   13: ldc_w 2172
    //   16: invokestatic 2178	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   19: invokeinterface 2179 3 0
    //   24: pop
    //   25: aload_0
    //   26: ldc_w 2181
    //   29: invokevirtual 2182	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   32: checkcast 2184	android/os/storage/StorageManager
    //   35: astore 5
    //   37: aload 5
    //   39: invokevirtual 2188	java/lang/Object:getClass	()Ljava/lang/Class;
    //   42: ldc_w 2190
    //   45: aconst_null
    //   46: invokevirtual 2196	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   49: aload 5
    //   51: aconst_null
    //   52: invokevirtual 2202	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   55: checkcast 2204	[Ljava/lang/String;
    //   58: checkcast 2204	[Ljava/lang/String;
    //   61: astore 5
    //   63: aload 5
    //   65: arraylength
    //   66: istore_3
    //   67: iconst_0
    //   68: istore_1
    //   69: iload_1
    //   70: iload_3
    //   71: if_icmpge +166 -> 237
    //   74: aload 5
    //   76: iload_1
    //   77: aaload
    //   78: astore 6
    //   80: new 447	java/io/File
    //   83: dup
    //   84: aload 6
    //   86: invokespecial 450	java/io/File:<init>	(Ljava/lang/String;)V
    //   89: astore 7
    //   91: getstatic 2209	android/os/Build$VERSION:SDK_INT	I
    //   94: bipush 9
    //   96: if_icmple +357 -> 453
    //   99: aload 7
    //   101: invokevirtual 2212	java/io/File:getUsableSpace	()J
    //   104: lconst_0
    //   105: lcmp
    //   106: ifgt +6 -> 112
    //   109: goto +344 -> 453
    //   112: aload 4
    //   114: invokeinterface 2214 1 0
    //   119: ifne +64 -> 183
    //   122: aload 4
    //   124: invokeinterface 2217 1 0
    //   129: invokeinterface 866 1 0
    //   134: astore 8
    //   136: aload 8
    //   138: invokeinterface 855 1 0
    //   143: ifeq +305 -> 448
    //   146: aload 4
    //   148: aload 8
    //   150: invokeinterface 859 1 0
    //   155: checkcast 22	java/lang/String
    //   158: invokeinterface 1699 2 0
    //   163: checkcast 447	java/io/File
    //   166: invokevirtual 2218	java/io/File:getPath	()Ljava/lang/String;
    //   169: aload 6
    //   171: invokevirtual 1796	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   174: iconst_1
    //   175: if_icmpne -39 -> 136
    //   178: iconst_1
    //   179: istore_2
    //   180: goto +280 -> 460
    //   183: ldc_w 337
    //   186: iconst_1
    //   187: new 339	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   194: ldc_w 2220
    //   197: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload 7
    //   202: invokevirtual 2218	java/io/File:getPath	()Ljava/lang/String;
    //   205: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokestatic 974	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: aload 4
    //   216: ldc_w 2222
    //   219: aload 7
    //   221: invokeinterface 2179 3 0
    //   226: pop
    //   227: goto +226 -> 453
    //   230: astore 5
    //   232: aload 5
    //   234: invokevirtual 2223	java/lang/IllegalArgumentException:printStackTrace	()V
    //   237: aload 4
    //   239: ldc_w 2222
    //   242: invokeinterface 2224 2 0
    //   247: ifne +111 -> 358
    //   250: aload_0
    //   251: aconst_null
    //   252: invokevirtual 2228	android/content/Context:getExternalFilesDir	(Ljava/lang/String;)Ljava/io/File;
    //   255: astore_0
    //   256: aload_0
    //   257: ifnull +144 -> 401
    //   260: ldc_w 337
    //   263: iconst_1
    //   264: new 339	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   271: ldc_w 2230
    //   274: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload_0
    //   278: invokevirtual 2218	java/io/File:getPath	()Ljava/lang/String;
    //   281: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokestatic 974	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   290: aload_0
    //   291: invokevirtual 2233	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   294: aload 4
    //   296: ldc_w 2172
    //   299: invokeinterface 1699 2 0
    //   304: checkcast 447	java/io/File
    //   307: invokevirtual 2233	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   310: invokevirtual 431	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   313: ifne +45 -> 358
    //   316: ldc_w 337
    //   319: iconst_1
    //   320: new 339	java/lang/StringBuilder
    //   323: dup
    //   324: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   327: ldc_w 2235
    //   330: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: aload_0
    //   334: invokevirtual 2218	java/io/File:getPath	()Ljava/lang/String;
    //   337: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 974	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   346: aload 4
    //   348: ldc_w 2222
    //   351: aload_0
    //   352: invokeinterface 2179 3 0
    //   357: pop
    //   358: aload 4
    //   360: areturn
    //   361: astore 5
    //   363: aload 5
    //   365: invokevirtual 2236	java/lang/IllegalAccessException:printStackTrace	()V
    //   368: goto -131 -> 237
    //   371: astore 5
    //   373: aload 5
    //   375: invokevirtual 2237	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   378: goto -141 -> 237
    //   381: astore 5
    //   383: aload 5
    //   385: invokevirtual 2238	java/lang/NoSuchMethodException:printStackTrace	()V
    //   388: goto -151 -> 237
    //   391: astore 5
    //   393: aload 5
    //   395: invokevirtual 640	java/lang/Exception:printStackTrace	()V
    //   398: goto -161 -> 237
    //   401: ldc_w 337
    //   404: iconst_1
    //   405: ldc_w 2240
    //   408: invokestatic 974	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   411: aload 4
    //   413: areturn
    //   414: astore_0
    //   415: ldc_w 337
    //   418: iconst_1
    //   419: new 339	java/lang/StringBuilder
    //   422: dup
    //   423: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   426: ldc_w 2242
    //   429: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: aload_0
    //   433: invokevirtual 440	java/lang/Exception:toString	()Ljava/lang/String;
    //   436: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokestatic 974	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   445: aload 4
    //   447: areturn
    //   448: iconst_0
    //   449: istore_2
    //   450: goto +10 -> 460
    //   453: iload_1
    //   454: iconst_1
    //   455: iadd
    //   456: istore_1
    //   457: goto -388 -> 69
    //   460: iload_2
    //   461: iconst_1
    //   462: if_icmpeq -9 -> 453
    //   465: goto -282 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	468	0	paramContext	Context
    //   68	389	1	i	int
    //   179	284	2	j	int
    //   66	6	3	k	int
    //   9	437	4	localHashMap	HashMap
    //   35	40	5	localObject	Object
    //   230	3	5	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   361	3	5	localIllegalAccessException	java.lang.IllegalAccessException
    //   371	3	5	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    //   381	3	5	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   391	3	5	localException	Exception
    //   78	92	6	str	String
    //   89	131	7	localFile	File
    //   134	15	8	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   11	67	230	java/lang/IllegalArgumentException
    //   80	109	230	java/lang/IllegalArgumentException
    //   112	136	230	java/lang/IllegalArgumentException
    //   136	178	230	java/lang/IllegalArgumentException
    //   183	227	230	java/lang/IllegalArgumentException
    //   11	67	361	java/lang/IllegalAccessException
    //   80	109	361	java/lang/IllegalAccessException
    //   112	136	361	java/lang/IllegalAccessException
    //   136	178	361	java/lang/IllegalAccessException
    //   183	227	361	java/lang/IllegalAccessException
    //   11	67	371	java/lang/reflect/InvocationTargetException
    //   80	109	371	java/lang/reflect/InvocationTargetException
    //   112	136	371	java/lang/reflect/InvocationTargetException
    //   136	178	371	java/lang/reflect/InvocationTargetException
    //   183	227	371	java/lang/reflect/InvocationTargetException
    //   11	67	381	java/lang/NoSuchMethodException
    //   80	109	381	java/lang/NoSuchMethodException
    //   112	136	381	java/lang/NoSuchMethodException
    //   136	178	381	java/lang/NoSuchMethodException
    //   183	227	381	java/lang/NoSuchMethodException
    //   11	67	391	java/lang/Exception
    //   80	109	391	java/lang/Exception
    //   112	136	391	java/lang/Exception
    //   136	178	391	java/lang/Exception
    //   183	227	391	java/lang/Exception
    //   250	256	414	java/lang/Exception
    //   260	358	414	java/lang/Exception
    //   401	411	414	java/lang/Exception
  }
  
  public static Manager a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    return paramQQAppInterface.getManager(paramInt);
  }
  
  public static void a()
  {
    ThreadManager.post(new FileManagerUtil.4(), 8, null, false);
  }
  
  public static void a(int paramInt)
  {
    FMToastUtil.a(paramInt);
  }
  
  private static void a(int paramInt, String paramString, QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    if (ResponseHandler.a(paramInt))
    {
      if (ResponseHandler.b()) {
        ResponseHandler.a(paramQQAppInterface);
      }
    }
    else {
      return;
    }
    a(paramInt, paramString, paramFileManagerEntity);
  }
  
  private static void a(int paramInt, String paramString, FileManagerEntity paramFileManagerEntity)
  {
    if (a(paramInt, paramFileManagerEntity.fileName)) {
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      c(paramString);
      return;
    }
    a(11, paramFileManagerEntity.fileName);
  }
  
  public static void a(long paramLong)
  {
    Object localObject = a();
    FileManagerEntity localFileManagerEntity = ((QQAppInterface)localObject).getFileManagerDataCenter().a(paramLong);
    if (localFileManagerEntity == null) {}
    do
    {
      return;
      switch (localFileManagerEntity.nOpType)
      {
      case -1: 
      case 0: 
      case 3: 
      case 7: 
      case 2: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      case 14: 
      case 15: 
      case 16: 
      case 17: 
      case 18: 
      case 19: 
      default: 
        return;
      case 1: 
      case 5: 
      case 8: 
        localObject = d(localFileManagerEntity.fileName);
        a((String)localObject + c(2131692387) + FMSettings.a().b());
        return;
      }
      if (localFileManagerEntity.nOpType == 6)
      {
        if (BaseActivity.sTopActivity != null)
        {
          WeiyunSaveTipsFactory.a((QQAppInterface)localObject, BaseActivity.sTopActivity, BaseActivity.sTopActivity.getTitleBarHeight());
          return;
        }
        a(BaseApplicationImpl.getContext().getString(2131697370));
        return;
      }
    } while (!ResponseHandler.a(0));
    if (BaseActivity.sTopActivity != null)
    {
      WeiyunSaveTipsFactory.a((QQAppInterface)localObject, BaseActivity.sTopActivity, BaseActivity.sTopActivity.getTitleBarHeight());
      return;
    }
    FMToastUtil.c(BaseApplicationImpl.getContext().getString(2131697370));
  }
  
  public static void a(long paramLong, int paramInt, String paramString)
  {
    QQAppInterface localQQAppInterface = a();
    FileManagerEntity localFileManagerEntity = localQQAppInterface.getFileManagerDataCenter().a(paramLong);
    if (localFileManagerEntity == null) {}
    do
    {
      return;
      switch (localFileManagerEntity.nOpType)
      {
      case 2: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      case 14: 
      case 15: 
      case 16: 
      case 17: 
      case 18: 
      case 19: 
      default: 
        return;
      }
    } while (a(paramInt, localFileManagerEntity.fileName));
    a(paramString, localFileManagerEntity);
    return;
    b(paramInt, paramString, localFileManagerEntity);
    return;
    b(paramInt, paramString, localQQAppInterface, localFileManagerEntity);
    return;
    a(paramInt, paramString, localQQAppInterface, localFileManagerEntity);
    return;
    a(paramInt, paramString, localFileManagerEntity);
    return;
    a(paramString, localFileManagerEntity);
    return;
    a(paramInt, null);
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    if ((paramString == null) || (!FileUtil.a(paramString)))
    {
      a(2131692760);
      return;
    }
    if (a(paramString) == 5)
    {
      b(paramActivity, paramString);
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800AE42", "0X800AE42", 0, 0, "", "", "", "");
    FileManagerReporter.a("0X8007152");
    WeakReference localWeakReference = new WeakReference(paramActivity);
    Bundle localBundle1 = new Bundle();
    localBundle1.putString("ChannelId", "biz_src_jc_file");
    WXShareHelper localWXShareHelper = WXShareHelper.a();
    if ((localWXShareHelper.a()) && (localWXShareHelper.d()))
    {
      Bundle localBundle2 = new Bundle();
      localBundle2.putString("name", "send_to_wx");
      localBundle2.putInt("resource_id", 2130844538);
      localBundle2.putString("value", "发送到微信");
      Bundle localBundle3 = new Bundle();
      localBundle3.putBundle("weixin", localBundle2);
      localBundle1.putBundle("extraMenu", localBundle3);
    }
    QbSdk.openFileReaderListWithQBDownload(paramActivity, paramString, localBundle1, new FileManagerUtil.6(localWeakReference, paramString, localWXShareHelper));
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity.getApplicationContext(), FMActivity.class);
    localIntent.putExtra("selectMode", true);
    localIntent.putExtra("targetUin", paramString);
    localIntent.putExtra("busiType", 1);
    localIntent.putExtra("sendprepare", paramInt1);
    localIntent.putExtra("apautocreate", paramBoolean);
    localIntent.putExtra("enterfrom", paramInt2);
    localIntent.putExtra("tab_tab_type", 5);
    localIntent.putExtra("qlinkselect", true);
    localIntent.putExtra("qfile_entrance_type_key", 20);
    paramActivity.startActivityForResult(localIntent, 106);
    paramActivity.overridePendingTransition(2130771981, 2130771982);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new Bundle();
    paramString1.putString("string_uin", paramString2);
    paramString1.putString("string_nick", paramString3);
    QQProxyForQlink.a(paramActivity, 1, paramString1);
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramActivity.getApplicationContext(), FMActivity.class);
    localIntent.putExtra("tab_tab_type", 6);
    localIntent.putExtra("from_qlink", paramBoolean);
    paramActivity.startActivityForResult(localIntent, 108);
    paramActivity.overridePendingTransition(2130771994, 2130771995);
  }
  
  public static void a(Context paramContext)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil<FileAssistant>", 2, "[QFILE] QQ - startQFile failed context=null!");
      }
      Toast.makeText(BaseApplication.getContext(), HardCodeUtil.a(2131704577), 0).show();
      return;
    }
    Intent localIntent = new Intent(paramContext, FileAssistantActivity.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("from", "FileAssistant");
    localIntent.putExtra("COMEFROMDESK", true);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    FileModel.a(paramFileManagerEntity).a(paramBoolean, paramContext, new FileManagerUtil.5(paramFileManagerEntity, paramQQAppInterface));
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (!new VFSFile(paramString).exists())
    {
      FMToastUtil.a(paramContext, 0, 2131692779);
      return;
    }
    ThreadManager.post(new FileManagerUtil.3(paramString, paramContext), 8, null, true);
  }
  
  public static void a(Context paramContext, String paramString, Bundle paramBundle)
  {
    if (a().getApp() == null)
    {
      localBundle1 = new Bundle();
      localBundle1.putString("_filename_from_dlg", paramContext.getString(2131694608));
      localBundle1.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_jc_file");
      Bundle localBundle2 = new Bundle();
      localBundle2.putAll(paramBundle);
      localBundle2.putString("big_brother_source_key", "biz_src_jc_file");
      localBundle1.putBundle("_user_data", localBundle2);
      paramBundle = new Intent("com.tencent.mobileqq.qfile_unifromdownload");
      paramBundle.putExtra("param", localBundle1);
      paramBundle.putExtra("url", paramString);
      paramContext.sendBroadcast(paramBundle);
      QLog.i("FileManagerUtil<FileAssistant>", 1, "app is null try sendBroadcast!");
      return;
    }
    Bundle localBundle1 = new Bundle();
    localBundle1.putAll(paramBundle);
    localBundle1.putString("big_brother_source_key", "biz_src_jc_file");
    b(paramContext, paramString, localBundle1);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    ShortcutManager localShortcutManager;
    if (Build.VERSION.SDK_INT >= 26)
    {
      localShortcutManager = (ShortcutManager)paramContext.getSystemService(ShortcutManager.class);
      if ((localShortcutManager != null) && (!a(paramString2, localShortcutManager))) {
        break label35;
      }
    }
    label35:
    while (!localShortcutManager.isRequestPinShortcutSupported()) {
      return;
    }
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.addCategory("android.intent.category.LAUNCHER");
    localIntent.putExtra(paramString1, true);
    localIntent.setClassName(paramContext, JumpActivity.class.getName());
    localIntent.setFlags(337641472);
    String str = "my-shortcut";
    paramString1 = str;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = str;
      if (paramString2.equals(paramContext.getString(2131693826))) {
        paramString1 = "my-dataline-shortcut";
      }
    }
    localShortcutManager.requestPinShortcut(new ShortcutInfo.Builder(paramContext, paramString1).setShortLabel(paramString2).setIcon(Icon.createWithResource(paramContext, paramInt)).setIntent(localIntent).build(), PendingIntent.getBroadcast(paramContext, 0, new Intent("com.tencent.fileassistant.createshrotcut"), 134217728).getIntentSender());
  }
  
  public static void a(ImageView paramImageView, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity.nFileType == 13)
    {
      Drawable localDrawable = BaseApplication.getContext().getResources().getDrawable(2130844531);
      try
      {
        if (paramFileManagerEntity.strThumbPath == null)
        {
          paramImageView.setImageDrawable(localDrawable);
          return;
        }
        paramImageView.setImageDrawable(URLDrawable.getDrawable(new URL(paramFileManagerEntity.strThumbPath), localDrawable, localDrawable));
        return;
      }
      catch (Exception paramFileManagerEntity)
      {
        paramImageView.setImageDrawable(localDrawable);
        return;
      }
    }
    paramFileManagerEntity = FileUtil.a(paramFileManagerEntity.fileName);
    if (paramFileManagerEntity == null)
    {
      paramImageView.setImageResource(2130844531);
      return;
    }
    paramImageView.setImageResource(b(paramFileManagerEntity));
  }
  
  public static void a(ImageView paramImageView, String paramString)
  {
    paramString = FileUtil.a(paramString);
    if (paramString == null)
    {
      paramImageView.setImageResource(2130844531);
      return;
    }
    paramImageView.setImageResource(b(paramString));
  }
  
  public static void a(TextView paramTextView)
  {
    if ((paramTextView != null) && (jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      ((Animatable)jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      paramTextView.setCompoundDrawables(null, null, null, null);
    }
  }
  
  public static void a(TextView paramTextView, FileManagerEntity paramFileManagerEntity)
  {
    if (paramTextView.getMeasuredWidth() == 0)
    {
      paramTextView.post(new FileManagerUtil.9(paramTextView, paramFileManagerEntity));
      return;
    }
    c(paramTextView, paramFileManagerEntity);
  }
  
  public static void a(com.dataline.util.widget.AsyncImageView paramAsyncImageView, DataLineMsgRecord paramDataLineMsgRecord)
  {
    String str3 = FileUtil.a(paramDataLineMsgRecord.filename);
    if (str3 == null)
    {
      paramAsyncImageView.setImageResource(2130844531);
      label20:
      return;
    }
    String str1 = paramDataLineMsgRecord.filename;
    if (a(str3) == 0) {
      if (com.tencent.mobileqq.utils.FileUtils.b(paramDataLineMsgRecord.thumbPath)) {
        paramDataLineMsgRecord = paramDataLineMsgRecord.thumbPath;
      }
    }
    for (;;)
    {
      paramAsyncImageView.setDefaultImage(b(str3));
      switch (a(str3))
      {
      default: 
        int i = b(str3);
        if (i == 0) {
          break label20;
        }
        paramAsyncImageView.setImageResource(i);
        return;
        String str2 = FilePathUtil.c(paramDataLineMsgRecord.path);
        paramDataLineMsgRecord = str2;
        if (!com.tencent.mobileqq.utils.FileUtils.b(str2)) {
          paramDataLineMsgRecord = str1;
        }
        break;
      }
    }
    paramAsyncImageView.setAsyncClipSize(128, 128);
    paramAsyncImageView.setAsyncImage(paramDataLineMsgRecord);
  }
  
  public static void a(BaseActivity paramBaseActivity, TextView paramTextView)
  {
    if ((paramTextView != null) && (jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
    {
      jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramBaseActivity.getResources().getDrawable(2130839543);
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      ((Animatable)jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    int k = ((IFMConfig)QRoute.api(IFMConfig.class)).timAIOGaryTipsCount();
    if (k == 0) {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerUtil<FileAssistant>_TimTips", 1, "aio switch is off,return!");
      }
    }
    FileManagerEntity localFileManagerEntity;
    long l;
    do
    {
      String str;
      int i;
      SharedPreferences.Editor localEditor;
      do
      {
        do
        {
          SharedPreferences localSharedPreferences;
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  str = "showTime_" + paramQQAppInterface.getCurrentAccountUin();
                  localFileManagerEntity = paramQQAppInterface.getFileManagerDataCenter().b(paramLong);
                  if (localFileManagerEntity != null) {
                    break;
                  }
                } while (!QLog.isColorLevel());
                QLog.i("FileManagerUtil<FileAssistant>_TimTips", 1, "entity is null! return");
                return;
                int j = a(localFileManagerEntity.fileName);
                if (j != -1)
                {
                  i = j;
                  if (j != 11) {}
                }
                else
                {
                  i = a(localFileManagerEntity.getFilePath());
                }
                if ((i == 3) || (i == 6)) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.i("FileManagerUtil<FileAssistant>_TimTips", 2, "File type wrong, return!");
              return;
              if ((localFileManagerEntity.peerType == 0) || (localFileManagerEntity.peerType == 3000)) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.i("FileManagerUtil<FileAssistant>_TimTips", 2, "aio[" + localFileManagerEntity.peerType + "] not buddy or disc, return!");
            return;
            localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("TimTips", 0);
            localEditor = localSharedPreferences.edit();
            i = localSharedPreferences.getInt("AIOshowTime_Total", 0);
            if (i < k) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.w("FileManagerUtil<FileAssistant>_TimTips", 2, "more then total return!");
          return;
          paramLong = localSharedPreferences.getLong(str, 0L);
          l = MessageCache.a();
          if (l - paramLong >= 86400000L) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.w("FileManagerUtil<FileAssistant>_TimTips", 2, "less OneDay return!");
        return;
        if (!PackageUtil.a(paramQQAppInterface.getApp().getBaseContext(), "com.tencent.tim")) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("FileManagerUtil<FileAssistant>_TimTips", 2, "Tim installed return!");
      return;
      new Handler(ThreadManager.getSubThreadLooper()).postDelayed(new FileManagerUtil.16(paramQQAppInterface, localFileManagerEntity), 1000L);
      localEditor.putLong(str, l);
      localEditor.putInt("AIOshowTime_Total", i + 1);
      localEditor.commit();
    } while (!QLog.isColorLevel());
    QLog.i("FileManagerUtil<FileAssistant>_TimTips", 1, "lastShowTime[" + l + "],[" + e(localFileManagerEntity.peerUin) + "]add new aiograyTips!");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, long paramLong4, long paramLong5, int paramInt, String paramString6)
  {
    a(paramQQAppInterface, paramLong1, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5, paramLong3, paramLong4, paramLong5, paramInt, paramString6, new Bundle());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, long paramLong4, long paramLong5, int paramInt, String paramString6, Bundle paramBundle)
  {
    HashMap localHashMap = new HashMap();
    String str2 = "";
    if (paramLong2 < 0L) {
      paramLong2 = 0L;
    }
    for (;;)
    {
      String str1 = str2;
      if (paramString2 != null) {
        str1 = str2;
      }
      try
      {
        if (paramString2.length() > 0) {
          str1 = paramString2.substring(paramString2.indexOf("://") + 3, paramString2.lastIndexOf(":"));
        }
        paramString2 = str1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int n;
          float f;
          int j;
          int i;
          int i1;
          int i2;
          continue;
          int k = 0;
          int m = 0;
          continue;
          long l2 = 0L;
          continue;
          long l1 = paramLong2;
        }
      }
      n = a();
      localHashMap.put("serverip", paramString2);
      localHashMap.put("param_Server", paramString2);
      localHashMap.put("param_ftnIP", paramString2);
      localHashMap.put("param_PeerUin", paramString3);
      localHashMap.put("param_uuid", paramString4);
      localHashMap.put("param_MD5", paramString5);
      localHashMap.put("param_fsized", String.valueOf(paramLong4));
      localHashMap.put("param_fsizeo", String.valueOf(paramLong5));
      localHashMap.put("param_retry", String.valueOf(paramInt));
      localHashMap.put("param_nSessionId", String.valueOf(paramLong1));
      localHashMap.put("param_errMsg", String.valueOf(paramString6));
      localHashMap.put("param_ipStackType", String.valueOf(n));
      localHashMap.put("param_realTransferType", String.valueOf(0));
      if (paramBundle != null)
      {
        l1 = paramBundle.getLong("param_transferTime", -1L);
        if (l1 >= 0L) {
          if ((l1 > 0L) && (paramLong3 >= 1024L))
          {
            f = (float)l1 / 1000.0F;
            l2 = ((float)paramLong3 / f);
            localHashMap.put("param_speed", String.valueOf(l2));
            j = 0;
            i = 0;
            i1 = b();
            i2 = c();
            if (paramBundle != null)
            {
              m = paramBundle.getInt("param_fromType", 0);
              j = paramBundle.getInt("param_V6SelectType", 0);
              i = paramBundle.getInt("param_ipAddrType", 0);
              k = paramBundle.getInt("param_ishttps", 0);
              localHashMap.put("param_fromType", String.valueOf(m));
              localHashMap.put("param_V6SelectType", String.valueOf(j));
              localHashMap.put("param_ipAddrType", String.valueOf(i));
              localHashMap.put("param_stackType", String.valueOf(i1));
              localHashMap.put("param_loginType", String.valueOf(i2));
              localHashMap.put("param_ishttps", String.valueOf(k));
              StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), paramString1, true, paramLong2, paramLong3, localHashMap, paramString6);
              if (QLog.isColorLevel()) {
                QLog.d("@@@@@@@", 2, "ReportFilemanagerInfo actType[" + paramString1 + "], isSuccess[" + true + "], nSessionId[" + paramLong1 + "], duration[" + paramLong2 + "], rpSize[" + paramLong3 + "], transfSize[" + paramLong4 + "], fileSize[" + paramLong5 + "], retryTimes[" + paramInt + "], reserved[" + paramString6 + "], ipStackType[" + n + "] realTransferType[" + 0 + "] speed[" + l2 + "] fromType[" + m + "] transferTime[" + l1 + "] isHttps[" + k + "]");
              }
              return;
            }
          }
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, String paramString6, long paramLong4, long paramLong5, long paramLong6, String paramString7, String paramString8, int paramInt, String paramString9, String paramString10)
  {
    a(paramQQAppInterface, paramLong1, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5, paramLong3, paramString6, paramLong4, paramLong5, paramLong6, paramString7, paramString8, paramInt, paramString9, paramString10, new Bundle());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, String paramString6, long paramLong4, long paramLong5, long paramLong6, String paramString7, String paramString8, int paramInt, String paramString9, String paramString10, Bundle paramBundle)
  {
    long l1 = paramLong2;
    if (paramLong2 == 0L) {
      l1 = System.currentTimeMillis();
    }
    if (l1 < 1L) {
      paramLong2 = 0L;
    }
    for (;;)
    {
      String str3 = "";
      String str1 = str3;
      if (paramString2 != null) {
        str1 = str3;
      }
      try
      {
        if (paramString2.length() > 0) {
          str1 = paramString2.substring(paramString2.indexOf("://") + 3, paramString2.lastIndexOf(":"));
        }
        if (paramLong2 < 0L)
        {
          paramLong2 = 0L;
          int j = 0;
          int i = j;
          if (paramString9 != null)
          {
            i = j;
            if (paramString9.length() > 0)
            {
              if (paramString9.indexOf("Network is unreachable") <= 0) {
                break label968;
              }
              i = 1;
            }
          }
          for (;;)
          {
            if (NetworkUtil.d(BaseApplication.getContext()))
            {
              paramString2 = paramString9;
              if (i == 0) {}
            }
            else
            {
              paramLong3 = 9004L;
              paramString2 = paramString9 + "_NotNetWork";
            }
            paramString9 = paramString2;
            if (!paramQQAppInterface.isLogin())
            {
              paramLong3 = 9004L;
              paramString9 = paramString2 + "_NotLogin";
            }
            int n = a();
            paramString2 = new HashMap();
            paramString2.put("serverip", str1);
            paramString2.put("param_Server", str1);
            paramString2.put("param_ftnIP", str1);
            paramString2.put("param_PeerUin", String.valueOf(paramString3));
            paramString2.put("param_uuid", String.valueOf(paramString4));
            paramString2.put("param_MD5", paramString5);
            paramString2.put("param_FailCode", Long.toString(paramLong3));
            paramString2.put("param_errorDesc", String.valueOf(paramString6));
            paramString2.put("param_fsized", String.valueOf(paramLong5));
            paramString2.put("param_fsizeo", String.valueOf(paramLong6));
            paramString2.put("param_url", String.valueOf(paramString7));
            paramString2.put("param_rspHeader", String.valueOf(paramString8));
            paramString2.put("param_retry", String.valueOf(paramInt));
            paramString2.put("param_errMsg", paramString9 + "uin[" + paramQQAppInterface.getCurrentAccountUin() + "]");
            paramString2.put("param_nSessionId", String.valueOf(paramLong1));
            paramString2.put("param_ipStackType", String.valueOf(n));
            paramString2.put("param_realTransferType", String.valueOf(0));
            if (paramBundle == null) {
              break label1030;
            }
            l2 = paramBundle.getLong("param_transferTime", -1L);
            if (l2 < 0L) {
              break label1030;
            }
            if ((l2 <= 0L) || (paramLong4 < 1024L)) {
              break label1024;
            }
            float f = (float)l2 / 1000.0F;
            l3 = ((float)paramLong4 / f);
            paramString2.put("param_speed", String.valueOf(l3));
            j = 0;
            i = 0;
            int i1 = b();
            int i2 = c();
            if (paramBundle == null) {
              break label1015;
            }
            m = paramBundle.getInt("param_fromType", 0);
            j = paramBundle.getInt("param_V6SelectType", 0);
            i = paramBundle.getInt("param_ipAddrType", 0);
            k = paramBundle.getInt("param_ishttps", 0);
            paramString2.put("param_fromType", String.valueOf(m));
            paramString2.put("param_V6SelectType", String.valueOf(j));
            paramString2.put("param_ipAddrType", String.valueOf(i));
            paramString2.put("param_stackType", String.valueOf(i1));
            paramString2.put("param_loginType", String.valueOf(i2));
            paramString2.put("param_ishttps", String.valueOf(k));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), paramString1, false, paramLong2, paramLong4, paramString2, paramString10);
            if (QLog.isColorLevel()) {
              QLog.d("@@@@@@@", 2, "ReportFilemanagerInfo actType[" + paramString1 + "], isSuccess[" + false + "], nSessionId[" + paramLong1 + "], param_FailCode[" + paramLong3 + "], startTime[" + l1 + "], duration[" + paramLong2 + "], rpSize[" + paramLong4 + "], transfSize[" + paramLong5 + "], fileSize[" + paramLong6 + "], param_errorDesc[" + paramString6 + "], retryTimes[" + paramInt + "], reserved[" + paramString10 + "], ipStackType[" + n + "] realTransferType[" + 0 + "] speed[" + l3 + "], errMsg[" + paramString9 + "] fromType[" + m + "] transferTime[" + l2 + "] isHttps[" + k + "]");
            }
            return;
            paramLong2 = System.currentTimeMillis() - l1;
            break;
            label968:
            if (paramString9.indexOf("No route to host") > 0)
            {
              i = 1;
            }
            else
            {
              i = j;
              if (paramString9.indexOf("MalformedURLException") > 0) {
                i = 1;
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String str2 = paramString2;
          continue;
          label1015:
          int k = 0;
          int m = 0;
          continue;
          label1024:
          long l3 = 0L;
          continue;
          label1030:
          long l2 = paramLong2;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), paramContext);
  }
  
  public static void a(@NonNull QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    ThreadManager.post(new FileManagerUtil.18(paramContext, paramInt, paramString1, paramQQAppInterface, paramString2), 2, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, Context paramContext)
  {
    if (paramChatMessage == null) {}
    while (!(paramChatMessage instanceof MessageForFile)) {
      return;
    }
    QFileUtils.a(paramQQAppInterface, paramContext, a(paramQQAppInterface, (MessageForFile)paramChatMessage));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage1, ChatMessage paramChatMessage2)
  {
    QFileUtils.a(paramQQAppInterface, paramChatMessage1, paramChatMessage2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    label316:
    label318:
    label329:
    label473:
    do
    {
      do
      {
        int j;
        do
        {
          do
          {
            do
            {
              for (;;)
              {
                return;
                FriendsManager localFriendsManager = (FriendsManager)a(paramQQAppInterface, QQManagerFactory.FRIENDS_MANAGER);
                Object localObject = paramFileManagerEntity.peerUin;
                if (paramFileManagerEntity.peerType == 3000) {
                  localObject = paramFileManagerEntity.selfUin;
                }
                localObject = localFriendsManager.e((String)localObject);
                int i = -1;
                if (localObject != null) {
                  i = ((Friends)localObject).iTermType;
                }
                j = a(paramFileManagerEntity.fileName);
                if (j == 0) {
                  QLog.i("FileManagerUtil<FileAssistant>", 1, "PreloadThumb Id[" + paramFileManagerEntity.nSessionId + "] PicFile, from device[" + i + "] size(wh)[" + paramFileManagerEntity.imgWidth + ":" + paramFileManagerEntity.imgHeight + "]");
                }
                for (;;)
                {
                  if ((!c()) && (a())) {
                    break label316;
                  }
                  if (j != 0) {
                    break label473;
                  }
                  if (!FilePicURLDrawlableHelper.a(paramFileManagerEntity)) {
                    break label329;
                  }
                  paramFileManagerEntity.strThumbPath = a(paramQQAppInterface).a(paramFileManagerEntity, 7);
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.i("FileManagerUtil<FileAssistant>", 1, "PreloadThumb Id[" + paramFileManagerEntity.nSessionId + "] is badPic Preload 750 Thumb[" + paramFileManagerEntity.strThumbPath + "]");
                  return;
                  if (j != 2) {
                    break label318;
                  }
                  QLog.i("FileManagerUtil<FileAssistant>", 1, "PreloadThumb Id[" + paramFileManagerEntity.nSessionId + "] VideoFile, from device[" + i + "] Preload VideoThumb size(wh)[" + paramFileManagerEntity.imgWidth + ":" + paramFileManagerEntity.imgHeight + "]");
                }
              }
              QLog.i("FileManagerUtil<FileAssistant>", 1, "not pic or video!");
              return;
              paramFileManagerEntity.strThumbPath = a(paramQQAppInterface).a(paramFileManagerEntity, 5);
              if (QLog.isColorLevel()) {
                QLog.i("FileManagerUtil<FileAssistant>", 1, "PreloadThumb Id[" + paramFileManagerEntity.nSessionId + "] Preload 384 Thumb[" + paramFileManagerEntity.strThumbPath + "]");
              }
            } while (a());
            paramFileManagerEntity.strThumbPath = a(paramQQAppInterface).a(paramFileManagerEntity, 7);
          } while (!QLog.isColorLevel());
          QLog.i("FileManagerUtil<FileAssistant>", 1, "PreloadThumb Id[" + paramFileManagerEntity.nSessionId + "] is Wi-Fi Preload 750 Thumb[" + paramFileManagerEntity.strThumbPath + "]");
          return;
        } while (j != 2);
        if (paramFileManagerEntity.peerType != 3000) {
          break;
        }
        paramQQAppInterface = a(paramQQAppInterface).b(paramFileManagerEntity);
      } while (paramQQAppInterface == null);
      paramFileManagerEntity.strLargeThumPath = paramQQAppInterface;
      return;
      paramQQAppInterface = a(paramQQAppInterface).a(paramFileManagerEntity);
    } while (paramQQAppInterface == null);
    paramFileManagerEntity.strLargeThumPath = paramQQAppInterface;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity, ChatMessage paramChatMessage)
  {
    QFileUtils.a(paramQQAppInterface, paramFileManagerEntity, paramChatMessage);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString, Context paramContext)
  {
    int i = StatisticAssist.a(paramContext, paramString, "Stop_download_2-1_3-1");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, i, 0, "1", "1", null, null);
    }
    i = StatisticAssist.a(paramContext, paramString, "Stop_download_2-1_3-0");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, i, 0, "1", "0", null, null);
    }
    i = StatisticAssist.a(paramContext, paramString, "Stop_download_2-2_3-1");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, i, 0, "2", "1", null, null);
    }
    i = StatisticAssist.a(paramContext, paramString, "Stop_download_2-2_3-0");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, i, 0, "2", "0", null, null);
    }
    i = StatisticAssist.a(paramContext, paramString, "Start_download_2-0_3-1");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Start_download", 1, i, 0, "0", "1", null, null);
    }
    i = StatisticAssist.a(paramContext, paramString, "Start_download_2-0_3-0");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Start_download", 1, i, 0, "0", "0", null, null);
    }
    i = StatisticAssist.a(paramContext, paramString, "Start_download_2-3_3-1");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Start_download", 1, i, 0, "3", "1", null, null);
    }
    i = StatisticAssist.a(paramContext, paramString, "Start_download_2-3_3-0");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Start_download", 1, i, 0, "3", "0", null, null);
    }
    i = StatisticAssist.a(paramContext, paramString, "Complete_download_2_1");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Complete_download", 1, i, 0, "0", "1", null, null);
    }
    i = StatisticAssist.a(paramContext, paramString, "Stop_download_2-0_3-1");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, i, 0, "0", "1", null, null);
    }
    i = StatisticAssist.a(paramContext, paramString, "Complete_download_2_0");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Complete_download", 1, i, 0, "0", null, null, null);
    }
    i = StatisticAssist.a(paramContext, paramString, "Stop_download_2-0_3-0");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, i, 0, "0", "0", null, null);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    ThreadManager.post(new FileManagerUtil.17(paramString2, paramQQAppInterface, paramInt, paramString1), 8, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil<FileAssistant>", 2, a());
      }
      return;
    }
    int i = (int)a(paramFileManagerEntity.peerType);
    QLog.i("FileManagerUtil<FileAssistant>", 2, "=_= Id[" + paramFileManagerEntity.nSessionId + "],setTempParam[" + i + "]");
    paramFileManagerEntity.tmpSessionType = i;
    paramFileManagerEntity.tmpSessionSig = a(paramQQAppInterface, paramFileManagerEntity.peerUin, i);
    switch (i)
    {
    case 103: 
    default: 
      return;
    case 102: 
      paramFileManagerEntity.tmpSessionFromPhone = paramString1;
      paramFileManagerEntity.tmpSessionToPhone = paramString2;
      return;
    }
    paramFileManagerEntity.tmpSessionRelatedUin = paramString1;
  }
  
  public static void a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      return;
    }
    Object localObject;
    if ((paramChatMessage instanceof MessageForFile))
    {
      localObject = (MessageForFile)paramChatMessage;
      ((MessageForFile)localObject).uniseq = 0L;
      ((MessageForFile)localObject).msgseq = 0L;
      ((MessageForFile)localObject).fileName = "";
      ((MessageForFile)localObject).fileSize = 0L;
    }
    for (;;)
    {
      paramChatMessage.extStr = null;
      return;
      if ((paramChatMessage instanceof MessageForTroopFile))
      {
        localObject = (MessageForTroopFile)paramChatMessage;
        ((MessageForTroopFile)localObject).uniseq = 0L;
        ((MessageForTroopFile)localObject).msgseq = 0L;
        ((MessageForTroopFile)localObject).url = "";
        ((MessageForTroopFile)localObject).uuid = "";
        ((MessageForTroopFile)localObject).bisID = 0;
        ((MessageForTroopFile)localObject).fileName = "";
        ((MessageForTroopFile)localObject).fileSize = 0L;
        ((MessageForTroopFile)localObject).width = 0;
        ((MessageForTroopFile)localObject).height = 0;
        ((MessageForTroopFile)localObject).duration = 0;
      }
    }
  }
  
  public static void a(ChatMessage paramChatMessage, MessageForFile paramMessageForFile)
  {
    paramMessageForFile.uniseq = paramChatMessage.uniseq;
    paramMessageForFile.msgseq = paramChatMessage.msgseq;
    paramMessageForFile.fileName = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileName");
    String str1 = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSize");
    if (!TextUtils.isEmpty(str1)) {
      paramMessageForFile.fileSize = Long.parseLong(str1);
    }
    str1 = paramChatMessage.getExtInfoFromExtStr("outest_uin");
    String str2 = paramChatMessage.getExtInfoFromExtStr("outest_uintype");
    paramChatMessage = paramChatMessage.getExtInfoFromExtStr("outest_uniseq");
    if (!TextUtils.isEmpty(str1)) {
      paramMessageForFile.saveExtInfoToExtStr("outest_uin", str1);
    }
    if (!TextUtils.isEmpty(str2)) {
      paramMessageForFile.saveExtInfoToExtStr("outest_uintype", str2);
    }
    if (!TextUtils.isEmpty(paramChatMessage)) {
      paramMessageForFile.saveExtInfoToExtStr("outest_uniseq", paramChatMessage);
    }
  }
  
  public static void a(ChatMessage paramChatMessage, MessageForTroopFile paramMessageForTroopFile)
  {
    paramMessageForTroopFile.uniseq = paramChatMessage.uniseq;
    paramMessageForTroopFile.msgseq = paramChatMessage.msgseq;
    paramMessageForTroopFile.url = paramChatMessage.getExtInfoFromExtStr("_m_ForwardUuid");
    paramMessageForTroopFile.uuid = UUID.nameUUIDFromBytes(paramMessageForTroopFile.url.getBytes()).toString();
    String str1 = paramChatMessage.getExtInfoFromExtStr("_m_ForwardBusType");
    if (!TextUtils.isEmpty(str1)) {
      paramMessageForTroopFile.bisID = Integer.parseInt(str1);
    }
    paramMessageForTroopFile.fileName = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileName");
    str1 = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSize");
    if (!TextUtils.isEmpty(str1)) {
      paramMessageForTroopFile.fileSize = Long.parseLong(str1);
    }
    str1 = paramChatMessage.getExtInfoFromExtStr("_m_ForwardImgWidth");
    String str2 = paramChatMessage.getExtInfoFromExtStr("_m_ForwardImgHeight");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      paramMessageForTroopFile.width = Integer.parseInt(str1);
      paramMessageForTroopFile.height = Integer.parseInt(str2);
    }
    str1 = paramChatMessage.getExtInfoFromExtStr("_m_ForwardDuration");
    if (!TextUtils.isEmpty(str1)) {
      paramMessageForTroopFile.duration = Integer.parseInt(str1);
    }
    str1 = paramChatMessage.getExtInfoFromExtStr("outest_uin");
    str2 = paramChatMessage.getExtInfoFromExtStr("outest_uintype");
    paramChatMessage = paramChatMessage.getExtInfoFromExtStr("outest_uniseq");
    if (!TextUtils.isEmpty(str1)) {
      paramMessageForTroopFile.saveExtInfoToExtStr("outest_uin", str1);
    }
    if (!TextUtils.isEmpty(str2)) {
      paramMessageForTroopFile.saveExtInfoToExtStr("outest_uintype", str2);
    }
    if (!TextUtils.isEmpty(paramChatMessage)) {
      paramMessageForTroopFile.saveExtInfoToExtStr("outest_uniseq", paramChatMessage);
    }
  }
  
  public static void a(BaseFileAssistantActivity paramBaseFileAssistantActivity)
  {
    Object localObject = a();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil<FileAssistant>", 2, "none select!why you can preview!");
      }
      return;
    }
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.b(((FileManagerEntity)localObject).nSessionId);
    localForwardFileInfo.d(3);
    localForwardFileInfo.b(10007);
    localObject = new Intent(paramBaseFileAssistantActivity, FileBrowserActivity.class);
    ((Intent)localObject).putExtra("FromEditBarPreview", true);
    ((Intent)localObject).putExtra("fileinfo", localForwardFileInfo);
    ((Intent)localObject).putExtra("from_qlink_enter_recent", paramBaseFileAssistantActivity.g());
    paramBaseFileAssistantActivity.startActivityForResult((Intent)localObject, 102);
  }
  
  public static void a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      QLog.w("FileManagerUtil<FileAssistant>", 1, "entity null!");
    }
    String str;
    do
    {
      do
      {
        return;
        if (!paramFileManagerEntity.isCheckPrivateDir)
        {
          paramFileManagerEntity.isCheckPrivateDir = true;
          str = paramFileManagerEntity.getFilePath();
          if ((str != null) && (str.contains("/Tencent/QQfile_recv/"))) {
            paramFileManagerEntity.setFilePath(VFSAssistantUtils.getSDKPrivatePath(paramFileManagerEntity.getFilePath()));
          }
          str = paramFileManagerEntity.strThumbPath;
          if ((str != null) && (str.contains("/Tencent/QQfile_recv/"))) {
            paramFileManagerEntity.strThumbPath = VFSAssistantUtils.getSDKPrivatePath(paramFileManagerEntity.strThumbPath);
          }
          str = paramFileManagerEntity.strMiddleThumPath;
          if ((str != null) && (str.contains("/Tencent/QQfile_recv/"))) {
            paramFileManagerEntity.strMiddleThumPath = VFSAssistantUtils.getSDKPrivatePath(paramFileManagerEntity.strMiddleThumPath);
          }
          str = paramFileManagerEntity.strLargeThumPath;
          if ((str != null) && (str.contains("/Tencent/QQfile_recv/"))) {
            paramFileManagerEntity.strLargeThumPath = VFSAssistantUtils.getSDKPrivatePath(paramFileManagerEntity.strLargeThumPath);
          }
        }
      } while ((paramFileManagerEntity.nFileType != -1) && (paramFileManagerEntity.nFileType != 5));
      str = paramFileManagerEntity.getFilePath();
      if (str == null) {
        break;
      }
      paramFileManagerEntity.nFileType = a(str);
    } while (!str.startsWith(AppConstants.SDCARD_PATH + "/Android/data/com.tencent.mobileqq"));
    paramFileManagerEntity.setFilePath(VFSAssistantUtils.getSDKPrivatePath(paramFileManagerEntity.getFilePath()));
    return;
    if ((paramFileManagerEntity.getCloudType() == 3) || (paramFileManagerEntity.getCloudType() == 5))
    {
      paramFileManagerEntity.nFileType = a(paramFileManagerEntity.fileName);
      return;
    }
    if ((paramFileManagerEntity.strSrcName != null) && (paramFileManagerEntity.strSrcName.length() > 0))
    {
      paramFileManagerEntity.nFileType = a(paramFileManagerEntity.strSrcName);
      return;
    }
    paramFileManagerEntity.nFileType = a(paramFileManagerEntity.fileName);
  }
  
  public static void a(FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.status = 2;
    paramQQAppInterface.getFileManagerDataCenter().d(localFileManagerEntity);
    paramQQAppInterface = a(localFileManagerEntity);
    paramQQAppInterface.b(paramInt);
    paramFileManagerEntity = new Bundle();
    paramFileManagerEntity.putInt("forward_type", 0);
    paramFileManagerEntity.putParcelable("fileinfo", paramQQAppInterface);
    paramFileManagerEntity.putBoolean("not_forward", true);
    paramQQAppInterface = new Intent();
    paramQQAppInterface.putExtras(paramFileManagerEntity);
    paramQQAppInterface.putExtra("destroy_last_activity", true);
    paramQQAppInterface.putExtra("forward_type", 0);
    paramQQAppInterface.putExtra("forward_filepath", localFileManagerEntity.getFilePath());
    paramQQAppInterface.putExtra("forward_text", d(2131704567) + d(localFileManagerEntity.fileName) + d(2131704560) + FileUtil.a(localFileManagerEntity.fileSize) + "。");
    paramQQAppInterface.putExtra("k_favorites", d(localFileManagerEntity));
    ForwardBaseOption.a(paramActivity, paramQQAppInterface, 103);
  }
  
  public static void a(FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface, FileManagerUtil.CheckResult paramCheckResult)
  {
    FileManagerUtil.FileExecutor.a().execute(new FileManagerUtil.21(paramFileManagerEntity, paramCheckResult, paramQQAppInterface));
  }
  
  public static void a(com.tencent.mobileqq.filemanager.widget.AsyncImageView paramAsyncImageView, FileManagerEntity paramFileManagerEntity)
  {
    a(paramFileManagerEntity);
    String str = paramFileManagerEntity.getFilePath();
    if (paramFileManagerEntity.nFileType == 0) {
      if (com.tencent.mobileqq.utils.FileUtils.b(paramFileManagerEntity.strMiddleThumPath)) {
        str = paramFileManagerEntity.strMiddleThumPath;
      }
    }
    for (;;)
    {
      a(paramAsyncImageView, str, paramFileManagerEntity.nFileType);
      return;
      if (com.tencent.mobileqq.utils.FileUtils.b(paramFileManagerEntity.strLargeThumPath))
      {
        str = paramFileManagerEntity.strLargeThumPath;
      }
      else if (com.tencent.mobileqq.utils.FileUtils.b(paramFileManagerEntity.getFilePath()))
      {
        str = paramFileManagerEntity.getFilePath();
        ThreadManager.executeOnSubThread(new FileManagerUtil.1(paramFileManagerEntity));
        continue;
        if (paramFileManagerEntity.nFileType == 2)
        {
          if (com.tencent.mobileqq.utils.FileUtils.b(paramFileManagerEntity.strLargeThumPath)) {
            str = paramFileManagerEntity.strLargeThumPath;
          } else if (com.tencent.mobileqq.utils.FileUtils.b(paramFileManagerEntity.strMiddleThumPath)) {
            str = paramFileManagerEntity.strMiddleThumPath;
          } else {
            str = null;
          }
        }
        else if (paramFileManagerEntity.nFileType == 13) {
          str = TeamWorkUtils.f(paramFileManagerEntity.Uuid);
        }
      }
    }
  }
  
  public static void a(com.tencent.mobileqq.filemanager.widget.AsyncImageView paramAsyncImageView, String paramString)
  {
    int i = a(paramString);
    try
    {
      paramAsyncImageView.setImageResource(a(i));
      return;
    }
    catch (Exception paramAsyncImageView)
    {
      paramAsyncImageView.printStackTrace();
    }
  }
  
  public static void a(com.tencent.mobileqq.filemanager.widget.AsyncImageView paramAsyncImageView, String paramString, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramAsyncImageView.setDefaultImage(a(paramInt));
    case 0: 
    case 5: 
    case 2: 
      do
      {
        do
        {
          return;
          paramAsyncImageView.setDefaultImage(2130844458);
          paramAsyncImageView.setAsyncImage(paramString);
          return;
          paramAsyncImageView.setDefaultImage(2130844419);
        } while (!FileUtil.b(paramString));
        paramAsyncImageView.setApkIconAsyncImage(paramString);
        return;
        paramAsyncImageView.setDefaultImage(2130844532);
      } while (!FileUtil.b(paramString));
      try
      {
        paramAsyncImageView.setAsyncImage(paramString);
        return;
      }
      catch (Exception paramAsyncImageView)
      {
        paramAsyncImageView.printStackTrace();
        return;
      }
    }
    paramAsyncImageView.setDefaultImage(2130844531);
    paramAsyncImageView.setUrlIconAsyncImage(paramString);
  }
  
  public static void a(com.tencent.mobileqq.filemanager.widget.AsyncImageView paramAsyncImageView, String paramString, boolean paramBoolean)
  {
    String str = FileUtil.a(paramString);
    if (str == null) {
      paramAsyncImageView.setImageResource(2130844531);
    }
    do
    {
      return;
      paramAsyncImageView.setImageResource(b(paramString));
    } while (!paramBoolean);
    switch (a(str))
    {
    case 1: 
    default: 
      return;
    case 0: 
      paramAsyncImageView.setDefaultImage(2130844458);
      paramAsyncImageView.setAsyncImage(paramString);
      return;
    }
    paramAsyncImageView.setDefaultImage(2130844532);
    paramAsyncImageView.setAsyncImage(paramString);
  }
  
  public static void a(String paramString)
  {
    FMToastUtil.c(paramString);
  }
  
  public static void a(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0);
    paramString = "qlink_new_count_" + paramString;
    localSharedPreferences.edit().putInt(paramString, paramInt).commit();
  }
  
  private static void a(String paramString, FileManagerEntity paramFileManagerEntity)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      c(paramString);
      return;
    }
    a(13, paramFileManagerEntity.fileName);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0);
    paramString1 = "qlink_new_flag_" + paramString1 + "_" + paramString2;
    localSharedPreferences.edit().putBoolean(paramString1, paramBoolean).commit();
  }
  
  @TargetApi(10)
  public static void a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, FileManagerUtil.IGetVideoCallback paramIGetVideoCallback)
  {
    ThreadManager.post(new FileManagerUtil.13(paramString, paramInt3, paramBoolean, paramIGetVideoCallback, paramInt1, paramInt2), 8, null, true);
  }
  
  public static void a(List<FileManagerEntity> paramList, Activity paramActivity)
  {
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      long l1 = 0L;
      do
      {
        l2 = l1;
        if (!paramList.hasNext()) {
          break;
        }
        localObject = (FileManagerEntity)paramList.next();
      } while (((FileManagerEntity)localObject).sendCloudUnsuccessful());
      ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.b(10001);
      localForwardFileInfo.d(((FileManagerEntity)localObject).getCloudType());
      localForwardFileInfo.b(((FileManagerEntity)localObject).nSessionId);
      localForwardFileInfo.d(((FileManagerEntity)localObject).fileName);
      localForwardFileInfo.c(((FileManagerEntity)localObject).uniseq);
      localForwardFileInfo.c(((FileManagerEntity)localObject).WeiYunFileId);
      localForwardFileInfo.d(((FileManagerEntity)localObject).fileSize);
      localForwardFileInfo.a(((FileManagerEntity)localObject).getFilePath());
      localForwardFileInfo.b(((FileManagerEntity)localObject).Uuid);
      localForwardFileInfo.jdField_a_of_type_Int = ForwardOrderManager.a().a();
      if ((((FileManagerEntity)localObject).getCloudType() == 3) && (((FileManagerEntity)localObject).getFilePath() != null) && (((FileManagerEntity)localObject).getFilePath().length() > 0)) {
        localArrayList2.add(Uri.parse(((FileManagerEntity)localObject).getFilePath()));
      }
      for (;;)
      {
        l2 = localForwardFileInfo.d();
        localArrayList1.add(localForwardFileInfo);
        l1 = l2 + l1;
        break;
        localArrayList2.add(Uri.parse(""));
      }
    }
    long l2 = 0L;
    paramList = new Bundle();
    Object localObject = new Intent();
    paramList.putInt("forward_type", 0);
    paramList.putParcelableArrayList("fileinfo_array", localArrayList1);
    paramList.putBoolean("not_forward", true);
    ((Intent)localObject).putExtra("sendMultiple", true);
    paramList.putParcelableArrayList("android.intent.extra.STREAM", localArrayList2);
    ((Intent)localObject).putExtras(paramList);
    ((Intent)localObject).putExtra("foward_editbar", true);
    ((Intent)localObject).putExtra("forward_type", 0);
    paramList = d(2131704580);
    if (localArrayList1.size() == 1) {
      paramList = d(2131704562) + d(((ForwardFileInfo)localArrayList1.get(0)).d()) + d(2131704572) + FileUtil.a(((ForwardFileInfo)localArrayList1.get(0)).d()) + "。";
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("forward_text", paramList);
      ((Intent)localObject).putExtra("k_favorites", false);
      ForwardBaseOption.a(paramActivity, (Intent)localObject, 103);
      return;
      if (localArrayList1.size() > 1) {
        paramList = d(2131704556) + d(((ForwardFileInfo)localArrayList1.get(0)).d()) + d(2131704569) + localArrayList1.size() + d(2131704573) + FileUtil.a(l2) + "。";
      }
    }
  }
  
  public static void a(boolean paramBoolean, Context paramContext, FMDialogUtil.FMDialogInterface paramFMDialogInterface)
  {
    a(paramBoolean, paramContext, paramFMDialogInterface, -1);
  }
  
  public static void a(boolean paramBoolean, Context paramContext, FMDialogUtil.FMDialogInterface paramFMDialogInterface, int paramInt)
  {
    int j = 2131692614;
    int k = 2;
    if (!NetworkUtil.e(a())) {
      a(2131693237);
    }
    Object localObject;
    int i;
    boolean bool1;
    label93:
    do
    {
      return;
      if (!a())
      {
        paramFMDialogInterface.a();
        return;
      }
      localObject = (Activity)paramContext;
      if (!paramBoolean) {
        break;
      }
      i = 3;
      boolean bool2 = CUKingCardHelper.a((Activity)localObject, i, new FileManagerUtil.19(paramFMDialogInterface), "");
      bool1 = bool2;
      if (bool2)
      {
        localObject = (Activity)paramContext;
        if (!paramBoolean) {
          break label186;
        }
        i = k;
        bool1 = FreeWifiHelper.a((Activity)localObject, i, new FileManagerUtil.20(paramFMDialogInterface));
      }
    } while (!bool1);
    if ((paramInt == 0) && (KingCardProcessor.c().a.jdField_a_of_type_Boolean) && (!TMSManager.a().b()))
    {
      if (paramBoolean) {}
      for (paramInt = 2131692614;; paramInt = 2131692611)
      {
        localObject = paramContext.getString(paramInt);
        FMDialogUtil.a(paramContext, paramContext.getString(2131692609), KingCardProcessor.c().a.a(paramContext, (CharSequence)localObject), paramFMDialogInterface);
        return;
        i = 2;
        break;
        label186:
        i = 1;
        break label93;
      }
    }
    if (paramBoolean) {}
    for (paramInt = j;; paramInt = 2131692611)
    {
      FMDialogUtil.a(paramContext, 2131692609, paramInt, paramFMDialogInterface);
      return;
    }
  }
  
  public static boolean a()
  {
    return AppNetConnInfo.isMobileConn();
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == FMConstants.jdField_b_of_type_Int;
  }
  
  public static boolean a(int paramInt, String paramString)
  {
    boolean bool = true;
    switch (paramInt)
    {
    case 8: 
    case 14: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil<FileAssistant>", 1, "unknow errCode:" + paramInt);
      }
      bool = false;
    case 0: 
      return bool;
    case 1: 
      b(d(paramString) + c(2131692760));
      return true;
    case 2: 
      b(d(paramString) + c(2131692789));
      return true;
    case 3: 
      b(d(paramString) + c(2131692760));
      return true;
    case 4: 
      b(d(paramString) + c(2131692760));
      return true;
    case 5: 
      b(d(paramString) + c(2131692789));
      return true;
    case 6: 
      b(d(paramString) + c(2131692789));
      return true;
    case 7: 
      b(d(paramString) + c(2131692789));
      return true;
    case 9: 
      b(d(paramString) + c(2131692789));
      return true;
    case 10: 
      b(d(paramString) + c(2131692789));
      return true;
    case 11: 
      b(d(paramString) + c(2131692789));
      return true;
    case 12: 
      if (QLog.isDevelopLevel()) {
        a();
      }
      a(2131692786);
      return true;
    case 16: 
      a(2131692751);
      return true;
    case 13: 
      b(d(paramString) + c(2131692789));
      return true;
    }
    a(2131694632);
    return true;
  }
  
  public static boolean a(Context paramContext)
  {
    return (paramContext != null) && ((paramContext instanceof BaseFileAssistantActivity)) && (((BaseFileAssistantActivity)paramContext).j);
  }
  
  public static boolean a(Context paramContext, FileManagerEntity paramFileManagerEntity)
  {
    return (a(paramContext)) && ((paramFileManagerEntity.fileSize > a(((BaseFileAssistantActivity)paramContext).app, paramFileManagerEntity.fileName)) || (!a(paramFileManagerEntity.fileName, ((BaseFileAssistantActivity)paramContext).jdField_e_of_type_JavaLangString)) || ((!FMDataCache.a(paramFileManagerEntity)) && (FMDataCache.b().size() != 0)));
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (Build.VERSION.SDK_INT < 26) {
      return QQUtils.a(paramContext, new String[] { paramString });
    }
    return a(paramString, (ShortcutManager)paramContext.getSystemService(ShortcutManager.class));
  }
  
  public static boolean a(Context paramContext, String paramString, long paramLong)
  {
    paramContext = a(paramContext, paramString, "FileMaxSize");
    if (paramContext == null) {}
    while (Integer.parseInt(paramContext) * 1048576 < paramLong) {
      return false;
    }
    return true;
  }
  
  public static boolean a(VFSFile paramVFSFile1, VFSFile paramVFSFile2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerUtil<FileAssistant>", 1, "vfs renameFile: src[" + paramVFSFile1.getAbsolutePath() + "] dest[" + paramVFSFile2.getAbsolutePath() + "]");
    }
    boolean bool1;
    if (paramVFSFile2.exists())
    {
      bool1 = paramVFSFile2.delete();
      QLog.e("FileManagerUtil<FileAssistant>", 1, "vfs rename, delete result[" + bool1 + "]");
    }
    for (;;)
    {
      boolean bool2 = bool1;
      if (bool1)
      {
        bool2 = paramVFSFile1.renameTo(paramVFSFile2);
        QLog.e("FileManagerUtil<FileAssistant>", 1, "vfs rename, rename result[" + bool2 + "]");
      }
      return bool2;
      bool1 = true;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!paramChatMessage.isMultiMsg)) {}
    while ((TextUtils.isEmpty(paramChatMessage.senderuin)) || (!paramChatMessage.senderuin.equals(paramQQAppInterface.getCurrentAccountUin()))) {
      return false;
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, Context paramContext)
  {
    return a(paramQQAppInterface, paramChatMessage, paramContext, false);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, Context paramContext, boolean paramBoolean)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800644C", "0X800644C", 0, 0, "6", "", "", "");
    if (paramChatMessage == null) {
      return false;
    }
    if (!(paramChatMessage instanceof MessageForFile)) {
      return false;
    }
    MessageForFile localMessageForFile = (MessageForFile)paramChatMessage;
    FileManagerEntity localFileManagerEntity = a(paramQQAppInterface, localMessageForFile);
    switch (localFileManagerEntity.getCloudType())
    {
    case 4: 
    default: 
      return false;
    case 1: 
      if (paramChatMessage.isSend()) {}
      for (paramChatMessage = paramQQAppInterface.getCurrentAccountUin();; paramChatMessage = localMessageForFile.frienduin)
      {
        if (!paramBoolean) {
          FMToastUtil.d(paramContext.getString(2131692733));
        }
        paramQQAppInterface.getFileManagerEngine().a(localFileManagerEntity, paramChatMessage);
        paramQQAppInterface.getFileManagerDataCenter().c(localFileManagerEntity);
        if (QLog.isColorLevel()) {
          QLog.i("@-@", 1, "mEntity[" + localFileManagerEntity.nSessionId + "]'s relateId[" + localFileManagerEntity.nRelatedSessionId + "] No reInit,Show Juhua");
        }
        paramChatMessage = new FileManagerReporter.FileAssistantReportData();
        paramChatMessage.jdField_b_of_type_JavaLangString = "file_to_weiyun";
        paramChatMessage.jdField_a_of_type_Int = 9;
        paramChatMessage.jdField_a_of_type_Long = localFileManagerEntity.fileSize;
        paramChatMessage.jdField_c_of_type_JavaLangString = FileUtil.a(localFileManagerEntity.fileName);
        FileManagerReporter.a(paramQQAppInterface.getCurrentAccountUin(), paramChatMessage);
        return true;
      }
    case 2: 
      return false;
    }
    if (!paramBoolean) {
      FMToastUtil.d(paramContext.getString(2131692733));
    }
    ResponseHandler.a();
    paramQQAppInterface.getFileManagerEngine().a(localFileManagerEntity.getFilePath(), null, paramQQAppInterface.getAccount(), 0, false);
    paramQQAppInterface.getFileManagerDataCenter().c(localFileManagerEntity);
    if (QLog.isColorLevel()) {
      QLog.i("@-@", 1, "mEntity[" + localFileManagerEntity.nSessionId + "]'s relateId[" + localFileManagerEntity.nRelatedSessionId + "] reInit");
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, IFileViewerAdapter paramIFileViewerAdapter, boolean paramBoolean)
  {
    paramQQAppInterface = a(a(paramQQAppInterface), paramIFileViewerAdapter.a(), "PreviewMode");
    int j = -1;
    int i = j;
    if (paramQQAppInterface != null)
    {
      i = j;
      if (paramQQAppInterface.length() > 0)
      {
        i = j;
        try
        {
          j = Integer.parseInt(paramQQAppInterface);
          i = j;
          int k = paramIFileViewerAdapter.d();
          i = j;
          if (k == 16) {
            return false;
          }
        }
        catch (NumberFormatException paramQQAppInterface) {}
      }
    }
    boolean bool = a(i);
    if (paramBoolean)
    {
      if ((bool) && (NetworkUtil.d(BaseApplicationImpl.getContext()))) {}
      for (paramBoolean = true;; paramBoolean = false) {
        return paramBoolean;
      }
    }
    return bool;
  }
  
  public static boolean a(ChatMessage paramChatMessage)
  {
    return QFileUtils.a(paramChatMessage);
  }
  
  public static boolean a(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramChatMessage == null) || (!paramChatMessage.isMultiMsg)) {
      return false;
    }
    String str = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileStatus");
    if ((!TextUtils.isEmpty(str)) && (Integer.parseInt(str) == 4))
    {
      QQToast.a(paramContext, 2131692618, 0).a();
      return false;
    }
    paramChatMessage = MultiMsgUtil.a(paramQQAppInterface, paramChatMessage);
    if ((paramChatMessage != null) && (paramChatMessage.extraflag == 32768))
    {
      QQToast.a(paramContext, 2131692617, 0).a();
      return false;
    }
    return true;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForFile)) {}
    while (((paramMessageRecord instanceof MessageForTroopFile)) || ((paramMessageRecord instanceof MessageForDLFile))) {
      return true;
    }
    return false;
  }
  
  public static boolean a(FileManagerEntity paramFileManagerEntity)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramFileManagerEntity == null) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (FileUtil.b(paramFileManagerEntity.strLargeThumPath));
      bool1 = bool2;
    } while (FileUtil.b(paramFileManagerEntity.strMiddleThumPath));
    return FileUtil.b(paramFileManagerEntity.strThumbPath);
  }
  
  public static boolean a(IFileViewerAdapter paramIFileViewerAdapter)
  {
    int i = paramIFileViewerAdapter.c();
    int j = paramIFileViewerAdapter.d();
    String str = paramIFileViewerAdapter.c();
    paramIFileViewerAdapter = paramIFileViewerAdapter.e();
    return (i == 3) && (j == 1) && ((!TextUtils.isEmpty(str)) || (!TextUtils.isEmpty(paramIFileViewerAdapter)));
  }
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerUtil<FileAssistant>", 1, "normal renameFile: src[" + paramFile1.getAbsolutePath() + "] dest[" + paramFile2.getAbsolutePath() + "]");
    }
    for (;;)
    {
      try
      {
        if (paramFile2.exists())
        {
          bool1 = paramFile2.delete();
          QLog.e("FileManagerUtil<FileAssistant>", 1, "normal rename, delete result[" + bool1 + "]");
          boolean bool2 = bool1;
          if (bool1)
          {
            bool2 = paramFile1.renameTo(paramFile2);
            QLog.e("FileManagerUtil<FileAssistant>", 1, "normal rename, rename result[" + bool2 + "]");
          }
          return bool2;
        }
      }
      catch (Exception paramFile1)
      {
        QLog.e("FileManagerUtil<FileAssistant>", 1, "normal rename exception: " + paramFile1.getMessage());
        return false;
      }
      boolean bool1 = true;
    }
  }
  
  public static boolean a(String paramString)
  {
    return ContactUtils.a(paramString);
  }
  
  @RequiresApi(api=25)
  public static boolean a(String paramString, ShortcutManager paramShortcutManager)
  {
    if (paramShortcutManager == null) {
      return false;
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramShortcutManager = paramShortcutManager.getPinnedShortcuts().iterator();
      do
      {
        if (!paramShortcutManager.hasNext()) {
          break;
        }
      } while (!paramString.equals(((ShortcutInfo)paramShortcutManager.next()).getShortLabel()));
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      do
      {
        return false;
      } while ((paramString2 == null) || (TextUtils.isEmpty(paramString2)));
      paramString1 = FileUtil.a(paramString1);
    } while ((paramString1 == null) || (paramString1.length() == 0) || (paramString2.indexOf(paramString1.toLowerCase()) < 0));
    return true;
  }
  
  public static boolean a(boolean paramBoolean, ArrayList<FileManagerEntity> paramArrayList)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      bool1 = false;
      return bool1;
    }
    paramArrayList = paramArrayList.iterator();
    for (long l = 0L;; l += l)
    {
      if (!paramArrayList.hasNext()) {
        break label65;
      }
      bool1 = bool2;
      if (FileModel.a((FileManagerEntity)paramArrayList.next()).a(paramBoolean)) {
        break;
      }
    }
    label65:
    if (l > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize()) {}
    for (paramBoolean = true;; paramBoolean = false) {
      return paramBoolean;
    }
  }
  
  public static byte[] a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    switch (paramInt)
    {
    case 102: 
    default: 
      return null;
    case 100: 
      return paramQQAppInterface.getMsgCache().m(paramString);
    case 127: 
      return paramQQAppInterface.getMsgCache().j(paramString);
    case 109: 
      return paramQQAppInterface.getMsgCache().p(paramString);
    }
    return paramQQAppInterface.getMsgCache().d(paramString);
  }
  
  public static byte[] a(String paramString)
  {
    return a(paramString, "SHA-1");
  }
  
  /* Error */
  public static byte[] a(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 3522	java/io/FileInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 3523	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   11: astore 4
    //   13: lload_1
    //   14: ldc2_w 3524
    //   17: lcmp
    //   18: ifge +28 -> 46
    //   21: aload 4
    //   23: astore_3
    //   24: aload_0
    //   25: lload_1
    //   26: invokestatic 3530	com/tencent/qphone/base/util/MD5:getPartfileMd5	(Ljava/lang/String;J)[B
    //   29: astore_0
    //   30: aload_0
    //   31: astore_3
    //   32: aload 4
    //   34: ifnull +10 -> 44
    //   37: aload 4
    //   39: invokevirtual 3531	java/io/FileInputStream:close	()V
    //   42: aload_0
    //   43: astore_3
    //   44: aload_3
    //   45: areturn
    //   46: ldc2_w 3524
    //   49: lstore_1
    //   50: goto -29 -> 21
    //   53: astore_3
    //   54: aload_3
    //   55: invokevirtual 1578	java/io/IOException:printStackTrace	()V
    //   58: ldc_w 337
    //   61: iconst_1
    //   62: new 339	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   69: ldc_w 3533
    //   72: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_3
    //   76: invokevirtual 3534	java/io/IOException:toString	()Ljava/lang/String;
    //   79: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokestatic 443	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   88: aload_0
    //   89: areturn
    //   90: astore 5
    //   92: aconst_null
    //   93: astore_0
    //   94: aload_0
    //   95: astore_3
    //   96: ldc_w 337
    //   99: iconst_1
    //   100: new 339	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   107: ldc_w 3536
    //   110: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload 5
    //   115: invokevirtual 3534	java/io/IOException:toString	()Ljava/lang/String;
    //   118: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 443	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   127: aload 6
    //   129: astore_3
    //   130: aload_0
    //   131: ifnull -87 -> 44
    //   134: aload_0
    //   135: invokevirtual 3531	java/io/FileInputStream:close	()V
    //   138: aconst_null
    //   139: areturn
    //   140: astore_0
    //   141: aload_0
    //   142: invokevirtual 1578	java/io/IOException:printStackTrace	()V
    //   145: ldc_w 337
    //   148: iconst_1
    //   149: new 339	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 3533
    //   159: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_0
    //   163: invokevirtual 3534	java/io/IOException:toString	()Ljava/lang/String;
    //   166: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 443	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   175: aconst_null
    //   176: areturn
    //   177: astore_0
    //   178: aconst_null
    //   179: astore_3
    //   180: aload_3
    //   181: ifnull +7 -> 188
    //   184: aload_3
    //   185: invokevirtual 3531	java/io/FileInputStream:close	()V
    //   188: aload_0
    //   189: athrow
    //   190: astore_3
    //   191: aload_3
    //   192: invokevirtual 1578	java/io/IOException:printStackTrace	()V
    //   195: ldc_w 337
    //   198: iconst_1
    //   199: new 339	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   206: ldc_w 3533
    //   209: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload_3
    //   213: invokevirtual 3534	java/io/IOException:toString	()Ljava/lang/String;
    //   216: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 443	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   225: goto -37 -> 188
    //   228: astore_0
    //   229: goto -49 -> 180
    //   232: astore 5
    //   234: aload 4
    //   236: astore_0
    //   237: goto -143 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	paramString	String
    //   0	240	1	paramLong	long
    //   23	22	3	localObject1	Object
    //   53	23	3	localIOException1	IOException
    //   95	90	3	localObject2	Object
    //   190	23	3	localIOException2	IOException
    //   11	224	4	localFileInputStream	java.io.FileInputStream
    //   90	24	5	localIOException3	IOException
    //   232	1	5	localIOException4	IOException
    //   1	127	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   37	42	53	java/io/IOException
    //   3	13	90	java/io/IOException
    //   134	138	140	java/io/IOException
    //   3	13	177	finally
    //   184	188	190	java/io/IOException
    //   24	30	228	finally
    //   96	127	228	finally
    //   24	30	232	java/io/IOException
  }
  
  /* Error */
  private static byte[] a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 3540	java/io/BufferedInputStream
    //   5: dup
    //   6: new 3522	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 3523	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: invokespecial 3543	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_0
    //   18: sipush 10240
    //   21: newarray byte
    //   23: astore 4
    //   25: aload_1
    //   26: invokestatic 3548	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   29: astore_1
    //   30: aload_0
    //   31: aload 4
    //   33: invokevirtual 3554	java/io/InputStream:read	([B)I
    //   36: istore_2
    //   37: iload_2
    //   38: ifle +39 -> 77
    //   41: aload_1
    //   42: aload 4
    //   44: iconst_0
    //   45: iload_2
    //   46: invokevirtual 3558	java/security/MessageDigest:update	([BII)V
    //   49: goto -19 -> 30
    //   52: astore_1
    //   53: aload_3
    //   54: astore_1
    //   55: aload_0
    //   56: ifnull +9 -> 65
    //   59: aload_0
    //   60: invokevirtual 3559	java/io/InputStream:close	()V
    //   63: aload_3
    //   64: astore_1
    //   65: aload_1
    //   66: areturn
    //   67: astore_1
    //   68: aload_1
    //   69: invokevirtual 3560	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   72: aconst_null
    //   73: astore_1
    //   74: goto -44 -> 30
    //   77: aload_0
    //   78: ifnull +7 -> 85
    //   81: aload_0
    //   82: invokevirtual 3559	java/io/InputStream:close	()V
    //   85: aload_1
    //   86: ifnull +25 -> 111
    //   89: aload_1
    //   90: invokevirtual 3563	java/security/MessageDigest:digest	()[B
    //   93: astore_1
    //   94: aload_1
    //   95: astore_3
    //   96: aload_3
    //   97: astore_1
    //   98: aload_0
    //   99: ifnull -34 -> 65
    //   102: aload_0
    //   103: invokevirtual 3559	java/io/InputStream:close	()V
    //   106: aload_3
    //   107: areturn
    //   108: astore_0
    //   109: aload_3
    //   110: areturn
    //   111: aload_3
    //   112: astore_1
    //   113: aload_0
    //   114: ifnull -49 -> 65
    //   117: aload_0
    //   118: invokevirtual 3559	java/io/InputStream:close	()V
    //   121: aconst_null
    //   122: areturn
    //   123: astore_0
    //   124: aconst_null
    //   125: areturn
    //   126: astore_0
    //   127: aconst_null
    //   128: astore_0
    //   129: aload_3
    //   130: astore_1
    //   131: aload_0
    //   132: ifnull -67 -> 65
    //   135: aload_0
    //   136: invokevirtual 3559	java/io/InputStream:close	()V
    //   139: aconst_null
    //   140: areturn
    //   141: astore_0
    //   142: aconst_null
    //   143: areturn
    //   144: astore_1
    //   145: aconst_null
    //   146: astore_0
    //   147: aload_0
    //   148: ifnull +7 -> 155
    //   151: aload_0
    //   152: invokevirtual 3559	java/io/InputStream:close	()V
    //   155: aload_1
    //   156: athrow
    //   157: astore 4
    //   159: goto -74 -> 85
    //   162: astore_0
    //   163: aconst_null
    //   164: areturn
    //   165: astore_0
    //   166: goto -11 -> 155
    //   169: astore_1
    //   170: goto -23 -> 147
    //   173: astore_1
    //   174: goto -45 -> 129
    //   177: astore_0
    //   178: aconst_null
    //   179: astore_0
    //   180: goto -127 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	paramString1	String
    //   0	183	1	paramString2	String
    //   36	10	2	i	int
    //   1	129	3	str	String
    //   23	20	4	arrayOfByte	byte[]
    //   157	1	4	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   18	25	52	java/io/FileNotFoundException
    //   25	30	52	java/io/FileNotFoundException
    //   30	37	52	java/io/FileNotFoundException
    //   41	49	52	java/io/FileNotFoundException
    //   68	72	52	java/io/FileNotFoundException
    //   81	85	52	java/io/FileNotFoundException
    //   89	94	52	java/io/FileNotFoundException
    //   25	30	67	java/security/NoSuchAlgorithmException
    //   102	106	108	java/io/IOException
    //   117	121	123	java/io/IOException
    //   2	18	126	java/io/IOException
    //   135	139	141	java/io/IOException
    //   2	18	144	finally
    //   81	85	157	java/io/IOException
    //   59	63	162	java/io/IOException
    //   151	155	165	java/io/IOException
    //   18	25	169	finally
    //   25	30	169	finally
    //   30	37	169	finally
    //   41	49	169	finally
    //   68	72	169	finally
    //   81	85	169	finally
    //   89	94	169	finally
    //   18	25	173	java/io/IOException
    //   25	30	173	java/io/IOException
    //   30	37	173	java/io/IOException
    //   41	49	173	java/io/IOException
    //   68	72	173	java/io/IOException
    //   89	94	173	java/io/IOException
    //   2	18	177	java/io/FileNotFoundException
  }
  
  public static int[] a(String paramString)
  {
    if (!com.tencent.mobileqq.utils.FileUtils.b(paramString)) {
      return new int[] { 0, 0 };
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    SafeBitmapFactory.decodeFile(paramString, localOptions);
    int i = URLDrawableHelper.getExifRotation(paramString);
    int j;
    if ((i == 90) || (i == 270))
    {
      i = localOptions.outWidth;
      j = localOptions.outHeight;
    }
    for (;;)
    {
      return new int[] { j, i };
      j = localOptions.outWidth;
      i = localOptions.outHeight;
    }
  }
  
  public static int b()
  {
    return QFileUtils.b();
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    case -1: 
    case 1000: 
    case 2000: 
    case 2008: 
    default: 
      return -1;
    case 1003: 
    case 2003: 
      return 1;
    case 1005: 
    case 2005: 
      return 0;
    case 1004: 
    case 2004: 
    case 4001: 
      return 3;
    case 1001: 
    case 1002: 
    case 2001: 
    case 2002: 
      return 2;
    case 0: 
      return 0;
    case 1: 
      return 1;
    case 3: 
      return 3;
    }
    return 2;
  }
  
  public static int b(FileManagerEntity paramFileManagerEntity)
  {
    paramFileManagerEntity = paramFileManagerEntity.fileName.toUpperCase();
    if (paramFileManagerEntity.endsWith(".ZIP")) {
      return 13;
    }
    if (paramFileManagerEntity.endsWith(".RAR")) {
      return 14;
    }
    if (paramFileManagerEntity.endsWith(".7Z")) {
      return 15;
    }
    return -1;
  }
  
  public static int b(String paramString)
  {
    paramString = FileUtil.a(paramString);
    if (paramString == null) {
      return 2130844531;
    }
    return a(a(paramString));
  }
  
  public static long b()
  {
    return MessageUtils.a(MessageUtils.a());
  }
  
  private static Bitmap b(Matrix paramMatrix, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int j = paramBitmap.getWidth() - paramInt1;
    int i = paramBitmap.getHeight() - paramInt2;
    Object localObject1;
    Object localObject2;
    if ((j < 0) || (i < 0)) {
      try
      {
        localObject1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        paramMatrix = new Canvas((Bitmap)localObject1);
        j = Math.max(0, j / 2);
        i = Math.max(0, i / 2);
        localObject2 = new Rect(j, i, Math.min(paramInt1, paramBitmap.getWidth()) + j, Math.min(paramInt2, paramBitmap.getHeight()) + i);
        i = (paramInt1 - ((Rect)localObject2).width()) / 2;
        j = (paramInt2 - ((Rect)localObject2).height()) / 2;
        paramMatrix.drawBitmap(paramBitmap, (Rect)localObject2, new Rect(i, j, paramInt1 - i, paramInt2 - j), null);
        return localObject1;
      }
      catch (OutOfMemoryError paramMatrix)
      {
        QLog.e("FileManagerUtil<FileAssistant>", 1, "transfrom bitmap fail, Exception OutOfMemoryError");
        return null;
      }
    }
    float f1 = paramBitmap.getWidth();
    float f2 = paramBitmap.getHeight();
    if (f1 / f2 > paramInt1 / paramInt2)
    {
      f1 = paramInt2 / f2;
      if ((f1 < 0.9F) || (f1 > 1.0F))
      {
        paramMatrix.setScale(f1, f1);
        label225:
        if (paramMatrix == null) {
          break label378;
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          paramMatrix = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramMatrix, true);
          if (paramMatrix != paramBitmap) {
            paramBitmap.recycle();
          }
          i = Math.max(0, paramMatrix.getWidth() - paramInt1);
          j = Math.max(0, paramMatrix.getHeight() - paramInt2);
        }
        catch (OutOfMemoryError paramMatrix)
        {
          QLog.e("FileManagerUtil<FileAssistant>", 1, "transfrom bitmap fail, Exception OutOfMemoryError");
          return null;
        }
        try
        {
          localObject2 = Bitmap.createBitmap(paramMatrix, i / 2, j / 2, paramInt1, paramInt2);
          localObject1 = localObject2;
          if (localObject2 == paramMatrix) {
            break;
          }
          localObject1 = localObject2;
          if (paramMatrix == paramBitmap) {
            break;
          }
          paramMatrix.recycle();
          return localObject2;
        }
        catch (OutOfMemoryError paramMatrix)
        {
          label378:
          QLog.e("FileManagerUtil<FileAssistant>", 1, "transfrom bitmap fail, Exception OutOfMemoryError");
        }
      }
      paramMatrix = null;
      break label225;
      f1 = paramInt1 / f1;
      if ((f1 < 0.9F) || (f1 > 1.0F))
      {
        paramMatrix.setScale(f1, f1);
        break label225;
      }
      paramMatrix = null;
      break label225;
      paramMatrix = paramBitmap;
    }
    return null;
  }
  
  public static IForwardCallBack b(QQAppInterface paramQQAppInterface)
  {
    return new FileManagerUtil.15(paramQQAppInterface);
  }
  
  public static String b()
  {
    return FMSettings.a().b();
  }
  
  public static String b(int paramInt)
  {
    switch (paramInt)
    {
    case 11: 
    default: 
      return "other";
    case 0: 
      return "image";
    case 1: 
      return "audio";
    case 2: 
      return "video";
    case 3: 
      return "doc";
    case 4: 
      return "zip";
    case 5: 
      return "apk";
    case 6: 
      return "excel";
    case 7: 
      return "ppt";
    case 8: 
      return "html";
    case 9: 
      return "pdf";
    case 10: 
      return "txt";
    }
    return "psd";
  }
  
  public static String b(FileManagerEntity paramFileManagerEntity)
  {
    Object localObject6 = null;
    Context localContext = a();
    if (c.size() == 0)
    {
      c.put(Integer.valueOf(1), localContext.getString(2131692379));
      c.put(Integer.valueOf(9), localContext.getString(2131692379));
      c.put(Integer.valueOf(10), localContext.getString(2131692379));
      c.put(Integer.valueOf(11), localContext.getString(2131692379));
      c.put(Integer.valueOf(12), localContext.getString(2131692379));
      c.put(Integer.valueOf(13), localContext.getString(2131692379));
      c.put(Integer.valueOf(6), localContext.getString(2131692386));
      c.put(Integer.valueOf(4), localContext.getString(2131692386));
      c.put(Integer.valueOf(20), localContext.getString(2131692386));
      c.put(Integer.valueOf(22), localContext.getString(2131692413));
      c.put(Integer.valueOf(21), localContext.getString(2131692413));
      c.put(Integer.valueOf(0), localContext.getString(2131692413));
      c.put(Integer.valueOf(7), localContext.getString(2131692413));
      c.put(Integer.valueOf(3), localContext.getString(2131692413));
      c.put(Integer.valueOf(24), localContext.getString(2131692413));
      c.put(Integer.valueOf(5), localContext.getString(2131692380));
      c.put(Integer.valueOf(50), localContext.getString(2131692380));
      c.put(Integer.valueOf(14), localContext.getString(2131720339));
      c.put(Integer.valueOf(15), localContext.getString(2131720340));
      c.put(Integer.valueOf(16), localContext.getString(2131720345));
      c.put(Integer.valueOf(17), localContext.getString(2131720342));
      c.put(Integer.valueOf(18), localContext.getString(2131720341));
      c.put(Integer.valueOf(19), localContext.getString(2131720343));
      c.put(Integer.valueOf(190), localContext.getString(2131720346));
      c.put(Integer.valueOf(40), localContext.getString(2131720344));
    }
    Object localObject1 = a(paramFileManagerEntity, localContext, (String)c.get(Integer.valueOf(paramFileManagerEntity.nOpType)));
    if (paramFileManagerEntity.getCloudType() == 0) {
      localObject1 = localContext.getString(2131692379);
    }
    if (paramFileManagerEntity.getCloudType() == 5)
    {
      localObject1 = localContext.getString(2131692379);
      if (paramFileManagerEntity.bSend) {
        localObject1 = localContext.getString(2131692413);
      }
    }
    Object localObject3;
    for (Object localObject2 = paramFileManagerEntity.peerNick;; localObject3 = null)
    {
      localObject2 = a(paramFileManagerEntity, localContext, (String)localObject1, (String)localObject2);
      Object localObject4 = localObject1;
      if (paramFileManagerEntity.nOpType == 1)
      {
        localObject4 = localObject1;
        if (paramFileManagerEntity.bSend) {
          localObject4 = localContext.getString(2131692413);
        }
      }
      localObject1 = localObject2;
      Object localObject5 = localObject4;
      for (;;)
      {
        try
        {
          QQAppInterface localQQAppInterface = a();
          localObject1 = localObject2;
          localObject5 = localObject4;
          String str2 = a(localQQAppInterface, paramFileManagerEntity.peerUin, "", paramFileManagerEntity.peerType);
          String str1 = str2;
          localObject2 = localObject4;
          localObject1 = str2;
          localObject5 = localObject4;
          if (paramFileManagerEntity.TroopUin != 0L)
          {
            localObject1 = str2;
            localObject5 = localObject4;
            str1 = b(paramFileManagerEntity, localContext, str2, localQQAppInterface);
            localObject2 = null;
          }
          localObject4 = str1;
          if (localObject2 != null)
          {
            localObject4 = str1;
            localObject1 = str1;
            localObject5 = localObject2;
            if (((String)localObject2).equals(localContext.getString(2131692386))) {
              localObject4 = null;
            }
          }
          localObject1 = localObject4;
          localObject5 = localObject2;
          if (paramFileManagerEntity.peerType != 3000) {
            break label917;
          }
          if (localObject2 != null)
          {
            localObject1 = localObject4;
            localObject5 = localObject2;
            if (!((String)localObject2).equals(localContext.getString(2131692386))) {}
          }
          else
          {
            localObject1 = localObject4;
            localObject5 = localObject2;
            if (paramFileManagerEntity.nOpType != 28) {
              break label917;
            }
          }
          localObject1 = localObject4;
          localObject5 = localObject2;
          localObject4 = a(paramFileManagerEntity, localContext, (String)localObject4, localQQAppInterface);
          localObject1 = localObject6;
          localObject2 = localObject4;
        }
        catch (Exception localException)
        {
          localObject3 = localObject1;
          localObject1 = localObject5;
          continue;
          if ((localObject1 == null) || (localObject3 == null)) {
            continue;
          }
          return (String)localObject1 + " " + localObject3;
          paramFileManagerEntity = (FileManagerEntity)localObject1;
          if (localObject1 != null) {
            continue;
          }
          return localObject3;
        }
        if ((localObject1 != null) && (((String)localObject1).equalsIgnoreCase(localContext.getString(2131692380))) && (paramFileManagerEntity.bSend))
        {
          paramFileManagerEntity = localContext.getString(2131692413) + " " + (String)localObject2;
          return paramFileManagerEntity;
        }
        label917:
        localObject1 = localObject3;
      }
    }
  }
  
  @NotNull
  private static String b(FileManagerEntity paramFileManagerEntity, Context paramContext, String paramString, QQAppInterface paramQQAppInterface)
  {
    paramString = ((TroopManager)a(paramQQAppInterface, QQManagerFactory.TROOP_MANAGER)).b(String.valueOf(paramFileManagerEntity.TroopUin));
    if ((paramString == null) || (paramString.getTroopDisplayName() == null)) {
      paramString = "";
    }
    for (;;)
    {
      paramQQAppInterface = paramContext.getString(2131692342) + paramString;
      paramString = paramQQAppInterface;
      if (paramFileManagerEntity.bSend) {
        paramString = paramContext.getString(2131692344) + paramQQAppInterface;
      }
      return paramString;
      if ((paramString != null) && (paramString.getTroopDisplayName() != null) && (paramString.getTroopDisplayName().length() > 14)) {
        paramString = paramString.getTroopDisplayName();
      } else {
        paramString = paramString.getTroopDisplayName();
      }
    }
  }
  
  public static String b(String paramString)
  {
    int i = paramString.lastIndexOf("/");
    int j = paramString.lastIndexOf(".");
    Object localObject2 = "";
    Object localObject1 = "";
    String str2 = "";
    String str1 = str2;
    if (i > 0)
    {
      if ((j <= 0) || (j <= i)) {
        break label161;
      }
      localObject1 = paramString.substring(i, j);
    }
    for (str1 = paramString.substring(j);; str1 = str2)
    {
      str2 = paramString.substring(0, i);
      localObject2 = localObject1;
      localObject1 = str2;
      VFSFile localVFSFile = new VFSFile(paramString);
      i = 1;
      str2 = paramString;
      paramString = localVFSFile;
      while (paramString.exists())
      {
        str2 = (String)localObject1 + (String)localObject2 + "(" + i + ")" + str1;
        paramString = new VFSFile(str2);
        i += 1;
      }
      label161:
      localObject1 = paramString.substring(i);
    }
    return str2;
  }
  
  public static void b()
  {
    QQAppInterface localQQAppInterface = a();
    Object localObject = localQQAppInterface.getFileManagerProxy().a();
    if (localObject == null) {
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
      if (!TextUtils.isEmpty(localFileManagerEntity.Uuid))
      {
        localFileManagerEntity.status = 16;
        localQQAppInterface.getFileManagerEngine().a(localFileManagerEntity.peerUin, localFileManagerEntity.fileName, localFileManagerEntity.Uuid, localFileManagerEntity.fileIdCrc, localFileManagerEntity.bSend);
      }
    }
    localQQAppInterface.getFileManagerProxy().d();
  }
  
  private static void b(int paramInt, String paramString, QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity.nOpType == 4)
    {
      if (ResponseHandler.a(paramInt))
      {
        if (ResponseHandler.b()) {
          ResponseHandler.a(paramQQAppInterface);
        }
      }
      else {
        return;
      }
      c(paramInt, paramString, paramFileManagerEntity);
      return;
    }
    c(paramInt, paramString, paramFileManagerEntity);
  }
  
  private static void b(int paramInt, String paramString, FileManagerEntity paramFileManagerEntity)
  {
    if (!TextUtils.isEmpty(paramString)) {
      c(paramString);
    }
    while (a(paramInt, paramFileManagerEntity.fileName)) {
      return;
    }
    a(13, paramFileManagerEntity.fileName);
  }
  
  /* Error */
  public static void b(long paramLong)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 34	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   6: ifnonnull +13 -> 19
    //   9: new 36	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 38	java/util/ArrayList:<init>	()V
    //   16: putstatic 34	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   19: getstatic 34	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   22: lload_0
    //   23: invokestatic 1686	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   26: invokevirtual 3687	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   29: istore_2
    //   30: iload_2
    //   31: ifeq +7 -> 38
    //   34: ldc 2
    //   36: monitorexit
    //   37: return
    //   38: getstatic 34	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   41: lload_0
    //   42: invokestatic 1686	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   45: invokevirtual 2080	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   48: pop
    //   49: invokestatic 335	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   52: ifeq -18 -> 34
    //   55: ldc_w 934
    //   58: iconst_2
    //   59: new 339	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   66: ldc_w 3689
    //   69: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: lload_0
    //   73: invokevirtual 954	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   76: ldc_w 3691
    //   79: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokestatic 443	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   88: goto -54 -> 34
    //   91: astore_3
    //   92: ldc 2
    //   94: monitorexit
    //   95: aload_3
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	paramLong	long
    //   29	2	2	bool	boolean
    //   91	5	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	19	91	finally
    //   19	30	91	finally
    //   38	88	91	finally
  }
  
  public static void b(Activity paramActivity, String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity.getApplicationContext(), FMActivity.class);
    localIntent.putExtra("selectMode", true);
    localIntent.putExtra("targetUin", paramString);
    localIntent.putExtra("busiType", 10);
    localIntent.putExtra("sendprepare", paramInt1);
    localIntent.putExtra("enterfrom", paramInt2);
    localIntent.putExtra("needRemember", true);
    localIntent.putExtra("qfile_entrance_type_key", 10);
    paramActivity.startActivityForResult(localIntent, 110);
    paramActivity.overridePendingTransition(2130771981, 2130771982);
  }
  
  public static void b(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new Bundle();
    paramString1.putString("string_uin", paramString2);
    paramString1.putString("string_nick", paramString3);
    QQProxyForQlink.a(paramActivity, 3, paramString1);
  }
  
  public static void b(Context paramContext)
  {
    paramContext.getSharedPreferences("LAST_CHOOSE_", 0).edit().clear().commit();
  }
  
  public static void b(Context paramContext, String paramString)
  {
    if (!com.tencent.mobileqq.utils.FileUtils.b(paramString))
    {
      FMToastUtil.a(2131692760);
      return;
    }
    paramString = FileProvider7Helper.openApkIntent(paramContext, paramString);
    paramString.putExtra("big_brother_source_key", "biz_src_jc_file");
    List localList = paramContext.getPackageManager().queryIntentActivities(paramString, 65536);
    if ((localList.size() == 1) && (((ResolveInfo)localList.get(0)).activityInfo.name.equals("com.tencent.mobileqq.activity.JumpActivity"))) {}
    for (int i = 1;; i = 0)
    {
      if ((localList.size() > 0) && (i == 0)) {
        try
        {
          paramContext.startActivity(paramString);
          return;
        }
        catch (ActivityNotFoundException paramContext)
        {
          FMToastUtil.a(2131693749);
          return;
        }
      }
      FMToastUtil.a(2131693749);
      return;
    }
  }
  
  public static void b(Context paramContext, String paramString, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("_filename_from_dlg", paramContext.getString(2131694608));
    localBundle.putString("big_brother_source_key", "biz_src_jc_file");
    localBundle.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_jc_file");
    localBundle.putBundle("_user_data", paramBundle);
    a().startDownloadNoSzie(paramString, localBundle);
    QLog.i("FileManagerUtil<FileAssistant>", 1, "downloadQQBrowser:" + paramString);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    paramQQAppInterface.getFileManagerProxy().a(paramFileManagerEntity);
  }
  
  public static void b(BaseFileAssistantActivity paramBaseFileAssistantActivity)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    Object localObject = FMDataCache.e();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        FavFileInfo localFavFileInfo = (FavFileInfo)((Iterator)localObject).next();
        if (a(localFavFileInfo.jdField_c_of_type_JavaLangString) == 0) {
          localArrayList.add(Long.valueOf(localFavFileInfo.jdField_a_of_type_Long));
        }
      }
    }
    if (localArrayList.size() > 0)
    {
      long l = ((Long)localArrayList.get(0)).longValue();
      localObject = new long[localArrayList.size()];
      while (i < localObject.length)
      {
        localObject[i] = ((Long)localArrayList.get(i)).longValue();
        i += 1;
      }
      QfavHelper.a(paramBaseFileAssistantActivity, paramBaseFileAssistantActivity.app.getCurrentAccountUin(), l, (long[])localObject);
    }
  }
  
  public static void b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    do
    {
      do
      {
        do
        {
          boolean bool;
          do
          {
            return;
            bool = FileUtil.a(paramFileManagerEntity.getFilePath());
            if ((bool) && ((paramFileManagerEntity.nOpType == 8) || (paramFileManagerEntity.nOpType == 190) || (paramFileManagerEntity.nOpType == 1) || (paramFileManagerEntity.nOpType == 16) || (paramFileManagerEntity.nOpType == 14) || (paramFileManagerEntity.nOpType == 15) || (paramFileManagerEntity.nOpType == 17) || (paramFileManagerEntity.nOpType == 18) || (paramFileManagerEntity.nOpType == 19) || (paramFileManagerEntity.nOpType == 190) || (paramFileManagerEntity.nOpType == 5) || (paramFileManagerEntity.nOpType == 50) || (paramFileManagerEntity.nOpType == -1)))
            {
              paramFileManagerEntity.cloudType = 3;
              paramFileManagerEntity.status = 1;
              return;
            }
          } while ((paramFileManagerEntity.getCloudType() != 3) || ((bool) && ((paramFileManagerEntity.nOpType == 0) || (paramFileManagerEntity.nOpType == 6))));
          if ((!bool) || (paramFileManagerEntity.nOpType != 51)) {
            break;
          }
        } while (paramFileManagerEntity.status != 16);
        paramFileManagerEntity.status = 0;
        return;
        if (paramFileManagerEntity.nFileType == 5) {
          FileCategoryUtil.a(paramFileManagerEntity);
        }
      } while (paramFileManagerEntity.status != 1);
      paramFileManagerEntity.status = 16;
      if (paramFileManagerEntity.peerType == 6000)
      {
        paramFileManagerEntity.setCloudType(6);
        paramFileManagerEntity.status = 16;
        return;
      }
      if ((paramFileManagerEntity.Uuid != null) && (paramFileManagerEntity.Uuid.length() > 0))
      {
        paramFileManagerEntity.setCloudType(1);
        paramFileManagerEntity.status = -1;
        return;
      }
    } while (TextUtils.isEmpty(paramFileManagerEntity.WeiYunFileId));
    paramFileManagerEntity.setCloudType(2);
    paramFileManagerEntity.status = -1;
  }
  
  public static void b(com.tencent.mobileqq.filemanager.widget.AsyncImageView paramAsyncImageView, FileManagerEntity paramFileManagerEntity)
  {
    a(paramFileManagerEntity);
    if (paramFileManagerEntity.nFileType == 0)
    {
      String str2 = paramFileManagerEntity.strLargeThumPath;
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = d(paramFileManagerEntity);
      }
      if (com.tencent.mobileqq.utils.FileUtils.b(str1))
      {
        paramFileManagerEntity.strLargeThumPath = str1;
        paramAsyncImageView.setDefaultImage(2130844458);
        paramAsyncImageView.setAsyncImage(str1);
        return;
      }
    }
    a(paramAsyncImageView, paramFileManagerEntity.fileName);
  }
  
  public static void b(String paramString)
  {
    FMToastUtil.a(paramString);
  }
  
  public static boolean b()
  {
    Object localObject = FMDataCache.e();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (a(((FavFileInfo)((Iterator)localObject).next()).jdField_c_of_type_JavaLangString) == 0) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, IFileViewerAdapter paramIFileViewerAdapter, boolean paramBoolean)
  {
    boolean bool = true;
    FileManagerEntity localFileManagerEntity = paramIFileViewerAdapter.a();
    if (localFileManagerEntity == null) {
      return false;
    }
    int i;
    int j;
    label63:
    int k;
    label100:
    int m;
    label112:
    int n;
    if ((a(paramQQAppInterface, paramIFileViewerAdapter, paramBoolean)) && (!localFileManagerEntity.isZipInnerFile))
    {
      i = 1;
      if ((paramIFileViewerAdapter.b() == 6000) || (paramIFileViewerAdapter.c() == 7)) {
        break label159;
      }
      j = 1;
      if ((paramIFileViewerAdapter.c() == 3) && (localFileManagerEntity.strTroopFilePath == null) && (localFileManagerEntity.Uuid == null) && (localFileManagerEntity.WeiYunFileId == null)) {
        break label165;
      }
      k = 1;
      if (paramIFileViewerAdapter.c() == 0) {
        break label171;
      }
      m = 1;
      if (paramIFileViewerAdapter.c() == 5) {
        break label177;
      }
      n = 1;
      label125:
      if ((i == 0) || (j == 0) || (k == 0) || (m == 0) || (n == 0)) {
        break label183;
      }
    }
    label159:
    label165:
    label171:
    label177:
    label183:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      return paramBoolean;
      i = 0;
      break;
      j = 0;
      break label63;
      k = 0;
      break label100;
      m = 0;
      break label112;
      n = 0;
      break label125;
    }
  }
  
  public static boolean b(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!QFileUtils.a(paramChatMessage))) {}
    do
    {
      return false;
      paramChatMessage = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileStatus");
    } while ((!TextUtils.isEmpty(paramChatMessage)) && (Integer.parseInt(paramChatMessage) != 1));
    return true;
  }
  
  public static boolean b(FileManagerEntity paramFileManagerEntity)
  {
    long l2 = 604800000L;
    if (paramFileManagerEntity == null) {
      return false;
    }
    long l3 = paramFileManagerEntity.srvTime;
    long l1 = l2;
    switch (paramFileManagerEntity.peerType)
    {
    default: 
      l1 = l2;
    case 0: 
      if (l1 + l3 > MessageCache.a() * 1000L) {
        break;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      l1 = 2592000000L;
      break;
    }
  }
  
  private static boolean b(FileManagerEntity paramFileManagerEntity1, FileManagerEntity paramFileManagerEntity2)
  {
    if ((paramFileManagerEntity1.Uuid != null) && (paramFileManagerEntity1.Uuid.equals(paramFileManagerEntity2.Uuid))) {}
    while (((paramFileManagerEntity2.strFileSHA != null) && (paramFileManagerEntity2.strFileSHA.equals(paramFileManagerEntity1.strFileSHA))) || ((paramFileManagerEntity2.strFileMd5 != null) && ((paramFileManagerEntity2.strFileMd5.equals(paramFileManagerEntity1.strFileMd5)) || (paramFileManagerEntity2.strFileMd5.equals(paramFileManagerEntity1.str10Md5)))) || ((paramFileManagerEntity2.strTroopFileSha1 != null) && (paramFileManagerEntity2.strTroopFileSha1.equals(paramFileManagerEntity1.strTroopFileSha1))) || ((paramFileManagerEntity2.strFileSha3 != null) && (paramFileManagerEntity2.strFileSha3.equals(paramFileManagerEntity1.strFileSha3))) || ((paramFileManagerEntity2.str10Md5 != null) && (paramFileManagerEntity2.str10Md5.equals(paramFileManagerEntity1.str10Md5)))) {
      return true;
    }
    return false;
  }
  
  public static boolean b(IFileViewerAdapter paramIFileViewerAdapter)
  {
    int i = paramIFileViewerAdapter.c();
    int j = paramIFileViewerAdapter.d();
    return (i == 3) && (j == 1);
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return new VFSFile(paramString).exists();
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    return BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getBoolean("qlink_new_flag_" + paramString1 + "_" + paramString2, true);
  }
  
  public static byte[] b(String paramString)
  {
    return a(paramString, "MD5");
  }
  
  private static int[] b(String paramString)
  {
    if (com.tencent.mobileqq.utils.FileUtils.b(paramString))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      FilePicURLDrawlableHelper.a(paramString, localOptions);
      int i = URLDrawableHelper.getExifRotation(paramString);
      if ((i == 90) || (i == 270)) {
        return new int[] { localOptions.outHeight, localOptions.outWidth };
      }
      return new int[] { localOptions.outWidth, localOptions.outHeight };
    }
    return new int[] { 0, 0 };
  }
  
  public static int c()
  {
    return QFileUtils.c();
  }
  
  public static int c(FileManagerEntity paramFileManagerEntity)
  {
    paramFileManagerEntity = paramFileManagerEntity.fileName.toUpperCase();
    if (paramFileManagerEntity.endsWith(".ZIP")) {
      return 13;
    }
    if (paramFileManagerEntity.endsWith(".RAR")) {
      return 14;
    }
    if (paramFileManagerEntity.endsWith(".7Z")) {
      return 15;
    }
    return -1;
  }
  
  @TargetApi(9)
  public static int c(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      i = -1;
    }
    Object localObject;
    do
    {
      return i;
      localObject = FileUtil.c(paramString);
    } while (b().equalsIgnoreCase((String)localObject));
    try
    {
      localObject = BaseApplication.getContext().getSharedPreferences("ExternalFileOfFM", 0).edit();
      ((SharedPreferences.Editor)localObject).putString(paramString, "-");
      if (Build.VERSION.SDK_INT < 9)
      {
        ((SharedPreferences.Editor)localObject).commit();
        return 0;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return -2;
    }
    ((SharedPreferences.Editor)localObject).apply();
    return 0;
  }
  
  public static String c(int paramInt)
  {
    return BaseApplicationImpl.getContext().getString(paramInt);
  }
  
  public static String c(FileManagerEntity paramFileManagerEntity)
  {
    String str1 = null;
    Object localObject = a();
    String str2 = ((Context)localObject).getString(2131692414);
    switch (paramFileManagerEntity.getCloudType())
    {
    case 4: 
    default: 
      localObject = null;
      if (localObject != null) {
        label62:
        if ((paramFileManagerEntity.getCloudType() != 2) || (3 != paramFileManagerEntity.nOpType)) {
          break label163;
        }
      }
      break;
    }
    label163:
    while ((paramFileManagerEntity.getCloudType() == 5) || (paramFileManagerEntity.TroopUin != 0L))
    {
      return localObject;
      localObject = ((Context)localObject).getString(2131692368);
      str1 = a(paramFileManagerEntity.srvTime, paramFileManagerEntity.peerType);
      break;
      localObject = ((Context)localObject).getString(2131692439);
      break;
      localObject = null;
      break;
      localObject = null;
      break;
      localObject = ((Context)localObject).getString(2131698337);
      break;
      localObject = "" + a(str2, str1);
      break label62;
    }
    if (str1 != null) {
      return str1;
    }
    return "";
  }
  
  public static String c(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap == null)
    {
      jdField_a_of_type_JavaUtilHashMap = new HashMap();
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewRotateScreenFunctionalSwitch", "1");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewLocalPreviewFunctionalSwitch", "0");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewAutoPreviewFunctionSwitch", "1");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewAutoPreviewWiFiMaxSize", "1000");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewAutoPreview3GMaxSize", "0");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewAutoPreviewWiFiGroupMaxSize", "1000");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewAutoPreview3GGroupMaxSize", "0");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocFileMaxSize", "10");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocFileType", "1");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocInterfacePage", "qq_document_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocPreviewMode", "0");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocxFileMaxSize", "10");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocxFileType", "2");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocxInterfacePage", "qq_document_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocxPreviewMode", "0");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrtfFileMaxSize", "10");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrtfFileType", "7");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrtfInterfacePage", "qq_document_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrtfPreviewMode", "0");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptFileMaxSize", "10");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptFileType", "5");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptInterfacePage", "qq_ppt_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptPreviewMode", "4");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptxFileMaxSize", "10");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptxFileType", "6");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptxInterfacePage", "qq_ppt_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptxPreviewMode", "5");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpdfFileMaxSize", "10");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpdfFileType", "8");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpdfInterfacePage", "qq_pdf_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpdfPreviewMode", "3");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewzipFileMaxSize", "100");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewzipFileType", "13");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewzipInterfacePage", "qq_compress_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewzipPreviewMode", "1");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrarFileMaxSize", "100");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrarFileType", "14");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrarInterfacePage", "qq_compress_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrarPreviewMode", "1");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreView7zFileMaxSize", "100");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreView7zFileType", "15");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreView7zInterfacePage", "qq_compress_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreView7zPreviewMode", "1");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewtxtFileMaxSize", "10");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewtxtFileType", "16");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewtxtInterfacePage", "qq_txt_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewtxtPreviewMode", "2");
      jdField_a_of_type_JavaUtilHashMap.put("OfflineConfigFlowSize", "1024");
      jdField_a_of_type_JavaUtilHashMap.put("OfflineConfigFlowTime", "30");
      jdField_a_of_type_JavaUtilHashMap.put("OfflineConfigFtnThumbMaxSize", "32768");
    }
    String str = (String)jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((str == null) && (QLog.isColorLevel())) {
      QLog.e("FileManagerUtil<FileAssistant>", 2, "key[" + paramString + "],value null!");
    }
    return str;
  }
  
  private static void c(int paramInt, String paramString, FileManagerEntity paramFileManagerEntity)
  {
    if (a(paramInt, paramFileManagerEntity.fileName)) {
      return;
    }
    if ((paramString != null) && (paramString.length() > 0))
    {
      c(paramString);
      return;
    }
    c(d(paramFileManagerEntity.fileName) + c(2131692732));
  }
  
  /* Error */
  public static void c(long paramLong)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 34	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: getstatic 34	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   18: lload_0
    //   19: invokestatic 1686	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   22: invokevirtual 3938	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   25: pop
    //   26: invokestatic 335	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq -18 -> 11
    //   32: ldc_w 934
    //   35: iconst_2
    //   36: new 339	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 3689
    //   46: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: lload_0
    //   50: invokevirtual 954	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   53: ldc_w 3940
    //   56: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 443	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   65: goto -54 -> 11
    //   68: astore_2
    //   69: ldc 2
    //   71: monitorexit
    //   72: aload_2
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	paramLong	long
    //   6	2	2	localArrayList	ArrayList
    //   68	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	68	finally
    //   15	65	68	finally
  }
  
  public static void c(Context paramContext, String paramString)
  {
    paramString = paramString.trim();
    Intent localIntent = new Intent(paramContext, QQBrowserDelegationActivity.class);
    localIntent.putExtra("param_force_internal_browser", true);
    String str = TeamWorkUtils.b("tdsourcetag", "s_qq_myfile_banner");
    localIntent.putExtra("tdsourcetag", "s_qq_myfile_banner");
    localIntent.putExtra("url", str);
    localIntent.putExtra("webStyle", "noBottomBar");
    localIntent.putExtra("fromAio", true);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    if (!TeamWorkDocEditBrowserActivity.a(paramContext, str, localIntent.getStringExtra("tdsourcetag"))) {
      WebAccelerator.a(paramContext, localIntent, paramString);
    }
  }
  
  private static void c(TextView paramTextView, FileManagerEntity paramFileManagerEntity)
  {
    String str2 = QfileTimeUtils.b(paramFileManagerEntity.srvTime);
    String str6 = b(paramFileManagerEntity);
    String str3 = FileUtil.a(paramFileManagerEntity.fileSize);
    String str4 = c(paramFileManagerEntity);
    String str5 = a().getString(2131692414);
    int j = paramTextView.getWidth();
    TextPaint localTextPaint = paramTextView.getPaint();
    String str1;
    float f;
    if (paramFileManagerEntity.nFileType == 13)
    {
      str1 = str2 + " " + str6 + " " + BaseApplicationImpl.getContext().getString(2131692370);
      f = localTextPaint.measureText(str1) + 30.0F;
      if (f >= j) {
        break label186;
      }
      paramTextView.setText(str1);
    }
    for (;;)
    {
      return;
      str1 = str2 + " " + str6 + str5 + str3 + str5 + str4;
      break;
      label186:
      if (f > j * 2)
      {
        i = 1;
        int k = str6.length();
        while (k - i > 0)
        {
          str1 = str6.substring(0, k - i);
          if (localTextPaint.measureText(str2 + str5 + str1 + jdField_a_of_type_JavaLangString + str5 + str3 + str5 + str4) + 30.0F < j * 2)
          {
            paramTextView.setVisibility(0);
            if (paramFileManagerEntity.nFileType == 13)
            {
              paramTextView.setText(str2 + " " + str6 + jdField_a_of_type_JavaLangString + " " + BaseApplicationImpl.getContext().getString(2131692370));
              return;
            }
            paramTextView.setText(str2 + str5 + str1 + jdField_a_of_type_JavaLangString + str5 + str3 + str5 + str4);
            return;
          }
          i += 1;
        }
        if (paramFileManagerEntity.nFileType == 13)
        {
          paramTextView.setText(str2 + " " + str6 + "\n" + BaseApplicationImpl.getContext().getString(2131692370));
          return;
        }
        paramTextView.setText(str2 + str5 + str6 + "\n" + str3 + str5 + str4);
        return;
      }
      if (localTextPaint.measureText(str2 + str5 + str6) + 30.0F <= j) {
        break label802;
      }
      int i = 4;
      while (i <= str6.length())
      {
        str1 = str6.substring(0, i);
        if (localTextPaint.measureText(str2 + str5 + str1) + 30.0F > j)
        {
          str1 = str6.substring(0, i - 1);
          str6 = str6.replace(str1, "");
          if (paramFileManagerEntity.nFileType == 13) {
            paramTextView.setText(str2 + " " + str1 + "\n" + str6 + str5 + BaseApplicationImpl.getContext().getString(2131692370));
          }
          for (;;)
          {
            paramTextView.setVisibility(0);
            return;
            paramTextView.setText(str2 + str5 + str1 + "\n" + str6 + str5 + str3 + str5 + str4);
          }
        }
        i += 1;
      }
    }
    label802:
    if (localTextPaint.measureText(str2 + str5 + str6 + str5 + str3) + 30.0F > j)
    {
      if (paramFileManagerEntity.nFileType == 13) {
        paramTextView.setText(str2 + " " + str6 + "\n" + BaseApplicationImpl.getContext().getString(2131692370));
      }
      for (;;)
      {
        paramTextView.setVisibility(0);
        return;
        paramTextView.setText(str2 + str5 + str6 + "\n" + str3 + str5 + str4);
      }
    }
    if (paramFileManagerEntity.nFileType == 13) {
      paramTextView.setText(str2 + " " + str6 + BaseApplicationImpl.getContext().getString(2131692370));
    }
    for (;;)
    {
      paramTextView.setVisibility(0);
      return;
      paramTextView.setText(str2 + str5 + str6 + str5 + str3 + str5 + str4);
    }
  }
  
  public static void c(FileManagerEntity paramFileManagerEntity)
  {
    Object localObject;
    if (paramFileManagerEntity.nFileType == 0)
    {
      if ((paramFileManagerEntity.imgHeight <= 0) || (paramFileManagerEntity.imgWidth <= 0))
      {
        if (com.tencent.mobileqq.utils.FileUtils.b(paramFileManagerEntity.getFilePath()))
        {
          localObject = b(paramFileManagerEntity.getFilePath());
          paramFileManagerEntity.imgWidth = localObject[0];
          paramFileManagerEntity.imgHeight = localObject[1];
        }
        QLog.i("FileManagerUtil<FileAssistant>", 1, "localPic[" + paramFileManagerEntity.nSessionId + "] get thumbsize success size(wh)[" + paramFileManagerEntity.imgWidth + ":" + paramFileManagerEntity.imgHeight + "]");
      }
      localObject = FilePicURLDrawlableHelper.a(paramFileManagerEntity);
      if (localObject != null) {
        URLDrawableHelper.getDrawable((URL)localObject).downloadImediatly();
      }
      if ((ZhuoXusManager.a().i()) && (b(paramFileManagerEntity.strMiddleThumPath)))
      {
        localObject = new File(paramFileManagerEntity.strMiddleThumPath);
        localObject = JumpShareUtils.a(BaseApplicationImpl.getContext(), (File)localObject);
        if (localObject == null) {
          break label225;
        }
        paramFileManagerEntity.strQRUrl = ((StringBuilder)((Pair)localObject).first).toString();
        if (QLog.isDevelopLevel()) {
          QLog.i("IMG_FILE_QR", 1, "createMediThumbnail success:" + paramFileManagerEntity.strQRUrl);
        }
      }
    }
    label225:
    do
    {
      do
      {
        return;
        if (JumpShareUtils.jdField_a_of_type_Boolean)
        {
          paramFileManagerEntity.strQRUrl = null;
          return;
        }
        paramFileManagerEntity.strQRUrl = "";
        return;
      } while (paramFileManagerEntity.nFileType != 2);
      localObject = a(paramFileManagerEntity.getFilePath());
    } while (((FileManagerUtil.VideoThumbInfo)localObject).jdField_a_of_type_Int == -1);
    paramFileManagerEntity.strLargeThumPath = ((FileManagerUtil.VideoThumbInfo)localObject).jdField_a_of_type_JavaLangString;
    if ((paramFileManagerEntity.imgHeight > 0) && (paramFileManagerEntity.imgWidth > 0)) {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerUtil<FileAssistant>", 1, "Id[" + paramFileManagerEntity.nSessionId + "] has size(wh)[" + paramFileManagerEntity.imgWidth + ":" + paramFileManagerEntity.imgHeight + "]");
      }
    }
    for (;;)
    {
      QLog.i("FileManagerUtil<FileAssistant>", 1, "localvideo[" + paramFileManagerEntity.nSessionId + "] create thumb success size(wh)[" + paramFileManagerEntity.imgWidth + ":" + paramFileManagerEntity.imgHeight + "]");
      return;
      paramFileManagerEntity.imgWidth = ((FileManagerUtil.VideoThumbInfo)localObject).jdField_b_of_type_Int;
      paramFileManagerEntity.imgHeight = ((FileManagerUtil.VideoThumbInfo)localObject).jdField_c_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerUtil<FileAssistant>", 1, "Id[" + paramFileManagerEntity.nSessionId + "]get local video,(wh)[" + paramFileManagerEntity.imgWidth + ":" + paramFileManagerEntity.imgHeight + "]");
      }
    }
  }
  
  public static void c(String paramString)
  {
    FMToastUtil.a(paramString);
  }
  
  public static boolean c()
  {
    return ((IFMConfig)QRoute.api(IFMConfig.class)).preDownloadThumb();
  }
  
  public static boolean c(FileManagerEntity paramFileManagerEntity)
  {
    return !FileUtil.a(paramFileManagerEntity.getFilePath()).equalsIgnoreCase(".mov");
  }
  
  public static boolean c(String paramString)
  {
    return FileUtil.b(paramString);
  }
  
  /* Error */
  public static byte[] c(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 4051	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)J
    //   4: lstore 7
    //   6: lload 7
    //   8: ldc2_w 4052
    //   11: lcmp
    //   12: ifge +9 -> 21
    //   15: aconst_null
    //   16: astore 20
    //   18: aload 20
    //   20: areturn
    //   21: ldc2_w 4054
    //   24: lconst_1
    //   25: lsub
    //   26: lstore 17
    //   28: lload 7
    //   30: ldc2_w 1247
    //   33: ldiv
    //   34: ldc2_w 4054
    //   37: ldc2_w 1247
    //   40: ldiv
    //   41: lsub
    //   42: lstore 13
    //   44: lload 7
    //   46: ldc2_w 1247
    //   49: ldiv
    //   50: ldc2_w 4054
    //   53: ldc2_w 1247
    //   56: ldiv
    //   57: ladd
    //   58: lconst_1
    //   59: lsub
    //   60: lstore 15
    //   62: lload 7
    //   64: ldc2_w 4054
    //   67: lsub
    //   68: lstore 9
    //   70: lload 7
    //   72: lconst_1
    //   73: lsub
    //   74: lstore 11
    //   76: ldc_w 3516
    //   79: invokestatic 3548	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   82: astore 20
    //   84: new 3540	java/io/BufferedInputStream
    //   87: dup
    //   88: new 3522	java/io/FileInputStream
    //   91: dup
    //   92: aload_0
    //   93: invokespecial 3523	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   96: invokespecial 3543	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   99: astore 19
    //   101: lconst_0
    //   102: lstore_3
    //   103: iconst_0
    //   104: istore_1
    //   105: aload 19
    //   107: astore_0
    //   108: lload 17
    //   110: lload_3
    //   111: lsub
    //   112: lconst_1
    //   113: ladd
    //   114: ldc2_w 4056
    //   117: invokestatic 4060	java/lang/Math:min	(JJ)J
    //   120: l2i
    //   121: newarray byte
    //   123: astore 21
    //   125: aload 19
    //   127: astore_0
    //   128: aload 19
    //   130: aload 21
    //   132: invokevirtual 3554	java/io/InputStream:read	([B)I
    //   135: istore_2
    //   136: aload 19
    //   138: astore_0
    //   139: aload 20
    //   141: aload 21
    //   143: iconst_0
    //   144: iload_2
    //   145: invokevirtual 3558	java/security/MessageDigest:update	([BII)V
    //   148: lload_3
    //   149: iload_2
    //   150: i2l
    //   151: ladd
    //   152: lstore 5
    //   154: iload_1
    //   155: iload_2
    //   156: iadd
    //   157: istore_2
    //   158: iload_2
    //   159: istore_1
    //   160: lload 5
    //   162: lstore_3
    //   163: lload 5
    //   165: lload 17
    //   167: lconst_0
    //   168: lsub
    //   169: lconst_1
    //   170: ladd
    //   171: lcmp
    //   172: iflt -67 -> 105
    //   175: aload 19
    //   177: astore_0
    //   178: aload 19
    //   180: lload 13
    //   182: lload 17
    //   184: lsub
    //   185: lconst_1
    //   186: lsub
    //   187: invokevirtual 4063	java/io/InputStream:skip	(J)J
    //   190: pop2
    //   191: lconst_0
    //   192: lstore_3
    //   193: iload_2
    //   194: istore_1
    //   195: aload 19
    //   197: astore_0
    //   198: lload 15
    //   200: lload 13
    //   202: lsub
    //   203: lload_3
    //   204: lsub
    //   205: lconst_1
    //   206: ladd
    //   207: ldc2_w 4056
    //   210: invokestatic 4060	java/lang/Math:min	(JJ)J
    //   213: l2i
    //   214: newarray byte
    //   216: astore 21
    //   218: aload 19
    //   220: astore_0
    //   221: aload 19
    //   223: aload 21
    //   225: invokevirtual 3554	java/io/InputStream:read	([B)I
    //   228: istore_2
    //   229: aload 19
    //   231: astore_0
    //   232: aload 20
    //   234: aload 21
    //   236: iconst_0
    //   237: iload_2
    //   238: invokevirtual 3558	java/security/MessageDigest:update	([BII)V
    //   241: lload_3
    //   242: iload_2
    //   243: i2l
    //   244: ladd
    //   245: lstore 5
    //   247: iload_1
    //   248: iload_2
    //   249: iadd
    //   250: istore_2
    //   251: iload_2
    //   252: istore_1
    //   253: lload 5
    //   255: lstore_3
    //   256: lload 5
    //   258: lload 15
    //   260: lload 13
    //   262: lsub
    //   263: lconst_1
    //   264: ladd
    //   265: lcmp
    //   266: iflt -71 -> 195
    //   269: aload 19
    //   271: astore_0
    //   272: aload 19
    //   274: lload 9
    //   276: lload 15
    //   278: lsub
    //   279: lconst_1
    //   280: lsub
    //   281: invokevirtual 4063	java/io/InputStream:skip	(J)J
    //   284: pop2
    //   285: lconst_0
    //   286: lstore_3
    //   287: iload_2
    //   288: istore_1
    //   289: aload 19
    //   291: astore_0
    //   292: lload 11
    //   294: lload 9
    //   296: lsub
    //   297: lload_3
    //   298: lsub
    //   299: lconst_1
    //   300: ladd
    //   301: ldc2_w 4056
    //   304: invokestatic 4060	java/lang/Math:min	(JJ)J
    //   307: l2i
    //   308: newarray byte
    //   310: astore 21
    //   312: aload 19
    //   314: astore_0
    //   315: aload 19
    //   317: aload 21
    //   319: invokevirtual 3554	java/io/InputStream:read	([B)I
    //   322: istore_2
    //   323: iload_2
    //   324: ifgt +17 -> 341
    //   327: aload 19
    //   329: astore_0
    //   330: bipush 8
    //   332: newarray byte
    //   334: astore 21
    //   336: iconst_0
    //   337: istore_2
    //   338: goto +194 -> 532
    //   341: aload 19
    //   343: astore_0
    //   344: aload 20
    //   346: aload 21
    //   348: iconst_0
    //   349: iload_2
    //   350: invokevirtual 3558	java/security/MessageDigest:update	([BII)V
    //   353: lload_3
    //   354: iload_2
    //   355: i2l
    //   356: ladd
    //   357: lstore 5
    //   359: iload_1
    //   360: iload_2
    //   361: iadd
    //   362: istore_2
    //   363: iload_2
    //   364: istore_1
    //   365: lload 5
    //   367: lstore_3
    //   368: lload 5
    //   370: lload 11
    //   372: lload 9
    //   374: lsub
    //   375: lconst_1
    //   376: ladd
    //   377: lcmp
    //   378: iflt -89 -> 289
    //   381: iload_2
    //   382: istore_1
    //   383: goto -56 -> 327
    //   386: aload 19
    //   388: astore_0
    //   389: aload 20
    //   391: aload 21
    //   393: iconst_0
    //   394: bipush 8
    //   396: invokevirtual 3558	java/security/MessageDigest:update	([BII)V
    //   399: aload 19
    //   401: astore_0
    //   402: ldc_w 337
    //   405: iconst_1
    //   406: new 339	java/lang/StringBuilder
    //   409: dup
    //   410: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   413: ldc_w 4065
    //   416: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: iload_1
    //   420: invokevirtual 964	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   423: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: invokestatic 974	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   429: aload 19
    //   431: astore_0
    //   432: aload 20
    //   434: invokevirtual 3563	java/security/MessageDigest:digest	()[B
    //   437: astore 20
    //   439: aload 20
    //   441: astore_0
    //   442: aload_0
    //   443: astore 20
    //   445: aload 19
    //   447: ifnull -429 -> 18
    //   450: aload 19
    //   452: invokevirtual 3559	java/io/InputStream:close	()V
    //   455: aload_0
    //   456: areturn
    //   457: astore 19
    //   459: aload 19
    //   461: invokevirtual 1578	java/io/IOException:printStackTrace	()V
    //   464: aload_0
    //   465: areturn
    //   466: astore 20
    //   468: aconst_null
    //   469: astore 19
    //   471: aload 19
    //   473: astore_0
    //   474: aload 20
    //   476: invokevirtual 640	java/lang/Exception:printStackTrace	()V
    //   479: aload 19
    //   481: ifnull +8 -> 489
    //   484: aload 19
    //   486: invokevirtual 3559	java/io/InputStream:close	()V
    //   489: aconst_null
    //   490: areturn
    //   491: astore_0
    //   492: aload_0
    //   493: invokevirtual 1578	java/io/IOException:printStackTrace	()V
    //   496: goto -7 -> 489
    //   499: astore 19
    //   501: aconst_null
    //   502: astore_0
    //   503: aload_0
    //   504: ifnull +7 -> 511
    //   507: aload_0
    //   508: invokevirtual 3559	java/io/InputStream:close	()V
    //   511: aload 19
    //   513: athrow
    //   514: astore_0
    //   515: aload_0
    //   516: invokevirtual 1578	java/io/IOException:printStackTrace	()V
    //   519: goto -8 -> 511
    //   522: astore 19
    //   524: goto -21 -> 503
    //   527: astore 20
    //   529: goto -58 -> 471
    //   532: iload_2
    //   533: bipush 8
    //   535: if_icmpge -149 -> 386
    //   538: aload 21
    //   540: bipush 8
    //   542: iload_2
    //   543: isub
    //   544: iconst_1
    //   545: isub
    //   546: lload 7
    //   548: bipush 64
    //   550: iload_2
    //   551: iconst_1
    //   552: iadd
    //   553: bipush 8
    //   555: imul
    //   556: isub
    //   557: lshr
    //   558: ldc2_w 4066
    //   561: land
    //   562: l2i
    //   563: i2b
    //   564: bastore
    //   565: iload_2
    //   566: iconst_1
    //   567: iadd
    //   568: istore_2
    //   569: goto -37 -> 532
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	572	0	paramString	String
    //   104	316	1	i	int
    //   135	434	2	j	int
    //   102	266	3	l1	long
    //   152	217	5	l2	long
    //   4	543	7	l3	long
    //   68	305	9	l4	long
    //   74	297	11	l5	long
    //   42	219	13	l6	long
    //   60	217	15	l7	long
    //   26	157	17	l8	long
    //   99	352	19	localBufferedInputStream	java.io.BufferedInputStream
    //   457	3	19	localIOException	IOException
    //   469	16	19	localObject1	Object
    //   499	13	19	localObject2	Object
    //   522	1	19	localObject3	Object
    //   16	428	20	localObject4	Object
    //   466	9	20	localException1	Exception
    //   527	1	20	localException2	Exception
    //   123	416	21	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   450	455	457	java/io/IOException
    //   28	62	466	java/lang/Exception
    //   76	101	466	java/lang/Exception
    //   484	489	491	java/io/IOException
    //   28	62	499	finally
    //   76	101	499	finally
    //   507	511	514	java/io/IOException
    //   108	125	522	finally
    //   128	136	522	finally
    //   139	148	522	finally
    //   178	191	522	finally
    //   198	218	522	finally
    //   221	229	522	finally
    //   232	241	522	finally
    //   272	285	522	finally
    //   292	312	522	finally
    //   315	323	522	finally
    //   330	336	522	finally
    //   344	353	522	finally
    //   389	399	522	finally
    //   402	429	522	finally
    //   432	439	522	finally
    //   474	479	522	finally
    //   108	125	527	java/lang/Exception
    //   128	136	527	java/lang/Exception
    //   139	148	527	java/lang/Exception
    //   178	191	527	java/lang/Exception
    //   198	218	527	java/lang/Exception
    //   221	229	527	java/lang/Exception
    //   232	241	527	java/lang/Exception
    //   272	285	527	java/lang/Exception
    //   292	312	527	java/lang/Exception
    //   315	323	527	java/lang/Exception
    //   330	336	527	java/lang/Exception
    //   344	353	527	java/lang/Exception
    //   389	399	527	java/lang/Exception
    //   402	429	527	java/lang/Exception
    //   432	439	527	java/lang/Exception
  }
  
  public static int d(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      i = -1;
    }
    Object localObject;
    do
    {
      return i;
      localObject = FileUtil.c(paramString);
    } while (b().equalsIgnoreCase((String)localObject));
    try
    {
      localObject = BaseApplication.getContext().getSharedPreferences("ExternalFileOfFM", 0).edit();
      ((SharedPreferences.Editor)localObject).remove(paramString);
      ((SharedPreferences.Editor)localObject).commit();
      return 0;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return -2;
  }
  
  public static String d(int paramInt)
  {
    return HardCodeUtil.a(paramInt);
  }
  
  public static String d(FileManagerEntity paramFileManagerEntity)
  {
    if ((paramFileManagerEntity.isZipInnerFile) && (paramFileManagerEntity.nFileType == 0))
    {
      String str = paramFileManagerEntity.zipInnerPath;
      paramFileManagerEntity = (String)paramFileManagerEntity.mContext;
      paramFileManagerEntity = MD5.a(paramFileManagerEntity + str);
      return FMSettings.a().d() + "x-zip-" + paramFileManagerEntity;
    }
    return "";
  }
  
  public static String d(String paramString)
  {
    int i = 3;
    String str;
    if ((paramString == null) || (paramString.length() == 0))
    {
      str = "";
      return str;
    }
    boolean bool = a(paramString);
    if (FontSettingManager.getFontLevel() >= 20.0F) {
      if (bool) {
        i = 7;
      }
    }
    for (;;)
    {
      str = paramString;
      if (paramString.length() <= 16 - i) {
        break;
      }
      int j = paramString.length();
      str = paramString.substring(0, (16 - i) / 2);
      paramString = paramString.substring(j - (16 - i) / 2);
      return str + "..." + paramString;
      if (FontSettingManager.getFontLevel() >= 18.0F)
      {
        if (bool) {
          i = 5;
        } else {
          i = 2;
        }
      }
      else if (FontSettingManager.getFontLevel() >= 17.0F)
      {
        if (!bool) {
          i = 1;
        }
      }
      else {
        i = 0;
      }
    }
  }
  
  public static void d(FileManagerEntity paramFileManagerEntity)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    StringBuilder localStringBuilder;
    int i;
    for (;;)
    {
      try
      {
        localStringBuilder = new StringBuilder();
        if (paramFileManagerEntity == null)
        {
          localStringBuilder.append("entity is nll,stack:" + a());
          QLog.i("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
          return;
        }
        i = paramFileManagerEntity.nFileType;
        if ((i != 2) && (i != 0))
        {
          localStringBuilder.append("entity[").append(paramFileManagerEntity.nSessionId).append("] is not pic or video, return");
          QLog.i("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
          continue;
        }
        if (paramFileManagerEntity.imgHeight <= 0) {
          break;
        }
      }
      finally {}
      if (paramFileManagerEntity.imgWidth <= 0) {
        break;
      }
      localStringBuilder.append("entity[").append(paramFileManagerEntity.nSessionId).append("] size(wh)[").append(paramFileManagerEntity.imgWidth).append(":").append(paramFileManagerEntity.imgHeight).append("] OK, return!");
      QLog.i("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
    }
    Object localObject1 = paramFileManagerEntity.getFilePath();
    if (FileUtil.b((String)localObject1))
    {
      if (i == 2) {
        bool1 = false;
      }
      localStringBuilder.append("entity[").append(paramFileManagerEntity.nSessionId).append("] is local, use local calc size!");
    }
    Object localObject2;
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label426;
      }
      localStringBuilder.append("entity[").append(paramFileManagerEntity.nSessionId).append("] is No LoaclFile,No LargeThumb,No middleThumb,so return");
      QLog.e("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
      break;
      localObject1 = paramFileManagerEntity.strLargeThumPath;
      if (FileUtil.b((String)localObject1))
      {
        localStringBuilder.append("entity[").append(paramFileManagerEntity.nSessionId).append("] is cloude , use largThumb calc size!");
        bool1 = bool2;
      }
      else
      {
        localObject1 = paramFileManagerEntity.strMiddleThumPath;
        if (FileUtil.b((String)localObject1))
        {
          localStringBuilder.append("entity[").append(paramFileManagerEntity.nSessionId).append("] is cloud , use middleThumb calc size!,becarefull middle must createByLarge!!!");
          bool1 = bool2;
        }
        else
        {
          bool1 = bool2;
          if (i == 2)
          {
            localObject2 = paramFileManagerEntity.strThumbPath;
            bool1 = bool2;
            localObject1 = localObject2;
            if (FileUtil.b((String)localObject2))
            {
              localStringBuilder.append("entity[").append(paramFileManagerEntity.nSessionId).append("] video is cloud , use thumb calc size!");
              bool1 = bool2;
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    label426:
    if (bool1)
    {
      localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      FilePicURLDrawlableHelper.a((String)localObject1, (BitmapFactory.Options)localObject2);
      if ((paramFileManagerEntity.imgHeight <= 0) || (paramFileManagerEntity.imgWidth <= 0))
      {
        paramFileManagerEntity.imgWidth = ((BitmapFactory.Options)localObject2).outWidth;
        paramFileManagerEntity.imgHeight = ((BitmapFactory.Options)localObject2).outHeight;
      }
      i = URLDrawableHelper.getExifRotation((String)localObject1);
      if ((i == 90) || (i == 270))
      {
        paramFileManagerEntity.imgWidth = ((BitmapFactory.Options)localObject2).outHeight;
        paramFileManagerEntity.imgHeight = ((BitmapFactory.Options)localObject2).outWidth;
      }
    }
    for (;;)
    {
      localStringBuilder.append(" calc size over size(wh)[").append(paramFileManagerEntity.imgWidth).append(":").append(paramFileManagerEntity.imgHeight).append("]");
      localStringBuilder.append(" useImageCreateThumb:").append(bool1);
      QLog.i("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
      break;
      if (i == 2) {
        c(paramFileManagerEntity);
      }
    }
  }
  
  public static void d(String paramString)
  {
    try
    {
      BaseApplicationImpl.getContext().getContentResolver().delete(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_data=?", new String[] { paramString });
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static boolean d(FileManagerEntity paramFileManagerEntity)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramFileManagerEntity == null) {}
    while (paramFileManagerEntity.isZipInnerFile) {
      return false;
    }
    switch (a(paramFileManagerEntity))
    {
    case 5: 
    default: 
      return false;
    case 1: 
    case 2: 
    case 4: 
      return true;
    case 3: 
      if (paramFileManagerEntity.nFileType == 0) {}
      for (;;)
      {
        return bool1;
        bool1 = false;
      }
    }
    if (paramFileManagerEntity.nFileType == 0) {}
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public static byte[] d(String paramString)
  {
    return c(paramString);
  }
  
  public static int e(String paramString)
  {
    return BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getInt("qlink_new_count_" + paramString, 0);
  }
  
  public static String e(FileManagerEntity paramFileManagerEntity)
  {
    if (!ZhuoXusManager.a().i())
    {
      paramFileManagerEntity.strQRUrl = "";
      return "";
    }
    if (!TextUtils.isEmpty(paramFileManagerEntity.strQRUrl))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("IMG_FILE_QR", 1, "getImageUrl:" + paramFileManagerEntity.strQRUrl);
      }
      return paramFileManagerEntity.strQRUrl;
    }
    Object localObject;
    if (com.tencent.biz.qqstory.utils.FileUtils.c(paramFileManagerEntity.strMiddleThumPath)) {
      localObject = new File(paramFileManagerEntity.strMiddleThumPath);
    }
    for (String str = "mid";; str = "larg")
    {
      localObject = JumpShareUtils.a(BaseApplicationImpl.getContext(), (File)localObject);
      if (localObject == null) {
        break label205;
      }
      paramFileManagerEntity.strQRUrl = ((StringBuilder)((Pair)localObject).first).toString();
      if (QLog.isDevelopLevel()) {
        QLog.i("IMG_FILE_QR", 1, "getImageUrl success:" + paramFileManagerEntity.strQRUrl + " use:" + str);
      }
      return paramFileManagerEntity.strQRUrl;
      if (!com.tencent.biz.qqstory.utils.FileUtils.c(paramFileManagerEntity.strLargeThumPath)) {
        break;
      }
      localObject = new File(paramFileManagerEntity.strLargeThumPath);
    }
    return null;
    label205:
    return "";
  }
  
  public static String e(String paramString)
  {
    int i = 0;
    String str;
    if (paramString == null)
    {
      str = "";
      return str;
    }
    label180:
    for (;;)
    {
      try
      {
        ByteArrayBuffer localByteArrayBuffer = new ByteArrayBuffer(paramString.length());
        str = paramString;
        if ("AnDrDQ_Fm_String".length() == 0) {
          break;
        }
        if (!paramString.equals(null))
        {
          int j = 0;
          if (j < paramString.length())
          {
            if (i <= "AnDrDQ_Fm_String".length() - 1) {
              break label180;
            }
            i %= "AnDrDQ_Fm_String".length();
            int m = paramString.codePointAt(j) + "AnDrDQ_Fm_String".codePointAt(i);
            int k = m;
            if (m > 65535) {
              k = m % 65535;
            }
            localByteArrayBuffer.append(k);
            j += 1;
            i += 1;
            continue;
          }
        }
        paramString = com.qq.taf.jce.HexUtil.bytes2HexStr(localByteArrayBuffer.toByteArray());
        str = "#_#" + paramString + "O_O";
        break;
      }
      finally {}
    }
  }
  
  public static boolean e(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    while ((paramFileManagerEntity.TroopUin == 0L) || (TextUtils.isEmpty(paramFileManagerEntity.strTroopFileID)) || (TextUtils.isEmpty(paramFileManagerEntity.strTroopFilePath))) {
      return false;
    }
    return true;
  }
  
  public static byte[] e(String paramString)
  {
    return a(paramString, a(paramString));
  }
  
  public static String f(String paramString)
  {
    paramString = e(paramString);
    if (paramString == null) {
      return "";
    }
    paramString = com.qq.taf.jce.HexUtil.bytes2HexStr(paramString);
    return FMSettings.a().d() + "x-video-" + paramString;
  }
  
  public static boolean f(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return false;
    }
    if (FileUtil.b(paramFileManagerEntity.getFilePath())) {
      return true;
    }
    if (FileUtil.b(paramFileManagerEntity.strMiddleThumPath)) {
      return true;
    }
    if (FileUtil.b(paramFileManagerEntity.strLargeThumPath)) {
      return true;
    }
    if (FileUtil.b(paramFileManagerEntity.strThumbPath)) {
      return true;
    }
    QLog.i("FileManagerUtil<FileAssistant>", 1, "Id[" + paramFileManagerEntity.nSessionId + "] no Thumb!");
    return false;
  }
  
  private static int g(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return 4;
      if (paramString.equalsIgnoreCase("com.tencent.mtt")) {
        return 1;
      }
      if (paramString.equalsIgnoreCase("send_to_wx")) {
        return 2;
      }
    } while (!paramString.equalsIgnoreCase("cn.wps.moffice_eng"));
    return 3;
  }
  
  public static String g(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    int i = paramString.lastIndexOf(".");
    if ((i > 0) && (i < paramString.length() - 1)) {
      return paramString.substring(i + 1).toUpperCase();
    }
    return "";
  }
  
  public static String h(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = paramString.replace("ftn_compress_getfile", "ftn_compress_getabs");
    return paramString + "size=750&";
  }
  
  private static String j(String paramString)
  {
    String str = null;
    if (paramString.equalsIgnoreCase("userClickOnceEvent")) {
      str = "0X800AE45";
    }
    do
    {
      return str;
      if (paramString.equalsIgnoreCase("userClickAlwaysEvent")) {
        return "0X800AE44";
      }
    } while (!paramString.equalsIgnoreCase("userMenuClickEvent"));
    return "0X800AE43";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil
 * JD-Core Version:    0.7.0.1
 */