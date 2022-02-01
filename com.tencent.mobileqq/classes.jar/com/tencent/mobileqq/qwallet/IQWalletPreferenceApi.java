package com.tencent.mobileqq.qwallet;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQWalletPreferenceApi
  extends QRouteApi
{
  public static final String KEY_BANK_CARD_INSTRUCTION_URL = "bankCardInstructionUrl";
  public static final String KEY_BIRTHDAY_HB = "birthdayHB";
  public static final String KEY_BIRTHDAY_HB_INVALID_SPACE = "birthdayHB_invalidSpace_";
  public static final String KEY_BIRTHDAY_HB_SKIN_LIST = "birthdayHB_skinList_";
  public static final String KEY_BIRTHDAY_HB_SKIN_LIST_BACK_ARC_COLOR = "backArcColor";
  public static final String KEY_BIRTHDAY_HB_SKIN_LIST_BG_COLOR = "bgColor";
  public static final String KEY_BIRTHDAY_HB_SKIN_LIST_BG_URL = "bgURL";
  public static final String KEY_BIRTHDAY_HB_SKIN_LIST_PRE_ARC_COLOR = "preArcColor";
  public static final String KEY_BIRTHDAY_HB_SKIN_LIST_SKINID = "skinId";
  public static final String KEY_BIRTHDAY_HB_THEME_LIST = "birthdayHB_themeList_";
  public static final String KEY_BIRTHDAY_HB_THEME_LIST_MONEY = "money";
  public static final String KEY_BIRTHDAY_HB_THEME_LIST_TEXT = "text";
  public static final String KEY_BIRTHDAY_HB_THEME_LIST_WISH_TEXT = "wishText";
  public static final String KEY_BIRTHDAY_HB_WISH_MAX_LEN = "birthdayHB_wishMaxLen_";
  public static final String KEY_BIRTHDAY_HB_WISH_PLACEHOLDER = "birthdayHB_wishPlaceholder_";
  public static final String KEY_F2F_REDPACK_ENTRY = "F2FRedpackEntry";
  public static final String KEY_PAY_INSTRUCTION_URL = "payInstructionUrl";
  public static final String KEY_REDPACK_POPWND_BEGIN_TIME = "redpack_popwnd_begin_time_";
  public static final String KEY_REDPACK_POPWND_CURRENT = "redpack_popwnd_current_";
  public static final String KEY_REDPACK_POPWND_END_TIME = "redpack_popwnd_end_time_";
  public static final String KEY_REDPACK_POPWND_FREQ = "redpack_popwnd_freq_";
  public static final String KEY_REDPACK_POPWND_GROUP_TYPE = "redpack_popwnd_group_type_";
  public static final String KEY_REDPACK_POPWND_ID = "redpack_popwnd_id";
  public static final String KEY_REDPACK_POPWND_LAST_SHOW_TIME = "redpack_popwnd_last_show_time_";
  public static final String KEY_REDPACK_POPWND_NETWORK = "redpack_popwnd_network_";
  public static final String KEY_REDPACK_POPWND_STATE = "redpack_popwnd_state_";
  public static final String KEY_REDPACK_POPWND_TOTAL = "redpack_popwnd_total_";
  public static final String KEY_REDPACK_POPWND_URL = "redpack_popwnd_url_";
  public static final String KEY_SKIN_ENRTY_ERROR_TIPS = "skin_entry_error_tips";
  public static final String KEY_SKIN_LIST = "skinList";
  public static final String KEY_STRANGER_CHAT_EXT = "strangerchat_ext";
  public static final String KEY_THEME_LIST = "themeList";
  public static final String KEY_WALLET_APPLIST_CONFIG = "qqwallet_entry_applist_config";
  public static final String KEY_WALLET_APPLIST_CONFIG_NUM_COLS = "num_cols";
  public static final String KEY_WALLET_CONSTANTS = "walletConstants";
  public static final String KEY_WALLET_CONSTANTS_BANK_CARD_INSTRUCTION_URL = "walletConstants_bankCardInstructionUrl";
  public static final String KEY_WALLET_CONSTANTS_PAY_INSTRUCTION_URL = "walletConstants_payInstructionUrl";
  public static final String KEY_WALLET_CONSTANTS_TENPAY_PROTOCOL_URL = "walletConstants_tenpayProtocolUrls";
  public static final String KEY_WALLET_MICRO_RECYCLE = "microRecycle";
  public static final String KEY_WALLET_MICRO_RECYCLE_NORMAL_COLOR = "microRecycle_normalColor";
  public static final String KEY_WALLET_MICRO_RECYCLE_PRESS_COLOR = "microRecycle_pressColor";
  public static final String KEY_WALLET_MICRO_RECYCLE_TITLE = "microRecycle_title";
  public static final String KEY_WALLET_MICRO_RECYCLE_URL = "microRecycle_url";
  public static final String KEY_WALLET_PUB_MSG_TAIL = "walletPubMsgTail";
  public static final String KEY_WALLET_PUB_MSG_TAIL_BUSI_TYPE = "walletPubMsgTail_busiType";
  public static final String KEY_WALLET_PUB_MSG_TAIL_IMG_URL = "walletPubMsgTail_imgURL";
  public static final String KEY_WALLET_PUB_MSG_TAIL_JUMP_URL = "walletPubMsgTail_jumpURL";
  public static final String KEY_WALLET_PUB_MSG_TAIL_TITLE = "walletPubMsgTail_title";
  public static final String KEY_WISH_MAX_LEN = "wishMaxLen";
  public static final String KEY_WISH_PLACEHOLDER = "wishPlaceholder";
  public static final String TENPAY_PROTOCOL_URL = "tenpayProtocolUrls";
  public static final String kEY_INVALID_SPACE = "invalidSpace";
  
  public abstract boolean getBoolean(String paramString1, String paramString2, String paramString3, boolean paramBoolean);
  
  public abstract boolean getBoolean(String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract int getInt(String paramString, int paramInt);
  
  public abstract int getInt(String paramString1, String paramString2, int paramInt);
  
  public abstract long getLong(String paramString1, String paramString2, long paramLong);
  
  public abstract String getString(String paramString1, String paramString2, String paramString3);
  
  public abstract boolean isShowF2FRedpackEntryColor(String paramString);
  
  public abstract void putBoolean(String paramString1, String paramString2, String paramString3, boolean paramBoolean);
  
  public abstract void putBoolean(String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract void putInt(String paramString, int paramInt);
  
  public abstract void putInt(String paramString1, String paramString2, int paramInt);
  
  public abstract void putLong(String paramString1, String paramString2, long paramLong);
  
  public abstract void putString(String paramString1, String paramString2, String paramString3);
  
  public abstract void removeSp(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.IQWalletPreferenceApi
 * JD-Core Version:    0.7.0.1
 */