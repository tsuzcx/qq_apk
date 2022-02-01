package com.tencent.mobileqq.guild.usecases;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.guild.error.GuildError;

public abstract interface FetchShareInfoUseCase$ResultCallback
{
  public abstract void a(@NonNull GuildError paramGuildError, @Nullable FetchShareInfoUseCase.ShareUrlInfo paramShareUrlInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.usecases.FetchShareInfoUseCase.ResultCallback
 * JD-Core Version:    0.7.0.1
 */