package com.tencent.mobileqq.pic.api;

import android.content.Intent;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;

@QAPI(process={"all"})
public abstract interface IPicBus
  extends QRouteApi
{
  public static final String AD_EMO_DESC_STR = "quick_send_ad_emo_desc_str";
  public static final String AD_EMO_JUMP_URL = "quick_send_ad_emo_jump_url";
  public static final int BUSI_TYPE_CHAT_PIC_DOWN = 1;
  public static final int BUSI_TYPE_CHAT_PIC_FORWARD_DOWN = 3;
  public static final int BUSI_TYPE_CHAT_PIC_PREDOWN = 2;
  public static final int BUSI_TYPE_CHAT_PIC_RESEND = 5;
  public static final int BUSI_TYPE_CHAT_PIC_SHARE_DOWN = 4;
  public static final int BUSI_TYPE_CHAT_PIC_SOGOU = 6;
  public static final int BUSI_TYPE_CHAT_UPLOAD_FORWARD_PICS = 7;
  public static final int EXTRA_FLAG_FOWARD_PHOTO = 10;
  public static final int EXTRA_FLAG_SEND_PHOTO = 0;
  public static final int EXTRA_FLAG_SEND_RAW_PHOTO = 1;
  public static final String IS_AD_EMO = "quick_send_is_ad_emo";
  public static final String IS_EMO_SEARCH = "quick_send_is_emo_search";
  public static final String MSG_EXTRA_KEY_IS_SYNC_QZONE = "msg_extra_key_is_sync_qzone";
  public static final String MSG_EXTRA_KEY_QZONE_ALBUM_ID = "msg_extra_key_qzone_album_id";
  public static final String MSG_EXTRA_KEY_QZONE_BATCH_COUNT = "msg_extra_key_qzone_batch_count";
  public static final String MSG_EXTRA_KEY_QZONE_BATCH_ID = "msg_extra_key_qzone_batch_id";
  public static final String MSG_EXTRA_KEY_QZONE_IS_RAW = "msg_extra_key_qzone_is_raw";
  public static final String MSG_EXTRA_KEY_QZONE_PHOTO_INDEX = "msg_extra_key_qzone_photo_index";
  public static final String ORIGINAL_MD5 = "quick_send_original_md5";
  public static final String ORIGINAL_SIZE = "quick_send_original_size";
  public static final int SEND_MSG_BUSINESS_TYPE_AIO_ALBUM_PIC = 1031;
  public static final int SEND_MSG_BUSINESS_TYPE_AIO_KEY_WORD_PIC = 1046;
  public static final int SEND_MSG_BUSINESS_TYPE_AIO_QZONE_PIC = 1045;
  public static final int SEND_MSG_BUSINESS_TYPE_ALBUM_PIC = 1007;
  public static final int SEND_MSG_BUSINESS_TYPE_BLESS = 1056;
  public static final int SEND_MSG_BUSINESS_TYPE_CAPTURE_PIC = 1008;
  public static final int SEND_MSG_BUSINESS_TYPE_COMMEN_FALSH_PIC = 1040;
  public static final int SEND_MSG_BUSINESS_TYPE_CUSTOM = 1006;
  public static final int SEND_MSG_BUSINESS_TYPE_DOUTU_PIC = 1044;
  public static final int SEND_MSG_BUSINESS_TYPE_FALSH_PIC = 1039;
  public static final int SEND_MSG_BUSINESS_TYPE_FAST_IMAGE = 1037;
  public static final int SEND_MSG_BUSINESS_TYPE_FORWARD_EDIT = 1048;
  public static final int SEND_MSG_BUSINESS_TYPE_FORWARD_PIC = 1009;
  public static final int SEND_MSG_BUSINESS_TYPE_FULL_SCREEN_ESSENCE = 1057;
  public static final int SEND_MSG_BUSINESS_TYPE_GALEERY_PIC = 1041;
  public static final int SEND_MSG_BUSINESS_TYPE_HOT_PIC = 1042;
  public static final int SEND_MSG_BUSINESS_TYPE_MIXED_PICS = 1043;
  public static final int SEND_MSG_BUSINESS_TYPE_PIC_AIO_ALBUM = 1052;
  public static final int SEND_MSG_BUSINESS_TYPE_PIC_CAMERA = 1050;
  public static final int SEND_MSG_BUSINESS_TYPE_PIC_FAV = 1053;
  public static final int SEND_MSG_BUSINESS_TYPE_PIC_SCREEN = 1027;
  public static final int SEND_MSG_BUSINESS_TYPE_PIC_SHARE = 1030;
  public static final int SEND_MSG_BUSINESS_TYPE_PIC_TAB_CAMERA = 1051;
  public static final int SEND_MSG_BUSINESS_TYPE_QQPINYIN_SEND_PIC = 1038;
  public static final int SEND_MSG_BUSINESS_TYPE_RECOMMENDED_STICKER = 1047;
  public static final int SEND_MSG_BUSINESS_TYPE_RELATED_EMOTION = 1054;
  public static final int SEND_MSG_BUSINESS_TYPE_SHOWLOVE = 1036;
  public static final int SEND_MSG_BUSINESS_TYPE_SOGOU_SEND_PIC = 1034;
  public static final int SEND_MSG_BUSINESS_TYPE_TROOP_BAR = 1035;
  public static final int SEND_MSG_BUSINESS_TYPE_WLAN_RECV_NOTIFY = 1055;
  public static final int SEND_MSG_BUSINESS_TYPE_ZHITU_PIC = 1049;
  public static final String THUMB_MD5 = "quick_send_thumb_md5";
  
  public abstract CompressInfo createCompressInfo(int paramInt, Intent paramIntent);
  
  public abstract PicFowardInfo createForwardPicInfo(int paramInt, Intent paramIntent);
  
  public abstract PicFowardInfo createForwardPicInfo(int paramInt1, MessageForPic paramMessageForPic, int paramInt2, String paramString1, String paramString2, String paramString3);
  
  public abstract ArrayList<PicFowardInfo> createForwardPicInfos(int paramInt1, MessageRecord paramMessageRecord, int paramInt2, String paramString1, String paramString2, String paramString3);
  
  public abstract PicReq createPicReq(int paramInt1, int paramInt2);
  
  public abstract PicReq createPicReq(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract PicUploadInfo createPicUploadInfo(int paramInt, Intent paramIntent);
  
  public abstract long getC2CPicSizeLimit();
  
  public abstract long getGroupPicSizeLimit();
  
  public abstract void launch(PicReq paramPicReq);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.api.IPicBus
 * JD-Core Version:    0.7.0.1
 */