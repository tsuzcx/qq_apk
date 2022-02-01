package com.tencent.mobileqq.guild.usecases;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.error.GuildError;

public abstract interface FetchGuildInfoUseCase$ResultCallback
{
  public abstract void a(@NonNull GuildError paramGuildError, @NonNull FetchGuildInfoUseCase.GuildInfo paramGuildInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.usecases.FetchGuildInfoUseCase.ResultCallback
 * JD-Core Version:    0.7.0.1
 */