import android.os.Handler.Callback;
import com.tencent.mobileqq.activity.Conversation;

public class scu
  implements Handler.Callback
{
  public scu(Conversation paramConversation) {}
  
  /* Error */
  public boolean handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: iconst_2
    //   1: istore_2
    //   2: iconst_0
    //   3: istore 4
    //   5: iconst_0
    //   6: istore_3
    //   7: aload_1
    //   8: getfield 26	android/os/Message:what	I
    //   11: ldc 27
    //   13: if_icmpne +16 -> 29
    //   16: aload_0
    //   17: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   20: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   23: bipush 10
    //   25: iconst_0
    //   26: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   29: aload_1
    //   30: getfield 26	android/os/Message:what	I
    //   33: ldc 38
    //   35: if_icmpeq +18 -> 53
    //   38: aload_0
    //   39: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   42: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   45: invokevirtual 47	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   48: ifne +5 -> 53
    //   51: iconst_1
    //   52: ireturn
    //   53: aload_1
    //   54: getfield 26	android/os/Message:what	I
    //   57: lookupswitch	default:+579->636, 1009:+590->647, 1010:+625->682, 1014:+2143->2200, 1016:+2153->2210, 1017:+2242->2299, 1019:+2573->2630, 1020:+2252->2309, 1023:+701->758, 1024:+2592->2649, 1025:+581->638, 1030:+2616->2673, 1032:+2035->2092, 1033:+2063->2120, 1035:+2723->2780, 1038:+2732->2789, 1039:+2760->2817, 1040:+2091->2148, 1041:+2117->2174, 1042:+2844->2901, 1044:+2873->2930, 1048:+2895->2952, 1049:+2788->2845, 1050:+2816->2873, 1051:+2972->3029, 1052:+3116->3173, 1053:+3161->3218, 1054:+3190->3247, 1055:+3268->3325, 10000:+2261->2318, 10001:+614->671, 10002:+614->671, 1134010:+1283->1340, 1134011:+1311->1368, 1134012:+1974->2031, 1134013:+1999->2056, 1134014:+2024->2081, 1134015:+1949->2006, 1134018:+849->906, 1134019:+1030->1087, 1134020:+1113->1170, 1134021:+1860->1917, 1134022:+1888->1945, 1134024:+1916->1973, 1134025:+2625->2682, 1134026:+2677->2734, 1134027:+1395->1452, 1134028:+1450->1507, 1134030:+3170->3227, 1134039:+1626->1683, 1134040:+1681->1738, 1134041:+1709->1766, 1134042:+1764->1821, 1134043:+1478->1535, 1134044:+1506->1563, 1134045:+1123->1180, 1134047:+1133->1190, 1134048:+1150->1207, 1134049:+1792->1849, 1134050:+1832->1889, 1134051:+1534->1591, 1134052:+1584->1641, 1134057:+1167->1224, 1134058:+1184->1241, 1134059:+1339->1396, 1134060:+1367->1424, 1134061:+3437->3494, 1134062:+3471->3528, 1134200:+3312->3369, 1134201:+3358->3415, 11340003:+718->775, 11340004:+1255->1312
    //   637: ireturn
    //   638: aload_0
    //   639: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   642: invokestatic 49	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   645: iconst_1
    //   646: ireturn
    //   647: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   650: ifeq +11 -> 661
    //   653: ldc 56
    //   655: iconst_2
    //   656: ldc 58
    //   658: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   661: aload_0
    //   662: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   665: lconst_0
    //   666: invokevirtual 65	com/tencent/mobileqq/activity/Conversation:a	(J)V
    //   669: iconst_1
    //   670: ireturn
    //   671: aload_0
    //   672: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   675: aload_1
    //   676: iconst_1
    //   677: invokevirtual 68	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;Z)V
    //   680: iconst_1
    //   681: ireturn
    //   682: aload_0
    //   683: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   686: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   689: invokevirtual 70	com/tencent/mobileqq/activity/recent/BannerManager:a	()Z
    //   692: ifeq +38 -> 730
    //   695: aload_0
    //   696: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   699: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   702: bipush 17
    //   704: iconst_2
    //   705: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   708: aload_0
    //   709: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   712: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   715: bipush 17
    //   717: aload_1
    //   718: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   721: aload_0
    //   722: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   725: invokestatic 76	com/tencent/mobileqq/activity/Conversation:b	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   728: iconst_1
    //   729: ireturn
    //   730: aload_0
    //   731: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   734: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   737: bipush 17
    //   739: iconst_0
    //   740: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   743: aload_0
    //   744: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   747: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   750: bipush 17
    //   752: aconst_null
    //   753: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   756: iconst_1
    //   757: ireturn
    //   758: invokestatic 82	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   761: new 84	scv
    //   764: dup
    //   765: aload_0
    //   766: invokespecial 87	scv:<init>	(Lscu;)V
    //   769: invokevirtual 93	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   772: pop
    //   773: iconst_1
    //   774: ireturn
    //   775: invokestatic 98	com/tencent/mobileqq/app/upgrade/UpgradeController:a	()Lcom/tencent/mobileqq/app/upgrade/UpgradeController;
    //   778: invokevirtual 101	com/tencent/mobileqq/app/upgrade/UpgradeController:a	()Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;
    //   781: astore 10
    //   783: aload 10
    //   785: getfield 106	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:a	Lcom/tencent/mobileqq/app/NewUpgradeConfig;
    //   788: ifnull -737 -> 51
    //   791: aload_0
    //   792: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   795: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   798: invokevirtual 110	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   801: astore 11
    //   803: aload 11
    //   805: ldc 112
    //   807: lconst_0
    //   808: invokeinterface 118 4 0
    //   813: lstore 5
    //   815: new 120	java/util/Date
    //   818: dup
    //   819: invokespecial 121	java/util/Date:<init>	()V
    //   822: invokevirtual 125	java/util/Date:getTime	()J
    //   825: lstore 7
    //   827: lload 7
    //   829: lload 5
    //   831: lsub
    //   832: aload 10
    //   834: getfield 106	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:a	Lcom/tencent/mobileqq/app/NewUpgradeConfig;
    //   837: getfield 131	com/tencent/mobileqq/app/NewUpgradeConfig:dialog	Lcom/tencent/mobileqq/app/NewUpgradeConfig$Dialog;
    //   840: getfield 135	com/tencent/mobileqq/app/NewUpgradeConfig$Dialog:b	I
    //   843: bipush 24
    //   845: imul
    //   846: bipush 60
    //   848: imul
    //   849: bipush 60
    //   851: imul
    //   852: sipush 1000
    //   855: imul
    //   856: i2l
    //   857: lcmp
    //   858: ifle -807 -> 51
    //   861: aload_0
    //   862: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   865: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   868: bipush 10
    //   870: iconst_2
    //   871: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   874: aload_0
    //   875: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   878: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   881: bipush 10
    //   883: aload_1
    //   884: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   887: aload 11
    //   889: invokeinterface 139 1 0
    //   894: ldc 112
    //   896: lload 7
    //   898: invokeinterface 145 4 0
    //   903: pop
    //   904: iconst_1
    //   905: ireturn
    //   906: invokestatic 98	com/tencent/mobileqq/app/upgrade/UpgradeController:a	()Lcom/tencent/mobileqq/app/upgrade/UpgradeController;
    //   909: invokevirtual 101	com/tencent/mobileqq/app/upgrade/UpgradeController:a	()Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;
    //   912: astore 10
    //   914: aload 10
    //   916: getfield 106	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:a	Lcom/tencent/mobileqq/app/NewUpgradeConfig;
    //   919: ifnull -868 -> 51
    //   922: aload_0
    //   923: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   926: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   929: invokevirtual 110	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   932: astore 11
    //   934: aload 11
    //   936: ldc 112
    //   938: lconst_0
    //   939: invokeinterface 118 4 0
    //   944: lstore 5
    //   946: new 120	java/util/Date
    //   949: dup
    //   950: invokespecial 121	java/util/Date:<init>	()V
    //   953: invokevirtual 125	java/util/Date:getTime	()J
    //   956: lstore 7
    //   958: lload 7
    //   960: lload 5
    //   962: lsub
    //   963: aload 10
    //   965: getfield 106	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:a	Lcom/tencent/mobileqq/app/NewUpgradeConfig;
    //   968: getfield 131	com/tencent/mobileqq/app/NewUpgradeConfig:dialog	Lcom/tencent/mobileqq/app/NewUpgradeConfig$Dialog;
    //   971: getfield 135	com/tencent/mobileqq/app/NewUpgradeConfig$Dialog:b	I
    //   974: bipush 24
    //   976: imul
    //   977: bipush 60
    //   979: imul
    //   980: bipush 60
    //   982: imul
    //   983: sipush 1000
    //   986: imul
    //   987: i2l
    //   988: lcmp
    //   989: ifle +64 -> 1053
    //   992: aload_0
    //   993: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   996: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   999: bipush 12
    //   1001: iconst_2
    //   1002: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1005: aload_0
    //   1006: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1009: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1012: bipush 10
    //   1014: iconst_0
    //   1015: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1018: aload_0
    //   1019: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1022: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1025: bipush 12
    //   1027: aload_1
    //   1028: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   1031: aload 11
    //   1033: invokeinterface 139 1 0
    //   1038: ldc 112
    //   1040: lload 7
    //   1042: invokeinterface 145 4 0
    //   1047: invokeinterface 148 1 0
    //   1052: pop
    //   1053: aload_1
    //   1054: getfield 152	android/os/Message:obj	Ljava/lang/Object;
    //   1057: ifnull -1006 -> 51
    //   1060: aload_1
    //   1061: getfield 152	android/os/Message:obj	Ljava/lang/Object;
    //   1064: instanceof 154
    //   1067: ifeq -1016 -> 51
    //   1070: aload_1
    //   1071: getfield 152	android/os/Message:obj	Ljava/lang/Object;
    //   1074: checkcast 154	com/tencent/mobileqq/activity/UpgradeActivity
    //   1077: astore_1
    //   1078: invokestatic 98	com/tencent/mobileqq/app/upgrade/UpgradeController:a	()Lcom/tencent/mobileqq/app/upgrade/UpgradeController;
    //   1081: aload_1
    //   1082: invokevirtual 157	com/tencent/mobileqq/app/upgrade/UpgradeController:a	(Landroid/content/Context;)V
    //   1085: iconst_1
    //   1086: ireturn
    //   1087: aload_0
    //   1088: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1091: invokestatic 160	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   1094: ifnull +22 -> 1116
    //   1097: aload_0
    //   1098: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1101: invokestatic 160	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   1104: invokevirtual 165	com/tencent/mobileqq/activity/UpgradeTipsDialog:dismiss	()V
    //   1107: aload_0
    //   1108: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1111: aconst_null
    //   1112: invokestatic 168	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;)Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   1115: pop
    //   1116: aload_0
    //   1117: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1120: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1123: bipush 12
    //   1125: iconst_0
    //   1126: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1129: aload_0
    //   1130: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1133: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1136: bipush 12
    //   1138: aload_1
    //   1139: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   1142: iconst_1
    //   1143: ireturn
    //   1144: astore 10
    //   1146: aload_0
    //   1147: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1150: aconst_null
    //   1151: invokestatic 168	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;)Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   1154: pop
    //   1155: goto -39 -> 1116
    //   1158: astore_1
    //   1159: aload_0
    //   1160: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1163: aconst_null
    //   1164: invokestatic 168	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;)Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   1167: pop
    //   1168: aload_1
    //   1169: athrow
    //   1170: aload_0
    //   1171: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1174: aload_1
    //   1175: invokestatic 171	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Landroid/os/Message;)V
    //   1178: iconst_1
    //   1179: ireturn
    //   1180: aload_0
    //   1181: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1184: aload_1
    //   1185: invokestatic 173	com/tencent/mobileqq/activity/Conversation:b	(Lcom/tencent/mobileqq/activity/Conversation;Landroid/os/Message;)V
    //   1188: iconst_1
    //   1189: ireturn
    //   1190: invokestatic 82	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   1193: new 175	scx
    //   1196: dup
    //   1197: aload_0
    //   1198: invokespecial 176	scx:<init>	(Lscu;)V
    //   1201: invokevirtual 93	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   1204: pop
    //   1205: iconst_1
    //   1206: ireturn
    //   1207: invokestatic 82	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   1210: new 178	scz
    //   1213: dup
    //   1214: aload_0
    //   1215: invokespecial 179	scz:<init>	(Lscu;)V
    //   1218: invokevirtual 93	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   1221: pop
    //   1222: iconst_1
    //   1223: ireturn
    //   1224: new 181	sda
    //   1227: dup
    //   1228: aload_0
    //   1229: invokespecial 182	sda:<init>	(Lscu;)V
    //   1232: bipush 8
    //   1234: aconst_null
    //   1235: iconst_1
    //   1236: invokestatic 185	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1239: iconst_1
    //   1240: ireturn
    //   1241: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1244: ifeq +11 -> 1255
    //   1247: ldc 56
    //   1249: iconst_2
    //   1250: ldc 187
    //   1252: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1255: aload_0
    //   1256: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1259: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1262: invokestatic 195	com/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper;
    //   1265: astore 10
    //   1267: aload 10
    //   1269: invokevirtual 197	com/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper:a	()V
    //   1272: aload_0
    //   1273: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1276: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1279: aload 10
    //   1281: invokestatic 200	com/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper;)V
    //   1284: aload_0
    //   1285: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1288: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1291: bipush 22
    //   1293: iconst_0
    //   1294: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1297: aload_0
    //   1298: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1301: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1304: bipush 22
    //   1306: aload_1
    //   1307: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   1310: iconst_1
    //   1311: ireturn
    //   1312: aload_0
    //   1313: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1316: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1319: bipush 10
    //   1321: iconst_0
    //   1322: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1325: aload_0
    //   1326: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1329: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1332: bipush 10
    //   1334: aload_1
    //   1335: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   1338: iconst_1
    //   1339: ireturn
    //   1340: aload_0
    //   1341: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1344: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1347: bipush 31
    //   1349: iconst_2
    //   1350: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1353: aload_0
    //   1354: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1357: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1360: bipush 31
    //   1362: aload_1
    //   1363: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   1366: iconst_1
    //   1367: ireturn
    //   1368: aload_0
    //   1369: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1372: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1375: bipush 31
    //   1377: iconst_0
    //   1378: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1381: aload_0
    //   1382: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1385: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1388: bipush 31
    //   1390: aload_1
    //   1391: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   1394: iconst_1
    //   1395: ireturn
    //   1396: aload_0
    //   1397: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1400: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1403: bipush 29
    //   1405: iconst_2
    //   1406: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1409: aload_0
    //   1410: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1413: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1416: bipush 29
    //   1418: aload_1
    //   1419: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   1422: iconst_1
    //   1423: ireturn
    //   1424: aload_0
    //   1425: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1428: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1431: bipush 29
    //   1433: iconst_0
    //   1434: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1437: aload_0
    //   1438: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1441: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1444: bipush 29
    //   1446: aload_1
    //   1447: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   1450: iconst_1
    //   1451: ireturn
    //   1452: aload_0
    //   1453: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1456: getfield 203	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1459: ldc 204
    //   1461: invokevirtual 208	mqq/os/MqqHandler:hasMessages	(I)Z
    //   1464: ifeq +15 -> 1479
    //   1467: aload_0
    //   1468: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1471: getfield 203	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1474: ldc 204
    //   1476: invokevirtual 212	mqq/os/MqqHandler:removeMessages	(I)V
    //   1479: aload_0
    //   1480: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1483: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1486: bipush 23
    //   1488: iconst_2
    //   1489: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1492: aload_0
    //   1493: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1496: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1499: bipush 23
    //   1501: aload_1
    //   1502: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   1505: iconst_1
    //   1506: ireturn
    //   1507: aload_0
    //   1508: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1511: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1514: bipush 23
    //   1516: iconst_0
    //   1517: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1520: aload_0
    //   1521: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1524: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1527: bipush 23
    //   1529: aload_1
    //   1530: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   1533: iconst_1
    //   1534: ireturn
    //   1535: aload_0
    //   1536: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1539: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1542: bipush 27
    //   1544: iconst_2
    //   1545: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1548: aload_0
    //   1549: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1552: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1555: bipush 27
    //   1557: aload_1
    //   1558: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   1561: iconst_1
    //   1562: ireturn
    //   1563: aload_0
    //   1564: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1567: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1570: bipush 27
    //   1572: iconst_0
    //   1573: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1576: aload_0
    //   1577: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1580: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1583: bipush 27
    //   1585: aload_1
    //   1586: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   1589: iconst_1
    //   1590: ireturn
    //   1591: aload_1
    //   1592: getfield 215	android/os/Message:arg1	I
    //   1595: iconst_1
    //   1596: if_icmpeq +16 -> 1612
    //   1599: aload_0
    //   1600: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1603: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1606: bipush 28
    //   1608: iconst_2
    //   1609: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1612: aload_0
    //   1613: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1616: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1619: bipush 28
    //   1621: aload_1
    //   1622: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   1625: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1628: ifeq -1577 -> 51
    //   1631: ldc 217
    //   1633: iconst_2
    //   1634: ldc 219
    //   1636: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1639: iconst_1
    //   1640: ireturn
    //   1641: aload_0
    //   1642: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1645: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1648: bipush 28
    //   1650: iconst_0
    //   1651: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1654: aload_0
    //   1655: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1658: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1661: bipush 28
    //   1663: aload_1
    //   1664: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   1667: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1670: ifeq -1619 -> 51
    //   1673: ldc 217
    //   1675: iconst_2
    //   1676: ldc 221
    //   1678: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1681: iconst_1
    //   1682: ireturn
    //   1683: aload_0
    //   1684: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1687: getfield 203	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1690: ldc 222
    //   1692: invokevirtual 208	mqq/os/MqqHandler:hasMessages	(I)Z
    //   1695: ifeq +15 -> 1710
    //   1698: aload_0
    //   1699: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1702: getfield 203	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1705: ldc 222
    //   1707: invokevirtual 212	mqq/os/MqqHandler:removeMessages	(I)V
    //   1710: aload_0
    //   1711: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1714: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1717: bipush 24
    //   1719: iconst_2
    //   1720: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1723: aload_0
    //   1724: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1727: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1730: bipush 24
    //   1732: aload_1
    //   1733: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   1736: iconst_1
    //   1737: ireturn
    //   1738: aload_0
    //   1739: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1742: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1745: bipush 24
    //   1747: iconst_0
    //   1748: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1751: aload_0
    //   1752: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1755: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1758: bipush 24
    //   1760: aload_1
    //   1761: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   1764: iconst_1
    //   1765: ireturn
    //   1766: aload_0
    //   1767: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1770: getfield 203	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1773: ldc 223
    //   1775: invokevirtual 208	mqq/os/MqqHandler:hasMessages	(I)Z
    //   1778: ifeq +15 -> 1793
    //   1781: aload_0
    //   1782: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1785: getfield 203	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1788: ldc 223
    //   1790: invokevirtual 212	mqq/os/MqqHandler:removeMessages	(I)V
    //   1793: aload_0
    //   1794: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1797: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1800: bipush 25
    //   1802: iconst_2
    //   1803: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1806: aload_0
    //   1807: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1810: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1813: bipush 25
    //   1815: aload_1
    //   1816: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   1819: iconst_1
    //   1820: ireturn
    //   1821: aload_0
    //   1822: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1825: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1828: bipush 25
    //   1830: iconst_0
    //   1831: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1834: aload_0
    //   1835: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1838: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1841: bipush 25
    //   1843: aload_1
    //   1844: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   1847: iconst_1
    //   1848: ireturn
    //   1849: aload_0
    //   1850: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1853: getfield 203	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1856: ldc 224
    //   1858: invokevirtual 208	mqq/os/MqqHandler:hasMessages	(I)Z
    //   1861: ifeq +15 -> 1876
    //   1864: aload_0
    //   1865: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1868: getfield 203	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1871: ldc 224
    //   1873: invokevirtual 212	mqq/os/MqqHandler:removeMessages	(I)V
    //   1876: aload_0
    //   1877: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1880: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1883: aload_1
    //   1884: invokevirtual 227	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   1887: iconst_1
    //   1888: ireturn
    //   1889: aload_0
    //   1890: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1893: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1896: bipush 26
    //   1898: iconst_0
    //   1899: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1902: aload_0
    //   1903: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1906: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1909: bipush 26
    //   1911: aload_1
    //   1912: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   1915: iconst_1
    //   1916: ireturn
    //   1917: aload_0
    //   1918: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1921: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1924: bipush 6
    //   1926: iconst_2
    //   1927: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1930: aload_0
    //   1931: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1934: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1937: bipush 6
    //   1939: aload_1
    //   1940: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   1943: iconst_1
    //   1944: ireturn
    //   1945: aload_0
    //   1946: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1949: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1952: bipush 6
    //   1954: iconst_0
    //   1955: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1958: aload_0
    //   1959: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1962: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1965: bipush 6
    //   1967: aload_1
    //   1968: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   1971: iconst_1
    //   1972: ireturn
    //   1973: aload_1
    //   1974: getfield 215	android/os/Message:arg1	I
    //   1977: istore_2
    //   1978: aload_0
    //   1979: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1982: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1985: bipush 7
    //   1987: iload_2
    //   1988: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1991: aload_0
    //   1992: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1995: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1998: bipush 7
    //   2000: aload_1
    //   2001: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   2004: iconst_1
    //   2005: ireturn
    //   2006: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2009: ifeq +11 -> 2020
    //   2012: ldc 56
    //   2014: iconst_2
    //   2015: ldc 229
    //   2017: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2020: aload_0
    //   2021: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2024: aload_1
    //   2025: iconst_0
    //   2026: invokevirtual 68	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;Z)V
    //   2029: iconst_1
    //   2030: ireturn
    //   2031: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2034: ifeq +11 -> 2045
    //   2037: ldc 56
    //   2039: iconst_2
    //   2040: ldc 231
    //   2042: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2045: aload_0
    //   2046: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2049: aload_1
    //   2050: iconst_1
    //   2051: invokevirtual 68	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;Z)V
    //   2054: iconst_1
    //   2055: ireturn
    //   2056: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2059: ifeq +11 -> 2070
    //   2062: ldc 56
    //   2064: iconst_2
    //   2065: ldc 233
    //   2067: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2070: aload_0
    //   2071: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2074: aload_1
    //   2075: iconst_1
    //   2076: invokevirtual 68	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;Z)V
    //   2079: iconst_1
    //   2080: ireturn
    //   2081: aload_0
    //   2082: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2085: aconst_null
    //   2086: iconst_1
    //   2087: invokevirtual 68	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;Z)V
    //   2090: iconst_1
    //   2091: ireturn
    //   2092: aload_0
    //   2093: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2096: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2099: bipush 18
    //   2101: iconst_2
    //   2102: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   2105: aload_0
    //   2106: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2109: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2112: bipush 18
    //   2114: aload_1
    //   2115: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   2118: iconst_1
    //   2119: ireturn
    //   2120: aload_0
    //   2121: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2124: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2127: bipush 18
    //   2129: iconst_0
    //   2130: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   2133: aload_0
    //   2134: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2137: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2140: bipush 18
    //   2142: aload_1
    //   2143: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   2146: iconst_1
    //   2147: ireturn
    //   2148: aload_0
    //   2149: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2152: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2155: iconst_5
    //   2156: iconst_2
    //   2157: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   2160: aload_0
    //   2161: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2164: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2167: iconst_5
    //   2168: aload_1
    //   2169: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   2172: iconst_1
    //   2173: ireturn
    //   2174: aload_0
    //   2175: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2178: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2181: iconst_5
    //   2182: iconst_0
    //   2183: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   2186: aload_0
    //   2187: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2190: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2193: iconst_5
    //   2194: aload_1
    //   2195: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   2198: iconst_1
    //   2199: ireturn
    //   2200: aload_0
    //   2201: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2204: lconst_0
    //   2205: invokevirtual 65	com/tencent/mobileqq/activity/Conversation:a	(J)V
    //   2208: iconst_1
    //   2209: ireturn
    //   2210: aload_0
    //   2211: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2214: iconst_0
    //   2215: putfield 236	com/tencent/mobileqq/activity/Conversation:i	Z
    //   2218: aload_0
    //   2219: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2222: getfield 239	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   2225: ifnull +36 -> 2261
    //   2228: aload_0
    //   2229: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2232: getfield 242	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao	Lcom/tencent/mobileqq/portal/ConversationHongBao;
    //   2235: invokevirtual 245	com/tencent/mobileqq/portal/ConversationHongBao:a	()Z
    //   2238: ifne +13 -> 2251
    //   2241: aload_0
    //   2242: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2245: getfield 239	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   2248: invokevirtual 250	com/tencent/mobileqq/fpsreport/FPSSwipListView:springBackOverScrollHeaderView	()V
    //   2251: aload_0
    //   2252: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2255: getfield 239	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   2258: invokevirtual 250	com/tencent/mobileqq/fpsreport/FPSSwipListView:springBackOverScrollHeaderView	()V
    //   2261: aload_0
    //   2262: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2265: getfield 253	com/tencent/mobileqq/activity/Conversation:b	J
    //   2268: lconst_0
    //   2269: lcmp
    //   2270: ifle +19 -> 2289
    //   2273: ldc 255
    //   2275: invokestatic 260	android/os/SystemClock:uptimeMillis	()J
    //   2278: aload_0
    //   2279: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2282: getfield 253	com/tencent/mobileqq/activity/Conversation:b	J
    //   2285: lsub
    //   2286: invokestatic 265	com/tencent/mobileqq/utils/StartupTracker:a	(Ljava/lang/String;J)V
    //   2289: aload_0
    //   2290: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2293: lconst_0
    //   2294: putfield 253	com/tencent/mobileqq/activity/Conversation:b	J
    //   2297: iconst_1
    //   2298: ireturn
    //   2299: aload_0
    //   2300: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2303: lconst_0
    //   2304: invokevirtual 65	com/tencent/mobileqq/activity/Conversation:a	(J)V
    //   2307: iconst_1
    //   2308: ireturn
    //   2309: aload_0
    //   2310: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2313: invokevirtual 268	com/tencent/mobileqq/activity/Conversation:o	()V
    //   2316: iconst_1
    //   2317: ireturn
    //   2318: invokestatic 273	java/lang/System:currentTimeMillis	()J
    //   2321: aload_0
    //   2322: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2325: getfield 275	com/tencent/mobileqq/activity/Conversation:d	J
    //   2328: lsub
    //   2329: invokestatic 281	java/lang/Math:abs	(J)J
    //   2332: lstore 5
    //   2334: invokestatic 284	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2337: ifeq +49 -> 2386
    //   2340: ldc 56
    //   2342: iconst_4
    //   2343: new 286	java/lang/StringBuilder
    //   2346: dup
    //   2347: invokespecial 287	java/lang/StringBuilder:<init>	()V
    //   2350: ldc_w 289
    //   2353: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2356: aload_1
    //   2357: getfield 215	android/os/Message:arg1	I
    //   2360: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2363: ldc_w 298
    //   2366: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2369: lload 5
    //   2371: invokevirtual 301	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2374: ldc_w 303
    //   2377: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2380: invokevirtual 307	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2383: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2386: lload 5
    //   2388: lconst_0
    //   2389: lcmp
    //   2390: ifge +1150 -> 3540
    //   2393: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2396: ifeq +52 -> 2448
    //   2399: ldc 56
    //   2401: iconst_2
    //   2402: new 286	java/lang/StringBuilder
    //   2405: dup
    //   2406: invokespecial 287	java/lang/StringBuilder:<init>	()V
    //   2409: ldc_w 309
    //   2412: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2415: lload 5
    //   2417: invokevirtual 301	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2420: ldc_w 298
    //   2423: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2426: aload_0
    //   2427: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2430: getfield 275	com/tencent/mobileqq/activity/Conversation:d	J
    //   2433: invokevirtual 301	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2436: ldc_w 303
    //   2439: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2442: invokevirtual 307	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2445: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2448: aload_0
    //   2449: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2452: getfield 311	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Long	J
    //   2455: lconst_1
    //   2456: ladd
    //   2457: lstore 5
    //   2459: aload_1
    //   2460: getfield 152	android/os/Message:obj	Ljava/lang/Object;
    //   2463: checkcast 313	java/util/List
    //   2466: astore 10
    //   2468: aload_1
    //   2469: getfield 316	android/os/Message:arg2	I
    //   2472: iconst_1
    //   2473: if_icmpeq +85 -> 2558
    //   2476: lload 5
    //   2478: aload_0
    //   2479: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2482: getfield 311	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Long	J
    //   2485: lcmp
    //   2486: ifge +72 -> 2558
    //   2489: aload_0
    //   2490: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2493: aload 10
    //   2495: putfield 319	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   2498: invokestatic 323	android/os/Message:obtain	()Landroid/os/Message;
    //   2501: astore_1
    //   2502: aload_1
    //   2503: sipush 10000
    //   2506: putfield 26	android/os/Message:what	I
    //   2509: aload_1
    //   2510: aload_0
    //   2511: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2514: getfield 319	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   2517: putfield 152	android/os/Message:obj	Ljava/lang/Object;
    //   2520: aload_1
    //   2521: iconst_0
    //   2522: putfield 215	android/os/Message:arg1	I
    //   2525: aload_1
    //   2526: iconst_1
    //   2527: putfield 316	android/os/Message:arg2	I
    //   2530: aload_0
    //   2531: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2534: getfield 203	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2537: aload_1
    //   2538: aload_0
    //   2539: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2542: getfield 311	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Long	J
    //   2545: lload 5
    //   2547: lsub
    //   2548: ldc2_w 324
    //   2551: ladd
    //   2552: invokevirtual 329	mqq/os/MqqHandler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   2555: pop
    //   2556: iconst_1
    //   2557: ireturn
    //   2558: aload_1
    //   2559: getfield 316	android/os/Message:arg2	I
    //   2562: iconst_1
    //   2563: if_icmpne +53 -> 2616
    //   2566: aload 10
    //   2568: aload_0
    //   2569: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2572: getfield 319	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   2575: if_acmpne +36 -> 2611
    //   2578: iconst_1
    //   2579: istore_2
    //   2580: iload_2
    //   2581: ifeq -2530 -> 51
    //   2584: aload_0
    //   2585: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2588: iconst_0
    //   2589: aload_0
    //   2590: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2593: getfield 319	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   2596: invokevirtual 332	com/tencent/mobileqq/activity/Conversation:a	(ILjava/util/List;)V
    //   2599: aload_0
    //   2600: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2603: invokestatic 273	java/lang/System:currentTimeMillis	()J
    //   2606: putfield 275	com/tencent/mobileqq/activity/Conversation:d	J
    //   2609: iconst_1
    //   2610: ireturn
    //   2611: iconst_0
    //   2612: istore_2
    //   2613: goto -33 -> 2580
    //   2616: aload_0
    //   2617: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2620: aload 10
    //   2622: putfield 319	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   2625: iconst_1
    //   2626: istore_2
    //   2627: goto -47 -> 2580
    //   2630: aload_1
    //   2631: getfield 152	android/os/Message:obj	Ljava/lang/Object;
    //   2634: checkcast 313	java/util/List
    //   2637: astore_1
    //   2638: aload_0
    //   2639: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2642: iconst_1
    //   2643: aload_1
    //   2644: invokevirtual 332	com/tencent/mobileqq/activity/Conversation:a	(ILjava/util/List;)V
    //   2647: iconst_1
    //   2648: ireturn
    //   2649: aload_0
    //   2650: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2653: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2656: ifnull -2605 -> 51
    //   2659: aload_0
    //   2660: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2663: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2666: iconst_1
    //   2667: iconst_0
    //   2668: invokevirtual 335	com/tencent/mobileqq/app/QQAppInterface:a	(ZI)V
    //   2671: iconst_1
    //   2672: ireturn
    //   2673: aload_0
    //   2674: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2677: invokestatic 338	com/tencent/mobileqq/activity/Conversation:c	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   2680: iconst_1
    //   2681: ireturn
    //   2682: aload_0
    //   2683: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2686: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2689: astore 10
    //   2691: iload_3
    //   2692: istore_2
    //   2693: aload_0
    //   2694: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2697: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2700: invokevirtual 341	com/tencent/mobileqq/app/QQAppInterface:a	()Lcooperation/qlink/QQProxyForQlink;
    //   2703: invokevirtual 346	cooperation/qlink/QQProxyForQlink:a	()I
    //   2706: ifeq +5 -> 2711
    //   2709: iconst_2
    //   2710: istore_2
    //   2711: aload 10
    //   2713: bipush 33
    //   2715: iload_2
    //   2716: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   2719: aload_0
    //   2720: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2723: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2726: bipush 33
    //   2728: aload_1
    //   2729: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   2732: iconst_1
    //   2733: ireturn
    //   2734: aload_0
    //   2735: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2738: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2741: astore 10
    //   2743: invokestatic 351	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:a	()Lcom/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService;
    //   2746: invokevirtual 352	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:a	()Z
    //   2749: ifeq +26 -> 2775
    //   2752: aload 10
    //   2754: bipush 34
    //   2756: iload_2
    //   2757: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   2760: aload_0
    //   2761: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2764: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2767: bipush 34
    //   2769: aload_1
    //   2770: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   2773: iconst_1
    //   2774: ireturn
    //   2775: iconst_0
    //   2776: istore_2
    //   2777: goto -25 -> 2752
    //   2780: aload_0
    //   2781: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2784: invokevirtual 355	com/tencent/mobileqq/activity/Conversation:t	()V
    //   2787: iconst_1
    //   2788: ireturn
    //   2789: aload_0
    //   2790: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2793: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2796: bipush 20
    //   2798: iconst_2
    //   2799: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   2802: aload_0
    //   2803: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2806: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2809: bipush 20
    //   2811: aload_1
    //   2812: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   2815: iconst_1
    //   2816: ireturn
    //   2817: aload_0
    //   2818: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2821: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2824: bipush 20
    //   2826: iconst_0
    //   2827: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   2830: aload_0
    //   2831: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2834: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2837: bipush 20
    //   2839: aload_1
    //   2840: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   2843: iconst_1
    //   2844: ireturn
    //   2845: aload_0
    //   2846: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2849: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2852: bipush 21
    //   2854: iconst_2
    //   2855: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   2858: aload_0
    //   2859: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2862: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2865: bipush 21
    //   2867: aload_1
    //   2868: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   2871: iconst_1
    //   2872: ireturn
    //   2873: aload_0
    //   2874: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2877: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2880: bipush 21
    //   2882: iconst_0
    //   2883: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   2886: aload_0
    //   2887: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2890: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2893: bipush 21
    //   2895: aload_1
    //   2896: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   2899: iconst_1
    //   2900: ireturn
    //   2901: aload_0
    //   2902: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2905: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2908: iconst_4
    //   2909: aload_1
    //   2910: getfield 215	android/os/Message:arg1	I
    //   2913: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   2916: aload_0
    //   2917: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2920: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2923: iconst_4
    //   2924: aload_1
    //   2925: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   2928: iconst_1
    //   2929: ireturn
    //   2930: aload_0
    //   2931: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2934: getfield 358	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter	Lcom/tencent/mobileqq/activity/recent/RecentAdapter;
    //   2937: ifnull -2886 -> 51
    //   2940: aload_0
    //   2941: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2944: getfield 358	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter	Lcom/tencent/mobileqq/activity/recent/RecentAdapter;
    //   2947: invokevirtual 361	com/tencent/mobileqq/activity/recent/RecentAdapter:a	()V
    //   2950: iconst_1
    //   2951: ireturn
    //   2952: aload_0
    //   2953: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2956: getfield 364	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   2959: ifnull -2908 -> 51
    //   2962: aload_1
    //   2963: getfield 215	android/os/Message:arg1	I
    //   2966: iconst_1
    //   2967: if_icmpne +38 -> 3005
    //   2970: iconst_1
    //   2971: istore_2
    //   2972: iload_2
    //   2973: ifeq +37 -> 3010
    //   2976: new 366	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo
    //   2979: dup
    //   2980: invokespecial 367	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:<init>	()V
    //   2983: astore_1
    //   2984: aload_1
    //   2985: getfield 371	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2988: iconst_0
    //   2989: invokevirtual 376	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   2992: aload_0
    //   2993: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2996: getfield 364	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   2999: aload_1
    //   3000: invokevirtual 381	com/tencent/mobileqq/redtouch/RedTouch:a	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;)V
    //   3003: iconst_1
    //   3004: ireturn
    //   3005: iconst_0
    //   3006: istore_2
    //   3007: goto -35 -> 2972
    //   3010: aload_0
    //   3011: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3014: getfield 364	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   3017: new 383	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo
    //   3020: dup
    //   3021: invokespecial 384	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:<init>	()V
    //   3024: invokevirtual 387	com/tencent/mobileqq/redtouch/RedTouch:a	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;)V
    //   3027: iconst_1
    //   3028: ireturn
    //   3029: aload_0
    //   3030: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3033: getfield 239	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   3036: ifnull -2985 -> 51
    //   3039: aload_0
    //   3040: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3043: getfield 390	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   3046: ifnull -2995 -> 51
    //   3049: aload_1
    //   3050: getfield 152	android/os/Message:obj	Ljava/lang/Object;
    //   3053: instanceof 392
    //   3056: ifeq -3005 -> 51
    //   3059: aload_1
    //   3060: getfield 152	android/os/Message:obj	Ljava/lang/Object;
    //   3063: checkcast 392	com/tencent/mobileqq/theme/diy/ThemeBackground
    //   3066: astore_1
    //   3067: ldc_w 394
    //   3070: aload_1
    //   3071: getfield 398	com/tencent/mobileqq/theme/diy/ThemeBackground:path	Ljava/lang/String;
    //   3074: invokevirtual 404	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3077: ifne +70 -> 3147
    //   3080: aload_1
    //   3081: getfield 408	com/tencent/mobileqq/theme/diy/ThemeBackground:img	Landroid/graphics/drawable/Drawable;
    //   3084: ifnull +63 -> 3147
    //   3087: invokestatic 413	com/tencent/mobileqq/theme/ThemeUtil:isNowThemeIsDIY	()Z
    //   3090: ifeq +30 -> 3120
    //   3093: aload_0
    //   3094: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3097: getfield 239	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   3100: aload_1
    //   3101: getfield 408	com/tencent/mobileqq/theme/diy/ThemeBackground:img	Landroid/graphics/drawable/Drawable;
    //   3104: invokevirtual 417	com/tencent/mobileqq/fpsreport/FPSSwipListView:setContentBackground	(Landroid/graphics/drawable/Drawable;)V
    //   3107: aload_0
    //   3108: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3111: getfield 390	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   3114: aconst_null
    //   3115: invokevirtual 422	android/view/View:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   3118: iconst_1
    //   3119: ireturn
    //   3120: aload_0
    //   3121: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3124: getfield 239	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   3127: aconst_null
    //   3128: invokevirtual 417	com/tencent/mobileqq/fpsreport/FPSSwipListView:setContentBackground	(Landroid/graphics/drawable/Drawable;)V
    //   3131: aload_0
    //   3132: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3135: getfield 390	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   3138: aload_1
    //   3139: getfield 408	com/tencent/mobileqq/theme/diy/ThemeBackground:img	Landroid/graphics/drawable/Drawable;
    //   3142: invokevirtual 422	android/view/View:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   3145: iconst_1
    //   3146: ireturn
    //   3147: aload_0
    //   3148: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3151: getfield 239	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   3154: ldc_w 423
    //   3157: invokevirtual 425	com/tencent/mobileqq/fpsreport/FPSSwipListView:setContentBackground	(I)V
    //   3160: aload_0
    //   3161: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3164: getfield 390	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   3167: aconst_null
    //   3168: invokevirtual 422	android/view/View:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   3171: iconst_1
    //   3172: ireturn
    //   3173: aload_0
    //   3174: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3177: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   3180: astore 10
    //   3182: aload_1
    //   3183: getfield 152	android/os/Message:obj	Ljava/lang/Object;
    //   3186: ifnonnull +27 -> 3213
    //   3189: iload 4
    //   3191: istore_2
    //   3192: aload 10
    //   3194: iconst_2
    //   3195: iload_2
    //   3196: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   3199: aload_0
    //   3200: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3203: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   3206: iconst_2
    //   3207: aload_1
    //   3208: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   3211: iconst_1
    //   3212: ireturn
    //   3213: iconst_2
    //   3214: istore_2
    //   3215: goto -23 -> 3192
    //   3218: aload_0
    //   3219: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3222: invokestatic 76	com/tencent/mobileqq/activity/Conversation:b	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   3225: iconst_1
    //   3226: ireturn
    //   3227: aload_0
    //   3228: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3231: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3234: bipush 10
    //   3236: invokevirtual 428	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   3239: checkcast 430	com/tencent/mobileqq/app/RegisterProxySvcPackHandler
    //   3242: invokevirtual 432	com/tencent/mobileqq/app/RegisterProxySvcPackHandler:c	()V
    //   3245: iconst_1
    //   3246: ireturn
    //   3247: aload_0
    //   3248: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3251: getfield 435	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity	Lcom/tencent/mobileqq/app/FrameHelperActivity;
    //   3254: getfield 440	com/tencent/mobileqq/app/FrameHelperActivity:a	Landroid/widget/ImageView;
    //   3257: astore_1
    //   3258: aload_0
    //   3259: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3262: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3265: sipush 249
    //   3268: invokevirtual 444	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3271: checkcast 446	com/tencent/mobileqq/medalwall/MedalWallMng
    //   3274: aload_0
    //   3275: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3278: invokevirtual 449	com/tencent/mobileqq/activity/Conversation:a	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   3281: aload_1
    //   3282: iconst_1
    //   3283: aconst_null
    //   3284: invokevirtual 452	com/tencent/mobileqq/medalwall/MedalWallMng:a	(Lcom/tencent/mobileqq/app/BaseActivity;Landroid/view/View;ILjava/lang/Object;)Z
    //   3287: istore 9
    //   3289: invokestatic 284	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3292: ifeq -3241 -> 51
    //   3295: ldc_w 454
    //   3298: iconst_4
    //   3299: invokestatic 460	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   3302: ldc_w 462
    //   3305: iconst_1
    //   3306: anewarray 4	java/lang/Object
    //   3309: dup
    //   3310: iconst_0
    //   3311: iload 9
    //   3313: invokestatic 468	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3316: aastore
    //   3317: invokestatic 472	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   3320: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3323: iconst_1
    //   3324: ireturn
    //   3325: aload_0
    //   3326: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3329: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3332: ifnull +20 -> 3352
    //   3335: aload_0
    //   3336: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3339: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3342: sipush 180
    //   3345: invokevirtual 444	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3348: checkcast 474	com/tencent/biz/qqstory/base/QQStoryManager
    //   3351: astore_1
    //   3352: new 476	sdc
    //   3355: dup
    //   3356: aload_0
    //   3357: invokespecial 477	sdc:<init>	(Lscu;)V
    //   3360: bipush 8
    //   3362: aconst_null
    //   3363: iconst_1
    //   3364: invokestatic 185	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   3367: iconst_1
    //   3368: ireturn
    //   3369: aload_0
    //   3370: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3373: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   3376: invokevirtual 479	com/tencent/mobileqq/activity/recent/BannerManager:a	()Lmqq/os/MqqHandler;
    //   3379: astore 10
    //   3381: aload 10
    //   3383: ifnull -3332 -> 51
    //   3386: aload 10
    //   3388: sipush 200
    //   3391: invokevirtual 483	mqq/os/MqqHandler:obtainMessage	(I)Landroid/os/Message;
    //   3394: astore 11
    //   3396: aload 11
    //   3398: aload_1
    //   3399: getfield 152	android/os/Message:obj	Ljava/lang/Object;
    //   3402: putfield 152	android/os/Message:obj	Ljava/lang/Object;
    //   3405: aload 10
    //   3407: aload 11
    //   3409: invokevirtual 486	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   3412: pop
    //   3413: iconst_1
    //   3414: ireturn
    //   3415: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3418: ifeq +30 -> 3448
    //   3421: ldc_w 488
    //   3424: iconst_2
    //   3425: new 286	java/lang/StringBuilder
    //   3428: dup
    //   3429: invokespecial 287	java/lang/StringBuilder:<init>	()V
    //   3432: ldc_w 490
    //   3435: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3438: aload_1
    //   3439: invokevirtual 493	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3442: invokevirtual 307	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3445: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3448: aload_0
    //   3449: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3452: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   3455: invokevirtual 479	com/tencent/mobileqq/activity/recent/BannerManager:a	()Lmqq/os/MqqHandler;
    //   3458: astore 10
    //   3460: aload 10
    //   3462: ifnull -3411 -> 51
    //   3465: aload 10
    //   3467: sipush 201
    //   3470: invokevirtual 483	mqq/os/MqqHandler:obtainMessage	(I)Landroid/os/Message;
    //   3473: astore 11
    //   3475: aload 11
    //   3477: aload_1
    //   3478: getfield 152	android/os/Message:obj	Ljava/lang/Object;
    //   3481: putfield 152	android/os/Message:obj	Ljava/lang/Object;
    //   3484: aload 10
    //   3486: aload 11
    //   3488: invokevirtual 486	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   3491: pop
    //   3492: iconst_1
    //   3493: ireturn
    //   3494: aload_0
    //   3495: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3498: getfield 496	com/tencent/mobileqq/activity/Conversation:h	Z
    //   3501: ifeq -3450 -> 51
    //   3504: aload_0
    //   3505: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3508: getfield 203	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   3511: ldc_w 497
    //   3514: getstatic 501	com/tencent/mobileqq/statistics/QZoneReport:a	I
    //   3517: sipush 1000
    //   3520: imul
    //   3521: i2l
    //   3522: invokevirtual 505	mqq/os/MqqHandler:sendEmptyMessageDelayed	(IJ)Z
    //   3525: pop
    //   3526: iconst_1
    //   3527: ireturn
    //   3528: aload_0
    //   3529: getfield 12	scu:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3532: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3535: invokestatic 508	com/tencent/mobileqq/statistics/QZoneReport:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   3538: iconst_1
    //   3539: ireturn
    //   3540: goto -1081 -> 2459
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3543	0	this	scu
    //   0	3543	1	paramMessage	android.os.Message
    //   1	3214	2	i	int
    //   6	2686	3	j	int
    //   3	3187	4	k	int
    //   813	1733	5	l1	long
    //   825	216	7	l2	long
    //   3287	25	9	bool	boolean
    //   781	183	10	localUpgradeDetailWrapper	com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper
    //   1144	1	10	localException	java.lang.Exception
    //   1265	2220	10	localObject1	Object
    //   801	2686	11	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   1097	1107	1144	java/lang/Exception
    //   1097	1107	1158	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     scu
 * JD-Core Version:    0.7.0.1
 */